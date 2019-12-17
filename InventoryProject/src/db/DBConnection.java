/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user
 */
public class DBConnection {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "inventory";
    
    protected static Connection getDbConnection(){
        Connection connection = null;
        
        try{
            Class.forName(DRIVER).newInstance();  
            connection=DriverManager.getConnection(URL + DATABASE_NAME,USERNAME,PASSWORD);
           
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return connection;
    }
    
}
