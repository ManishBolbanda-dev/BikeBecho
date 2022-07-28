package com.BikeBecho.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BikeBecho.Utility.DBUtility;

public class LoginDaoImpl implements LoginDao
{
	String str;
	int row;
	PreparedStatement stmt;
	ResultSet rs;
	
	static Connection con=DBUtility.connection();
  
	@Override
	public boolean userLogin(String email, String pass) 
	{
	  str="select userEmail,userPassword from User where userEmail=? and userPassword=?";
	  try
	  {
		  stmt=con.prepareStatement(str);
		  stmt.setString(1, email);
		  stmt.setString(2, pass);
		  rs=stmt.executeQuery();
		  if(rs.next())
		  {
			 return true;
		  }
	  }
	  catch(SQLException e)
	  {
		  e.printStackTrace();
	  }
	  return false;
	
	}

	@Override
	public boolean userChangePassword(String email, String pass)
	{
		str="update User set userPassword=? where userEmail=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setString(1, pass);
			stmt.setString(2, email);
			row=stmt.executeUpdate();
			
		}
		catch(SQLException e)
		  {
			  e.printStackTrace();
		  }
		if(row>0)
			return true;
		else
		  return false;
	}

	@Override
	public boolean adminLogin(String email, String pass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean adminChangePassword(String email, String pass) {
		// TODO Auto-generated method stub
		return false;
	}

}
