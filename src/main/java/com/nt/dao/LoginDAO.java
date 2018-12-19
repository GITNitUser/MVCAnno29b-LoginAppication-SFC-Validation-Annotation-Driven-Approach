package com.nt.dao;

import com.nt.bo.LoginBO;

public interface LoginDAO {
	public int authenticate(LoginBO bo);
}
