package com.qa.ims.persistence.domain;

public class Item {
		
	private  Long item_id;
	private  String item_name;
	private  Double item_price;

	public Item(String item_name, Double item_price) {
		this.item_name = item_name;
		this.item_price = item_price;

	}

	public Item(Long id, String item_name, Double item_price) {
		this.item_id = id;
		this.item_name = item_name;
		this.item_price = item_price;
		;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public Double getItem_price() {
		return item_price;
	}

	public void setItem_price(Double item_price) {
		this.item_price = item_price;
	}

	@Override
	public String toString() {
		return "Item [item_id=" + item_id + " item_name=" + item_name + " item_price=" + item_price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
		result = prime * result + ((item_price == null) ? 0 : item_price.hashCode());
		return result;
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
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		if (item_price == null) {
			if (other.item_price != null)
				return false;
		} else if (!item_price.equals(other.item_price))
			return false;
		return true;
	}



}

