package com.qa.ims.persistence.domain;

public class Order_Details {

	private Long FID;
	private Long order_ID;
	private Long item_ID;
	private Long quantity;
	private Double cost;

	public Order_Details(Long order_ID, Long item_ID) {
		this.setOrder_ID(order_ID);
		this.setItem_ID(item_ID);
	}
	
	public Order_Details(Long FID, Long order_ID, Long item_ID) {
		this.setFID(FID);
		this.setOrder_ID(order_ID);
		this.setItem_ID(item_ID);
	}
	
	public Order_Details(Long FID, Long order_ID, Long item_ID, Long quantity) {
		this.setFID(FID);
		this.setOrder_ID(order_ID);
		this.setItem_ID(item_ID);
		this.setQuantity(quantity);
	}

	public Order_Details(Long FID, Long order_ID, Long item_ID, Long quantity, Double cost) {
		this.setFID(FID);
		this.setOrder_ID(order_ID);
		this.setItem_ID(item_ID);
		this.setQuantity(quantity);
		this.setCost(cost);
	}

	public Long getFID() {
		return FID;
	}

	public void setFID(Long FID) {
		this.FID = FID;
	}

	public Long getOrder_ID() {
		return order_ID;
	}

	public void setOrder_ID(Long order_ID) {
		this.order_ID = order_ID;
	}

	public Long getItem_ID() {
		return item_ID;
	}

	public void setItem_ID(Long item_ID) {
		this.item_ID = item_ID;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Order_Details [FID=" + FID + ", order_ID=" + order_ID + ", item_ID=" + item_ID + ", quantity="
				+ quantity + ", cost=" + cost + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FID == null) ? 0 : FID.hashCode());
		result = prime * result + ((order_ID == null) ? 0 : order_ID.hashCode());
		result = prime * result + ((item_ID == null) ? 0 : item_ID.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
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
		Order_Details other = (Order_Details) obj;
		if (getFID() == null) {
			if (other.getFID() != null)
				return false;
		} else if (!getFID().equals(other.getFID()))
			return false;
		if (order_ID == null) {
			if (other.order_ID != null)
				return false;
		} else if (!order_ID.equals(other.order_ID))
			return false;
		if (item_ID == null) {
			if (other.item_ID != null)
				return false;
		} else if (!item_ID.equals(other.item_ID))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;

		return true;
	}

}