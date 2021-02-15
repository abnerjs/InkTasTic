/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.hq.swingmaterialdesign.materialdesign.MButton;
import com.hq.swingmaterialdesign.materialdesign.MGradientPanel;
import control.ControleOrcamento;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.AnexoOrcamento;
import model.Orcamento;
import util.LimitText;

/**
 *
 * @author Abner
 */
public class OrcamentoForm extends javax.swing.JDialog {

    private int xMouse, yMouse;
    private Orcamento p = new Orcamento();
    private ControleOrcamento co = new ControleOrcamento();
    private File file;
    private ArrayList<Orcamento> listaPesquisa = new ArrayList();
    private ArrayList<AnexoOrcamento> listaAnexos = new ArrayList<>();
    private Orcamento selecionado;
    private int menuSelection = 0;
    private final Color errorColor = new Color(255, 0, 0);

    public OrcamentoForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        warningPanelForm.setVisible(false);
        warningPanelData.setVisible(false);
        atualizaTabela();
        tabOrcamento.getTableHeader().setBackground(new Color(51, 51, 51));
        tabOrcamento.getTableHeader().setForeground(new Color(255, 255, 255));
    }

    private void atualizaTabela() {
        new Thread() {
            @Override
            public void run() {
                listaPesquisa.clear();
                listaPesquisa.addAll(co.findByCliente(txtPesquisa.getText()));
                DefaultTableModel dtm = (DefaultTableModel) tabOrcamento.getModel();
                dtm.setNumRows(0);
                for (Orcamento s : listaPesquisa) {
                    dtm.addRow(new Object[]{s.getCliente(), s.getTelefone(), s.getValorEstimado()});
                }
            }
        }.start();
    }

    private void makeAllBlack() {
        txtCliente.setForeground(new Color(240, 240, 240));
        txtTelefone.setForeground(new Color(240, 240, 240));
        txtDescricao.setForeground(new Color(240, 240, 240));
        txtValorEstimado.setForeground(new Color(240, 240, 240));
    }

    private void limparCampos() {
        txtCliente.setText("");
        txtTelefone.setValue("");
        txtDescricao.setText("");
        txtValorEstimado.setText("");
        selecionado = null;
        panAnexos.removeAll();
        listaAnexos.clear();
    }

    private void setOrcamento() {
        txtCliente.setText(selecionado.getCliente());
        txtTelefone.setText(selecionado.getTelefone());
        txtDescricao.setText(selecionado.getDescricao());
        txtValorEstimado.setValue(selecionado.getValorEstimado());
        listaAnexos.addAll(selecionado.getAnexoOrcamentoCollection());
        atualizaAnexos();
    }

    private void voltar() {
        menuSelection = 0;
        addBtn.unselect();;
        changeBtn.unselect();;
        excludeBtn.unselect();
        limparCampos();
        makeAllBlack();
        dataPanel.setVisible(true);
        formPanel.setVisible(false);
        atualizaTabela();
    }

    private void atualizaAnexos() {
        int ind = 0;
        panAnexos.removeAll();

        for (AnexoOrcamento i : listaAnexos) {
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
                listaAnexos.remove(index);
                atualizaAnexos();
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
                        .addComponent(btnRemoveAnexo, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
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
                        .addComponent(imageAnexo, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
    }

    private void anexosConfig(byte[] anexoImg, int index) {
        MGradientPanel frame = new MGradientPanel();
        MGradientPanel imageAnexo = new MGradientPanel();
        MButton btnRemoveAnexo = new MButton();

        imageInPanel(frame, imageAnexo, btnRemoveAnexo, anexoImg, index);

        panAnexos.add(frame, new org.netbeans.lib.awtextra.AbsoluteConstraints((130 * index + 10), 10, 120, 170));

        scroll.setViewportView(panAnexos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        excludeBtn = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();
        addBtn = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();
        changeBtn = new com.hq.swingmaterialdesign.materialdesign.MToggleButton();
        cardPanel = new javax.swing.JPanel();
        dataPanel = new javax.swing.JPanel();
        warningPanelData = new javax.swing.JPanel();
        btnMessage = new com.hq.swingmaterialdesign.materialdesign.MButton();
        labelWarningData = new javax.swing.JLabel();
        searchPanel = new javax.swing.JPanel();
        txtPesquisa = new com.hq.swingmaterialdesign.materialdesign.MTextField();
        mGradientButton1 = new com.hq.swingmaterialdesign.materialdesign.MGradientButton();
        tablePanel = new javax.swing.JScrollPane();
        tabOrcamento = new javax.swing.JTable();
        btnExit = new com.hq.swingmaterialdesign.materialdesign.MButton();
        formPanel = new javax.swing.JPanel();
        warningPanelForm = new javax.swing.JPanel();
        btnError = new com.hq.swingmaterialdesign.materialdesign.MButton();
        labelWarningForm = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        mButton4 = new com.hq.swingmaterialdesign.materialdesign.MButton();
        txtCliente = new com.hq.swingmaterialdesign.materialdesign.MTextField();
        botCancelar = new com.hq.swingmaterialdesign.materialdesign.MButton();
        botConfirmar = new com.hq.swingmaterialdesign.materialdesign.MButton();
        txtDescricao = new com.hq.swingmaterialdesign.materialdesign.MTextField();
        txtTelefone = new com.hq.swingmaterialdesign.materialdesign.MFormattedTextField();
        txtValorEstimado = new com.hq.swingmaterialdesign.materialdesign.MFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAddAnexo = new com.hq.swingmaterialdesign.materialdesign.MButton();
        scroll = new javax.swing.JScrollPane();
        panAnexos = new javax.swing.JPanel();
        frame = new com.hq.swingmaterialdesign.materialdesign.MGradientPanel();
        imageAnexo = new com.hq.swingmaterialdesign.materialdesign.MGradientPanel();
        btnRemoveAnexo = new com.hq.swingmaterialdesign.materialdesign.MButton();

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
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePanel.setBackground(new java.awt.Color(24, 24, 24));
        sidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Mont SemiBold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ORÇAMENTO");
        sidePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 26, 230, 40));

        excludeBtn.setBackground(new java.awt.Color(24, 24, 24));
        excludeBtn.setBorder(null);
        excludeBtn.setText("Excluir");
        excludeBtn.setEndColor(new java.awt.Color(24, 24, 24));
        excludeBtn.setFont(new java.awt.Font("Mont Bold", 0, 14)); // NOI18N
        excludeBtn.setHoverEndColor(new java.awt.Color(24, 24, 24));
        excludeBtn.setHoverStartColor(new java.awt.Color(37, 46, 55));
        excludeBtn.setSelectedColor(new java.awt.Color(50, 56, 68));
        excludeBtn.setStartColor(new java.awt.Color(24, 24, 24));
        excludeBtn.setType(com.hq.swingmaterialdesign.materialdesign.MToggleButton.Type.FLAT);
        excludeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excludeBtnActionPerformed(evt);
            }
        });
        sidePanel.add(excludeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 230, 50));

        addBtn.setBackground(new java.awt.Color(24, 24, 24));
        addBtn.setBorder(null);
        addBtn.setText("Adicionar");
        addBtn.setEndColor(new java.awt.Color(24, 24, 24));
        addBtn.setFont(new java.awt.Font("Mont Bold", 0, 14)); // NOI18N
        addBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        addBtn.setHoverEndColor(new java.awt.Color(24, 24, 24));
        addBtn.setHoverStartColor(new java.awt.Color(37, 46, 55));
        addBtn.setSelectedColor(new java.awt.Color(50, 56, 68));
        addBtn.setStartColor(new java.awt.Color(24, 24, 24));
        addBtn.setType(com.hq.swingmaterialdesign.materialdesign.MToggleButton.Type.FLAT);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        sidePanel.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 230, 50));

        changeBtn.setBackground(new java.awt.Color(24, 24, 24));
        changeBtn.setBorder(null);
        changeBtn.setText("Alterar");
        changeBtn.setEndColor(new java.awt.Color(24, 24, 24));
        changeBtn.setFont(new java.awt.Font("Mont Bold", 0, 14)); // NOI18N
        changeBtn.setHoverEndColor(new java.awt.Color(24, 24, 24));
        changeBtn.setHoverStartColor(new java.awt.Color(37, 46, 55));
        changeBtn.setSelectedColor(new java.awt.Color(50, 56, 68));
        changeBtn.setStartColor(new java.awt.Color(24, 24, 24));
        changeBtn.setType(com.hq.swingmaterialdesign.materialdesign.MToggleButton.Type.FLAT);
        changeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBtnActionPerformed(evt);
            }
        });
        sidePanel.add(changeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 50));

        bg.add(sidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 580));

        cardPanel.setLayout(new java.awt.CardLayout());

        dataPanel.setBackground(new java.awt.Color(51, 51, 51));
        dataPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        warningPanelData.setBackground(new java.awt.Color(0, 153, 0));

        btnMessage.setBackground(new java.awt.Color(0, 153, 0));
        btnMessage.setText(String.valueOf(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.CLOSE));
        btnMessage.setBorderRadius(0);
        btnMessage.setFont(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.ICON_FONT.deriveFont(20f));
        btnMessage.setType(com.hq.swingmaterialdesign.materialdesign.MButton.Type.FLAT);
        btnMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageActionPerformed(evt);
            }
        });

        labelWarningData.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        labelWarningData.setForeground(new java.awt.Color(255, 255, 255));
        labelWarningData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelWarningData.setText("Cadastro efetuado com sucesso.");

        javax.swing.GroupLayout warningPanelDataLayout = new javax.swing.GroupLayout(warningPanelData);
        warningPanelData.setLayout(warningPanelDataLayout);
        warningPanelDataLayout.setHorizontalGroup(
            warningPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, warningPanelDataLayout.createSequentialGroup()
                .addComponent(labelWarningData, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        warningPanelDataLayout.setVerticalGroup(
            warningPanelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelWarningData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        dataPanel.add(warningPanelData, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 710, 40));

        searchPanel.setBackground(new java.awt.Color(24, 24, 24));

        txtPesquisa.setBackground(new java.awt.Color(24, 24, 24));
        txtPesquisa.setForeground(new java.awt.Color(240, 240, 240));
        txtPesquisa.setFont(new java.awt.Font("Nunito", 0, 18)); // NOI18N
        txtPesquisa.setLabel("Pesquisar");
        txtPesquisa.setSelectionColor(new java.awt.Color(0, 153, 153));

        mGradientButton1.setForeground(new java.awt.Color(204, 204, 204));
        mGradientButton1.setText(String.valueOf(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.SEARCH));
        mGradientButton1.setBorderRadius(58);
        mGradientButton1.setEndColor(new java.awt.Color(24, 24, 24));
        mGradientButton1.setFont(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.ICON_FONT.deriveFont(26f));
        mGradientButton1.setHoverEndColor(new java.awt.Color(24, 24, 24));
        mGradientButton1.setHoverStartColor(new java.awt.Color(24, 24, 24));
        mGradientButton1.setStartColor(new java.awt.Color(24, 24, 24));
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

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addComponent(mGradientButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mGradientButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        dataPanel.add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 710, 100));

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tablePanel.setFont(new java.awt.Font("Nunito SemiBold", 0, 14)); // NOI18N
        tablePanel.setHorizontalScrollBar(null);

        tabOrcamento.setBackground(new java.awt.Color(51, 51, 51));
        tabOrcamento.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabOrcamento.setFont(new java.awt.Font("Nunito SemiBold", 0, 14)); // NOI18N
        tabOrcamento.setForeground(new java.awt.Color(255, 255, 255));
        tabOrcamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Telefone", "Valor Estimado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabOrcamento.setGridColor(new java.awt.Color(255, 255, 255));
        tabOrcamento.setRowHeight(30);
        tabOrcamento.setSelectionBackground(new java.awt.Color(102, 102, 102));
        tabOrcamento.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablePanel.setViewportView(tabOrcamento);
        tabOrcamento.getTableHeader().setFont(new java.awt.Font("Nunito Bold", 0, 14));

        dataPanel.add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 670, 390));

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
        dataPanel.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 50, 40));

        cardPanel.add(dataPanel, "card2");

        formPanel.setBackground(new java.awt.Color(51, 51, 51));
        formPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        warningPanelForm.setBackground(new java.awt.Color(255, 51, 51));

        btnError.setBackground(new java.awt.Color(255, 51, 51));
        btnError.setBorder(null);
        btnError.setText(String.valueOf(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.CLOSE));
        btnError.setBorderRadius(0);
        btnError.setFont(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.ICON_FONT.deriveFont(20f));
        btnError.setType(com.hq.swingmaterialdesign.materialdesign.MButton.Type.FLAT);
        btnError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnErrorActionPerformed(evt);
            }
        });

        labelWarningForm.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        labelWarningForm.setForeground(new java.awt.Color(255, 255, 255));
        labelWarningForm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelWarningForm.setText("Preencha os campos corretamente.");

        javax.swing.GroupLayout warningPanelFormLayout = new javax.swing.GroupLayout(warningPanelForm);
        warningPanelForm.setLayout(warningPanelFormLayout);
        warningPanelFormLayout.setHorizontalGroup(
            warningPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, warningPanelFormLayout.createSequentialGroup()
                .addComponent(labelWarningForm, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnError, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        warningPanelFormLayout.setVerticalGroup(
            warningPanelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelWarningForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnError, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        formPanel.add(warningPanelForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 710, 40));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        mButton4.setBackground(new java.awt.Color(102, 102, 102));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        formPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, -1));

        txtCliente.setBackground(new java.awt.Color(51, 51, 51));
        txtCliente.setForeground(new java.awt.Color(240, 240, 240));
        txtCliente.setFont(new java.awt.Font("Nunito", 0, 16)); // NOI18N
        txtCliente.setLabel("Cliente");
        txtCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtClienteFocusGained(evt);
            }
        });
        txtCliente.setDocument(new LimitText(50));
        formPanel.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 410, 51));

        botCancelar.setBackground(new java.awt.Color(102, 102, 102));
        botCancelar.setBorder(null);
        botCancelar.setText("CANCELAR");
        botCancelar.setBorderRadius(50);
        botCancelar.setFont(new java.awt.Font("Mont Bold", 0, 14)); // NOI18N
        botCancelar.setType(com.hq.swingmaterialdesign.materialdesign.MButton.Type.RAISED);
        botCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botCancelarActionPerformed(evt);
            }
        });
        formPanel.add(botCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 514, 180, 50));

        botConfirmar.setBackground(new java.awt.Color(153, 153, 153));
        botConfirmar.setBorder(null);
        botConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        botConfirmar.setText("Confirmar");
        botConfirmar.setBorderRadius(50);
        botConfirmar.setFont(new java.awt.Font("Mont Bold", 0, 14)); // NOI18N
        botConfirmar.setType(com.hq.swingmaterialdesign.materialdesign.MButton.Type.RAISED);
        botConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botConfirmarActionPerformed(evt);
            }
        });
        formPanel.add(botConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 514, 180, 50));

        txtDescricao.setBackground(new java.awt.Color(51, 51, 51));
        txtDescricao.setForeground(new java.awt.Color(240, 240, 240));
        txtDescricao.setFont(new java.awt.Font("Nunito", 0, 16)); // NOI18N
        txtDescricao.setLabel("Descrição");
        txtDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescricaoFocusGained(evt);
            }
        });
        txtCliente.setDocument(new LimitText(50));
        formPanel.add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 630, 51));

        txtTelefone.setBackground(new java.awt.Color(51, 51, 51));
        txtTelefone.setForeground(new java.awt.Color(240, 240, 240));
        txtTelefone.setFont(new java.awt.Font("Nunito", 0, 16)); // NOI18N
        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setLabel("Telefone");
        txtTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefoneFocusGained(evt);
            }
        });
        formPanel.add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 200, 51));

        txtValorEstimado.setBackground(new java.awt.Color(51, 51, 51));
        txtValorEstimado.setForeground(new java.awt.Color(240, 240, 240));
        txtValorEstimado.setFont(new java.awt.Font("Nunito", 0, 16)); // NOI18N
        txtValorEstimado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtValorEstimado.setLabel("Valor Estimado");
        txtValorEstimado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorEstimadoFocusGained(evt);
            }
        });
        formPanel.add(txtValorEstimado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 250, 51));

        jLabel2.setFont(new java.awt.Font("Nunito", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Anexos");
        formPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 273, -1, 30));

        btnAddAnexo.setBackground(new java.awt.Color(51, 51, 51));
        btnAddAnexo.setBorder(null);
        btnAddAnexo.setText(String.valueOf(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.ADD_BOX));
        btnAddAnexo.setBorderRadius(0);
        btnAddAnexo.setFont(com.hq.swingmaterialdesign.materialdesign.resource.MaterialIcons.ICON_FONT.deriveFont(20f));
        btnAddAnexo.setType(com.hq.swingmaterialdesign.materialdesign.MButton.Type.FLAT);
        btnAddAnexo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddAnexoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddAnexoMouseExited(evt);
            }
        });
        btnAddAnexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAnexoActionPerformed(evt);
            }
        });
        formPanel.add(btnAddAnexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 20, 20));

        scroll.setBackground(new java.awt.Color(255, 255, 255));
        scroll.setBorder(null);
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

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
            .addComponent(btnRemoveAnexo, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
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
            .addComponent(imageAnexo, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );

        panAnexos.add(frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 170));

        scroll.setViewportView(panAnexos);

        formPanel.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 630, 190));

        cardPanel.add(formPanel, "card3");

        bg.add(cardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 710, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void excludeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excludeBtnActionPerformed
        int linha = tabOrcamento.getSelectedRow();
        if (menuSelection == 0) {

            if (linha != -1) {
                menuSelection = 3;

                Orcamento sExcluir = listaPesquisa.get(linha);
                if (sExcluir != null) {
                    int op = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o orçamento?");
                    if (op == 0) {

                        co.delete(sExcluir);
                        DefaultTableModel dtm = (DefaultTableModel) tabOrcamento.getModel();
                        dtm.removeRow(linha);
                        warningPanelData.setVisible(true);
                        warningPanelData.setBackground(new Color(0, 153, 0));
                        btnMessage.setBackground(new Color(0, 153, 0));
                        labelWarningData.setText("Excluído com sucesso!");
                        menuSelection = 0;

                    }

                }

            } else {
                warningPanelData.setVisible(true);
                warningPanelData.setBackground(new Color(255, 51, 51));
                labelWarningData.setText("Selecione um secretário.");
            }
        } else {
            if (menuSelection == 1) {
                addBtn.select();
                excludeBtn.unselect();
            } else if (menuSelection == 2) {
                changeBtn.select();
                excludeBtn.unselect();
            }
        }
    }//GEN-LAST:event_excludeBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        if (menuSelection == 0) {
            p = new Orcamento();
            selecionado = null;
            menuSelection = 1;
            dataPanel.setVisible(false);
            formPanel.setVisible(true);
            selecionado = null;
            limparCampos();
        } else {
            if (menuSelection == 2) {
                changeBtn.select();
                addBtn.unselect();
            } else if (menuSelection == 3) {
                excludeBtn.select();
                addBtn.unselect();
            }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void changeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBtnActionPerformed
        if (menuSelection == 0) {
            int linha = tabOrcamento.getSelectedRow();
            if (linha != -1) {
                menuSelection = 2;
                selecionado = listaPesquisa.get(linha);
                setOrcamento();

                dataPanel.setVisible(false);
                formPanel.setVisible(true);

            } else {
                changeBtn.unselect();
                labelWarningData.setText("Selecione um secretário.");
                warningPanelData.setVisible(true);
                warningPanelData.setBackground(new Color(255, 51, 51));
                btnMessage.setBackground(new Color(255, 51, 51));
                menuSelection = 0;
                //timer
            }
        } else {
            if (menuSelection == 1) {
                addBtn.select();
                changeBtn.unselect();
            } else if (menuSelection == 3) {
                excludeBtn.select();
                changeBtn.unselect();
            }
        }
    }//GEN-LAST:event_changeBtnActionPerformed

    private void btnMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageActionPerformed
        warningPanelData.setVisible(false);
    }//GEN-LAST:event_btnMessageActionPerformed

    private void mGradientButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mGradientButton1MouseEntered
        mGradientButton1.setForeground(Color.white);
    }//GEN-LAST:event_mGradientButton1MouseEntered

    private void mGradientButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mGradientButton1MouseExited
        mGradientButton1.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_mGradientButton1MouseExited

    private void mGradientButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mGradientButton1ActionPerformed
        atualizaTabela();
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

    private void btnErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnErrorActionPerformed
        warningPanelForm.setVisible(false);
    }//GEN-LAST:event_btnErrorActionPerformed

    private void mButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mButton4MouseEntered
        mButton4.setForeground(new java.awt.Color(50, 60, 69));
    }//GEN-LAST:event_mButton4MouseEntered

    private void mButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mButton4MouseExited
        mButton4.setForeground(new java.awt.Color(153, 153, 153));
    }//GEN-LAST:event_mButton4MouseExited

    private void mButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_mButton4ActionPerformed

    private void txtClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClienteFocusGained
        txtCliente.setForeground(new Color(240, 240, 240));
    }//GEN-LAST:event_txtClienteFocusGained

    private void botCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botCancelarActionPerformed
        warningPanelData.setVisible(false);
        warningPanelForm.setVisible(false);
        voltar();
    }//GEN-LAST:event_botCancelarActionPerformed

    private void botConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botConfirmarActionPerformed
        byte[] imageInByte = null;

        if (file != null) {
            imageInByte = new byte[(int) file.length()];
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                fis.read(imageInByte);
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(OrcamentoForm.class.getName()).log(Level.SEVERE, null, ex);
                fis = null;
            }
        }
        boolean flag = false;
        String message = "";
        boolean passerr = false;

        if (txtCliente.getText().equals("")) {
            txtCliente.setForeground(errorColor);
            flag = true;
        }
        if (txtTelefone.getText().equals("(  )      -    ")) {
            txtTelefone.setForeground(errorColor);
            flag = true;
        }

        if (txtDescricao.getText().equals("")) {
            txtDescricao.setForeground(errorColor);
            flag = true;
        }

        if (txtValorEstimado.getText().equals("")) {
            txtValorEstimado.setForeground(errorColor);
            flag = true;
        }

        this.repaint();

        if (flag) {
            message = "Preencha todos os campos corretamente.";

        }
        if (passerr) {
            message += " A senha deve ter no mínimo 4 caracteres!";

        }

        if (!flag && !passerr) {
            p.setCliente(txtCliente.getText());
            p.setDescricao(txtDescricao.getText());
            p.setTelefone(txtTelefone.getText());
            p.setValorEstimado(Double.parseDouble(txtValorEstimado.getText().replace(',', '.')));
            p.setAnexoOrcamentoCollection(listaAnexos);
            if (selecionado == null) {
                try {

                    co.persist(p);
                    message = "Cadastro efetuado com sucesso.";
                    warningPanelData.setBackground(new Color(0, 153, 0));
                    btnMessage.setBackground(new Color(0, 153, 0));
                    warningPanelData.setVisible(true);
                    limparCampos();
                    labelWarningData.setText(message);
                    warningPanelData.setVisible(true);
                    voltar();
                } catch (Exception ex) {
                    warningPanelForm.setBackground(new Color(255, 51, 51));
                    btnError.setBackground(new Color(255, 51, 51));
                    labelWarningForm.setText(message);
                    warningPanelForm.setVisible(true);

                }
            } else {
                p.setId(selecionado.getId());
                co.alter(p);
                message = "Alteração efetuada com sucesso.";
                warningPanelData.setBackground(new Color(0, 153, 0));
                btnMessage.setBackground(new Color(0, 153, 0));
                labelWarningData.setText(message);
                warningPanelData.setVisible(true);
                voltar();
            }

            //timer
            // view panel aviso, setColor aviso (danger/success) -> flag , setText(message)
        } else {

            labelWarningForm.setText(message);
            warningPanelForm.setVisible(true);
            warningPanelForm.setBackground(new Color(255, 51, 51));
            btnError.setBackground(new Color(255, 51, 51));

        }
    }//GEN-LAST:event_botConfirmarActionPerformed

    private void bgMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseDragged

        setLocation(evt.getXOnScreen() - xMouse, evt.getYOnScreen() - yMouse);
        try {
            setOpacity((float) 0.9);
        } catch (java.lang.UnsupportedOperationException e) {

        }
    }//GEN-LAST:event_bgMouseDragged

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

    private void txtDescricaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescricaoFocusGained
        txtDescricao.setForeground((new Color(240, 240, 240)));
    }//GEN-LAST:event_txtDescricaoFocusGained

    private void txtTelefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefoneFocusGained
        txtTelefone.setForeground((new Color(240, 240, 240)));
    }//GEN-LAST:event_txtTelefoneFocusGained

    private void txtValorEstimadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorEstimadoFocusGained
        txtValorEstimado.setForeground((new Color(240, 240, 240)));
    }//GEN-LAST:event_txtValorEstimadoFocusGained

    private void btnAddAnexoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddAnexoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddAnexoMouseEntered

    private void btnAddAnexoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddAnexoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddAnexoMouseExited

    private void btnAddAnexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAnexoActionPerformed
        AnexoOrcamento a = new AnexoOrcamento();

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
        }
        a.setId(listaAnexos.size() + 1);
        listaAnexos.add(a);
        atualizaAnexos();
    }//GEN-LAST:event_btnAddAnexoActionPerformed

    private void btnRemoveAnexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAnexoActionPerformed
        panAnexos.remove(btnRemoveAnexo.getParent().getParent());
        panAnexos.repaint();
    }//GEN-LAST:event_btnRemoveAnexoActionPerformed

    private void btnRemoveAnexoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveAnexoMouseExited
        btnRemoveAnexo.setVisible(false);
    }//GEN-LAST:event_btnRemoveAnexoMouseExited

    private void btnRemoveAnexoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveAnexoMouseEntered

    }//GEN-LAST:event_btnRemoveAnexoMouseEntered

    private void imageAnexoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageAnexoMouseEntered

    }//GEN-LAST:event_imageAnexoMouseEntered

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
                OrcamentoForm dialog = new OrcamentoForm(new javax.swing.JFrame(), true);
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
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton addBtn;
    private javax.swing.JPanel bg;
    private com.hq.swingmaterialdesign.materialdesign.MButton botCancelar;
    private com.hq.swingmaterialdesign.materialdesign.MButton botConfirmar;
    private com.hq.swingmaterialdesign.materialdesign.MButton btnAddAnexo;
    private com.hq.swingmaterialdesign.materialdesign.MButton btnError;
    private com.hq.swingmaterialdesign.materialdesign.MButton btnExit;
    private com.hq.swingmaterialdesign.materialdesign.MButton btnMessage;
    private com.hq.swingmaterialdesign.materialdesign.MButton btnRemoveAnexo;
    private javax.swing.JPanel cardPanel;
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton changeBtn;
    private javax.swing.JPanel dataPanel;
    private com.hq.swingmaterialdesign.materialdesign.MToggleButton excludeBtn;
    private javax.swing.JPanel formPanel;
    private com.hq.swingmaterialdesign.materialdesign.MGradientPanel frame;
    private com.hq.swingmaterialdesign.materialdesign.MGradientPanel imageAnexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelWarningData;
    private javax.swing.JLabel labelWarningForm;
    private com.hq.swingmaterialdesign.materialdesign.MButton mButton4;
    private com.hq.swingmaterialdesign.materialdesign.MGradientButton mGradientButton1;
    private javax.swing.JPanel panAnexos;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JTable tabOrcamento;
    private javax.swing.JScrollPane tablePanel;
    private com.hq.swingmaterialdesign.materialdesign.MTextField txtCliente;
    private com.hq.swingmaterialdesign.materialdesign.MTextField txtDescricao;
    private com.hq.swingmaterialdesign.materialdesign.MTextField txtPesquisa;
    private com.hq.swingmaterialdesign.materialdesign.MFormattedTextField txtTelefone;
    private com.hq.swingmaterialdesign.materialdesign.MFormattedTextField txtValorEstimado;
    private javax.swing.JPanel warningPanelData;
    private javax.swing.JPanel warningPanelForm;
    // End of variables declaration//GEN-END:variables
}
