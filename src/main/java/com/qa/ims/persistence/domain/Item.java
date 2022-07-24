package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {

	private Long itemId;
	private String itemName;
	private Double itemPrice;

	public Item(String itemName, Double itemPrice) {
		this.setItemName(itemName);
		this.setItemPrice(itemPrice);
	}

	public Item(Long itemId, String itemName, Double itemPrice) {
		this.setItemId(itemId);
		this.setItemName(itemName);
		this.setItemPrice(itemPrice);
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Item ID: " + itemId + " Item Name: " + itemName + " Item Price: " + itemPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, itemName, itemPrice);
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
		return Objects.equals(itemId, other.itemId) && Objects.equals(itemName, other.itemName)
				&& Objects.equals(itemPrice, other.itemPrice);
	}
}