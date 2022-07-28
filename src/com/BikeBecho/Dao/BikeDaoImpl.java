package com.BikeBecho.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BikeBecho.Utility.DBUtility;
import com.BikeBecho.pojo.Bike;

public class BikeDaoImpl implements BikeDao
{
	Bike b;
	int row;
	String str;
	PreparedStatement stmt;
	ResultSet rs;
	//Connection con;
	static Connection con=DBUtility.connection();
	
	List<Bike> list=new ArrayList<>();
	

	@Override
	public boolean addBike(Bike b)
	{
		str="INSERT into Bike(bikeManufacturerName,bikeModel,datePosted,year,kmDriven,price,docsAvailable,bikeCondition,city,description,img1,img2,img3,userEmail)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setString(1,b.getBikeManufacturerName());
			stmt.setString(2,b.getBikeModel());
			stmt.setString(3, b.getDatePosted());
			stmt.setString(4, b.getYear());
			stmt.setInt(5, b.getKmDriven());
			stmt.setDouble(6, b.getPrice());
			stmt.setString(7, b.getDocumentsAvailable());
			stmt.setString(8,b.getBikeCondition());
			stmt.setString(9,b.getCity());
			stmt.setString(10, b.getDescription());
			stmt.setBinaryStream(11,b.getImg1());
			stmt.setBinaryStream(12,b.getImg2());
			stmt.setBinaryStream(13,b.getImg3());
			stmt.setString(14, b.getEmail());
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
		{return false;}
	}

	@Override
	public boolean updateBike(Bike b)
	{
		str="UPDATE Bike set bikeManufacturerName=?,bikeModel=?,datePosted=?,year=?,kmDriven=?,price=?,docsAvailable=?,bikeCondition=?,city=?,description=?,"
				+ "img1=?,img2=?,img3=? where bikeId=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setString(1,b.getBikeManufacturerName());
			stmt.setString(2,b.getBikeModel());
			stmt.setString(3, b.getDatePosted());
			stmt.setString(4, b.getYear());
			stmt.setInt(5, b.getKmDriven());
			stmt.setDouble(6, b.getPrice());
			stmt.setString(7, b.getDocumentsAvailable());
			stmt.setString(8,b.getBikeCondition());
			stmt.setString(9,b.getCity());
			stmt.setString(10, b.getDescription());
			stmt.setBinaryStream(11,b.getImg1());
			stmt.setBinaryStream(12,b.getImg2());
			stmt.setBinaryStream(13,b.getImg3());
			stmt.setInt(14,b.getBikeId());
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
		{
		return false;
		}
	}

	@Override
	public boolean deleteBikeById(int bikeId)
	{
		str="delete from Bike where bikeId=?";
		
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setInt(1,bikeId);
			row=stmt.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		if(row>1)
			return true;
		return false;
	}

