package com.qa.ims.persistence.domain;

public class Order {

	private long order_id;
	private long customer_id;
	private long item_id;

	public Order(long order_id, long customer_id, long item_id) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.item_id = item_id;
	}

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public long getItem_id() {
		return item_id;
	}

	public void setItem_id(long item_id) {
		this.item_id = item_id;
	}

}
