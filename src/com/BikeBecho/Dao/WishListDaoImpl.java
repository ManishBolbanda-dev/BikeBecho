package com.BikeBecho.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BikeBecho.Utility.DBUtility;
import com.BikeBecho.pojo.WishList;
//import com.mysql.jdbc.PreparedStatement;

public class WishListDaoImpl implements WishListDao
{
	WishList w;
    String str;
    int row;
    PreparedStatement stmt;
    ResultSet rs;
    static Connection con=DBUtility.connection();
    
    List<WishList> list;
    		
    
	@Override
	public boolean addToWishList(WishList w) 
	{
		str="INSERT INTO WishList(bikeId,email) VALUES(?,?)";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setInt(1,w.getBikeId());
			stmt.setString(2, w.getEmail());
			row=stmt.executeUpdate();
			
	    }
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
		{
			return true;
		}
		else
			return false;
	}

	@Override
	public List<WishList> showWishList(String email) 
	{
		str="SELECT w.wishListId,w.bikeId,b.bikeModel,b.price,w.email FROM WishList AS w INNER JOIN  Bike AS b WHERE w.bikeId=b.bikeId AND w.email=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setString(1, email);
			rs=stmt.executeQuery();
			list=new ArrayList<>();
			/*if(rs.next()==false)
			{
				
				System.out.println("no data available");
			
			}*/
			//else
			while(rs.next())
			{
				
				w=new WishList(rs.getInt("bikeId"),rs.getString("bikeModel"),rs.getString("email"),rs.getDouble("price"));
				w.setWishListId(rs.getInt("wishListId"));
				list.add(w);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteWishListById(int wishListId)
	{
		str="DELETE FROM WishList WHERE wishListId=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setInt(1,wishListId);
			row=stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
		{
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean clearWishList(String email) 
	{
		str="DELETE FROM WishList WHERE email=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setString(1, email);
			row=stmt.executeUpdate();	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>0)
		{
			return true;
		}
		else
			return false;
	}
	

}
