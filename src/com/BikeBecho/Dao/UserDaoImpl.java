package com.BikeBecho.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BikeBecho.Utility.DBUtility;
import com.BikeBecho.pojo.User;

public class UserDaoImpl implements UserDao
{
	User u;
	int row;
	String str;
	PreparedStatement stmt;
	ResultSet rs;
	//Connection con;
	static Connection con=DBUtility.connection();
	List<User> list;

	@Override
	public boolean addUser(User u)
	{
		str="INSERT INTO User(userName,userCity,userMobile,userEmail,userPassword) VALUES(?,?,?,?,?)";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setString(1, u.getUserName());
			stmt.setString(2, u.getUserCity());
			stmt.setString(3, u.getUserMobile());
			stmt.setString(4, u.getUserEmail());
			stmt.setString(5, u.getUserPassword());
			row=stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		return false;
	}

	@Override
	public boolean updateUser(User u)
	{
		str="UPDATE User SET userName=?,userCity=?,userMobile=?,userEmail=?,userPassword=? WHERE userId=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt=con.prepareStatement(str);
			stmt.setString(1, u.getUserName());
			stmt.setString(2, u.getUserCity());
			stmt.setString(3, u.getUserMobile());
			stmt.setString(4, u.getUserEmail());
			stmt.setString(5, u.getUserPassword());
			stmt.setInt(6, u.getUserId());
			row=stmt.executeUpdate();

		}
			
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteUserById(int userId)
	{
		str="DELETE FROM User WHERE userId=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setInt(1, userId);
			row=stmt.executeUpdate();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
			return true;
		return false;
	}

	@Override
	public User getUserById(int userId)
	{
		str="SELECT * FROM User WHERE userId=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setInt(1, userId);
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				u=new User(rs.getString("userName"),rs.getString("userCity"),rs.getString("userMobile"),rs.getString("userEmail"),rs.getString("userPassword"));
				u.setUserId(rs.getInt("userId"));
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return u;

		
	}

	@Override
	public List<User> showAllUser() 
	{
		str="SELECT * FROM User";
		list=new ArrayList<>();
		try
		{
			stmt=con.prepareStatement(str);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				u=new User(rs.getString("userName"),rs.getString("userCity"),rs.getString("userMobile"),rs.getString("userEmail"),rs.getString("userPassword"));
				u.setUserId(rs.getInt("userId"));
				list.add(u);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User nameofUser(String email) 
	{
	
		str="select * from User where userEmail=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setString(1, email);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				u=new User(rs.getString("userName"),rs.getString("userCity"),rs.getString("userMobile"),rs.getString("userEmail"),rs.getString("userPassword"));
				u.setUserId(rs.getInt("userId"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return u;
		
	}

	@Override
	public User getUserByEmail(String email) 
	{
		str="SELECT * FROM User WHERE userEmail=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setString(1, email);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				u=new User(rs.getString("userName"),rs.getString("userCity"),rs.getString("userMobile"),rs.getString("userEmail"),rs.getString("userPassword"));
				u.setUserId(rs.getInt("userId"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return u;
	}

}
