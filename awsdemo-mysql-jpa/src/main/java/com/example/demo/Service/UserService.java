package com.example.demo.Service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.UserCustomeRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.UserSubjectAssociationRepository;
import com.example.demo.model.User;
import com.example.demo.model.UserRoleType;
import com.example.demo.model.UserSubjectAssociation;
 
@Service
@Transactional
public class UserService {
 
    @Autowired
    private UserRepository repo;
    @Autowired
    private UserCustomeRepository repoUser;
    @Autowired
    private UserSubjectAssociationRepository userSubjectRepo;
     
    public List<User> listAll() {
        return repo.findAll();
    }
     
    public User save(User User) {
    	// upload candidate images at particular
		/*
		 * if(successFully uploaded) { User.setUserImagePath(null); }
		 */
    	// 
        return repo.save(User);
    }
     
    public User get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    
    public User findUserByUserName(String uName) {
        return	repo.findUserByUserName(uName);
        }
        
        public void updateUserByUserName(User user) throws Exception{
        	 repo.updateUserByUserName(user.getMobile(), user.getEmail(), user.getuName());
        }
        
        public boolean saveUserSubjectAssociation(UserSubjectAssociation usersubAssociation) {
       	 try {
       		userSubjectRepo.save(usersubAssociation);
   		} catch (Exception e) {
   			LoggerFactory.getLogger(UserService.class).error(e.getMessage());
   			return false;
   		}
       return true;
       }
    
    
    
    public List<User> findUserByRoleTypeli(UserRoleType roleType) {
    	return repoUser.findUserByRoleType(roleType.ordinal());
    	
    }
    public List<User> findUserByStandardID(long fkStandardId,UserRoleType roleType) {
    	return repoUser.findUserByStandardID(fkStandardId);
    	
    }
    
}
