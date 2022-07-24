package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private Long orderId;
	// private Long orderItemId; ??
	private Long id; // ( = customerId)
	private Long itemId;
	private Double quantity;
	private Double totalPrice;

	public Order(Long id, Long itemId) {
		super();
		this.id = id;
		this.itemId = itemId;
	}

	public Order(Long orderId, Long id, Long itemId, Double quantity, Double totalPrice) {
		super();
		this.orderId = orderId;
		this.id = id;
		this.itemId = itemId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Order ID: " + orderId + " Customer ID: " + id + " Item ID: " + itemId + " Total Price: " + totalPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itemId, orderId, quantity, totalPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id) && Objects.equals(itemId, other.itemId)
				&& Objects.equals(orderId, other.orderId) && quantity == other.quantity
				&& Objects.equals(totalPrice, other.totalPrice);

	}
}
