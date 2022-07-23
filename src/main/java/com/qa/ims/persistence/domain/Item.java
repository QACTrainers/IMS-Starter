package com.qa.ims.persistence.domain;

public class Item {

	private long item_id;
	private String item_name;
	private double item_price;

	public Item(long item_id, String item_name, double item_price) {
		this.setItem_id(item_id);
		this.setItem_name(item_name);
		this.setItem_price(item_price);
	}

	public Item(String item_name, double item_price) {
		this.setItem_name(item_name);
		this.setItem_price(item_price);
	}

	public Item(String item_name) {
		this.setItem_name(item_name);
	}

	public long getItem_id() {
		return item_id;
	}

	public void setItem_id(long item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public double getItem_price() {
		return item_price;
	}

	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}

}
