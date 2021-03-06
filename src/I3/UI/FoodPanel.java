/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package I3.UI;

import I3Db.DatabaseOperation;
import I3.Food;
import I3Db.FoodDb;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.text.JTextComponent;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.combobox.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;




public class FoodPanel extends javax.swing.JDialog {

   
    Food food;
    ResultSet result;
    FoodDb db = new FoodDb();
    Vector comboItems = new Vector();

    public FoodPanel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(new Color(241,241,242));
        populateFoodTable();
      //  test();
       
    }

    public void foodObjectCreation() {
        food = new Food();
        food.setName(tf_food_name.getText());
        food.setPrice(Integer.parseInt(tf_food_price.getText()));

        try {
            food.setFood_id(Integer.parseInt(tf_food_id.getText()));
        } catch (Exception ex) {
            food.setFood_id(-1);
        }
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
        jPanel1 = new javax.swing.JPanel();
        btn_edit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tf_food_id = new javax.swing.JTextField();
        btn_delete = new javax.swing.JButton();
        tf_food_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        tf_food_price = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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

        jPanel1.setBackground(new java.awt.Color(230, 231, 232));

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/EditButton.png"))); // NOI18N
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        jLabel2.setText("Food Name");

        tf_food_id.setEditable(false);
        tf_food_id.setBackground(new java.awt.Color(209, 210, 212));

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/DeleteButton.png"))); // NOI18N
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Food ID");

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/DefaultButton.png"))); // NOI18N
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        tf_food_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_food_priceKeyTyped(evt);
            }
        });

        jLabel3.setText("Price");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(tf_food_name)
        						.addComponent(tf_food_id)
        						.addComponent(tf_food_price)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(btn_add, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 307, Short.MAX_VALUE)
        								.addComponent(btn_edit, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        							.addContainerGap())))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabel1)
        				.addComponent(tf_food_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(tf_food_name, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(tf_food_price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btn_edit, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(64, 64, 65));
        jLabel4.setText("Add/ Edit Foods :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void populateFoodTable() {
        result = db.getFoods();
        table_food.setModel(DbUtils.resultSetToTableModel(result));
        db.flushAll();
    }


    public void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        foodObjectCreation();
        db.insertFood(food);

    }//GEN-LAST:event_btn_addActionPerformed

    public void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        foodObjectCreation();
        db.updateFood(food);
        
    }//GEN-LAST:event_btn_editActionPerformed

    public void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
       int foodId = Integer.parseInt(tf_food_id.getText());
       db.deleteFood(foodId);
       
    }//GEN-LAST:event_btn_deleteActionPerformed

    public void table_foodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_foodMouseClicked
       btn_edit.setEnabled(true);
       btn_delete.setEnabled(true);
       btn_add.setEnabled(false);
       
       int row = table_food.getSelectedRow();
       //System.out.println("row ... "+ row);
       displayToTextFields(row);
       foodObjectCreation();
    }//GEN-LAST:event_table_foodMouseClicked

    public void tf_food_priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_food_priceKeyTyped
        char c = evt.getKeyChar();
        
        if(!(Character.isDigit(c) || c== KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE ))
        {
            evt.consume();
        }
    }//GEN-LAST:event_tf_food_priceKeyTyped

    public void clearAllFields()
    {
        food  = new Food();
        tf_food_id.setText("");
        tf_food_name.setText("");
        tf_food_price.setText("");
        table_food.clearSelection();
        btn_add.setEnabled(true);
        btn_edit.setEnabled(false);
        btn_delete.setEnabled(false);
        
    }
    
    public void displayToTextFields(int row)
    {
        tf_food_id.setText(table_food.getModel().getValueAt(row, 0)+"");
        tf_food_name.setText( table_food.getModel().getValueAt(row, 1)+"");
        tf_food_price.setText(table_food.getModel().getValueAt(row, 2)+"");
        
    }
//  public void test()
//  {
//      final DefaultComboBoxModel model = new DefaultComboBoxModel(comboItems);
//      jComboBox1.setModel(model);
//      
//      
//      JTextComponent editor = (JTextComponent) jComboBox1.getEditor().getEditorComponent();
//       editor.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyTyped(KeyEvent evt) {
//                comboItems.add("xc");
//                //System.out.println("working now");
//                
//            }
//        });
//        
//        
//        
//  }

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
            java.util.logging.Logger.getLogger(FoodPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FoodPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FoodPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FoodPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FoodPanel dialog = new FoodPanel(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton btn_add;
    public javax.swing.JButton btn_delete;
    public javax.swing.JButton btn_edit;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable table_food;
    public javax.swing.JTextField tf_food_id;
    public javax.swing.JTextField tf_food_name;
    public javax.swing.JTextField tf_food_price;
    // End of variables declaration//GEN-END:variables

}
