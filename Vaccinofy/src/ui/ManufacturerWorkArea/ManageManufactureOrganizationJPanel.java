/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.ManufacturerWorkArea;

import Business.Employee.Employee;
import Business.Enterprise.VaccineManufacturesEnterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */

public class ManageManufactureOrganizationJPanel extends javax.swing.JPanel {
    
    /**
     * Creates new form ManageManufactureOrganizationJPanel
     */
    
    private JPanel userProcessContainer;
    private VaccineManufacturesEnterprise vaccineManufacturesEnterprise;
    
    public ManageManufactureOrganizationJPanel(JPanel userProcessContainer, VaccineManufacturesEnterprise vaccineManufacturesEnterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.vaccineManufacturesEnterprise = vaccineManufacturesEnterprise;
        
        populateTable();
        popOrganizationComboBox();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) userAccountJTable.getModel();
        model.setRowCount(0);
        for(Organization organization : vaccineManufacturesEnterprise.getOrganizationDirectory().getOrganizationDirectory()){
            for(UserAccount userAccount : organization.getUserAccountDirectory().getUserAccountDirectory()){
                Object[] row = new Object[2];
                row[0] = userAccount.getUserAccUserName();
                row[1] = userAccount.getRole();
                model.addRow(row);
            }
        }
    }
    
    public void popOrganizationComboBox() {
        organizationJComboBox.removeAllItems();
        vaccineManufacturesEnterprise.getOrganizationDirectory().createNewOrganization(Organization.OrganizationType.Finance);
        organizationJComboBox.removeAllItems();
        for (Organization org : vaccineManufacturesEnterprise.getOrganizationDirectory().getOrganizationDirectory()){
            organizationJComboBox.addItem(org);
        }
    }
    
    private void populateRoleComboBox(Organization organization){
        roleJComboBox.removeAllItems();
        for (Role role : organization.getSupportedRole()){
            if(role.toString().contains("Manufacture")){
                roleJComboBox.addItem(role);
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

        userNameJLabel = new javax.swing.JLabel();
        enterpriseJLabel = new javax.swing.JLabel();
        passwordJPasswordField = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        userAccountJTable = new javax.swing.JTable();
        roleJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        submitJButton = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();
        userNameJTextField = new javax.swing.JTextField();
        organizationJComboBox = new javax.swing.JComboBox();
        nameJLabel = new javax.swing.JLabel();
        passwordJLabel = new javax.swing.JLabel();
        enterpriseRoleJLabel = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();

        userNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userNameJLabel.setText("Username :");

        enterpriseJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterpriseJLabel.setText("Organization :");

        passwordJPasswordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        userAccountJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserName", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userAccountJTable);

        roleJComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        roleJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Manufacture Organization");

        submitJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        nameJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        userNameJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        organizationJComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });

        nameJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameJLabel.setText("Employee Name :");

        passwordJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordJLabel.setText("Password :");

        enterpriseRoleJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterpriseRoleJLabel.setText("Organization Role :");

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(393, 393, 393)
                .addComponent(backJButton)
                .addContainerGap(709, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(374, 374, 374)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(enterpriseJLabel)
                                        .addGap(139, 139, 139)
                                        .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(enterpriseRoleJLabel)
                                        .addGap(99, 99, 99)
                                        .addComponent(roleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(passwordJLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(userNameJLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(nameJLabel)))
                                        .addGap(107, 107, 107)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(passwordJPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(25, 25, 25)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(178, 178, 178)
                            .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(153, 153, 153)))
                    .addContainerGap(374, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(843, Short.MAX_VALUE)
                .addComponent(backJButton)
                .addGap(128, 128, 128))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(230, 230, 230)
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(enterpriseJLabel)
                        .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(enterpriseRoleJLabel)
                        .addComponent(roleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userNameJLabel)
                        .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordJLabel)
                        .addComponent(passwordJPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameJLabel)
                        .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(39, 39, 39)
                    .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(230, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        
        String userName = userNameJTextField.getText();
        String password = String.valueOf(passwordJPasswordField.getPassword());
        String empName = nameJTextField.getText();
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        Role role = (Role) roleJComboBox.getSelectedItem();
        Employee employee = vaccineManufacturesEnterprise.getEmployeeDirectory().createNewEmployee(empName);
        organization.getUserAccountDirectory().createNewUserAccount(userName, password, employee, role);

        populateTable();
        
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            populateRoleComboBox(organization);
        }
        
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.remove(this);
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel enterpriseJLabel;
    private javax.swing.JLabel enterpriseRoleJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JLabel passwordJLabel;
    private javax.swing.JPasswordField passwordJPasswordField;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JButton submitJButton;
    private javax.swing.JTable userAccountJTable;
    private javax.swing.JLabel userNameJLabel;
    private javax.swing.JTextField userNameJTextField;
    // End of variables declaration//GEN-END:variables
}
