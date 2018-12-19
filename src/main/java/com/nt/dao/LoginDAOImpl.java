package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.LoginBO;

@Repository("dao")
public class LoginDAOImpl implements LoginDAO {
   private static final String USER_AUTH="SELECT COUNT(*) FROM USERLIST WHERE UNAME=? AND PASS=?";
	@Autowired
	private JdbcTemplate jd;
	
   
   @Override
	public int authenticate(LoginBO bo) {
		int count=0;
		
		//call the JDBC Template method
		count=jd.queryForObject(USER_AUTH, Integer.class, bo.getUsername(),bo.getPassword());
		
		return count;
	}//end of authenticate() method

}//end of class
