package com.qa.ims.persistence.domain;
//DONE

import java.util.Objects;

public class Item {
    //Item(itemID, itemName, itemValue, quantity, colour)
    private Long itemID;
    private String itemName;
    private Long itemValue;
    private Long quantity;
    private String colour;

    public Item(Long itemID, String itemName, Long itemValue, Long quantity, String colour) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemValue = itemValue;
        this.quantity = quantity;
        this.colour = colour;
    }

    public Item(String itemName, Long itemValue, Long quantity, String colour) {
        this.itemName = itemName;
        this.itemValue = itemValue;
        this.quantity = quantity;
        this.colour = colour;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public Long getItemID() {
        return itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemValue(Long itemValue) {
        this.itemValue = itemValue;
    }

    public Long getItemValue() {
        return itemValue;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "id:" + itemID + " item name: " + itemName + " item value: £" + itemValue + " quantity: " + quantity + " colour: " + colour;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemID, item.itemID) && Objects.equals(itemName, item.itemName) && Objects.equals(itemValue, item.itemValue) && Objects.equals(quantity, item.quantity) && Objects.equals(colour, item.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemID, itemName, itemValue, quantity, colour);
    }
}
