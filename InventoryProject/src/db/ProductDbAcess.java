/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import inventoryproject.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ProductDbAcess extends DBConnection{
    
    private static final String TABLE_NAME = "product";
    private static final String PRODUCT_ID = "product_id";
    private static final String PRODUCT_NAME = "product_name";
    private static final String PRODUCT_BRAND = "item_brand";
    private static final String PRODUCT_PRICE = "cost_price";
    private static final String PRODUCT_STOCKS = "stocks";
    private static final String PRODUCT_STATUS = "status";
    Connection connection = getDbConnection();
    public static List<Product> getAllProduct(){
        List<Product> productList = new ArrayList<Product>();
        
        try{
            //Get the db connection
            Connection connection = getDbConnection();

            //Verify if connection is null
            if(connection != null) {
                //Create the sql query  
                String sqlQuery = "SELECT * FROM " + TABLE_NAME + ";";
                //Create the statement
                Statement dbStatement = connection.createStatement();
                //Get the result
                ResultSet resultSet = dbStatement.executeQuery(sqlQuery);
                
                productList = mapProductResultSet(resultSet);
            }
         
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
    
    
    private static List<Product> mapProductResultSet(ResultSet resultSet){
        List<Product> productList = new ArrayList<Product>();
        
        try{
            //Iterate the result set while there are still remaining
            while(resultSet.next()){
                //Create the product object
                Product product = new Product();
                //Set the product values
                product.setProductId(resultSet.getString(PRODUCT_ID));
                product.setProductName(resultSet.getString(PRODUCT_NAME));
                product.setProductBrand(resultSet.getString(PRODUCT_BRAND));
                product.setCostPrice(resultSet.getDouble(PRODUCT_PRICE));
                product.setStocks(resultSet.getInt(PRODUCT_STOCKS));
                product.setStatus(resultSet.getBoolean(PRODUCT_STATUS));
                
                //Insert in the arraylist the newly created product object
                productList.add(product);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDbAcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return productList;
    }
    public void addProduct(Product product) throws Exception {
	try (PreparedStatement myStmt = connection.prepareStatement
        ("INSERT INTO products"+ 
        " ( `tag`, `name`, `brand`, `cost_price`,`stocks`,`status`)" + 
           " VALUES (?,?,?,?,?,?,?)")) {
            myStmt.setString(1, product.getProductId());
            myStmt.setString(2, product.getProductName());
            myStmt.setString(3, product.getProductBrand());
            myStmt.setDouble(4, product.getCostPrice());
            myStmt.setDouble(5, product.getStocks());
            myStmt.setBoolean(6, product.getStatus());
            myStmt.executeUpdate();
	}
    }
    public void deleteItem(int productId) throws SQLException{
        try (PreparedStatement myStmt = connection.prepareStatement("DELETE FROM `inventorymgtsys`.`products` WHERE `products`.`id` = ?")) {
            myStmt.setInt(1, productId);
            myStmt.executeUpdate();
        }
    }
    public ArrayList<Product> searchProduct(String name) throws SQLException {
    ArrayList<Product> list = new ArrayList<>();
    java.sql.PreparedStatement mystmt = null;
    ResultSet myRst = null;
    try {
	name += "%";
    mystmt = connection.prepareStatement("SELECT * FROM products WHERE name LIKE ?");
    mystmt.setString(1, name);
    myRst = mystmt.executeQuery();
    while (myRst.next()) {
	Product tmp = converRowToProduct(myRst);
	list.add(tmp);
    }
    return list;
    } finally {
	close(mystmt, myRst);
    }
    }
    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);
	}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {

		}

		if (myConn != null) {
			myConn.close();
		}
	}
    private Product converRowToProduct(ResultSet myRst) throws SQLException {

		int id = myRst.getInt("id");
		String tag = myRst.getString("tag");
		String name = myRst.getString("name");
		String company = myRst.getString("company");
		double cprice = myRst.getDouble("cost_price");
		int stocks = myRst.getInt("stocks");
		boolean status = myRst.getBoolean("status");

		Product product = new Product(id, tag, name, company, cprice, stocks, status);
		return product;
	}

    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
