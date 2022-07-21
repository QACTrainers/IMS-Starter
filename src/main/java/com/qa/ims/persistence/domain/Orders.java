package com.qa.ims.persistence.domain;

public class Orders {

	private Long orderID;
	private Long fk_id;
	private Long fk_itemID;
	private Long quantity;

	public Orders(Long orderID, Long fk_id, Long fk_itemID, Long quantity) {
		this.setOrderID(orderID);
		this.setFk_id(fk_id);
		this.setFk_itemID(fk_itemID);
		this.setQuantity(quantity);
	}

	public Orders(Long fk_id, Long fk_itemID, Long quantity) {
		this.setFk_id(fk_id);
		this.setFk_itemID(fk_itemID);
		this.setQuantity(quantity);
	}

	@Override
	public String toString() {
		return "OrderID=" + orderID + ", fk_id=" + fk_id + ", fk_itemID=" + fk_itemID + ", quantity=" + quantity;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Long getFk_id() {
		return fk_id;
	}

	public void setFk_id(Long fk_id) {
		this.fk_id = fk_id;
	}

	public Long getFk_itemID() {
		return fk_itemID;
	}

	public void setFk_itemID(Long fk_itemID) {
		this.fk_itemID = fk_itemID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		result = prime * result + ((fk_id == null) ? 0 : fk_id.hashCode());
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
		if (fk_id == null) {
			if (other.fk_id != null)
				return false;
		} else if (!fk_id.equals(other.fk_id))
			return false;
		if (fk_itemID == null) {
			if (other.fk_itemID != null)
				return false;
		} else if (!fk_itemID.equals(other.fk_itemID))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

}
