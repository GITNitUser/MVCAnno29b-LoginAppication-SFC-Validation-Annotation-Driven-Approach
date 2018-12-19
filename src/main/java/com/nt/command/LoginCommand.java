package com.nt.command;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class LoginCommand implements Serializable {
	@NotEmpty(message="Username is Required")
	private String username;
	@NotEmpty(message="Password is Required")
	private String password;
	
	public LoginCommand() {
		System.out.println("LoginCommand.LoginCommand()-0 Param Constructor");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
