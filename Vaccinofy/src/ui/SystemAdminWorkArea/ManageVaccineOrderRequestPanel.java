/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.SystemAdminWorkArea;

import Business.Ecosystem;
import Business.Employee.Employee;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.VaccineRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rangeshmurali
 */
public class ManageVaccineOrderRequestPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Ecosystem system;
    
    public ManageVaccineOrderRequestPanel(JPanel userProcessContainer, UserAccount userAccount, Ecosystem system) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.system = system;
        
        populateVaccineOrderTable();
    }
    
    public void populateVaccineOrderTable(){
        DefaultTableModel dtm = (DefaultTableModel) vaccineOrderTable.getModel();
        dtm.setRowCount(0);
        for(WorkRequest request : system.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[5];
            row[0] = request;
            if(request.getRequestType().equalsIgnoreCase("Hospital Vaccine request")){
                row[1] = request.getSender().getEmployee().getHospital().getHospitalName();
            }
            else if(request.getRequestType().equalsIgnoreCase("Pharmacy Vaccine request")){
                row[1] = request.getSender().getEmployee().getPharmacy().getPharmacyName();
            }
            row[2] = request.getSender();
            row[3] = request.getReceiver() == null? null : request.getReceiver();
            row[4] = request.getStatus();
            dtm.addRow(row);
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
        vaccineOrderTable = new javax.swing.JTable();
        viewOrderButton = new javax.swing.JButton();
        assignButton = new javax.swing.JButton();
        forwardButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        rejectButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Vaccine Request");

        vaccineOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Request Type", "Provider Name", "Employee Name", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vaccineOrderTable);
        if (vaccineOrderTable.getColumnModel().getColumnCount() > 0) {
            vaccineOrderTable.getColumnModel().getColumn(0).setResizable(false);
            vaccineOrderTable.getColumnModel().getColumn(1).setResizable(false);
            vaccineOrderTable.getColumnModel().getColumn(2).setResizable(false);
            vaccineOrderTable.getColumnModel().getColumn(3).setResizable(false);
            vaccineOrderTable.getColumnModel().getColumn(4).setResizable(false);
        }

        viewOrderButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewOrderButton.setText("View Order");
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

        forwardButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        forwardButton.setText("Forward to National Distributor");
        forwardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardButtonActionPerformed(evt);
            }
        });

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderTable);
        if (orderTable.getColumnModel().getColumnCount() > 0) {
            orderTable.getColumnModel().getColumn(0).setResizable(false);
            orderTable.getColumnModel().getColumn(1).setResizable(false);
        }

        backButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton.setText("<< Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        rejectButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rejectButton.setText("Reject");
        rejectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(backButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(viewOrderButton)
                                .addGap(47, 47, 47)
                                .addComponent(assignButton)
                                .addGap(36, 36, 36)
                                .addComponent(forwardButton)
                                .addGap(8, 8, 8)
                                .addComponent(rejectButton))
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(jLabel1)))
                .addContainerGap(333, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewOrderButton)
                    .addComponent(assignButton)
                    .addComponent(forwardButton)
                    .addComponent(rejectButton))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(backButton)
                .addContainerGap(338, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderButtonActionPerformed
        int selectedRow = vaccineOrderTable.getSelectedRow();
        if(selectedRow >= 0){
            VaccineRequest request = (VaccineRequest) vaccineOrderTable.getValueAt(selectedRow, 0);
            DefaultTableModel dtm = (DefaultTableModel) orderTable.getModel();
            dtm.setRowCount(0);
            
            UserAccount userAccount = (UserAccount) request.getSender();
            Employee employee = (Employee) userAccount.getEmployee();
            Order orderI = null;
            for(Order order : employee.getOrderCatalog().getOrderList()){
                if(request.getOrderID() == order.getOrderID()){
                    orderI = order;
                }
            }
            for(OrderItem orderItem : orderI.getOrderItemList()){
                Object[] row = new Object[2];
                row[0] = orderItem;
                row[1] = orderItem.getItemQuantity();
                dtm.addRow(row);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Please select a row first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_viewOrderButtonActionPerformed

    private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignButtonActionPerformed
        int selectedRow = vaccineOrderTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(vaccineOrderTable.getValueAt(selectedRow, 3) != null){
            JOptionPane.showMessageDialog(null, "The request is already assigned", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VaccineRequest request = (VaccineRequest) vaccineOrderTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        UserAccount userAccount = (UserAccount) request.getSender();
        Employee person = (Employee) userAccount.getEmployee();
        for(Order order : person.getOrderCatalog().getOrderList()){
            if(request.getOrderID() == order.getOrderID()){
                order.setOrderStatus("Waiting to be approved by CDC");
            }
        }
        
        populateVaccineOrderTable();
        
        JOptionPane.showMessageDialog(null, "The request is assigned to " + request.getReceiver());
    }//GEN-LAST:event_assignButtonActionPerformed

    private void forwardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardButtonActionPerformed
        int selectedRow = vaccineOrderTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(vaccineOrderTable.getValueAt(selectedRow, 4) == "Approved"){
            JOptionPane.showMessageDialog(null, "The request is already sent to National Distributor", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(vaccineOrderTable.getValueAt(selectedRow, 4) == "Rejected"){
            JOptionPane.showMessageDialog(null, "The request is already rejected", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        VaccineRequest request = (VaccineRequest) vaccineOrderTable.getValueAt(selectedRow, 0);
        if(vaccineOrderTable.getValueAt(selectedRow, 3) == null){
            JOptionPane.showMessageDialog(null, "The request is yet to be assigned to CDC", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        request.setStatus("Approved");
        request.setVaccineRequest("Approved");
        UserAccount userAccount = (UserAccount) request.getSender();
        Employee employee = (Employee) userAccount.getEmployee();
        for(Order order : employee.getOrderCatalog().getOrderList()){
            if(request.getOrderID() == order.getOrderID()){
                order.setOrderStatus("Approved by CDC");
            }
        }
        VaccineRequest vaccineRequest = new VaccineRequest();
        if(employee.getCheck().equalsIgnoreCase("Hospital")){
            vaccineRequest.setRequestType("Hospital Vaccine Request");
        } else if(employee.getCheck().equalsIgnoreCase("Pharmacy")){
            vaccineRequest.setRequestType("Pharmacy Vaccine Request");
        }
        vaccineRequest.setStatus("waiting");
        vaccineRequest.setSender(request.getSender());
        vaccineRequest.setOrderID(request.getOrderID());
        vaccineRequest.setReceiver(null);
        system.getNationalDistributor().getWorkQueue().getWorkRequestList().add(vaccineRequest);
        userAccount.getWorkQueue().getWorkRequestList().add(vaccineRequest);
        populateVaccineOrderTable();
    }//GEN-LAST:event_forwardButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.remove(this);
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    private void rejectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectButtonActionPerformed
        int selectedRow = vaccineOrderTable.getSelectedRow();
        int quantity = 0;
        int orginalQuantity = 0;

        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(vaccineOrderTable.getValueAt(selectedRow, 4) == "Rejected"){
            JOptionPane.showMessageDialog(null, "The request is already rejected", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(vaccineOrderTable.getValueAt(selectedRow, 4) == "Approved"){
            JOptionPane.showMessageDialog(null, "The request is already Approved", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VaccineRequest request = (VaccineRequest) vaccineOrderTable.getValueAt(selectedRow, 0);
        if(vaccineOrderTable.getValueAt(selectedRow, 3) == null){
            JOptionPane.showMessageDialog(null, "The request is yet to be assigned to CDC", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Are you sure if you want to Reject?", "warning", dialogButton);
        if(result == JOptionPane.YES_OPTION){
            UserAccount userAccount = (UserAccount) request.getSender();
            Employee employee = (Employee) userAccount.getEmployee();
            for(Order order : employee.getOrderCatalog().getOrderList()){
                if(request.getOrderID() == order.getOrderID()){
                    order.setOrderStatus("Order rejected by CDC");
                    request.setStatus("Rejected");
                    request.setVaccineRequest("Rejected");
                    for (OrderItem oi : order.getOrderItemList()) {
                        quantity = oi.getVaccine().getAvailablity();
                        orginalQuantity = quantity + oi.getItemQuantity();
                        oi.getVaccine().setAvailablity(orginalQuantity);
                    }
                }
            }
        }
        
        populateVaccineOrderTable();
        
        JOptionPane.showMessageDialog(null, "The request is rejected", "Vaccine Request", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_rejectButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton forwardButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderTable;
    private javax.swing.JButton rejectButton;
    private javax.swing.JTable vaccineOrderTable;
    private javax.swing.JButton viewOrderButton;
    // End of variables declaration//GEN-END:variables
}
