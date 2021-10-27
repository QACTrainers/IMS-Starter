package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private long id;
	private long customer_id;

	public Order(long customer_id) {
		super();
		this.customer_id = customer_id;

	}

	public Order(long id, long customer_id) {
		super();
		this.id = id;
		this.customer_id = customer_id;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	@Override
	public String toString() {
		return "id:" + id + ", customer_id:" + customer_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer_id, id);
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
		return customer_id == other.customer_id && id == other.id;
	}

}
