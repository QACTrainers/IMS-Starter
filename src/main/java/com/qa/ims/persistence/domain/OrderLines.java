package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderLines {

	private long id;
	private long itemId;
	private long quantity;
	private long orderId;
	
	
	public OrderLines(long id, long itemId, long quantity, long orderId) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.quantity = quantity;
		this.orderId = orderId;
	}
	public OrderLines(long id, long itemId, long quantity) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.quantity = quantity;
	}
	public OrderLines(long itemId, long quantity) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
	}
	public long getId() {
		return id;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, itemId, quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLines other = (OrderLines) obj;
		return id == other.id && itemId == other.itemId && quantity == other.quantity;
	}
	@Override
	public String toString() {
		return "OrderLines [id=" + id + ", itemId=" + itemId + ", quantity=" + quantity + "]";
	}
	
	
}
