/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.SystemAdminWorkArea;

import Business.Ecosystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author meetdoshi
 */

public class ManageEnterpriseAdminPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private Ecosystem system;
    
    public ManageEnterpriseAdminPanel(JPanel userProcessContainer, Ecosystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        
        populateTable();
        populateNetworkComboBox();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) enterpriseAdminTable.getModel();
        model.setRowCount(0);
        for (Network network : system.getNetworkDirectory()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterprisesDirectory()) {
                for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountDirectory()) {
                    Object[] row = new Object[3];
                    row[0] = enterprise.getOrgnizationName();
                    row[1] = network.getNetworkName();
                    row[2] = userAccount.getUserAccUserName();
                    
                    model.addRow(row);
                }
            }
        }
    }
    
    private void populateNetworkComboBox(){
        networkComboBox.removeAllItems();
        for (Network network : system.getNetworkDirectory()){
            networkComboBox.addItem(network);
        }
    }
    
    private void populateEnterpriseComboBox(Network network){
        enterpriseComboBox.removeAllItems();
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterprisesDirectory()){
            enterpriseComboBox.addItem(enterprise);
        }
        
    }
    
    private void populateEnterpriseRoleComboBox(Enterprise enterprise){
        enterpriseRoleComboBox.removeAllItems();
        for(Role role : enterprise.getSupportedRole()){
            enterpriseRoleComboBox.addItem(role);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        enterpriseAdminTable = new javax.swing.JTable();
        networkJLabel = new javax.swing.JLabel();
        enterpriseJLabel = new javax.swing.JLabel();
        enterpriseRoleJLabel = new javax.swing.JLabel();
        userNameJLabel = new javax.swing.JLabel();
        passwordJLabel = new javax.swing.JLabel();
        nameJLabel = new javax.swing.JLabel();
        networkComboBox = new javax.swing.JComboBox();
        enterpriseComboBox = new javax.swing.JComboBox();
        userNameTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        enterpriseRoleComboBox = new javax.swing.JComboBox();
        passwordPasswordField = new javax.swing.JPasswordField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Enterprise Admin");

        enterpriseAdminTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise Name", "Network", "UserName"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(enterpriseAdminTable);
        if (enterpriseAdminTable.getColumnModel().getColumnCount() > 0) {
            enterpriseAdminTable.getColumnModel().getColumn(0).setResizable(false);
            enterpriseAdminTable.getColumnModel().getColumn(1).setResizable(false);
            enterpriseAdminTable.getColumnModel().getColumn(2).setResizable(false);
        }

        networkJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        networkJLabel.setText("Network :");

        enterpriseJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterpriseJLabel.setText("Enterprise :");

        enterpriseRoleJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterpriseRoleJLabel.setText("Enterprise Role :");

        userNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userNameJLabel.setText("Username :");

        passwordJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordJLabel.setText("Password :");

        nameJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameJLabel.setText("Name :");

        networkComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        networkComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkComboBoxActionPerformed(evt);
            }
        });

        enterpriseComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterpriseComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        enterpriseComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseComboBoxActionPerformed(evt);
            }
        });

        userNameTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        nameTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

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

        enterpriseRoleComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterpriseRoleComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        passwordPasswordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(252, 252, 252))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(339, 339, 339))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordJLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(userNameJLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(139, 139, 139)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(userNameTextField)
                                    .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(networkJLabel)
                                    .addComponent(enterpriseJLabel))
                                .addGap(139, 139, 139)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(enterpriseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(networkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(enterpriseRoleJLabel)
                                .addGap(99, 99, 99)
                                .addComponent(enterpriseRoleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(nameJLabel)
                                .addGap(172, 172, 172)
                                .addComponent(nameTextField))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(backButton)))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(networkJLabel)
                    .addComponent(networkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseJLabel)
                    .addComponent(enterpriseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(enterpriseRoleJLabel)
                    .addComponent(enterpriseRoleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameJLabel)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordJLabel)
                    .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameJLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addContainerGap(225, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        Enterprise enterprise = (Enterprise) enterpriseComboBox.getSelectedItem();
        
        String username = userNameTextField.getText();
        String password = String.valueOf(passwordPasswordField.getPassword());
        String name = nameTextField.getText();
        
        Employee employee = enterprise.getEmployeeDirectory().createNewEmployee(name);
        Role role = (Role) enterpriseRoleComboBox.getSelectedItem();
        
        UserAccount account = enterprise.getUserAccountDirectory().createNewUserAccount(username, password, employee, role);
        populateTable();
    }//GEN-LAST:event_submitButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.remove(this);
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void enterpriseComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseComboBoxActionPerformed
        Enterprise enterprise = (Enterprise) enterpriseComboBox.getSelectedItem();
        if(enterprise != null){
            populateEnterpriseRoleComboBox(enterprise);
        }
    }//GEN-LAST:event_enterpriseComboBoxActionPerformed

    private void networkComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkComboBoxActionPerformed
        Network network = (Network) networkComboBox.getSelectedItem();
        if (network != null){
            populateEnterpriseComboBox(network);
        }
    }//GEN-LAST:event_networkComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTable enterpriseAdminTable;
    private javax.swing.JComboBox enterpriseComboBox;
    private javax.swing.JLabel enterpriseJLabel;
    private javax.swing.JComboBox enterpriseRoleComboBox;
    private javax.swing.JLabel enterpriseRoleJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JComboBox networkComboBox;
    private javax.swing.JLabel networkJLabel;
    private javax.swing.JLabel passwordJLabel;
    private javax.swing.JPasswordField passwordPasswordField;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel userNameJLabel;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables
}