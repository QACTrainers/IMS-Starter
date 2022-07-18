package com.qa.ims.persistence.domain;

public class Orders {

	private Long orderID;
	private Long customerID;
	private String date;
	private Long fk_itemID;

	public Orders(Long orderID, Long customerID, String date, Long fk_itemID) {
		this.setOrderID(orderID);
		this.setCustomerID(customerID);
		this.setDate(date);
		this.setFk_itemID(fk_itemID);

	}

	public Orders(Long customerID, String date) {
		this.setCustomerID(customerID);
		this.setDate(date);
	}

	public Orders(Long customerID, Long fk_itemID) { // dont need date to update orders
		this.setCustomerID(customerID);
		this.setFk_itemID(fk_itemID);
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getFk_itemID() {
		return fk_itemID;
	}

	public void setFk_itemID(Long fk_itemID) {
		this.fk_itemID = fk_itemID;
	}

	@Override
	public String toString() {
		return "orderID = " + orderID + " customerID = " + customerID + " date = " + date + " itemID = " + fk_itemID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((fk_itemID == null) ? 0 : fk_itemID.hashCode());
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
		Orders other = (Orders) obj;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		if (customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (fk_itemID == null) {
			if (other.fk_itemID != null)
				return false;
		} else if (!fk_itemID.equals(other.fk_itemID))
			return false;
		return true;
	}

}
