package com.BikeBecho.pojo;

public class WishList 
{
	private int wishListId,bikeId;
	private String bikeName,email;
	private Double price;
	public WishList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WishList(int bikeId, String email) 
	{
		super();
		this.bikeId = bikeId;
		this.email = email;
		
	}
	public WishList(int bikeId, String bikeName, String email, Double price) {
		super();
		this.bikeId = bikeId;
		this.bikeName = bikeName;
		this.email = email;
		this.price = price;
	}
	public int getWishListId() {
		return wishListId;
	}
	public void setWishListId(int wishListId) {
		this.wishListId = wishListId;
	}
	public int getBikeId() {
		return bikeId;
	}
	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}
	public String getBikeName() {
		return bikeName;
	}
	public void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "WishList [wishListId=" + wishListId + ", bikeId=" + bikeId + ", bikeName=" + bikeName + ", email="
				+ email + ", price=" + price + "]";
	}

}
