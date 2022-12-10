/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.StateDistributer;

import Business.Ecosystem;
import Business.Enterprise.DistributorEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ProviderEnterprise;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.FinanceOrganization;
import Business.Organization.OrderOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PaymentRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author meetdoshi
 */

public class ManageProviderPaymentPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageProviderPaymentPanel
     */
    
    private JPanel userProcessContainer;
    private Ecosystem system;
    private UserAccount userAccount;
    private DistributorEnterprise distributorEnterprise;
    private float total;
    private int oID;
    
    public ManageProviderPaymentPanel(JPanel userProcessContainer, Ecosystem system, UserAccount userAccount, DistributorEnterprise distributorEnterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.userAccount = userAccount;
        this.distributorEnterprise = distributorEnterprise;

        populateVaccineOrderTable();
    }
    
    public void populateVaccineOrderTable() {
        DefaultTableModel dtm = (DefaultTableModel) billTable.getModel();
        dtm.setRowCount(0);
        for (Organization organization : distributorEnterprise.getOrganizationDirectory().getOrganizationDirectory()) {
            for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                for (Order order : request.getSender().getEmployee().getOrderCatalog().getOrderList()) {
                    if (request.getOrderID() == order.getOrderID()) {
                        float totalPrice = 0;
                        for (OrderItem orderItem : order.getOrderItemList()) {
                            float price = orderItem.getVaccine().getVaccinePrice() * orderItem.getItemQuantity();
                            totalPrice = totalPrice + price;
                        }
                        Object[] row = new Object[5];
                        row[0] = order.getOrderID();
                        if (request.getSender().getEmployee().getCheck().equalsIgnoreCase("Hospital")) {
                            row[1] = request.getSender().getEmployee().getHospital().getHospitalName();
                        } else if (request.getSender().getEmployee().getCheck().equalsIgnoreCase("Pharmacy")) {
                            row[1] = request.getSender().getEmployee().getPharmacy().getPharmacyName();
                        }
                        row[2] = totalPrice;
                        for (WorkRequest request1 : userAccount.getWorkQueue().getWorkRequestList()) {
                            if (order.getOrderID() == request1.getOrderID()) {
                                row[3] = request1.getReceiver();
                                row[4] = request1.getStatus();
                            }
                        }
                        dtm.addRow(row);
                    }
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

        titleJLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        viewOrderButton = new javax.swing.JButton();
        sendButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();

        titleJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleJLabel.setText("Manage Provider Payment");

        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Provider Name", "Total Price", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(billTable);

        viewOrderButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewOrderButton.setText("View Order");
        viewOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderButtonActionPerformed(evt);
            }
        });

        sendButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sendButton.setText("Send Bill");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Vaccine ID", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(orderTable);

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
                        .addGap(270, 270, 270)
                        .addComponent(titleJLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE))
                            .addComponent(backButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(viewOrderButton)
                        .addGap(195, 195, 195)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(375, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(titleJLabel)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewOrderButton)
                    .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(backButton)
                .addContainerGap(397, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderButtonActionPerformed
        int selectedRow = billTable.getSelectedRow();
        if (selectedRow >= 0) {
            int orderId = (Integer) billTable.getValueAt(selectedRow, 0);
            DefaultTableModel dtm = (DefaultTableModel) orderTable.getModel();
            dtm.setRowCount(0);

            Enterprise enterprise = null;
            Network net = null;
            Organization org = null;
            UserAccount u = null;
            for (Network network : system.getNetworkDirectory()) {
                for (Enterprise ent : network.getEnterpriseDirectory().getEnterprisesDirectory()) {
                    if (ent == distributorEnterprise) {
                        net = network;
                    }
                }
            }
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterprisesDirectory()) {
                if (ent instanceof ProviderEnterprise) {
                    enterprise = ent;
                    break;
                }
            }
            UserAccount uu = null;
            for (Organization o : enterprise.getOrganizationDirectory().getOrganizationDirectory()) {
                if (o instanceof OrderOrganization) {
                    for (UserAccount user : o.getUserAccountDirectory().getUserAccountDirectory()) {
                        uu = user;
                    }
                }
            }
            Order orderI = null;
            for (Order order : uu.getEmployee().getOrderCatalog().getOrderList()) {
                if (orderId == order.getOrderID()) {
                    orderI = order;
                }
            }
            for (OrderItem orderItem : orderI.getOrderItemList()) {
                Object[] row = new Object[4];
                row[0] = orderItem;
                row[1] = orderItem.getVaccine().getVaccineID();
                row[2] = orderItem.getItemQuantity();
                row[3] = orderItem.getVaccine().getVaccinePrice();
                dtm.addRow(row);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_viewOrderButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        
        int selectedRow = billTable.getSelectedRow();
        int orderId = (Integer) billTable.getValueAt(selectedRow, 0);
        Order order = null;
        PaymentRequest request = new PaymentRequest();
        request.setRequestType("Provider Payment Request");
        request.setStatus("Sent");
        request.setPaymentRequest("Sent");
        request.setSender(userAccount);
        Enterprise enterprise = null;
        Network net = null;
        Organization org = null;
        UserAccount u = null;
        for (Network network : system.getNetworkDirectory()) {
            for (Enterprise ent : network.getEnterpriseDirectory().getEnterprisesDirectory()) {
                if (ent == distributorEnterprise) {
                    net = network;
                }
            }
        }
        
        for (Enterprise ent : net.getEnterpriseDirectory().getEnterprisesDirectory()) {
            if (ent instanceof ProviderEnterprise) {
                enterprise = ent;
                break;
            }
        }
        
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationDirectory()) {
            if (organization instanceof FinanceOrganization) {
                org = organization;
            }
        }
        
        for (UserAccount user : org.getUserAccountDirectory().getUserAccountDirectory()) {
            if(user.getEmployee().getHospital().getHospitalName() == billTable.getValueAt(selectedRow, 1)){
                u = user;
                JOptionPane.showMessageDialog(null, user.getEmployee().getEmployeeName());
            }
        }
        
        UserAccount uu = null;
        for (Organization o : enterprise.getOrganizationDirectory().getOrganizationDirectory()) {
            if (o instanceof OrderOrganization) {
                for (UserAccount user : o.getUserAccountDirectory().getUserAccountDirectory()) {
                    uu = user;
                }
            }
        }
        
        for (Order o : uu.getEmployee().getOrderCatalog().getOrderList()) {
            if (o.getOrderID() == orderId) {
                order = o;
            }
        }
        
        request.setOrderID(order.getOrderID());
        
        if (u != null) {
            u.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
            populateVaccineOrderTable();
            JOptionPane.showMessageDialog(null, "Bill sent successfully", "Payment Request", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_sendButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.remove(this);
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTable billTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable orderTable;
    private javax.swing.JButton sendButton;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JButton viewOrderButton;
    // End of variables declaration//GEN-END:variables
}