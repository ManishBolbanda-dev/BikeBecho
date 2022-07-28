package com.BikeBecho.pojo;

public class User 
{
	private int userId;
	private String userName,userCity,userMobile,userEmail,userPassword;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String userCity, String userMobile, String userEmail, String userPassword) 
	{
		super();
		this.userName = userName;
		this.userCity = userCity;
		this.userMobile = userMobile;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	public int getUserId() 
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userCity=" + userCity + ", userMobile="
				+ userMobile + ", userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
	}

}
