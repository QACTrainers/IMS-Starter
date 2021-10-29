package com.qa.ims.persistence.domain;

import java.util.ArrayList;

public class Order {
//	private Long orderline_id;
	private Long order_id;
	private Long customer_id;
//	private ArrayList<Item> item_list = new ArrayList<>();
	private Integer quantity;
//	private Item item = null;
//	private Double orderline_price;
////	private String first_name;
////	private String surname;
////	private String address;
//	private Long item_id;

	
	
	public Order(Long order_id, Long customer_id, Integer quantity) {
	super();
	this.order_id = order_id;
	this.customer_id = customer_id;
	this.quantity = quantity;
}


	public Order(Long order_id, Long item_id, Integer quantity, Double orderline_price) {
		this.order_id = order_id;
		this.quantity = quantity;
//		this.orderline_price = orderline_price;
//		this.item_id = item_id;
	}
	

	public Order() {
		
	}
	
	public Order(Integer quantity, Double orderline_price) {
		this.quantity = quantity;
		this.orderline_price = orderline_price;
	}
	
	

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Order(Long customer_id) {
		this.customer_id = customer_id;
	}

	public Order(Long order_id, Long customer_id) {
		this.order_id = order_id;
		this.customer_id = customer_id;
	}

	public Order(Long order_id, Long customer_id, ArrayList<Item> item_list) {

		this.order_id = order_id;
		this.customer_id = customer_id;
		this.item_list = item_list;
	}

	public Order(Long orderline_id, Long order_id, Long customer_id, Integer quantity, Long item_id,
			Double orderline_price, String first_name, String surname, String address) {
		super();
		this.orderline_id = orderline_id;
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.quantity = quantity;
		this.item_id = item_id;
		this.orderline_price = orderline_price;
		this.first_name = first_name;
		this.surname = surname;
		this.address = address;
	}

	public Order(Long order_id, Long customer_id, Long item_id) {
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.item_id = item_id;
	}
	
	
	public Order(Long order_id, Long orderline_id, Double orderline_price) {
		this.order_id = order_id;
		this.orderline_id = orderline_id;
		this.orderline_price = orderline_price;

	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void addItemsInOrder(Item item) {
		this.item_list.add(item);
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public ArrayList<Item> getItem_list() {
		return item_list;
	}

	public void setItem_list(ArrayList<Item> item_list) {
		this.item_list = item_list;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [orderline_id=" + orderline_id + ", order_id=" + order_id + ", customer_id=" + customer_id
				+ ", item_id=" + item_id + ", quantity=" + quantity + ", orderline_price=" + orderline_price
				+ ", first_name=" + first_name + ", surname=" + surname + ", address=" + address + ", item_id="
				+ item_id + "]";
	}
 
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result + ((item_list == null) ? 0 : item_list.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((orderline_id == null) ? 0 : orderline_id.hashCode());
		result = prime * result + ((orderline_price == null) ? 0 : orderline_price.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		if (item_list == null) {
			if (other.item_list != null)
				return false;
		} else if (!item_list.equals(other.item_list))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (orderline_id == null) {
			if (other.orderline_id != null)
				return false;
		} else if (!orderline_id.equals(other.orderline_id))
			return false;
		if (orderline_price == null) {
			if (other.orderline_price != null)
				return false;
		} else if (!orderline_price.equals(other.orderline_price))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}


	public Double getOrderline_price() {
		return orderline_price;
	}

	public void setOrderline_price(Double orderline_price) {
		this.orderline_price = orderline_price;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public Long getOrderline_id() {
		return orderline_id;
	}

	public void setOrderline_id(Long orderline_id) {
		this.orderline_id = orderline_id;
	}

}