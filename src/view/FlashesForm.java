/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.hq.swingmaterialdesign.materialdesign.MButton;
import com.hq.swingmaterialdesign.materialdesign.MGradientPanel;
import control.ControleFlashes;
import control.ControleUsuario;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Flashes;

/**
 *
 * @author Abner
 */
public class FlashesForm extends javax.swing.JDialog {

    private int xMouse, yMouse;
    private ControleFlashes co = new ControleFlashes();
    private File file;
    private ArrayList<Flashes> listaFlashes = new ArrayList<>();

    public FlashesForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        atualizaFlashes();
    }

    private void atualizaFlashes() {
        int ind = 0;
        panAnexos.removeAll();
        listaFlashes.clear();
        listaFlashes.addAll(co.findAll());

        for (Flashes i : listaFlashes) {
            anexosConfig(i.getImagem(), ind);
            ind++;
        }
        panAnexos.repaint();
    }

    private void imageInPanel(MGradientPanel frame, MGradientPanel imageAnexo, MButton btnRemoveAnexo, byte[] anexoImg, int index) {
        frame.setBackground(new java.awt.Color(70, 70, 70));
        frame.setBorderRadius(20);
        imageAnexo.setBackground(new java.awt.Color(70, 70, 70));
        imageAnexo.setFillBackground(false);
        imageAnexo.setFillImage(true);
        imageAnexo.setBorderRadius(20);
        ImageIcon im = new ImageIcon(anexoImg);
        imageAnexo.setImage(im.getImage());
        imageAnexo.repaint();

        imageAnexo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                imageAnexo.getComponent(0).setVisible(true);
            }
        });

        btnRemoveAnexo.setBackground(new Color(0, 0, 0, 120));
        btnRemoveAnexo.setBorder(null);
        btnRemoveAnexo.setText(String.valueOf(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.DELETE));
        btnRemoveAnexo.setBorderRadius(10);
        btnRemoveAnexo.setFont(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.ICON_FONT.deriveFont(40f));
        btnRemoveAnexo.setType(com.hq.swingmaterialdesign.materialdesign.MButton.Type.FLAT);
        btnRemoveAnexo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnRemoveAnexo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRemoveAnexo.setVisible(false);
            }
        });
        btnRemoveAnexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                co.delete(listaFlashes.get(index));
                listaFlashes.remove(index);
                atualizaFlashes();
            }
        });

        javax.swing.GroupLayout imageAnexoLayout = new javax.swing.GroupLayout(imageAnexo);
        imageAnexo.setLayout(imageAnexoLayout);
        imageAnexoLayout.setHorizontalGroup(
                imageAnexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnRemoveAnexo, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        imageAnexoLayout.setVerticalGroup(
                imageAnexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnRemoveAnexo, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        btnRemoveAnexo.setVisible(false);

        javax.swing.GroupLayout frameLayout = new javax.swing.GroupLayout(frame);
        frame.setLayout(frameLayout);
        frameLayout.setHorizontalGroup(
                frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imageAnexo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        frameLayout.setVerticalGroup(
                frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imageAnexo, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
    }

    private void anexosConfig(byte[] anexoImg, int index) {
        MGradientPanel frame = new MGradientPanel();
        MGradientPanel imageAnexo = new MGradientPanel();
        MButton btnRemoveAnexo = new MButton();

        imageInPanel(frame, imageAnexo, btnRemoveAnexo, anexoImg, index);
        System.out.println(10 + (130 * (((int) index / 6))) + "  ------  " + listaFlashes.size()  + "  ------  " + index);
        panAnexos.add(frame, new org.netbeans.lib.awtextra.AbsoluteConstraints((130 * ((index) % 5) + 10), 10 + (130 * (((int) (index + 1) / 6))), 120, 120));

        scroll.setViewportView(panAnexos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        mButton4 = new com.hq.swingmaterialdesign.materialdesign.MButton();
        btnAddAnexo1 = new com.hq.swingmaterialdesign.materialdesign.MButton();
        jLabel3 = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        panAnexos = new javax.swing.JPanel();
        frame = new com.hq.swingmaterialdesign.materialdesign.MGradientPanel();
        imageAnexo = new com.hq.swingmaterialdesign.materialdesign.MGradientPanel();
        btnRemoveAnexo = new com.hq.swingmaterialdesign.materialdesign.MButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(51, 51, 51));
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
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mButton4.setBackground(new java.awt.Color(51, 51, 51));
        mButton4.setBorder(null);
        mButton4.setText(String.valueOf(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.CLOSE));
        mButton4.setBorderRadius(0);
        mButton4.setFont(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.ICON_FONT.deriveFont(20f));
        mButton4.setType(com.hq.swingmaterialdesign.materialdesign.MButton.Type.FLAT);
        mButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mButton4MouseExited(evt);
            }
        });
        mButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mButton4ActionPerformed(evt);
            }
        });
        bg.add(mButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 40, 40));

        btnAddAnexo1.setBackground(new java.awt.Color(51, 51, 51));
        btnAddAnexo1.setBorder(null);
        btnAddAnexo1.setText(String.valueOf(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.ADD_BOX));
        btnAddAnexo1.setBorderRadius(0);
        btnAddAnexo1.setFont(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.ICON_FONT.deriveFont(20f));
        btnAddAnexo1.setType(com.hq.swingmaterialdesign.materialdesign.MButton.Type.FLAT);
        btnAddAnexo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddAnexo1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddAnexo1MouseExited(evt);
            }
        });
        btnAddAnexo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAnexo1ActionPerformed(evt);
            }
        });
        bg.add(btnAddAnexo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 20, 20));

        jLabel3.setFont(new java.awt.Font("Nunito", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Anexos");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));

        scroll.setBorder(null);

        panAnexos.setBackground(new java.awt.Color(70, 70, 70));
        panAnexos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        frame.setBackground(new java.awt.Color(70, 70, 70));
        frame.setBorderRadius(20);

        imageAnexo.setBackground(new java.awt.Color(70, 70, 70));
        imageAnexo.setFillBackground(false);
        imageAnexo.setFillImage(true);
        imageAnexo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                imageAnexoMouseEntered(evt);
            }
        });

        btnRemoveAnexo.setBackground(new Color(0,0,0,120));
        btnRemoveAnexo.setBorder(null);
        btnRemoveAnexo.setText(String.valueOf(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.DELETE));
        btnRemoveAnexo.setBorderRadius(10);
        btnRemoveAnexo.setFont(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.ICON_FONT.deriveFont(40f));
        btnRemoveAnexo.setType(com.hq.swingmaterialdesign.materialdesign.MButton.Type.FLAT);
        btnRemoveAnexo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnRemoveAnexo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRemoveAnexoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRemoveAnexoMouseExited(evt);
            }
        });
        btnRemoveAnexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAnexoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imageAnexoLayout = new javax.swing.GroupLayout(imageAnexo);
        imageAnexo.setLayout(imageAnexoLayout);
        imageAnexoLayout.setHorizontalGroup(
            imageAnexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRemoveAnexo, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        imageAnexoLayout.setVerticalGroup(
            imageAnexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRemoveAnexo, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        btnRemoveAnexo.setVisible(false);

        javax.swing.GroupLayout frameLayout = new javax.swing.GroupLayout(frame);
        frame.setLayout(frameLayout);
        frameLayout.setHorizontalGroup(
            frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageAnexo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        frameLayout.setVerticalGroup(
            frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageAnexo, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        panAnexos.add(frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 120));

        scroll.setViewportView(panAnexos);

        bg.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 660, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 528, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bgMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseReleased

        try {
            setOpacity((float) 1);
        } catch (java.lang.UnsupportedOperationException e) {

        }
    }//GEN-LAST:event_bgMouseReleased

    private void bgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_bgMousePressed

    private void bgMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseDragged

        setLocation(evt.getXOnScreen() - xMouse, evt.getYOnScreen() - yMouse);
        try {
            setOpacity((float) 0.9);
        } catch (java.lang.UnsupportedOperationException e) {

        }
    }//GEN-LAST:event_bgMouseDragged

    private void mButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_mButton4ActionPerformed

    private void mButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mButton4MouseExited
        mButton4.setForeground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_mButton4MouseExited

    private void mButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mButton4MouseEntered
        mButton4.setForeground(new java.awt.Color(50, 60, 69));
    }//GEN-LAST:event_mButton4MouseEntered

    private void btnRemoveAnexoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveAnexoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveAnexoMouseEntered

    private void btnRemoveAnexoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveAnexoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveAnexoMouseExited

    private void btnRemoveAnexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAnexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveAnexoActionPerformed

    private void imageAnexoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageAnexoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_imageAnexoMouseEntered

    private void btnAddAnexo1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddAnexo1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddAnexo1MouseEntered

    private void btnAddAnexo1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddAnexo1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddAnexo1MouseExited

    private void btnAddAnexo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAnexo1ActionPerformed
        Flashes a = new Flashes();

        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Selecione o anexo");
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileNameExtensionFilter ext = new FileNameExtensionFilter("Imagem", "png", "jpg", "bmp");

        jfc.setFileFilter(ext);

        int r = jfc.showOpenDialog(this);

        if (r == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
            byte[] imageInByte = null;
            FileInputStream fis = null;
            try {
                imageInByte = new byte[(int) file.length()];
                fis = new FileInputStream(file);
                fis.read(imageInByte);
                fis.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Impossível carregar imagem!");
                fis = null;
            } finally {
                a.setImagem(imageInByte);
            }

            a.setIdUsuario(ControleUsuario.getLogado());
            listaFlashes.add(a);
            co.persist(a);

            atualizaFlashes();
        }

    }//GEN-LAST:event_btnAddAnexo1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code FLAT DARK LAF ">
        try {
            javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarkLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FlashesForm dialog = new FlashesForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel bg;
    private com.hq.swingmaterialdesign.materialdesign.MButton btnAddAnexo1;
    private com.hq.swingmaterialdesign.materialdesign.MButton btnRemoveAnexo;
    private com.hq.swingmaterialdesign.materialdesign.MGradientPanel frame;
    private com.hq.swingmaterialdesign.materialdesign.MGradientPanel imageAnexo;
    private javax.swing.JLabel jLabel3;
    private com.hq.swingmaterialdesign.materialdesign.MButton mButton4;
    private javax.swing.JPanel panAnexos;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
