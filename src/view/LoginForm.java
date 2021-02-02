package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import control.ControleUsuario;
//import control.ControleCaixa;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.persistence.NoResultException;
import model.Usuario;
import model.Caixa;

/**
 *
 * @author abner
 */
public class LoginForm extends javax.swing.JFrame {

    private int xMouse;
    private int yMouse;
    private ControleUsuario cu = new ControleUsuario();
    //private ControleCaixa cc = new ControleCaixa();

    /**
     * Creates new form loginForm
     */
    public LoginForm() {
        initComponents();
        setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/view/images/favicon2.png")));
        warningPanelForm1.setVisible(false);
        txtUsuario.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        sideImage = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        txtUsuario = new com.hq.swingmaterialdesign.materialdesign.MTextField();
        txtSenha = new com.hq.swingmaterialdesign.materialdesign.MPasswordField();
        mButton3 = new com.hq.swingmaterialdesign.materialdesign.MButton();
        jLabel3 = new javax.swing.JLabel();
        warningPanelForm1 = new javax.swing.JPanel();
        btnError1 = new com.hq.swingmaterialdesign.materialdesign.MButton();
        labelWarningForm1 = new javax.swing.JLabel();
        btnEntrar = new com.hq.swingmaterialdesign.materialdesign.MButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        loadingPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        bg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bgMouseDragged(evt);
            }
        });
        bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bgMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                bgMouseReleased(evt);
            }
        });
        bg.setLayout(new java.awt.CardLayout());

        loginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sideImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/SIGAM.png"))); // NOI18N
        loginPanel.add(sideImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        formPanel.setBackground(new java.awt.Color(255, 255, 255));
        formPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setForeground(new java.awt.Color(51, 51, 51));
        txtUsuario.setAccent(new java.awt.Color(220, 148, 74));
        txtUsuario.setFont(new java.awt.Font("Nunito SemiBold", 0, 16)); // NOI18N
        txtUsuario.setLabel("Nome de usuário");
        txtUsuario.setSelectionColor(new java.awt.Color(220, 148, 74));
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        formPanel.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 310, 60));

        txtSenha.setForeground(new java.awt.Color(51, 51, 51));
        txtSenha.setAccent(new java.awt.Color(220, 148, 74));
        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSenha.setLabel("Senha");
        txtSenha.setSelectionColor(new java.awt.Color(220, 148, 74));
        txtSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSenhaFocusGained(evt);
            }
        });
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSenhaKeyTyped(evt);
            }
        });
        formPanel.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 310, 60));

        mButton3.setBorder(null);
        mButton3.setForeground(new java.awt.Color(51, 51, 51));
        mButton3.setText(String.valueOf(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.CLOSE));
        mButton3.setBorderRadius(0);
        mButton3.setFont(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.ICON_FONT.deriveFont(20f));
        mButton3.setType(com.hq.swingmaterialdesign.materialdesign.MButton.Type.FLAT);
        mButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mButton3MouseExited(evt);
            }
        });
        mButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mButton3ActionPerformed(evt);
            }
        });
        formPanel.add(mButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 40, 40));

        jLabel3.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 38)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TIC");
        formPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 430, 30));

        warningPanelForm1.setBackground(new java.awt.Color(255, 51, 51));

        btnError1.setBackground(new java.awt.Color(255, 51, 51));
        btnError1.setBorder(null);
        btnError1.setText(String.valueOf(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.CLOSE));
        btnError1.setBorderRadius(0);
        btnError1.setFont(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.ICON_FONT.deriveFont(20f));
        btnError1.setType(com.hq.swingmaterialdesign.materialdesign.MButton.Type.FLAT);
        btnError1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnError1ActionPerformed(evt);
            }
        });

        labelWarningForm1.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        labelWarningForm1.setForeground(new java.awt.Color(255, 255, 255));
        labelWarningForm1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelWarningForm1.setText("Preencha os campos corretamente.");

        javax.swing.GroupLayout warningPanelForm1Layout = new javax.swing.GroupLayout(warningPanelForm1);
        warningPanelForm1.setLayout(warningPanelForm1Layout);
        warningPanelForm1Layout.setHorizontalGroup(
            warningPanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, warningPanelForm1Layout.createSequentialGroup()
                .addComponent(labelWarningForm1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnError1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        warningPanelForm1Layout.setVerticalGroup(
            warningPanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warningPanelForm1Layout.createSequentialGroup()
                .addGroup(warningPanelForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnError1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelWarningForm1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        formPanel.add(warningPanelForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 430, -1));

        btnEntrar.setBackground(new java.awt.Color(0, 0, 0));
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("ENTRAR");
        btnEntrar.setBorderRadius(40);
        btnEntrar.setFont(new java.awt.Font("Nunito ExtraBold", 0, 14)); // NOI18N
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        formPanel.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 310, 40));

        jLabel4.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("INK");
        formPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 430, 30));

        jLabel5.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TAS");
        formPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 430, 30));

        loginPanel.add(formPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 540));

        bg.add(loginPanel, "card2");

        loadingPanel.setBackground(new java.awt.Color(37, 46, 55));

        javax.swing.GroupLayout loadingPanelLayout = new javax.swing.GroupLayout(loadingPanel);
        loadingPanel.setLayout(loadingPanelLayout);
        loadingPanelLayout.setHorizontalGroup(
            loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        loadingPanelLayout.setVerticalGroup(
            loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        bg.add(loadingPanel, "card3");

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

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void mButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_mButton3ActionPerformed

    private void mButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mButton3MouseEntered
        mButton3.setForeground(new java.awt.Color(232, 25, 30));
    }//GEN-LAST:event_mButton3MouseEntered

    private void mButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mButton3MouseExited
        mButton3.setForeground(new java.awt.Color(51, 51, 51));
    }//GEN-LAST:event_mButton3MouseExited

    private void bgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_bgMousePressed

    private void bgMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseReleased
        try {
            setOpacity((float) 1);
        } catch (java.lang.UnsupportedOperationException e) {

        }
    }//GEN-LAST:event_bgMouseReleased

    private void bgMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseDragged
        setLocation(evt.getXOnScreen() - xMouse, evt.getYOnScreen() - yMouse);
        try {
            setOpacity((float) 0.9);
        } catch (java.lang.UnsupportedOperationException e) {

        }
    }//GEN-LAST:event_bgMouseDragged
    private void entrar() {
        if (txtSenha.getText().equals("") || txtUsuario.getText().equals("")) {
            labelWarningForm1.setText("Preencha os campos corretamente");
            warningPanelForm1.setVisible(true);
            Color errorColor = new Color(255, 0, 0);
            if (txtSenha.getText().equals("")) {
                txtSenha.setForeground(errorColor);
            }
            if (txtUsuario.getText().equals("")) {
                txtUsuario.setForeground(errorColor);
            }
        } else {
            Usuario u = null;
            try {
                u = cu.findByLoginSenha(txtUsuario.getText(), txtSenha.getText());
                loadingPanel.setVisible(true);
                formPanel.setVisible(false);
                ControleUsuario.setLogado((Usuario) u);
                UsuarioForm tela = new UsuarioForm(this, false);
                tela.setVisible(true);
                this.dispose();
                Caixa c = null;
//                try {
//                    c = cc.findByAbertoFuncionario((Secretario) u, new Date());
//                } catch (NoResultException ex) {
//                    System.out.println("nao encontrou caixa");
//                }
//                ControleCaixa.setCaixa(c);
            } catch (NoResultException e) {
                labelWarningForm1.setText("Usuário ou senha incorretos");
                warningPanelForm1.setVisible(true);
            }
        }
    }
    private void btnError1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnError1ActionPerformed
        warningPanelForm1.setVisible(false);
    }//GEN-LAST:event_btnError1ActionPerformed

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
        txtUsuario.setForeground(new Color(240, 240, 240));
    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusGained
        txtSenha.setForeground(new Color(240, 240, 240));
    }//GEN-LAST:event_txtSenhaFocusGained

    private void txtSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyTyped

    }//GEN-LAST:event_txtSenhaKeyTyped

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped

    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            entrar();
        }

    }//GEN-LAST:event_txtSenhaKeyPressed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            txtSenha.requestFocus();
        }

    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        entrar();
    }//GEN-LAST:event_btnEntrarActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private com.hq.swingmaterialdesign.materialdesign.MButton btnEntrar;
    private com.hq.swingmaterialdesign.materialdesign.MButton btnError1;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel labelWarningForm1;
    private javax.swing.JPanel loadingPanel;
    private javax.swing.JPanel loginPanel;
    private com.hq.swingmaterialdesign.materialdesign.MButton mButton3;
    private javax.swing.JLabel sideImage;
    private com.hq.swingmaterialdesign.materialdesign.MPasswordField txtSenha;
    private com.hq.swingmaterialdesign.materialdesign.MTextField txtUsuario;
    private javax.swing.JPanel warningPanelForm1;
    // End of variables declaration//GEN-END:variables
}
