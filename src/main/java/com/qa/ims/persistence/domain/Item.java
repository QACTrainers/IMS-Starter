package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private long id;
	private String item_name;
	private double value;
	public Item(long id, String item_name, double value) {
		super();
		this.id = id;
		this.item_name = item_name;
		this.value = value;
	}
	public Item(String item_name, double value) {
		super();
		this.item_name = item_name;
		this.value = value;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "id:" + id + ", item_name:" + item_name + ", value:" + value;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, item_name, value);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return id == other.id && Objects.equals(item_name, other.item_name)
				&& Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}
	
	
	
}
