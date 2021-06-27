package com.example.demo.resource;

import java.util.List;

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
import com.example.demo.model.Course;
import com.example.demo.model.Paper;
import com.example.demo.model.Question;
import com.example.demo.model.QuestionOption;
import com.example.demo.model.QuestionOptionViewModel;

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
	 ResponseEntity<Long> addQuestion(@RequestBody QuestionOptionViewModel questionVM) {
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
			
		} catch (Exception e) {
			return new ResponseEntity<>(questionVM.getFkPaperID(), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<>(questionVM.getFkPaperID(), HttpStatus.OK); 
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
	
	@GetMapping("/allqn/{paperID}")
	public List<Question> getAllQuestion(@PathVariable("paperID") long paperID) {
		return questionService.listAll();
	}
	
}