	@Override
	public Bike getBikeByid(int bikeId)
	{
		str="SELECT * FROM Bike WHERE bikeId=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setInt(1, bikeId);
			rs=stmt.executeQuery();
		    while(rs.next())
		    {
		    	b=new Bike(rs.getString("bikeManufacturerName"),rs.getString("bikeModel"),rs.getString("datePosted"),rs.getString("year"),rs.getInt("kmDriven"),
		    			rs.getDouble("price"),rs.getString("docsAvailable"),rs.getString("bikeCondition"),rs.getString("city"),rs.getString("description"),
		    			rs.getBinaryStream("img1"),rs.getBinaryStream("img2"),rs.getBinaryStream("img3"));
		    	b.setEmail(rs.getString("userEmail"));
	            b.setBikeId(rs.getInt("bikeId"));	    
		    }
		    
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Bike> getAllBike() 
	{   
		list=new ArrayList<>();
		str="SELECT * FROM BIKE";
		try
		{
			stmt=con.prepareStatement(str);
			rs=stmt.executeQuery();
			/* "key imp point" 
			 * if we do check list is Empty in this way then as the .next() is called twice it will leave the 1st row data and only n-1 row datas will be returned
			 * if(rs.next()==false) {
			 * System.out.println("No data is present for your search"); }
			  */			
			
			while(rs.next())
			{
				b=new Bike(rs.getString("bikeManufacturerName"),rs.getString("bikeModel"),rs.getString("datePosted"),rs.getString("year"),rs.getInt("kmDriven"),
		    			rs.getDouble("price"),rs.getString("docsAvailable"),rs.getString("bikeCondition"),rs.getString("city"),rs.getString("description"),
		    			rs.getBinaryStream("img1"),rs.getBinaryStream("img2"),rs.getBinaryStream("img3"));
				b.setEmail(rs.getString("userEmail"));
	            b.setBikeId(rs.getInt("bikeId"));	 
	            list.add(b);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Bike> getListBySearch(String search,double start, double end) 
	{
		if(search!=null && end==0.0) //case1:if only data from search box is submitted
		{
			list=new ArrayList<>();
			str="SELECT * FROM Bike WHERE bikeManufacturerName=? OR bikeModel=?";
			try
			{
				stmt=con.prepareStatement(str);
				stmt.setString(1, search);
				stmt.setString(2, search);
				rs=stmt.executeQuery();
				
				if(rs.next()==false)
				{
					System.out.println("No data is present for your search");
				}
				else
				{
					do
					{
						b=new Bike(rs.getString("bikeManufacturerName"),rs.getString("bikeModel"),rs.getString("datePosted"),rs.getString("year"),rs.getInt("kmDriven"),
				    			rs.getDouble("price"),rs.getString("docsAvailable"),rs.getString("bikeCondition"),rs.getString("city"),rs.getString("description"),
				    			rs.getBinaryStream("img1"),rs.getBinaryStream("img2"),rs.getBinaryStream("img3"));
						b.setEmail(rs.getString("userEmail"));
			            b.setBikeId(rs.getInt("bikeId"));	 
			            list.add(b);		
					}
					
					while(rs.next()) ;
		
					
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return list;
		}
		else if(search==null && end>0.0)
		{
			list=new ArrayList<>();
			str="SELECT * FROM Bike WHERE price BETWEEN ? AND ?";
			try
			{
				stmt=con.prepareStatement(str);
				stmt.setDouble(1, start);
				stmt.setDouble(2, end);
				rs=stmt.executeQuery();
				
				if(rs.next()==false)
				{
					System.out.println("no result found in the range of "+start+" And "+end);
				}
				else
				{
					do
					{
						b=new Bike(rs.getString("bikeManufacturerName"),rs.getString("bikeModel"),rs.getString("datePosted"),rs.getString("year"),rs.getInt("kmDriven"),
				    			rs.getDouble("price"),rs.getString("docsAvailable"),rs.getString("bikeCondition"),rs.getString("city"),rs.getString("description"),
				    			rs.getBinaryStream("img1"),rs.getBinaryStream("img2"),rs.getBinaryStream("img3"));
						b.setEmail(rs.getString("userEmail"));
			            b.setBikeId(rs.getInt("bikeId"));	 
			            list.add(b);
					}
					while(rs.next());
				}

			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return list;
		}
		else
		{
			list=new ArrayList<>();
			str="SELECT * FROM Bike WHERE bikeManufacturerName=? OR bikeModel=?(SELECT * FROM Bike WHERE price BETWEEN ? AND ?)";
		}
		return list;
		
	}

	@Override
	public List<String> needToAjax(String ajax)
	{
		List<String> li=new ArrayList<>();
		str="SELECT bikeModel FROM Bike WHERE bikeModel LIKE ? ORDER BY bikeModel";

		//str="SELECT bikeModel FROM Bike WHERE bikeModel LIKE "+"'"+ajax+"%"+"'";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setString(1, ajax+"%");
			rs=stmt.executeQuery();
			if(rs.next()==false)
			{
				System.out.println("no result found");
			}
			else
			{
				do
				{
					String data=rs.getString("bikeModel");
					li.add(data);
				}
				while(rs.next());
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return li;
	}

	@Override
	public List<Bike> getBikeByPriceRange(double start, double end) 
	{
		list=new ArrayList<>();
		str="SELECT * FROM Bike WHERE price BETWEEN ? AND ?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setDouble(1, start);
			stmt.setDouble(2, end);
			rs=stmt.executeQuery();
			
			if(rs.next()==false)
			{
				System.out.println("no result found in the range of "+start+" And "+end);
			}
			else
			{
				do
				{
					b=new Bike(rs.getString("bikeManufacturerName"),rs.getString("bikeModel"),rs.getString("datePosted"),rs.getString("year"),rs.getInt("kmDriven"),
			    			rs.getDouble("price"),rs.getString("docsAvailable"),rs.getString("bikeCondition"),rs.getString("city"),rs.getString("description"),
			    			rs.getBinaryStream("img1"),rs.getBinaryStream("img2"),rs.getBinaryStream("img3"));
					b.setEmail(rs.getString("userEmail"));
		            b.setBikeId(rs.getInt("bikeId"));	 
		            list.add(b);
				}
				while(rs.next());
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Bike> getBikeByEmail(String email)
	{
		list=new ArrayList<>();
		str="select * from Bike where userEmail=?";
		try
		{
			stmt=con.prepareStatement(str);
			stmt.setString(1, email);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				b=new Bike(rs.getString("bikeManufacturerName"),rs.getString("bikeModel"),rs.getString("datePosted"),rs.getString("year"),rs.getInt("kmDriven"),
			    			rs.getDouble("price"),rs.getString("docsAvailable"),rs.getString("bikeCondition"),rs.getString("city"),rs.getString("description"),
			    			rs.getBinaryStream("img1"),rs.getBinaryStream("img2"),rs.getBinaryStream("img3"));
				b.setEmail(rs.getString("userEmail"));
				b.setBikeId(rs.getInt("bikeId"));	 
		        list.add(b);
				
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
		
	}

}
