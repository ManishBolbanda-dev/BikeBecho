package com.BikeBecho.Dao;

import java.util.List;

import com.BikeBecho.pojo.WishList;

public interface WishListDao 
{
	boolean addToWishList(WishList w);
	List<WishList> showWishList(String email);
	boolean deleteWishListById(int wishListId);
	boolean clearWishList(String email);
	

}
