/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.ManufacturerWorkArea;

import Business.Ecosystem;
import Business.Employee.Employee;
import Business.Enterprise.DistributorEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.VaccineManufacturesEnterprise;
import Business.Inventory.Inventory;
import Business.Network.Network;
import Business.Organization.FinanceOrganization;
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
 * @author ADMIN
 */
public class ManufactureFinanceWorkAreaJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private Ecosystem system;
    private UserAccount userAccount;
    private VaccineManufacturesEnterprise vaccineManufacturesEnterprise;

    /**
     * Creates new form ManufactureFinanceWorkAreaJPanel
     */
    public ManufactureFinanceWorkAreaJPanel(JPanel userProcessContainer, Ecosystem system, UserAccount userAccount, VaccineManufacturesEnterprise vaccineManufacturesEnterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.system = system;
        this.vaccineManufacturesEnterprise = vaccineManufacturesEnterprise;

        populateManufactureTable();
    }
    public void populateManufactureTable() {
        DefaultTableModel dtm = (DefaultTableModel) manufactureOrderJTable.getModel();
        dtm.setRowCount(0);

        for (Organization organization : vaccineManufacturesEnterprise.getOrganizationDirectory().getOrganizationDirectory()) {
            for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                Enterprise ent = null;
                UserAccount user = (UserAccount) request.getSender();
                for (Network network : system.getNetworkDirectory()) {
                    for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterprisesDirectory()) {
                        for (UserAccount ua : enterprise.getUserAccountDirectory().getUserAccountDirectory()) {
                            if (ua == user) {
                                ent = enterprise;
                            }
                        }
                    }
                }
                for (Organization org : ent.getOrganizationDirectory().getOrganizationDirectory()) {
                    for (Inventory inventory : org.getInventoryDirectory().getInventoryDirectory()) {
                        if (request.getOrderID() == inventory.getVaccine().getVaccineID()) {
                            Object[] row = new Object[7];
                            row[0] = inventory.getVaccine();
                            row[1] = request.getOrderID();
                            row[2] = inventory.getVaccine().getVaccinePrice();
                            row[3] = request.getRequestedQuantity();
                            row[4] = request.getRequestedQuantity() * inventory.getVaccine().getVaccinePrice();
                            for (WorkRequest work : userAccount.getWorkQueue().getWorkRequestList()) {
                                if (inventory.getVaccine().getVaccineID() == work.getOrderID()) {
                                    row[5] = work.getReceiver();
                                    row[6] = work.getStatus();
                                }
                            }
                            dtm.addRow(row);
                        }
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        manufactureOrderJTable = new javax.swing.JTable();
        sendJButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Manufacture Request");

        manufactureOrderJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Vaccine ID", "Price", "Quantity", "Total Price", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(manufactureOrderJTable);

        sendJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sendJButton.setText("Send Bill");
        sendJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(sendJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(382, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(sendJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(672, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sendJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendJButtonActionPerformed
        int selectedRow = manufactureOrderJTable.getSelectedRow();
        Vaccine vaccine = (Vaccine) manufactureOrderJTable.getValueAt(selectedRow, 0);
        PaymentRequest request = new PaymentRequest();
        request.setRequestType("Manufacture Payment Request");
        request.setStatus("Sent");
        request.setPaymentRequest("Sent");
        request.setSender(userAccount);
        request.setOrderID(vaccine.getVaccineID());
        request.setRequestedQuantity(((Integer) (manufactureOrderJTable.getValueAt(selectedRow, 3))));
        UserAccount ua = (UserAccount) request.getSender();
        Employee employee = (Employee) ua.getEmployee();
        Enterprise enterprise = null;
        Network net = null;
        Organization org = null;
        for (Network network : system.getNetworkDirectory()) {
            for (Enterprise ent : network.getEnterpriseDirectory().getEnterprisesDirectory()) {
                if (ent == vaccineManufacturesEnterprise) {
                    net = network;
                }
            }
        }
        for (Enterprise ent : net.getEnterpriseDirectory().getEnterprisesDirectory()) {
            if (ent instanceof DistributorEnterprise) {
                enterprise = ent;
                break;
            }
        }
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationDirectory()) {
            if (organization instanceof FinanceOrganization) {
                org = organization;
            }
        }

        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
            populateManufactureTable();
        }
        JOptionPane.showMessageDialog(null, "Bill sent successfully", "Payment Request", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_sendJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable manufactureOrderJTable;
    private javax.swing.JButton sendJButton;
    // End of variables declaration//GEN-END:variables
}