/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.StateDistributer;

import Business.Ecosystem;
import Business.Employee.Employee;
import Business.Enterprise.DistributorEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.VaccineManufacturerEnterprise;
import Business.Inventory.Inventory;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.FinanceOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ManufacturerRequest;
import Business.WorkQueue.VaccineRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author meetdoshi
 */
public class ManageVaccineOrderPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagerVaccineOrderPaymentPanel
     */
    
    private JPanel userProcessContainer;
    private Ecosystem system;
    private UserAccount userAccount;
    private DistributorEnterprise distributorEnterprise;
    private boolean isCheck = true;
    
    public ManageVaccineOrderPanel(JPanel userProcessContainer, Ecosystem system, UserAccount userAccount, DistributorEnterprise distributorEnterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.userAccount = userAccount;
        this.distributorEnterprise = distributorEnterprise;
        
        populateVaccineTable();
        populateVaccineOrderTable();
        populateManufactureTable();
    }
    
    public void populateVaccineTable() {
        DefaultTableModel dtm = (DefaultTableModel) vaccineTable.getModel();
        dtm.setRowCount(0);
        for (Organization organization : distributorEnterprise.getOrganizationDirectory().getOrganizationDirectory()) {
            for (Inventory inventory : organization.getInventoryDirectory().getInventoryDirectory()) {
                Object[] row = new Object[7];
                row[0] = inventory.getVaccine();
                row[1] = inventory.getVaccine().getVaccineID();
                row[2] = inventory.getVaccine().getDiseaseName();
                row[3] = inventory.getVaccine().getVaccinePrice();
                row[4] = inventory.getVaccine().getVaccineManufactureDate();
                row[5] = inventory.getVaccine().getVaccineExpiryDate();
                row[6] = inventory.getVaccine().getAvailablity();
                dtm.addRow(row);
            }
        }
    }
    
    public void populateVaccineOrderTable() {
        DefaultTableModel dtm = (DefaultTableModel) vaccineOrderTable.getModel();
        dtm.setRowCount(0);

        for (WorkRequest request : distributorEnterprise.getWorkQueue().getWorkRequestList()) {
            if (request.getRequestType().equalsIgnoreCase("Hospital Vaccine request") || request.getRequestType().equalsIgnoreCase("Pharmacy Vaccine request")) {
                Object[] row = new Object[5];
                row[0] = request;
                if (request.getRequestType().equalsIgnoreCase("Hospital Vaccine request")) {
                    row[1] = request.getSender().getEmployee().getHospital().getHospitalName();
                } else if (request.getRequestType().equalsIgnoreCase("Pharmacy Vaccine request")) {
                    row[1] = request.getSender().getEmployee().getPharmacy().getPharmacyName();
                }
                row[2] = request.getSender();
                row[3] = request.getReceiver() == null ? null : request.getReceiver();
                row[4] = request.getStatus();
                dtm.addRow(row);
            }
        }
    }
    
    public void manufactureRequest() {
        int selectedRow = vaccineOrderTable.getSelectedRow();
        VaccineRequest request = (VaccineRequest) vaccineOrderTable.getValueAt(selectedRow, 0);
        UserAccount user = (UserAccount) request.getSender();
        for (Order order : user.getEmployee().getOrderCatalog().getOrderList()) {
            if (order.getOrderID() == request.getOrderID()) {
                for (OrderItem orderItem : order.getOrderItemList()) {
                    for (Organization organization : distributorEnterprise.getOrganizationDirectory().getOrganizationDirectory()) {
                        for (Inventory inventory : organization.getInventoryDirectory().getInventoryDirectory()) {
                            if (orderItem.getVaccine() == inventory.getVaccine()) {
                                if (orderItem.getItemQuantity() > inventory.getVaccine().getAvailablity()) {
                                    isCheck = false;
                                    int quant = orderItem.getItemQuantity() - inventory.getVaccine().getAvailablity();
                                    ManufacturerRequest manufactureRequest = new ManufacturerRequest();
                                    manufactureRequest.setRequestedQuantity(quant);
                                    manufactureRequest.setRequestType("Manufacture Vaccine request");
                                    manufactureRequest.setStatus("Sent");
                                    manufactureRequest.setSender(userAccount);
                                    manufactureRequest.setOrderID(inventory.getVaccine().getVaccineID());
                                    order.setOrderStatus("Processing");
                                    Enterprise enterprise = null;
                                    Network net = null;
                                    for (Network network : system.getNetworkDirectory()) {
                                        for (Enterprise ent : network.getEnterpriseDirectory().getEnterprisesDirectory()) {
                                            if (ent == distributorEnterprise) {
                                                net = network;
                                            }
                                        }
                                    }
                                    for (Enterprise ent : net.getEnterpriseDirectory().getEnterprisesDirectory()) {
                                        if (ent instanceof VaccineManufacturerEnterprise) {
                                            enterprise = ent;
                                            break;
                                        }
                                    }
                                    if (enterprise != null) {
                                        enterprise.getWorkQueue().getWorkRequestList().add(manufactureRequest);

                                        userAccount.getWorkQueue().getWorkRequestList().add(manufactureRequest);
                                        populateManufactureTable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }
    
    public void populateManufactureTable() {
        DefaultTableModel dtm = (DefaultTableModel) manufactureOrderTable.getModel();
        dtm.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if (request.getRequestType().equalsIgnoreCase("Manufacture Vaccine Request")) {
                Object[] row = new Object[5];
                row[0] = request;
                row[1] = request.getSender();
                row[2] = request.getReceiver() == null ? null : request.getReceiver();
                row[3] = request.getRequestedQuantity();
                row[4] = request.getStatus();
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
        vaccineTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        vaccineOrderTable = new javax.swing.JTable();
        viewOrderButton = new javax.swing.JButton();
        assignButton = new javax.swing.JButton();
        forwardButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        manufactureOrderTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();

        titleJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleJLabel.setText("Manage Vaccine Order Request");

        vaccineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Vaccine ID", "Disease Name", "Price", "Manufactore Date", "Expiry Date", "Availablity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vaccineTable);

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
        jScrollPane2.setViewportView(vaccineOrderTable);

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
        forwardButton.setText("Forward to Distributor Finance");
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
        jScrollPane3.setViewportView(orderTable);

        manufactureOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Request Type", "Employee Name", "Receiver", "Quantity", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(manufactureOrderTable);

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(titleJLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(viewOrderButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(assignButton)
                                .addGap(69, 69, 69)
                                .addComponent(forwardButton))
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(backButton)))
                .addContainerGap(315, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(titleJLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewOrderButton)
                    .addComponent(assignButton)
                    .addComponent(forwardButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton)
                .addContainerGap(257, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderButtonActionPerformed
        int selectedRow = vaccineOrderTable.getSelectedRow();
        if (selectedRow >= 0) {
            VaccineRequest request = (VaccineRequest) vaccineOrderTable.getValueAt(selectedRow, 0);
            DefaultTableModel dtm = (DefaultTableModel) orderTable.getModel();
            dtm.setRowCount(0);

            UserAccount userAccount = (UserAccount) request.getSender();
            Employee employee = (Employee) userAccount.getEmployee();
            Order orderI = null;
            for (Order order : employee.getOrderCatalog().getOrderList()) {
                if (request.getOrderID() == order.getOrderID()) {
                    orderI = order;
                }
            }
            for (OrderItem orderItem : orderI.getOrderItemList()) {
                Object[] row = new Object[2];
                row[0] = orderItem;
                row[1] = orderItem.getItemQuantity();
                dtm.addRow(row);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_viewOrderButtonActionPerformed

    private void assignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignButtonActionPerformed
        int selectedRow = vaccineOrderTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (vaccineOrderTable.getValueAt(selectedRow, 3) != null) {
            JOptionPane.showMessageDialog(null, "The request is already assigned", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VaccineRequest request = (VaccineRequest) vaccineOrderTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        UserAccount userAccount = (UserAccount) request.getSender();
        Employee person = (Employee) userAccount.getEmployee();
        for (Order order : person.getOrderCatalog().getOrderList()) {
            if (request.getOrderID() == order.getOrderID()) {
                order.setOrderStatus("Waiting to be approved by CDC");
            }
        }
        populateVaccineOrderTable();
        JOptionPane.showMessageDialog(null, "The request is assigned to " + request.getReceiver());
    }//GEN-LAST:event_assignButtonActionPerformed

    private void forwardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardButtonActionPerformed

        int selectedRow = vaccineOrderTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (vaccineOrderTable.getValueAt(selectedRow, 3) == null) {
            JOptionPane.showMessageDialog(null, "The request is yet to be assigned to CDC", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (vaccineOrderTable.getValueAt(selectedRow, 4) == "Approved") {
            JOptionPane.showMessageDialog(null, "The request is already sent to National Distributor", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (vaccineOrderTable.getValueAt(selectedRow, 4) == "Rejected") {
            JOptionPane.showMessageDialog(null, "The request is already rejected", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //        if (vaccineOrderJTable.getValueAt(selectedRow, 4) == "Pending") {
            //            JOptionPane.showMessageDialog(null, "The request is already sent to Manufacturer for production!", "Warning", JOptionPane.WARNING_MESSAGE);
            //            return;
            //        }
        manufactureRequest();
        if (isCheck) {
            VaccineRequest work = (VaccineRequest) vaccineOrderTable.getValueAt(selectedRow, 0);
            if (work.getRequestType().equalsIgnoreCase("Hospital Vaccine request") || work.getRequestType().equalsIgnoreCase("Pharmacy Vaccine request")) {
                UserAccount user = (UserAccount) work.getSender();
                for (Order order1 : user.getEmployee().getOrderCatalog().getOrderList()) {
                    if (order1.getOrderID() == work.getOrderID()) {
                        for (OrderItem orderItem : order1.getOrderItemList()) {
                            for (Organization organization : distributorEnterprise.getOrganizationDirectory().getOrganizationDirectory()) {
                                for (Inventory inventory : organization.getInventoryDirectory().getInventoryDirectory()) {
                                    if (orderItem.getVaccine() == inventory.getVaccine()) {
                                        if (orderItem.getItemQuantity() <= inventory.getVaccine().getAvailablity()) {

                                            int quantity = inventory.getVaccine().getAvailablity() - orderItem.getItemQuantity();
                                            inventory.getVaccine().setAvailablity(quantity);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            work.setStatus("Approved");
            work.setVaccineRequest("Approved");
            UserAccount userAccount1 = (UserAccount) work.getSender();
            Employee employee = (Employee) userAccount1.getEmployee();
            for (Order order : employee.getOrderCatalog().getOrderList()) {
                if (work.getOrderID() == order.getOrderID()) {
                    order.setOrderStatus("Approved by CDC");
                }
            }
            VaccineRequest vaccineRequest = new VaccineRequest();
            vaccineRequest.setRequestType("Provider Payment Request");
            vaccineRequest.setStatus("waiting");
            vaccineRequest.setSender(work.getSender());
            vaccineRequest.setOrderID(work.getOrderID());
            vaccineRequest.setReceiver(null);
            Enterprise enterprise = null;
            Network net = null;
            Organization org = null;
            UserAccount us = null;
            for (Network network : system.getNetworkDirectory()) {
                for (Enterprise ent : network.getEnterpriseDirectory().getEnterprisesDirectory()) {
                    for (UserAccount userAccount2 : ent.getUserAccountDirectory().getUserAccountDirectory()) {
                        if (userAccount2 == userAccount) {
                            net = network;
                        }
                    }
                }
            }
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterprisesDirectory()) {
                if (ent instanceof DistributorEnterprise) {
                    enterprise = ent;
                    break;
                }
            }
            for (Organization organization1 : enterprise.getOrganizationDirectory().getOrganizationDirectory()) {
                if (organization1 instanceof FinanceOrganization) {
                    org = organization1;
                }
            }

            if (org != null) {
                org.getWorkQueue().getWorkRequestList().add(vaccineRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(vaccineRequest);

            }
            populateVaccineOrderTable();
            populateVaccineTable();
        }
    }//GEN-LAST:event_forwardButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.remove(this);
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton forwardButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable manufactureOrderTable;
    private javax.swing.JTable orderTable;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JTable vaccineOrderTable;
    private javax.swing.JTable vaccineTable;
    private javax.swing.JButton viewOrderButton;
    // End of variables declaration//GEN-END:variables
}
