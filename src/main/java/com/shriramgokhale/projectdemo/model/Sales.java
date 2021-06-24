package com.shriramgokhale.projectdemo.model;

import java.io.Serializable;

public class Sales {
	
	private int id;
	private String item;
	private String quantity;
	private float price;
	
	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sales(int id, String item, String quantity, float price) {
		super();
		this.id = id;
		this.item = item;
		this.quantity = quantity;
		this.price = price;
	}

	public Sales(String item, String quantity, float price) {
		super();
		this.item = item;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Sales [id=" + id + ", item=" + item + ", quantity=" + quantity + ", price=" + price + "]";
	}

}
