package com.qa.ims.persistence.domain;

public class Order {

	private Long order_id;
	private Long customer_id;
	private Long item_id;

	public Order(long customer_id, long item_id) {
		super();
		this.customer_id = customer_id;
		this.item_id = item_id;
	}

	public Order(long customer_id) {
		super();
		this.customer_id = customer_id;
	}

	public Order(long order_id, long customer_id, long item_id) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.item_id = item_id;
	}

	public Long getOrder_id() {
		return this.order_id;
	}

	public void setOrder_id(long order_Id) {
		order_id = order_Id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_Id) {
		customer_id = customer_Id;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(long item_Id) {
		item_id = item_Id;
	}

	@Override
	public String toString() {
		return "Order ID:" + order_id + " Customer ID:" + customer_id + " Item ID:" + item_id;
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
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;

		return true;
	}
}
