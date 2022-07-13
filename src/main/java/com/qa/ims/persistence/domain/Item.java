package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {
    private Long itemId;
    private String itemName;
    private Double itemPrice;

    public Item(){};

    public Item(String itemName, Double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Item(Long itemId, String itemName, Double itemPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "Item ID: " + itemId + ", Item Name: " + itemName + ", Item Price: " + itemPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemId, itemPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Item other = (Item) o;
        if (itemName == null) {
            if (other.itemName != null)
                return false;
        } else if (!itemName.equals(other.itemName))
            return false;
        if (itemId == null) {
            return other.itemId == null;
        } else return itemId.equals(other.itemId);
    }
}
