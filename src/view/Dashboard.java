/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ControleUsuario;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
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
        if (ControleUsuario.getLogado() != null) {
            if (ControleUsuario.getLogado().getFotoPerfil() != null) {
                ImageIcon im = new ImageIcon(ControleUsuario.getLogado().getFotoPerfil());
                imgPessoa.setImage(im.getImage());
                imgPessoa.repaint();
            }
        }
    }

    private void showRelogio() {
        AtualizadorHorario ah = new AtualizadorHorario(txtHora, txtDataHora);
        ah.mostrarData(true);
        Thread thHora = ah;
        thHora.start();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/reports/issaefav.png")));

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
        imgPessoa = new com.hq.swingmaterialdesign.materialdesign.MGradientPanel();
        btnSair = new com.hq.swingmaterialdesign.materialdesign.MButton();
        btnEditarPerfil = new com.hq.swingmaterialdesign.materialdesign.MButton();
        btnOrcamento = new com.hq.swingmaterialdesign.materialdesign.MGradientButton();
        btnFlashes = new com.hq.swingmaterialdesign.materialdesign.MGradientButton();

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
        btnUsuario.setBorderRadius(20);
        btnUsuario.setEndColor(new java.awt.Color(184, 27, 232));
        btnUsuario.setFont(new java.awt.Font("Mont Bold", 0, 18)); // NOI18N
        btnUsuario.setStartColor(new java.awt.Color(255, 0, 255));
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        imgPessoa.setBackground(new java.awt.Color(255, 255, 255));
        imgPessoa.setAutoscrolls(true);
        imgPessoa.setBackgroundColor(new java.awt.Color(242, 242, 242));
        imgPessoa.setBorderRadius(20000);
        imgPessoa.setFillImage(true);
        imgPessoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgPessoaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout imgPessoaLayout = new javax.swing.GroupLayout(imgPessoa);
        imgPessoa.setLayout(imgPessoaLayout);
        imgPessoaLayout.setHorizontalGroup(
            imgPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        imgPessoaLayout.setVerticalGroup(
            imgPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        btnSair.setBorder(null);
        btnSair.setForeground(new java.awt.Color(153, 0, 0));
        btnSair.setText("sair");
        btnSair.setFont(new java.awt.Font("Mont Light", 0, 14)); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnEditarPerfil.setBorder(null);
        btnEditarPerfil.setText("editar perfil");
        btnEditarPerfil.setFont(new java.awt.Font("Mont Light", 0, 14)); // NOI18N

        btnOrcamento.setForeground(new java.awt.Color(255, 255, 255));
        btnOrcamento.setText("orçamento");
        btnOrcamento.setBorderRadius(20);
        btnOrcamento.setEndColor(new java.awt.Color(184, 27, 232));
        btnOrcamento.setFont(new java.awt.Font("Mont Bold", 0, 18)); // NOI18N
        btnOrcamento.setStartColor(new java.awt.Color(255, 0, 255));
        btnOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrcamentoActionPerformed(evt);
            }
        });

        btnFlashes.setForeground(new java.awt.Color(255, 255, 255));
        btnFlashes.setText("Flashes");
        btnFlashes.setBorderRadius(20);
        btnFlashes.setEndColor(new java.awt.Color(184, 27, 232));
        btnFlashes.setFont(new java.awt.Font("Mont Bold", 0, 18)); // NOI18N
        btnFlashes.setStartColor(new java.awt.Color(255, 0, 255));
        btnFlashes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlashesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDataHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                        .addComponent(btnEditarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(imgPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(btnFlashes, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEditarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFlashes, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void imgPessoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgPessoaMouseClicked

    }//GEN-LAST:event_imgPessoaMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrcamentoActionPerformed
        OrcamentoForm of = new OrcamentoForm(this, false);
        of.setVisible(true);
    }//GEN-LAST:event_btnOrcamentoActionPerformed

    private void btnFlashesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlashesActionPerformed
        FlashesForm ff = new FlashesForm(this,false);
        ff.setVisible(true);
    }//GEN-LAST:event_btnFlashesActionPerformed

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
    private com.hq.swingmaterialdesign.materialdesign.MButton btnEditarPerfil;
    private com.hq.swingmaterialdesign.materialdesign.MGradientButton btnFlashes;
    private com.hq.swingmaterialdesign.materialdesign.MGradientButton btnOrcamento;
    private com.hq.swingmaterialdesign.materialdesign.MButton btnSair;
    private com.hq.swingmaterialdesign.materialdesign.MGradientButton btnUsuario;
    private com.hq.swingmaterialdesign.materialdesign.MGradientPanel imgPessoa;
    private javax.swing.JSeparator jSeparator3;
    private com.hq.swingmaterialdesign.materialdesign.MGradientPanel mGradientPanel1;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JLabel txtDataHora;
    private javax.swing.JLabel txtHora;
    // End of variables declaration//GEN-END:variables
}
