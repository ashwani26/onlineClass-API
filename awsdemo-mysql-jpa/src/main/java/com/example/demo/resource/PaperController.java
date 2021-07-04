package com.example.demo.resource;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CourseService;
import com.example.demo.Service.OptionService;
import com.example.demo.Service.PaperService;
import com.example.demo.Service.QuestionService;
import com.example.demo.model.CandidateAnswer;
import com.example.demo.model.CandidateExam;
import com.example.demo.model.Course;
import com.example.demo.model.Paper;
import com.example.demo.model.Question;
import com.example.demo.model.QuestionOption;
import com.example.demo.model.QuestionOptionViewModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
public class PaperController {
	@Autowired
    private PaperService paperService;
	@Autowired
    private QuestionService questionService;
	@Autowired
    private OptionService optionService;
	@Autowired
    private CourseService courseService;
	
	
	
	@PostMapping("/savePaper")
	 ResponseEntity<Paper> addPaper(@RequestBody Paper paper) {
		Paper paperObj = null; 
		try {
			Course courseObj =courseService.get(paper.getFkCourseID());
			paper.setCourseName(courseObj.getCourseName());
			paper.setSubjectName(courseObj.getSubjectName());
			paperObj = paperService.save(paper);
		} catch (Exception e) {
			return new ResponseEntity<>(paperObj, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<>(paperObj, HttpStatus.OK); 
	  }
	
	@PostMapping("/saveQuestion")
	 ResponseEntity<Paper> addQuestion(@RequestBody QuestionOptionViewModel questionVM) {
		Paper paperObj = null;
		try {
			Question questionObj = new Question();
			questionObj.setQuestionTxt(questionVM.getQuestionTxt());
			questionObj.setFkPaperID(questionVM.getFkPaperID());
			questionObj.setNoOfOption(4);
			questionObj.setCorrectOptionID(questionVM.getCorrectOptionID());
			questionService.save(questionObj);
			// save option data
			if(questionObj.getQuestionID()>0)
			{
			QuestionOption  optionObj = new QuestionOption();
			optionObj.setFkQuestionID(questionObj.getQuestionID());
			optionObj.setOptionText1(questionVM.getOptionText1());
			optionObj.setOptionText2(questionVM.getOptionText2());
			optionObj.setOptionText3(questionVM.getOptionText3());
			optionObj.setOptionText4(questionVM.getOptionText4());
			optionService.save(optionObj);
			}
			 paperObj = new Paper();
				paperObj.setPaperID(questionVM.getFkPaperID());
				paperObj.setTotalQuestion(paperService.getListOfQuestionByPaperID(questionVM.getFkPaperID()).size());
				
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return new ResponseEntity<>(paperObj, HttpStatus.OK); 
	  }
	

	@GetMapping("/getPaper/{paperID}")
	public Paper getPaperByPaperID(@PathVariable("paperID") long paperID) {
		return paperService.get(paperID);
	}
	
	@GetMapping("/getQuestions/{paperID}")
	public List<QuestionOptionViewModel> getQuestionByPaperID(@PathVariable("paperID") long paperID) {
		return paperService.getListOfQuestionByPaperID(paperID);
	}
	
	@GetMapping("/getAllPaper")
	public List<Paper> getAllPaper() {
		return paperService.listAll();
	}
	
	@GetMapping("/getStudentReport/{userID}")
	public List<CandidateExam> getStudentReport(@PathVariable("userID") long userID) {
		return questionService.getStudentReport(userID);
	}
	
	@GetMapping("/allqn/{paperID}")
	public List<Question> getAllQuestion(@PathVariable("paperID") long paperID) {
		return questionService.listAll();
	}
	
	@PostMapping("/saveAnswer")
	 ResponseEntity<Boolean> addCandiateAnswer(@RequestBody String candiadteAnswerList) {
	ObjectMapper mapper = new ObjectMapper();
	final int totalCorrectQuestion = 0;
		try {
			
			
			CandidateAnswer[] answers = mapper.readValue(candiadteAnswerList, CandidateAnswer[].class);
			List<CandidateAnswer> candAnsList = Arrays.stream(answers).collect(Collectors.toList());
			
			// check whether exam already attempted
						if(questionService.isExamAlreadyAttempted(candAnsList.get(0).getFkPaperID(), candAnsList.get(0).getFkUserID())) {
							return new ResponseEntity<>(false, HttpStatus.ALREADY_REPORTED); 
						}
			candAnsList.stream()
	         .filter(ans -> ans.getAttemptedOptionID()==ans.getCorrectOptionID())
	         .forEach(ans -> ans.setIsCorrect(true));
			Date attemptDate = new Date();
			long correctAns = candAnsList.stream().filter(ans -> ans.getAttemptedOptionID()==ans.getCorrectOptionID()).count();
		Paper paperObj = paperService.get(candAnsList.get(0).getFkPaperID());
			
			candAnsList.stream().forEach(ans -> ans.setAttemptedDate(attemptDate));
			
			// save into candiate exam data first
			int marksObstaoned = (int) (paperObj.getMarksPerQuestion()*correctAns);
			
			CandidateExam cexamObj = new CandidateExam();
			cexamObj.setFkPaperID(candAnsList.get(0).getFkPaperID());
			cexamObj.setFkUserID(candAnsList.get(0).getFkUserID());
			cexamObj.setISExamCompleted(true);
			cexamObj.setMarksObtained(marksObstaoned);
			cexamObj.setAttemptDate(attemptDate);
			cexamObj.setTestName(paperObj.getPaperName());
			cexamObj.setTotalMarks(paperObj.getTotalMarks());
			
			questionService.saveCandidateExam(cexamObj);
			if(cexamObj.getCandidateExamID() > 0)
			{
			
			questionService.saveAllAnswer(candAnsList);
			}else {
				throw new Exception("Exception whle saving candidate exam");
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR); 
		}

		return new ResponseEntity<>(true, HttpStatus.OK); 
	  }
	
}
