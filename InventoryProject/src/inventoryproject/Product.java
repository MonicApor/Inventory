/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryproject;

/**
 *
 * @author user
 */
public class Product {
        private int id;
	private String productId;
	private String productName;
	private String productBrand;
	private double costPrice;
        private int stocks;
	private boolean status;

    public Product(){
        
    }
    
    public Product(int id,String productId,String productName,String productBrand,double costPrice,int stocks,boolean status){
        this.id = id;
        this.costPrice = costPrice;
        this.productBrand = productBrand;
        this.stocks = stocks;
        this.status = status;
        this.productId = productId;
        this.productName = productName;
    }
        
    public String getProductId() {
        return productId;
    }
    public int getId() {
        return id;
    }
    
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setProuctId(String productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCostprice(double costprice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
