package com.shriramgokhale.projectdemo.model;

public class AppUser {
	
    private Long userId;
    private String userName;
    private String encrytedPassword;
    
    
	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppUser(Long userId, String userName, String encrytedPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}

	@Override
	public String toString() {
		return "AppUser [userId=" + userId + ", userName=" + userName + ", encrytedPassword=" + encrytedPassword + "]";
	}
    
	
    

}
