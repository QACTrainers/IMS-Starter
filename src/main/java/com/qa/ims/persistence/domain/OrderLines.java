package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderLines {

	private long id;
	private long orderId;
	private long itemId;
	private long quantity;
	public OrderLines(long id, long orderId, long itemId, long quantity) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
	}
	public OrderLines(long orderId, long itemId, long quantity) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
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
		return Objects.hash(id, itemId, orderId, quantity);
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
		return id == other.id && itemId == other.itemId && orderId == other.orderId && quantity == other.quantity;
	}
	@Override
	public String toString() {
		return "OrderLines [id=" + id + ", orderId=" + orderId + ", itemId=" + itemId + ", quantity=" + quantity + "]";
	}
	
	
	
	
}
