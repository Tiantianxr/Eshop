package com.zy.bean;

import java.io.Serializable;

public class Good implements Serializable{

	private String id;
	private String image;
	private String message;
	private double price;
	private String shopName;

	private int number;
	private double sum;// 单品小计

	public Good() {
		super();
	}

	public Good(String id, int number) {
		super();
		this.id = id;
		this.number = number;
	}

	public Good(String id, String image, String message, double price, String shopName, int number, double sum) {
		super();
		this.id = id;
		this.image = image;
		this.message = message;
		this.price = price;
		this.shopName = shopName;
		this.number = number;
		this.sum = sum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "Good [id=" + id + ", image=" + image + ", message=" + message + ", price=" + price + ", shopName="
				+ shopName + ", number=" + number + ", sum=" + sum + "]";
	}

}
