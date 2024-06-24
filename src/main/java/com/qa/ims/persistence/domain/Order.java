package com.qa.ims.persistence.domain;

import java.util.HashMap;
import java.util.Objects;

public class Order {

	private Long orderId;
	private int customer_id;
	private Double totalOrderPrice;
	private HashMap<Long, Integer> items = new HashMap<Long, Integer>();

	

	public Order(Long orderId, int customer_id, Double totalOrderPrice, HashMap<Long, Integer> items) {
		this.orderId = orderId;
		this.customer_id = customer_id;
		this.totalOrderPrice = totalOrderPrice;
		this.items = items;
	}
	
	public Order(int customer_id, Double totalOrderPrice, HashMap<Long, Integer> items) {
		this.customer_id = customer_id;
		this.totalOrderPrice = totalOrderPrice;
		this.items = items;
	}
	
	public Order(Long orderId , Double totalOrderPrice) {
		this.orderId = orderId;
		this.totalOrderPrice = totalOrderPrice;
	}
	
	public Order(int customer_id ,HashMap<Long, Integer> items, Double totalOrderPrice) {
		this.customer_id = customer_id;
		this.items = items;
		this.totalOrderPrice = totalOrderPrice;
	}
	
	

	public Order(Long orderId, int customer_id, Double totalOrderPrice) {
		this.orderId = orderId;
		this.customer_id = customer_id;
		this.totalOrderPrice = totalOrderPrice;
	}

	public Order(int customer_id, HashMap<Long, Integer> items) {
		this.customer_id = customer_id;
		this.items = items;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public int getcustomer_id() {
		return customer_id;
	}

	public void setcustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	
	public Double getTotalOrderPrice() {
		return totalOrderPrice;
	}

	public void setTotalOrderPrice(Double totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}

	public HashMap<Long, Integer> getItems() {
		return items;
	}

	public void setItems(HashMap<Long, Integer> items) {
		this.items = items;
	}
	
	@Override
	public String toString() {
		return "order id:" + orderId + "customer_id:" + customer_id  + "totalOrderPrice:" + totalOrderPrice;
	}
		@Override
		public int hashCode() {
			return Objects.hash(customer_id, items, orderId, totalOrderPrice);
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
		return customer_id == other.customer_id && Objects.equals(items, other.items)
				&& Objects.equals(orderId, other.orderId) && Objects.equals(totalOrderPrice, other.totalOrderPrice);
	}
	
	
}


