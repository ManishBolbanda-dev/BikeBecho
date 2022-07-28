package com.BikeBecho.Dao;

import java.util.List;

import com.BikeBecho.pojo.User;

public interface UserDao 
{
	boolean addUser(User u);
	boolean updateUser(User u);
	boolean deleteUserById(int userId);
	User getUserById(int userId);
	List<User> showAllUser();
	User nameofUser(String email);
	User getUserByEmail(String email);


}
