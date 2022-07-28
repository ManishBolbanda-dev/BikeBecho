package com.BikeBecho.Dao;

public interface LoginDao 
{
	boolean userLogin(String email,String pass);
	boolean userChangePassword(String email,String pass);
	boolean adminLogin(String email,String pass);
	boolean adminChangePassword(String email,String pass);
	

}
