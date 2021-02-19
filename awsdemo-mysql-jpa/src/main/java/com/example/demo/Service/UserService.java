package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.UserCustomeRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.model.User;
import com.example.demo.model.UserRoleType;
 
@Service
@Transactional
public class UserService {
 
    @Autowired
    private UserRepository repo;
    @Autowired
    private UserCustomeRepository repoUser;
     
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
    
    
    
    public List<User> findUserByRoleTypeli(UserRoleType roleType) {
    	return repoUser.findUserByRoleType();
    	
    }
    public List<User> findUserByStandardID(long fkStandardId,UserRoleType roleType) {
    	return repoUser.findUserByStandardID(fkStandardId);
    	
    }
    
}
