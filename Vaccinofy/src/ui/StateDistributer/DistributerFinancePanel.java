/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.StateDistributer;

import Business.Ecosystem;
import Business.Enterprise.DistributorEnterprise;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author meetdoshi
 */

public class DistributerFinancePanel extends javax.swing.JPanel {
    
    /**
     * Creates new form DistributerFinanceWorkAreaJPanel
     */
    
    private JPanel userProcessContainer;
    private Ecosystem system;
    private UserAccount userAccount;
    private DistributorEnterprise distributorEnterprise;
    
    public DistributerFinancePanel(JPanel userProcessContainer, Ecosystem system, UserAccount userAccount, DistributorEnterprise distributorEnterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.system = system;
        this.distributorEnterprise = distributorEnterprise;
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
        manageManufacturerPaymentButton = new javax.swing.JButton();
        manageProviderPaymentButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Distributor Finance WorkArea ");

        manageManufacturerPaymentButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageManufacturerPaymentButton.setText("Manage Manufacture Payment >>");
        manageManufacturerPaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageManufacturerPaymentButtonActionPerformed(evt);
            }
        });

        manageProviderPaymentButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageProviderPaymentButton.setText("Manage Provider Payment >>");
        manageProviderPaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageProviderPaymentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(manageProviderPaymentButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(manageManufacturerPaymentButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(545, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addComponent(manageManufacturerPaymentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(manageProviderPaymentButton)
                .addContainerGap(804, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageManufacturerPaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageManufacturerPaymentButtonActionPerformed
        ManageManufacturerPaymentPanel manageManufacturerPaymentPanel = new ManageManufacturerPaymentPanel(userProcessContainer, system, userAccount, distributorEnterprise);
        userProcessContainer.add("manageManufacturePaymentJPanel", manageManufacturerPaymentPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageManufacturerPaymentButtonActionPerformed

    private void manageProviderPaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageProviderPaymentButtonActionPerformed
        ManageProviderPaymentPanel manageProviderPaymentPanel = new ManageProviderPaymentPanel(userProcessContainer, system, userAccount, distributorEnterprise);
        userProcessContainer.add("manageProviderPaymentJPanel", manageProviderPaymentPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageProviderPaymentButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageManufacturerPaymentButton;
    private javax.swing.JButton manageProviderPaymentButton;
    // End of variables declaration//GEN-END:variables
}
