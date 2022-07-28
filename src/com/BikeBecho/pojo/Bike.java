package com.BikeBecho.pojo;

import java.io.InputStream;

public class Bike 
{
	private int bikeId;
	private String bikeManufacturerName,bikeModel;
	private String datePosted;
	private String year;
	private int kmDriven;
	private double price;
	private String documentsAvailable,bikeCondition;
	private String city;
	private String description;
	InputStream img1,img2,img3;
	private String email;
	
	public Bike() 
	{
		
	}
	
	public Bike(String bikeManufacturerName, String bikeModel, String datePosted, String year, int kmDriven,
			double price, String documentsAvailable, String bikeCondition, String city, String description,
			InputStream img1, InputStream img2, InputStream img3) {
		super();
		this.bikeManufacturerName = bikeManufacturerName;
		this.bikeModel = bikeModel;
		this.datePosted = datePosted;
		this.year = year;
		this.kmDriven = kmDriven;
		this.price = price;
		this.documentsAvailable = documentsAvailable;
		this.bikeCondition = bikeCondition;
		this.city = city;
		this.description = description;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		
	}

	
	 
	
	public int getBikeId() {
		return bikeId;
	}
	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}
	public String getBikeManufacturerName() {
		return bikeManufacturerName;
	}
	public void setBikeManufacturerName(String bikeManufacturerName) {
		this.bikeManufacturerName = bikeManufacturerName;
	}
	public String getBikeModel() {
		return bikeModel;
	}
	public void setBikeModel(String bikeModel) {
		this.bikeModel = bikeModel;
	}
	public String getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(String datePosted) {
		this.datePosted = datePosted;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getKmDriven() {
		return kmDriven;
	}
	public void setKmDriven(int kmDriven) {
		this.kmDriven = kmDriven;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDocumentsAvailable() {
		return documentsAvailable;
	}
	public void setDocumentsAvailable(String documentsAvailable) {
		this.documentsAvailable = documentsAvailable;
	}
	public String getBikeCondition() {
		return bikeCondition;
	}
	public void setBikeCondition(String bikeCondition) {
		this.bikeCondition = bikeCondition;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public InputStream getImg1() {
		return img1;
	}
	public void setImg1(InputStream img1) {
		this.img1 = img1;
	}
	public InputStream getImg2() {
		return img2;
	}
	public void setImg2(InputStream img2) {
		this.img2 = img2;
	}
	public InputStream getImg3() {
		return img3;
	}
	public void setImg3(InputStream img3) {
		this.img3 = img3;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Bike [bikeId=" + bikeId + ", bikeManufacturerName=" + bikeManufacturerName + ", bikeModel=" + bikeModel
				+ ", datePosted=" + datePosted + ", year=" + year + ", kmDriven=" + kmDriven + ", price=" + price
				+ ", documentsAvailable=" + documentsAvailable + ", bikeCondition=" + bikeCondition + ", city=" + city
				+ ", description=" + description + ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + ", email="
				+ email + "]";
	}
	
	
	

}
