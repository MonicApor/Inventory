/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryproject;
import db.ProductDbAcess;
import java.util.List;
/**
 *
 * @author user
 */
public class InventoryProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Product> products = ProductDbAcess.getAllProduct();
       Object rowData[] = new Object[6];
        for(int i = 0; i<products.size();i++){
            rowData[0] = products.get(i).getProductId();
            System.out.println("Row" + i +rowData[0]);
            rowData[1] = products.get(i).getProductName();
            System.out.println("Row" + i+ rowData[1]);
            rowData[2] = products.get(i).getProductBrand();
            System.out.println("Row" + i+ rowData[2]);
            rowData[3] = products.get(i).getCostPrice();
            System.out.println("Row" + i+ rowData[3]);
            rowData[4] = products.get(i).getStocks();
            System.out.println("Row" + i+ rowData[4]);
            rowData[5] = products.get(i).getStatus();
            System.out.println("Row" + i+ rowData[5]);
        }
    }
    
}
