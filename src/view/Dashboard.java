/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import AppPackage.AnimationClass;
import control.ControleUsuario;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import util.AtualizadorHorario;

/**
 *
 * @author Abner
 */
public class Dashboard extends javax.swing.JFrame {

    ControleUsuario cu = new ControleUsuario();
    
    public Dashboard() {
        initComponents();
        showRelogio();
        
        AnimationClass anim = new AnimationClass();

        try {
            anim.jLabelXLeft(blinded.getX(), blinded.getX() - 270, 4, 1, blinded);
        } finally {
            blinded.setVisible(false);
        }
    }

    private void showRelogio() {
        AtualizadorHorario ah = new AtualizadorHorario(txtHora, txtDataHora);
        ah.mostrarData(true);
        Thread thHora = ah;
        thHora.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        mGradientPanel1 = new com.hq.swingmaterialdesign.materialdesign.MGradientPanel();
        txtHora = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtDataHora = new javax.swing.JLabel();
        btnUsuario = new com.hq.swingmaterialdesign.materialdesign.MGradientButton();
        btnRelatorio = new com.hq.swingmaterialdesign.materialdesign.MGradientButton();
        panHeader = new javax.swing.JPanel();
        mGradientPanel2 = new com.hq.swingmaterialdesign.materialdesign.MGradientPanel();
        blinded = new javax.swing.JLabel();
        mButton2 = new com.hq.swingmaterialdesign.materialdesign.MButton();
        mButton1 = new com.hq.swingmaterialdesign.materialdesign.MButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));

        mGradientPanel1.setAutoscrolls(true);
        mGradientPanel1.setBackgroundColor(new java.awt.Color(242, 242, 242));
        mGradientPanel1.setBorderRadius(0);
        mGradientPanel1.setFillImage(true);
        mGradientPanel1.setImagePath("/reports/issae.png");

        javax.swing.GroupLayout mGradientPanel1Layout = new javax.swing.GroupLayout(mGradientPanel1);
        mGradientPanel1.setLayout(mGradientPanel1Layout);
        mGradientPanel1Layout.setHorizontalGroup(
            mGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 53, Short.MAX_VALUE)
        );
        mGradientPanel1Layout.setVerticalGroup(
            mGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(mGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(mGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtHora.setFont(new java.awt.Font("Poppins SemiBold", 0, 48)); // NOI18N
        txtHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        txtDataHora.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        txtDataHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btnUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuario.setText("usuário");
        btnUsuario.setActionCommand("usuário");
        btnUsuario.setBorderRadius(20);
        btnUsuario.setEndColor(new java.awt.Color(184, 27, 232));
        btnUsuario.setFont(new java.awt.Font("Mont Bold", 0, 18)); // NOI18N
        btnUsuario.setStartColor(new java.awt.Color(255, 0, 255));
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        btnRelatorio.setForeground(new java.awt.Color(255, 255, 255));
        btnRelatorio.setText("relatório");
        btnRelatorio.setBorderRadius(20);
        btnRelatorio.setEndColor(new java.awt.Color(184, 27, 232));
        btnRelatorio.setFont(new java.awt.Font("Mont Bold", 0, 18)); // NOI18N
        btnRelatorio.setStartColor(new java.awt.Color(255, 0, 255));
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        panHeader.setBackground(new java.awt.Color(255, 255, 255));
        panHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mGradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        mGradientPanel2.setAutoscrolls(true);
        mGradientPanel2.setBackgroundColor(new java.awt.Color(242, 242, 242));
        mGradientPanel2.setBorderRadius(200);
        mGradientPanel2.setFillImage(true);
        mGradientPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mGradientPanel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mGradientPanel2Layout = new javax.swing.GroupLayout(mGradientPanel2);
        mGradientPanel2.setLayout(mGradientPanel2Layout);
        mGradientPanel2Layout.setHorizontalGroup(
            mGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        mGradientPanel2Layout.setVerticalGroup(
            mGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panHeader.add(mGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 50, 50));

        blinded.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reports/blinded.png"))); // NOI18N
        blinded.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panHeader.add(blinded, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, -1));

        mButton2.setBorder(null);
        mButton2.setForeground(new java.awt.Color(153, 0, 0));
        mButton2.setText("sair");
        mButton2.setFont(new java.awt.Font("Mont Light", 0, 14)); // NOI18N
        panHeader.add(mButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 64, 53));

        mButton1.setBorder(null);
        mButton1.setText("editar perfil");
        mButton1.setFont(new java.awt.Font("Mont Light", 0, 14)); // NOI18N
        panHeader.add(mButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 113, 53));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDataHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        UsuarioForm uf = new UsuarioForm(this, false);
        uf.setVisible(true);
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        HashMap<String, Object> parametros = new HashMap();
        parametros.put("usuario", cu.findByNome(""));
        try {
            cu.gerarRelatorio(parametros, cu.findByNome(""), "src/reports/Usuarios.jrxml");
        } catch (JRException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void mGradientPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mGradientPanel2MouseClicked
        this.dispose();
    }//GEN-LAST:event_mGradientPanel2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code FLAT LIGHT LAF ">
        try {
            javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel blinded;
    private com.hq.swingmaterialdesign.materialdesign.MGradientButton btnRelatorio;
    private com.hq.swingmaterialdesign.materialdesign.MGradientButton btnUsuario;
    private javax.swing.JSeparator jSeparator3;
    private com.hq.swingmaterialdesign.materialdesign.MButton mButton1;
    private com.hq.swingmaterialdesign.materialdesign.MButton mButton2;
    private com.hq.swingmaterialdesign.materialdesign.MGradientPanel mGradientPanel1;
    private com.hq.swingmaterialdesign.materialdesign.MGradientPanel mGradientPanel2;
    private javax.swing.JPanel panHeader;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JLabel txtDataHora;
    private javax.swing.JLabel txtHora;
    // End of variables declaration//GEN-END:variables
}
