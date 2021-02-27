package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;

public interface UserCustomeRepository {
	
	@Query("SELECT u from User u where u.roleType=1")
	public List<User> findUserByRoleType();
	
	@Query("SELECT us from User us,UserStandardAssociation usa where usa.fkUserID = us.userID and usa.fkStandardId=:fkStandardId and us.roleType=1")
	public List<User> findUserByStandardID(@Param("fkStandardId") long fkStandardId);
	
	 @Query("select u from User u where u.uName =:uName ")
	   public User findUserByUserName(@Param("uName") String uName);
	 
	
	 @Modifying
	 @Query("update User u set u.mobile = ?1, u.email = ?2 where u.uName = ?3")
	 void updateUserByUserName(String mobile, String email, String userName);
	

}
