package com.qa.ims.persistence.domain;
//DONE

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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
        result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
        result = prime * result + ((itemValue == null) ? 0 : itemValue.hashCode());
        result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
        result = prime * result + ((colour == null) ? 0 : colour.hashCode());
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
        Item other = (Item) obj;
        if (itemName == null) {
            if (other.getItemID() != null)
                return false;
        } else if (itemName.equals(other.getItemName()))
            return false;
        if (itemID == null) {
            if (other.getItemID() != null)
                return false;
        } else if (!itemID.equals(other.getItemID()))
            return false;
        if (itemValue == null) {
            if (other.getItemValue() != null)
                return false;
        } else if (!itemValue.equals(other.getItemValue()))
            return false;
        if (quantity == null) {
            if (other.getQuantity() != null)
                return false;
        } else if (!quantity.equals(other.getQuantity()))
            return false;
        if (colour == null) {
            if (other.getColour() != null)
                return false;
        } else if (!colour.equals(other.getColour()))
            return false;
        return true;
    }
}
