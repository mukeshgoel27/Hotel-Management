/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package I3.UI;

import I3.Order;
import I3Db.BookingDb;
import I3Db.DatabaseOperation;
import I3Db.FoodDb;
import I3Db.ItemDb;
import I3Db.OrderDb;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import net.proteanit.sql.DbUtils;



public class OrderPanel extends javax.swing.JDialog {

    /**
     * Creates new form OrderPanel
     */
    
	
	 public javax.swing.JComboBox combo_booking;
	    public javax.swing.JButton jButton1;
	    public javax.swing.JLabel jLabel1;
	    public javax.swing.JLabel jLabel2;
	    public javax.swing.JLabel jLabel3;
	    public javax.swing.JLabel jLabel4;
	    public javax.swing.JPanel jPanel1;
	    public javax.swing.JScrollPane jScrollPane1;
	    public javax.swing.JScrollPane jScrollPane2;
	    public javax.swing.JTable table_food;
	    public javax.swing.JTable table_item;
	    public javax.swing.JTextField tf_bookingId;
	    public javax.swing.JTextField tf_foodItem;
	    public javax.swing.JTextField tf_price;
	    public javax.swing.JTextField tf_quantity;
	    public javax.swing.JTextField tf_total;
	    
	    
    Vector<String> bookingList = new Vector();
    BookingDb db = new BookingDb();
    ResultSet result;
    FoodDb foodDb = new FoodDb();
    ItemDb itemDb = new ItemDb();
  //  OrderDb orderDb = new OrderDb();
    public OrderPanel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(new Color(241,241,242));
        searchHelper();
        populateFoodTable();
        populateItemTable();
        AutoCompleteDecorator.decorate(combo_booking);
    }
    
    public void searchHelper()
    {
         final DefaultComboBoxModel model = new DefaultComboBoxModel(bookingList);
        combo_booking.setModel(model);
        
        
        JTextComponent editor = (JTextComponent) combo_booking.getEditor().getEditorComponent();
        editor.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent evt)
            {
               
                if(evt.getKeyChar() == KeyEvent.VK_ENTER)
                {
                    String details = (String) combo_booking.getSelectedItem();
                    //System.out.println(details);
                    if(!details.contains(","))
                    {
                        JOptionPane.showMessageDialog(null, "no booking found, try adding a new booking");
                    }
                    else
                    {
                        int bookinId = Integer.parseInt(details.substring(details.lastIndexOf(",")+1));
                        tf_bookingId.setText(bookinId+"");
                        // A if condition should be here, but not required as the last line has no chance of returning -1.
                        
                    }
                    
                }
                
                
                
                /// suggestion generation
                
                 String value = "";
                try {
                    value = combo_booking.getEditor().getItem().toString();
                       // System.out.println(value +" <<<<<<<<<<<<<");

                } catch (Exception ex) {
                }
                if (value.length() >= 2) {

                   // System.out.println("working");
                    bookingComboFill(db.bookingsReadyForOrder(value));
                    db.flushAll();
                }

            }
        });
    }
    
    public void bookingComboFill(ResultSet result)
    {
        bookingList.clear();
        try {
            
            while (result.next()) {
               // System.out.println(">>>>>> "+result.getString("name"));
                bookingList.add(result.getString("booking_room") + ", " + result.getString("name") + "," + result.getString("booking_id"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "bookingCombo fill error");
        }

    }
    
     public void populateFoodTable() {
        result = foodDb.getFoods();
        table_food.setModel(DbUtils.resultSetToTableModel(result));
        foodDb.flushAll();
    }
     
     public void populateItemTable()
     {
        result = itemDb.getItems();
        table_item.setModel(DbUtils.resultSetToTableModel(result));
        itemDb.flushAll();
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_food = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_item = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        tf_foodItem = new javax.swing.JTextField();
        tf_quantity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_price = new javax.swing.JTextField();
        tf_total = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_bookingId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        combo_booking = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        table_food.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_food.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_foodMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_food);

        table_item.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_item.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_itemMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_item);

        jPanel1.setBackground(new java.awt.Color(230, 231, 232));

        tf_quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_quantityKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_quantityKeyTyped(evt);
            }
        });

        jLabel1.setText("Item/Food");

        jLabel2.setText("Quantity");

        tf_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_priceKeyTyped(evt);
            }
        });

        jLabel3.setText("Total");

        tf_bookingId.setBackground(new java.awt.Color(204, 255, 0));

        jLabel4.setText("Price");

        combo_booking.setEditable(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/SaveButton.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(combo_booking, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf_bookingId)
                                .addComponent(tf_foodItem)
                                .addComponent(tf_quantity)
                                .addComponent(tf_total)
                                .addComponent(tf_price, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo_booking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tf_bookingId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_foodItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void table_foodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_foodMouseClicked
        int row = table_food.getSelectedRow();
        displayToTextField(row);
    }//GEN-LAST:event_table_foodMouseClicked

    public void tf_quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_quantityKeyReleased
       int price = Integer.parseInt(tf_price.getText());
        try{
           int quantity = Integer.parseInt(tf_quantity.getText());
            tf_total.setText(quantity*price+"");
       }catch(Exception ex)
       {
       }
    }//GEN-LAST:event_tf_quantityKeyReleased

    public void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        db.insertOrder(new Order(
                Integer.parseInt(tf_bookingId.getText()),
                tf_foodItem.getText(),
                Integer.parseInt(tf_price.getText()),
                Integer.parseInt(tf_quantity.getText()),
                Integer.parseInt(tf_total.getText())
                
        ));
    }//GEN-LAST:event_jButton1ActionPerformed

    public void table_itemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_itemMouseClicked
        int row = table_item.getSelectedRow();
        displayToTextFieldFromItem(row);
    }//GEN-LAST:event_table_itemMouseClicked

    public void tf_priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_priceKeyTyped
        char c = evt.getKeyChar();
        
        if(!(Character.isDigit(c) || c== KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE ))
        {
            evt.consume();
        }
    }//GEN-LAST:event_tf_priceKeyTyped

    public void tf_quantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_quantityKeyTyped
        char c = evt.getKeyChar();
        
        if(!(Character.isDigit(c) || c== KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE ))
        {
            evt.consume();
        }
    }//GEN-LAST:event_tf_quantityKeyTyped

    
     public void displayToTextField(int row) {
        tf_foodItem.setText(table_food.getModel().getValueAt(row, 1)+"");
        tf_price.setText(table_food.getModel().getValueAt(row, 2)+"");
       
    }
     public void displayToTextFieldFromItem(int row) {
        tf_foodItem.setText(table_item.getModel().getValueAt(row, 1)+"");
        tf_price.setText(table_item.getModel().getValueAt(row, 2)+"");
       
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OrderPanel dialog = new OrderPanel(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
   
    // End of variables declaration//GEN-END:variables

   
}
