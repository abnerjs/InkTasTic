/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ControleCaixa;
import control.ControleUsuario;
import java.awt.Color;
import java.util.Date;
import model.Caixa;

/**
 *
 * @author Abner
 */
public class AbreCaixa extends javax.swing.JDialog {

    ControleCaixa cc = new ControleCaixa();
    public AbreCaixa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataPanel = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        mGradientButton1 = new com.hq.swingmaterialdesign.materialdesign.MGradientButton();
        txtValor = new com.hq.swingmaterialdesign.materialdesign.MFormattedTextField();
        btnExit = new com.hq.swingmaterialdesign.materialdesign.MButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        dataPanel.setBackground(new java.awt.Color(51, 51, 51));
        dataPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchPanel.setBackground(new java.awt.Color(24, 24, 24));

        mGradientButton1.setBackground(new java.awt.Color(51, 51, 51));
        mGradientButton1.setForeground(new java.awt.Color(204, 204, 204));
        mGradientButton1.setText("ABRIR");
        mGradientButton1.setBorderRadius(48);
        mGradientButton1.setEndColor(new java.awt.Color(24, 24, 24));
        mGradientButton1.setFont(new java.awt.Font("Mont SemiBold", 0, 14)); // NOI18N
        mGradientButton1.setHoverEndColor(new java.awt.Color(51, 51, 51));
        mGradientButton1.setHoverStartColor(new java.awt.Color(51, 51, 51));
        mGradientButton1.setStartColor(new java.awt.Color(51, 51, 51));
        mGradientButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mGradientButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mGradientButton1MouseExited(evt);
            }
        });
        mGradientButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mGradientButton1ActionPerformed(evt);
            }
        });

        txtValor.setBackground(new java.awt.Color(24, 24, 24));
        txtValor.setForeground(new java.awt.Color(240, 240, 240));
        txtValor.setFont(new java.awt.Font("Nunito", 0, 16)); // NOI18N
        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtValor.setLabel("Valor Inicial");
        txtValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorFocusGained(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mGradientButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mGradientButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        dataPanel.add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 600, 100));

        btnExit.setBackground(new java.awt.Color(51, 51, 51));
        btnExit.setBorder(null);
        btnExit.setText(String.valueOf(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.CLOSE));
        btnExit.setBorderRadius(0);
        btnExit.setFont(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.ICON_FONT.deriveFont(20f));
        btnExit.setType(com.hq.swingmaterialdesign.materialdesign.MButton.Type.FLAT);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        dataPanel.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 50, 40));

        jLabel1.setFont(new java.awt.Font("Mont SemiBold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Abertura do Caixa");
        dataPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mGradientButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mGradientButton1MouseEntered
        mGradientButton1.setForeground(Color.white);
    }//GEN-LAST:event_mGradientButton1MouseEntered

    private void mGradientButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mGradientButton1MouseExited
        mGradientButton1.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_mGradientButton1MouseExited

    private void mGradientButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGradientButton1ActionPerformed
        String txt = txtValor.getText().replace(',', '.');
        Double d = Double.parseDouble(txt);
        
        Caixa c = new Caixa();
        c.setAbertura(new Date());
        c.setSaldoInicial(d);
        c.setUsuario(ControleUsuario.getLogado());
        
        cc.persist(c);
        ControleCaixa.setCaixa(c);
    }//GEN-LAST:event_mGradientButton1ActionPerformed

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setForeground(new java.awt.Color(230, 230, 230));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setForeground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorFocusGained
        txtValor.setForeground(new java.awt.Color(240, 240, 240));
    }//GEN-LAST:event_txtValorFocusGained

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
            java.util.logging.Logger.getLogger(AbreCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbreCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbreCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbreCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AbreCaixa dialog = new AbreCaixa(new javax.swing.JFrame(), true);
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
    private com.hq.swingmaterialdesign.materialdesign.MButton btnExit;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JLabel jLabel1;
    private com.hq.swingmaterialdesign.materialdesign.MGradientButton mGradientButton1;
    private javax.swing.JPanel searchPanel;
    private com.hq.swingmaterialdesign.materialdesign.MFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
}