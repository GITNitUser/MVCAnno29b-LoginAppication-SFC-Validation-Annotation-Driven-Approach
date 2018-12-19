package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.LoginBO;
import com.nt.dao.LoginDAO;
import com.nt.dto.LoginDTO;

@Service("service")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public String login(LoginDTO dto) {
		String msg = null;
		int count = 0;
		LoginBO bo = null;

		// create LoginBO class object
		bo = new LoginBO();
		// copy the data from dto to bo
		BeanUtils.copyProperties(dto, bo);

		// call the DAO class method
		count = dao.authenticate(bo);

		if (count != 0)
			msg = "Authentication Successful";
		else
			msg = "Authentication Failed..Please type correct username and password";

		return msg;
	}// end of login method

}// end of service class
