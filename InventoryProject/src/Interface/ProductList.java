/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import db.ProductDbAcess;
import db.ProductTableModel;
import inventoryproject.Product;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



import javax.swing.table.DefaultTableModel;
    

/**
 *
 * @author user
 */
public class ProductList extends javax.swing.JFrame {
    Product prod = new Product();
    DefaultTableModel model;
    ProductDbAcess productdao;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchField;
    private JTable table;
    private JScrollPane scrollPane;
    private JMenuBar menuBar;
    private JMenu mnProducts;
    private JMenu mnAccount;
    private JMenuItem mntmAddNewItems;
    private JMenuItem mntmFind;
    private JMenuItem mntmDelete;
    private JMenuItem mntmExit;
    private JMenuItem mntmEditAccount;
    private JPanel reportPanel;
    private JLabel lblTotalItems;
    private JLabel label;
    private JLabel lblAvaibleItems;
    private JLabel availablela;
    private JLabel lblReport;
    private JButton btnSell;
    private JLabel soldNum;
    private JLabel investmentNum;
    private JLabel sellNum;
    private JLabel profitNum;
    private JMenuItem mntmUpdate;
    
    /**
     * Creates new form ProductList
     */
    public ProductList() {
        initComponents();
        model = (DefaultTableModel) productTable.getModel();
        setProductTable();
         
        
        
        JButton btnNewButton = new JButton("search");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                String searchtext = searchField.getText();
            try {
		List<Product> items = new ArrayList<>();
		if (searchtext != null && searchtext.trim().length() > 0) {
		items = productdao.searchProduct(searchtext);
            } else {
		items = ProductDbAcess.getAllProduct();
            }
            // Using table Model
            ProductTableModel model = new ProductTableModel((ArrayList<Product>) items);
            table.setModel(model);
            }   catch (SQLException ex) {
                    Logger.getLogger(ProductList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton btnaddNewProduct = new JButton("Add New");
		btnaddNewProduct.setForeground(new Color(0, 128, 0));
		btnaddNewProduct.setFont(new Font("Segoe Script", Font.BOLD, 13));
		btnaddNewProduct.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
                            AddNewProductItem dialog = new AddNewProductItem(productdao, ProductList.this);
                            dialog.setVisible(true);
			}
		});
        
        
            
    }   
    
    private void setProductTable(){
        
                String[] columnNames = {"Product ID","Product Name","Product Brand","Cost Price","Stocks","Status"};
                List<Product> products = ProductDbAcess.getAllProduct();
                model.setColumnIdentifiers(columnNames);
                Object rowData[] = new Object[6];
                for(int i = 0; i<products.size();i++){
                    rowData[0] = products.get(i).getProductId();
                    rowData[1] = products.get(i).getProductName();
                    rowData[2] = products.get(i).getProductBrand();
                    rowData[3] = products.get(i).getCostPrice();
                    rowData[4] = products.get(i).getStocks();
                    rowData[5] = products.get(i).getStatus();
                    model.addRow(rowData);
                }
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Inventory Title");

        jLabel2.setText("Type Product Name:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SELL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("UPDATE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("ADDNew");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "null", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(productTable);
        if (productTable.getColumnModel().getColumnCount() > 0) {
            productTable.getColumnModel().getColumn(0).setResizable(false);
            productTable.getColumnModel().getColumn(1).setResizable(false);
            productTable.getColumnModel().getColumn(2).setResizable(false);
            productTable.getColumnModel().getColumn(3).setResizable(false);
            productTable.getColumnModel().getColumn(4).setResizable(false);
            productTable.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jButton4)
                        .addGap(73, 73, 73)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        // TODO add your handling code here
//            model = (DefaultTableModel) table.getModel();
//            try{
//            int rowIndex = table.getSelectedRow();
//            model.removeRow(rowIndex);
//            }catch(Exception ex){
//                JOptionPane.showMessageDialog(null,ex);
//            }
//            String[] options = {"Yes", "No"};
//            int answ = JOptionPane.showOptionDialog(null, "Sure To Delete??", "Delete Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
//
//        if (answ == 0) {
//            int index = table.getSelectedRow();
//            String id = table.getValueAt(index, 0).toString();
//
//            if (productdao.delete(id)) {
//                JOptionPane.showMessageDialog(null, "Deleted Updated");
//
//                //CLEAR TXT
//                
//                nameTxt.setText("");
//                posTxt.setText("");
//                teamTxt.setText("");
//
//           retrieve();
//            } else
//            {
//                JOptionPane.showMessageDialog(null, "Not Deleted");
//            }
//
//        }
        int row = table.getSelectedRow();

	if (row <= 0) {
            
            JOptionPane.showMessageDialog(ProductList.this, "You must select a Product.", "Error",
            JOptionPane.ERROR_MESSAGE);
            return;
	}
        int response = JOptionPane.showConfirmDialog(ProductList.this,"Delete this products?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
	if(response != JOptionPane.YES_OPTION){
            return;
	}
        
	Product tmpProduct = (Product) table.getValueAt(row, ProductTableModel.OBJECT_COL);

	try {
            productdao.deleteItem(tmpProduct.getId());
            refreshProductView();
	} catch (SQLException e1) {
	}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        AddNewProductItem dialog = new AddNewProductItem(productdao,ProductList.this);
	dialog.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(ProductList.this, "You must select a Product.", "Error",
		JOptionPane.ERROR_MESSAGE);
		return;
        }
        Product tmpProduct = (Product) table.getValueAt(row, ProductTableModel.OBJECT_COL);
	// System.out.println(tmpProduct);
	AddNewProductItem dialog = new AddNewProductItem(productdao, ProductList.this, tmpProduct, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    JButton btnNewButton = new JButton("search");
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String searchtext = searchField.getText();
            try {
		List<Product> items = new ArrayList<>();
		if (searchtext != null && searchtext.trim().length() > 0) {
		items = productdao.searchProduct(searchtext);
            } else {
		items = ProductDbAcess.getAllProduct();
            }
            // Using table Model
            ProductTableModel model = new ProductTableModel((ArrayList<Product>) items);
            table.setModel(model);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void refreshProductView() {
        try {
            List<Product> list = productdao.getAllProduct();
            ProductTableModel mode = new ProductTableModel((ArrayList<Product>) list);
            table.setModel(mode);
	} catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error:" + e, "Error", JOptionPane.ERROR_MESSAGE);
	}
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProductList().setVisible(true);
            
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable productTable;
    // End of variables declaration//GEN-END:variables

}
