/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;



/**
 *
 * @author USUARIO
 */
public class Configuracion extends javax.swing.JFrame {

    /**
     * Creates new form Configuración
     */
    public Configuracion() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSLabelImage1 = new rojeru_san.rslabel.RSLabelImage();
        jLabel1 = new javax.swing.JLabel();
        rSLabelFecha = new rojeru_san.rsdate.RSLabelFecha();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        jPanel2 = new javax.swing.JPanel();
        btnProvedorC = new newscomponents.RSButtonBigIcon_new();
        BtnProductosC = new newscomponents.RSButtonBigIcon_new();
        BtnRVentasC = new newscomponents.RSButtonBigIcon_new();
        BtnConfiguracionC = new newscomponents.RSButtonBigIcon_new();
        rSLabelImage2 = new rojeru_san.rslabel.RSLabelImage();
        jLabel2 = new javax.swing.JLabel();
        jLblRuc = new javax.swing.JLabel();
        jLblTelef = new javax.swing.JLabel();
        jLblLema = new javax.swing.JLabel();
        jLblNombre = new javax.swing.JLabel();
        jLblDireccion = new javax.swing.JLabel();
        txtRucC = new javax.swing.JTextField();
        txtTelfC = new javax.swing.JTextField();
        txtNombreC = new javax.swing.JTextField();
        txtDireccionC = new javax.swing.JTextField();
        txtLemaC = new javax.swing.JTextField();
        btnMinimizarConfig = new RSMaterialComponent.RSButtonIconDos();
        btnActualizarC = new RSMaterialComponent.RSButtonMaterialRipple();
        labelIcon1 = new necesario.LabelIcon();
        btnSalirConfig = new RSMaterialComponent.RSButtonIconDos();
        btnRegresarC = new newscomponents.RSButtonIcon_new();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoSistemaFinal.jpg"))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("ELECTROCASA");

        rSLabelFecha.setForeground(new java.awt.Color(102, 102, 102));

