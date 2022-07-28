package com.BikeBecho.Dao;

import java.util.List;

import com.BikeBecho.pojo.Bike;

public interface BikeDao 
{
	boolean addBike(Bike b);
	boolean updateBike(Bike b);
	boolean deleteBikeById(int bikeId);
	Bike getBikeByid(int bikeId);
	List<Bike> getAllBike();
	List<Bike> getListBySearch(String search,double start, double end);
	List<String> needToAjax(String ajax);
	List<Bike> getBikeByPriceRange(double start,double end);
	List<Bike> getBikeByEmail(String email);

}
