package com.qa.ims.persistence.domain;

public class Order {

	private Long orderId;
	private Long customerId;
	
	public Order (Long customerId) {
		this.setCustomerId(customerId);
	}
	
	public Order (Long customerId, Long orderId) {
		this.setCustomerId(customerId);
		this.setOrderId(orderId);
	}

	

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer Id:" + customerId + " Order Id:" + orderId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
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
		Order other = (Order) obj;
		if (getCustomerId() == null) {
			if (other.getCustomerId() != null)
				return false;
		} else if (!getCustomerId().equals(other.getCustomerId()))
			return false;
		if (orderId == null) {
			if (other.orderId!= null)
				return false;
		} else if (!orderId.equals(other.getOrderId()))
			return false;
		return true;
	}

}
