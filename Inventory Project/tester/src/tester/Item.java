/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

/**
 *
 * @author user
 */
public class Item {
    private String itemId;
    private String itemName;
    private String itemBrand;
    private double price;

    public Item(String itemId, String itemName, String itemBrand, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemBrand = itemBrand;
        this.price = price;
    }
    
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