        rSLabelHora1.setForeground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));

        btnProvedorC.setBackground(new java.awt.Color(0, 153, 102));
        btnProvedorC.setText("Proveedor");
        btnProvedorC.setBgHover(new java.awt.Color(102, 102, 102));
        btnProvedorC.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERSON);
        btnProvedorC.setSizeIcon(50.0F);
        btnProvedorC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProvedorCMouseClicked(evt);
            }
        });
        btnProvedorC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProvedorCActionPerformed(evt);
            }
        });

        BtnProductosC.setBackground(new java.awt.Color(0, 153, 102));
        BtnProductosC.setText("Productos");
        BtnProductosC.setBgHover(new java.awt.Color(102, 102, 102));
        BtnProductosC.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SHOP);
        BtnProductosC.setSizeIcon(50.0F);
        BtnProductosC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnProductosCMouseClicked(evt);
            }
        });
        BtnProductosC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProductosCActionPerformed(evt);
            }
        });

        BtnRVentasC.setBackground(new java.awt.Color(0, 153, 102));
        BtnRVentasC.setText("RegistroVentas");
        BtnRVentasC.setBgHover(new java.awt.Color(102, 102, 102));
        BtnRVentasC.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.RECEIPT);
        BtnRVentasC.setSizeIcon(50.0F);
        BtnRVentasC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnRVentasCMouseClicked(evt);
            }
        });
        BtnRVentasC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRVentasCActionPerformed(evt);
            }
        });

        BtnConfiguracionC.setBackground(new java.awt.Color(0, 153, 102));
        BtnConfiguracionC.setText("Configuración");
        BtnConfiguracionC.setToolTipText("");
        BtnConfiguracionC.setBgHover(new java.awt.Color(102, 102, 102));
        BtnConfiguracionC.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SETTINGS);
        BtnConfiguracionC.setSizeIcon(50.0F);
        BtnConfiguracionC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfiguracionCActionPerformed(evt);
            }
        });

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoSistemaFinal.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(btnProvedorC, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnProductosC, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnRVentasC, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnConfiguracionC, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnProvedorC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addComponent(BtnProductosC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(BtnRVentasC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(BtnConfiguracionC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel2.setText("DATOS DE LA TIENDA");

        jLblRuc.setText("RUC:");

        jLblTelef.setText("TELEFONO:");

        jLblLema.setText("LEMA:");

        jLblNombre.setText("NOMBRE:");

        jLblDireccion.setText("DIRECCIÓN:");

        txtRucC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucCActionPerformed(evt);
            }
        });

        btnMinimizarConfig.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimizarConfig.setForeground(new java.awt.Color(102, 102, 102));
        btnMinimizarConfig.setBackgroundHover(new java.awt.Color(0, 102, 204));
        btnMinimizarConfig.setForegroundHover(new java.awt.Color(102, 102, 102));
        btnMinimizarConfig.setForegroundText(new java.awt.Color(102, 102, 102));
        btnMinimizarConfig.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REMOVE);
        btnMinimizarConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarConfigActionPerformed(evt);
            }
        });

        btnActualizarC.setBackground(new java.awt.Color(0, 204, 51));
        btnActualizarC.setText("Actualizar");
        btnActualizarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCActionPerformed(evt);
            }
        });

        labelIcon1.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ROTATE_LEFT);
        labelIcon1.setInheritsPopupMenu(true);

        btnSalirConfig.setBackground(new java.awt.Color(255, 255, 255));
        btnSalirConfig.setForeground(new java.awt.Color(102, 102, 102));
        btnSalirConfig.setBackgroundHover(new java.awt.Color(255, 0, 0));
        btnSalirConfig.setForegroundHover(new java.awt.Color(102, 102, 102));
        btnSalirConfig.setForegroundText(new java.awt.Color(102, 102, 102));
        btnSalirConfig.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalirConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirConfigActionPerformed(evt);
            }
        });

        btnRegresarC.setBackground(new java.awt.Color(0, 204, 51));
        btnRegresarC.setText("Regresar");
        btnRegresarC.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REPLAY);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel1)
                    .addGap(43, 43, 43)
                    .addComponent(btnRegresarC, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37)
                    .addComponent(rSLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMinimizarConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnSalirConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(229, 229, 229))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLblRuc)
                                            .addGap(56, 56, 56))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLblTelef)
                                            .addGap(25, 25, 25)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLblLema)
                                        .addGap(51, 51, 51)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtLemaC, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtRucC, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTelfC, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(76, 76, 76)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLblNombre)
                                    .addComponent(jLblDireccion))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(labelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnActualizarC, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(108, 108, 108))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSalirConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMinimizarConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rSLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(btnRegresarC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLemaC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLblRuc)
                                    .addComponent(jLblNombre)
                                    .addComponent(txtRucC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLblTelef)
                                    .addComponent(jLblDireccion)
                                    .addComponent(txtTelfC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addComponent(jLblLema)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(btnActualizarC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRucCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucCActionPerformed

    private void btnMinimizarConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarConfigActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarConfigActionPerformed

    private void btnSalirConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirConfigActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirConfigActionPerformed

    private void BtnRVentasCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnRVentasCMouseClicked

        // TODO add your handling code here:
    
    }//GEN-LAST:event_BtnRVentasCMouseClicked

    private void btnProvedorCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProvedorCMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnProvedorCMouseClicked

    private void BtnProductosCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnProductosCMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_BtnProductosCMouseClicked

    private void btnActualizarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarCActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        FiveCodMover.FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        FiveCodMover.FiveCodMoverJFrame.MouseDraggedFrame(evt,this);
    }//GEN-LAST:event_formMouseDragged

    private void btnProvedorCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProvedorCActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnProvedorCActionPerformed

    private void BtnProductosCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProductosCActionPerformed
     
    }//GEN-LAST:event_BtnProductosCActionPerformed

    private void BtnRVentasCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRVentasCActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_BtnRVentasCActionPerformed

    private void BtnConfiguracionCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfiguracionCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnConfiguracionCActionPerformed

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
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonBigIcon_new BtnConfiguracionC;
    private newscomponents.RSButtonBigIcon_new BtnProductosC;
    private newscomponents.RSButtonBigIcon_new BtnRVentasC;
    private RSMaterialComponent.RSButtonMaterialRipple btnActualizarC;
    private RSMaterialComponent.RSButtonIconDos btnMinimizarConfig;
    private newscomponents.RSButtonBigIcon_new btnProvedorC;
    private newscomponents.RSButtonIcon_new btnRegresarC;
    private RSMaterialComponent.RSButtonIconDos btnSalirConfig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLblDireccion;
    private javax.swing.JLabel jLblLema;
    private javax.swing.JLabel jLblNombre;
    private javax.swing.JLabel jLblRuc;
    private javax.swing.JLabel jLblTelef;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private necesario.LabelIcon labelIcon1;
    private rojeru_san.rsdate.RSLabelFecha rSLabelFecha;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private rojeru_san.rslabel.RSLabelImage rSLabelImage1;
    private rojeru_san.rslabel.RSLabelImage rSLabelImage2;
    private javax.swing.JTextField txtDireccionC;
    private javax.swing.JTextField txtLemaC;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtRucC;
    private javax.swing.JTextField txtTelfC;
    // End of variables declaration//GEN-END:variables
}
