package com.jo.productrest;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;

public class Product {
	
	private int id;
	private String name;
	private int quantity;
	private double price;
	
	public Product(int id, String name, int quantity, double price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	//no args constructor
	public Product() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	//toString method 
	@Override
	public String toString() {
		return "Product: [id = " + id + ", name = " + name;
	}
}
