/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.SystemAdminWorkArea;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author meetdoshi
 */

public class ManageEnterprisePanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Ecosystem system;
    
    public ManageEnterprisePanel(JPanel userProcessContainer, Ecosystem system) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        
        populateComboBox();
        populateTable();
    }
    
    public void populateComboBox(){
        networkComboBox.removeAllItems();
        enterpriseTypeComboBox.removeAllItems();
        for(Network network : system.getNetworkDirectory()){
            networkComboBox.addItem(network);
        }
        for(Enterprise.EnterpriseType enterpriseType : Enterprise.EnterpriseType.values()){
            enterpriseTypeComboBox.addItem(enterpriseType);
        }
    }
    
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) enterpriseTable.getModel();
        dtm.setRowCount(0);
        for(Network network : system.getNetworkDirectory()){
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterprisesDirectory()){
                Object[] row = new Object[3];
                row[0] = enterprise.getOrgnizationName();
                row[1] = network.getNetworkName();
                row[2] = enterprise.getEnterpriseType().getValue();
                
                dtm.addRow(row);
            }
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

        titleJLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        enterpriseTable = new javax.swing.JTable();
        networkLabel = new javax.swing.JLabel();
        enterpriseTypeLabel = new javax.swing.JLabel();
        enterpriseNameLabel = new javax.swing.JLabel();
        enterpriseNameTextField = new javax.swing.JTextField();
        networkComboBox = new javax.swing.JComboBox();
        enterpriseTypeComboBox = new javax.swing.JComboBox();
        submitButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        titleJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleJLabel.setText("Manage Enterprise");

        enterpriseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise Name", "Network", "Enterprise Type"
            }
        ));
        jScrollPane1.setViewportView(enterpriseTable);

        networkLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        networkLabel.setText("Network :");

        enterpriseTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterpriseTypeLabel.setText("Enterprise Type :");

        enterpriseNameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterpriseNameLabel.setText("Enterprise Name :");

        enterpriseNameTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        networkComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        networkComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        enterpriseTypeComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterpriseTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        submitButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton.setText("<< back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(networkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enterpriseTypeLabel)
                            .addComponent(enterpriseNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(networkComboBox, 0, 164, Short.MAX_VALUE)
                            .addComponent(enterpriseTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterpriseNameTextField))
                        .addGap(187, 187, 187))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(titleJLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(submitButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(backButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(titleJLabel)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(networkLabel)
                    .addComponent(networkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseTypeLabel)
                    .addComponent(enterpriseTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseNameLabel)
                    .addComponent(enterpriseNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(backButton)
                .addGap(125, 125, 125))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        Network network = (Network) networkComboBox.getSelectedItem();
        Enterprise.EnterpriseType type = (Enterprise.EnterpriseType)enterpriseTypeComboBox.getSelectedItem();
        if (network == null || type == null){
            JOptionPane.showMessageDialog(null, "Invalid Input!");
            return;
        }
        String name = enterpriseNameTextField.getText();
        Enterprise enterprise = network.getEnterpriseDirectory().createAndAddEnterprise(name, type);
        
        populateTable();
    }//GEN-LAST:event_submitButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel enterpriseNameLabel;
    private javax.swing.JTextField enterpriseNameTextField;
    private javax.swing.JTable enterpriseTable;
    private javax.swing.JComboBox enterpriseTypeComboBox;
    private javax.swing.JLabel enterpriseTypeLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox networkComboBox;
    private javax.swing.JLabel networkLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
}
