/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.StateDistributer;

import Business.Ecosystem;
import Business.Employee.Employee;
import Business.Enterprise.DistributorEnterprise;
import Business.Order.Order;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import Business.WorkQueue.PaymentRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author meetdoshi
 */

public class ManageManufacturerPaymentPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageManufacturerPaymentPanel
     */
    
    private JPanel userProcessContainer;
    private Ecosystem system;
    private UserAccount userAccount;
    private DistributorEnterprise distributorEnterprise;
    
    public ManageManufacturerPaymentPanel(JPanel userProcessContainer, Ecosystem system, UserAccount userAccount, DistributorEnterprise distributorEnterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.system = system;
        this.distributorEnterprise = distributorEnterprise;

        populateManufacturePaymentTable();
    }
    
    public void populateManufacturePaymentTable() {
        DefaultTableModel dtm = (DefaultTableModel) manufacturerPaymentTable.getModel();
        dtm.setRowCount(0);

        for (Organization organization : distributorEnterprise.getOrganizationDirectory().getOrganizationDirectory()) {
            for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                if (request.getRequestType().equalsIgnoreCase("Manufacture Payment Request")) {
                    Object[] row = new Object[4];
                    row[0] = request;
                    row[1] = request.getSender();
                    row[2] = request.getReceiver();
                    row[3] = request.getStatus();
                    dtm.addRow(row);
                }
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        manufacturerPaymentTable = new javax.swing.JTable();
        viewOrderButton = new javax.swing.JButton();
        assignButton = new javax.swing.JButton();
        payBillButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Manufacture Payment");

        manufacturerPaymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Request Type", "Sender Name", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(manufacturerPaymentTable);

        viewOrderButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewOrderButton.setText("View Bill");
        viewOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderButtonActionPerformed(evt);
            }
        });

        assignButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        assignButton.setText("Assign to me");
        assignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignButtonActionPerformed(evt);
            }
        });

        payBillButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        payBillButton.setText("Pay Bill");
        payBillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBillButtonActionPerformed(evt);
            }
        });

        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Vaccine ID", "Disease Name", "Price", "Quantity", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(billTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(viewOrderButton)
                        .addGap(77, 77, 77)
                        .addComponent(assignButton)
                        .addGap(77, 77, 77)
                        .addComponent(payBillButton)))
                .addContainerGap(378, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewOrderButton)
                    .addComponent(payBillButton)
                    .addComponent(assignButton))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(556, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderButtonActionPerformed
        int selectedRow = manufacturerPaymentTable.getSelectedRow();
        if (selectedRow >= 0) {
            PaymentRequest request = (PaymentRequest) manufacturerPaymentTable.getValueAt(selectedRow, 0);
            DefaultTableModel dtm = (DefaultTableModel) billTable.getModel();
            dtm.setRowCount(0);
            
            for (Vaccine vaccine : system.getVaccineDirectory().getVaccineDirectory()) {
                if (vaccine.getVaccineID() == request.getOrderID()) {
                    Object[] row = new Object[6];
                    row[0] = vaccine;
                    row[1] = vaccine.getVaccineID();
                    row[2] = vaccine.getDiseaseName();
                    row[3] = vaccine.getVaccinePrice();
                    row[4] = request.getRequestedQuantity();
                    row[5] = request.getRequestedQuantity() * vaccine.getVaccinePrice();
                    dtm.addRow(row);
                }
            }

        }
        else {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_viewOrderButtonActionPerformed

    private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignButtonActionPerformed
        int selectedRow = manufacturerPaymentTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (manufacturerPaymentTable.getValueAt(selectedRow, 2) != null) {
            JOptionPane.showMessageDialog(null, "The request is already assigned", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        PaymentRequest request = (PaymentRequest) manufacturerPaymentTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        UserAccount user = (UserAccount) request.getSender();
        Employee person = (Employee) user.getEmployee();
        for (Order order : person.getOrderCatalog().getOrderList()) {
            if (request.getOrderID() == order.getOrderID()) {
                order.setOrderStatus("Waiting to be approved by National Distributor");
            }
        }
        
        populateManufacturePaymentTable();
        
        JOptionPane.showMessageDialog(null, "The request is assigned to " + request.getReceiver());
    }//GEN-LAST:event_assignButtonActionPerformed

    private void payBillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBillButtonActionPerformed
        int selectedRow = manufacturerPaymentTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (manufacturerPaymentTable.getValueAt(selectedRow, 3) == "Paid") {
            JOptionPane.showMessageDialog(null, "The bill is already Paid", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (manufacturerPaymentTable.getValueAt(selectedRow, 2) == null) {
            JOptionPane.showMessageDialog(null, "The request is yet to be assigned to the Distributor", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        PaymentRequest paymentRequest = (PaymentRequest) manufacturerPaymentTable.getValueAt(selectedRow, 0);
        paymentRequest.setPaymentRequest("Paid");
        paymentRequest.setStatus("Paid");
        populateManufacturePaymentTable();
        JOptionPane.showMessageDialog(null, "Bill paid", "Payment Request", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_payBillButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignButton;
    private javax.swing.JTable billTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable manufacturerPaymentTable;
    private javax.swing.JButton payBillButton;
    private javax.swing.JButton viewOrderButton;
    // End of variables declaration//GEN-END:variables
}
