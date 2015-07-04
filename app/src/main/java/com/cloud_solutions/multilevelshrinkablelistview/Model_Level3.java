package com.cloud_solutions.multilevelshrinkablelistview;

/**
 * third level item
 */
public class Model_Level3 {
    private String itemName;
    private String itemPrice;

    public Model_Level3(String itemName, String itemPrice) {
        super();
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}