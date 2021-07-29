/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import vista.AdministrarVentas;

/**
 *
 * @author juana
 */
public class RealizarVenta extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarPersonal
     */
    public RealizarVenta() {
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
        jPanel2 = new javax.swing.JPanel();
        rSLabelImage4 = new necesario.RSLabelImage();
        btnVentas = new newscomponents.RSButtonBigIcon_new();
        btnClientes = new newscomponents.RSButtonBigIcon_new();
        lblNombreVendedor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnProductos = new RSMaterialComponent.RSButtonCustomIcon();
        txtCodigoVenta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCedulaCliente = new javax.swing.JTextField();
        txtFechaVenta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtClientes = new RSMaterialComponent.RSTableMetro();
        btnGuardar = new rojerusan.RSButtonHover();
        labelIcon5 = new necesario.LabelIcon();
        labelIcon6 = new necesario.LabelIcon();
        btnActualizarDatos = new rojerusan.RSButtonHover();
        labelIcon7 = new necesario.LabelIcon();
        btnDarDeBaja = new rojerusan.RSButtonHover();
        btnNuevoCliente = new rojerusan.RSButtonHover();
        btnMinimizar = new RSMaterialComponent.RSButtonIconDos();
        btnSalir = new RSMaterialComponent.RSButtonIconDos();
        labelIcon10 = new necesario.LabelIcon();
        rSLabelImage2 = new necesario.RSLabelImage();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        rSLabelFecha1 = new rojeru_san.rsdate.RSLabelFecha();
        jLabel23 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxRol = new RSMaterialComponent.RSComboBoxMaterial();
        cbxRol1 = new RSMaterialComponent.RSComboBoxMaterial();
        cbxRol2 = new RSMaterialComponent.RSComboBoxMaterial();

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
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);
        jPanel2.setLayout(null);

        rSLabelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoSistemaFinal.jpg"))); // NOI18N
        jPanel2.add(rSLabelImage4);
        rSLabelImage4.setBounds(910, 10, 230, 140);

        btnVentas.setBackground(new java.awt.Color(0, 153, 102));
        btnVentas.setText("Ventas");
        btnVentas.setBgHover(new java.awt.Color(102, 102, 102));
        btnVentas.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MONETIZATION_ON);
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        jPanel2.add(btnVentas);
        btnVentas.setBounds(720, 20, 130, 130);

        btnClientes.setBackground(new java.awt.Color(0, 153, 102));
        btnClientes.setText("Clientes");
        btnClientes.setBgHover(new java.awt.Color(102, 102, 102));
        btnClientes.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CONTACTS);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        jPanel2.add(btnClientes);
        btnClientes.setBounds(510, 20, 130, 130);

        lblNombreVendedor.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        lblNombreVendedor.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreVendedor.setText("nombreVendedor, Apellido ");
        jPanel2.add(lblNombreVendedor);
        lblNombreVendedor.setBounds(120, 70, 320, 40);

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hola,");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(70, 70, 90, 40);

        btnProductos.setText("Productos");
        btnProductos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STORE);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        jPanel2.add(btnProductos);
        btnProductos.setBounds(20, 120, 200, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 50, 1160, 160);

        txtCodigoVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCodigoVenta.setForeground(new java.awt.Color(102, 102, 102));
        txtCodigoVenta.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtCodigoVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCodigoVentaMouseClicked(evt);
            }
        });
        txtCodigoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoVentaActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigoVenta);
        txtCodigoVenta.setBounds(140, 310, 220, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setText("LISTA DE PRODUCTOS");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(410, 210, 140, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Forma de pago");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 470, 100, 30);

        txtCedulaCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCedulaCliente.setForeground(new java.awt.Color(102, 102, 102));
        txtCedulaCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtCedulaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCedulaClienteMouseClicked(evt);
            }
        });
        txtCedulaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaClienteActionPerformed(evt);
            }
        });
        jPanel1.add(txtCedulaCliente);
        txtCedulaCliente.setBounds(140, 350, 220, 30);

        txtFechaVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFechaVenta.setForeground(new java.awt.Color(102, 102, 102));
        txtFechaVenta.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtFechaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFechaVentaMouseClicked(evt);
            }
        });
        txtFechaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaVentaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaVenta);
        txtFechaVenta.setBounds(140, 430, 220, 30);

        tbtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Cedula del cliente", "vendedor", "Fecha", "Forma de pago", "Proveedor"
            }
        ));
        tbtClientes.setBackgoundHead(new java.awt.Color(102, 0, 102));
        jScrollPane1.setViewportView(tbtClientes);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(400, 250, 720, 310);

        btnGuardar.setBackground(new java.awt.Color(0, 204, 51));
        btnGuardar.setText("Guardar");
        btnGuardar.setColorHover(new java.awt.Color(102, 102, 102));
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(600, 570, 130, 30);

        labelIcon5.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        jPanel1.add(labelIcon5);
        labelIcon5.setBounds(560, 570, 30, 30);

        labelIcon6.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon6.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);
        jPanel1.add(labelIcon6);
        labelIcon6.setBounds(830, 570, 30, 30);

        btnActualizarDatos.setBackground(new java.awt.Color(0, 102, 204));
        btnActualizarDatos.setText("Actualizar datos");
        btnActualizarDatos.setColorHover(new java.awt.Color(102, 102, 102));
        jPanel1.add(btnActualizarDatos);
        btnActualizarDatos.setBounds(870, 570, 180, 30);

        labelIcon7.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon7.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        jPanel1.add(labelIcon7);
        labelIcon7.setBounds(560, 620, 30, 30);

        btnDarDeBaja.setBackground(new java.awt.Color(255, 0, 0));
        btnDarDeBaja.setText("Dar de baja");
        btnDarDeBaja.setColorHover(new java.awt.Color(102, 102, 102));
        jPanel1.add(btnDarDeBaja);
        btnDarDeBaja.setBounds(600, 620, 130, 30);

        btnNuevoCliente.setBackground(new java.awt.Color(0, 102, 51));
        btnNuevoCliente.setText("Nuevo cliente");
        btnNuevoCliente.setColorHover(new java.awt.Color(102, 102, 102));
        jPanel1.add(btnNuevoCliente);
        btnNuevoCliente.setBounds(870, 620, 180, 30);

        btnMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimizar.setForeground(new java.awt.Color(102, 102, 102));
        btnMinimizar.setBackgroundHover(new java.awt.Color(0, 102, 204));
        btnMinimizar.setForegroundHover(new java.awt.Color(102, 102, 102));
        btnMinimizar.setForegroundText(new java.awt.Color(102, 102, 102));
        btnMinimizar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REMOVE);
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnMinimizar);
        btnMinimizar.setBounds(1070, 10, 40, 40);

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setForeground(new java.awt.Color(102, 102, 102));
        btnSalir.setBackgroundHover(new java.awt.Color(255, 0, 0));
        btnSalir.setForegroundHover(new java.awt.Color(102, 102, 102));
        btnSalir.setForegroundText(new java.awt.Color(102, 102, 102));
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir);
        btnSalir.setBounds(1110, 10, 40, 40);

        labelIcon10.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon10.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        jPanel1.add(labelIcon10);
        labelIcon10.setBounds(830, 620, 30, 30);

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoSistemaFinal.jpg"))); // NOI18N
        jPanel1.add(rSLabelImage2);
        rSLabelImage2.setBounds(10, 10, 50, 40);

        rSLabelHora1.setForeground(new java.awt.Color(102, 102, 102));
        rSLabelHora1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(rSLabelHora1);
        rSLabelHora1.setBounds(830, 10, 200, 40);

        rSLabelFecha1.setForeground(new java.awt.Color(102, 102, 102));
        rSLabelFecha1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(rSLabelFecha1);
        rSLabelFecha1.setBounds(640, 10, 200, 40);

        jLabel23.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("ELECTROCASA");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(70, 10, 190, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Registrar una nueva venta");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 220, 490, 50);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Cedula del cliente:");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(20, 350, 100, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Vendedor:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 390, 100, 30);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Proveedor:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(20, 520, 100, 30);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Fecha:");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(20, 440, 100, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Código:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 310, 80, 30);

        cbxRol.setForeground(new java.awt.Color(102, 102, 102));
        cbxRol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Efectivo", "Tarjeta de credito" }));
        cbxRol.setColorMaterial(new java.awt.Color(102, 102, 102));
        cbxRol.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(cbxRol);
        cbxRol.setBounds(140, 470, 220, 40);

        cbxRol1.setForeground(new java.awt.Color(102, 102, 102));
        cbxRol1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jose Gomez", " " }));
        cbxRol1.setColorMaterial(new java.awt.Color(102, 102, 102));
        cbxRol1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(cbxRol1);
        cbxRol1.setBounds(140, 520, 220, 40);

        cbxRol2.setForeground(new java.awt.Color(102, 102, 102));
        cbxRol2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jose Perez", "Ana Suarez" }));
        cbxRol2.setColorMaterial(new java.awt.Color(102, 102, 102));
        cbxRol2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(cbxRol2);
        cbxRol2.setBounds(140, 390, 220, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1159, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FiveCodMover.FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FiveCodMover.FiveCodMoverJFrame.MouseDraggedFrame(evt, this);
    }//GEN-LAST:event_formMouseDragged

    private void txtCodigoVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodigoVentaMouseClicked

    }//GEN-LAST:event_txtCodigoVentaMouseClicked

    private void txtCodigoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoVentaActionPerformed

    private void txtCedulaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCedulaClienteMouseClicked

    }//GEN-LAST:event_txtCedulaClienteMouseClicked

    private void txtCedulaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaClienteActionPerformed

    private void txtFechaVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaVentaMouseClicked

    }//GEN-LAST:event_txtFechaVentaMouseClicked

    private void txtFechaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaVentaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void txtUsuario7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuario7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuario7MouseClicked

    private void txtUsuario6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuario6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuario6ActionPerformed

    private void txtUsuario6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuario6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuario6MouseClicked

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        RealizarVenta ventas = new RealizarVenta();
        this.dispose();
        ventas.setVisible(true);
        ventas.setLocationRelativeTo(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        AdministrarCliente cliente = new AdministrarCliente();
        dispose();
        cliente.setVisible(true);
        cliente.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {
        AdministrarProducto productos = new AdministrarProducto();
        dispose();
        productos.setVisible(true);
        productos.setLocationRelativeTo(null);
        // TODO add your handling code here:
    }

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
            java.util.logging.Logger.getLogger(RealizarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover btnActualizarDatos;
    private newscomponents.RSButtonBigIcon_new btnClientes;
    private rojerusan.RSButtonHover btnDarDeBaja;
    private rojerusan.RSButtonHover btnGuardar;
    private RSMaterialComponent.RSButtonIconDos btnMinimizar;
    private rojerusan.RSButtonHover btnNuevoCliente;
    private RSMaterialComponent.RSButtonCustomIcon btnProductos;
    private RSMaterialComponent.RSButtonIconDos btnSalir;
    private newscomponents.RSButtonBigIcon_new btnVentas;
    private RSMaterialComponent.RSComboBoxMaterial cbxRol;
    private RSMaterialComponent.RSComboBoxMaterial cbxRol1;
    private RSMaterialComponent.RSComboBoxMaterial cbxRol2;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private necesario.LabelIcon labelIcon10;
    private necesario.LabelIcon labelIcon5;
    private necesario.LabelIcon labelIcon6;
    private necesario.LabelIcon labelIcon7;
    private javax.swing.JLabel lblNombreVendedor;
    private rojeru_san.rsdate.RSLabelFecha rSLabelFecha1;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private necesario.RSLabelImage rSLabelImage2;
    private necesario.RSLabelImage rSLabelImage4;
    private RSMaterialComponent.RSTableMetro tbtClientes;
    private javax.swing.JTextField txtCedulaCliente;
    private javax.swing.JTextField txtCodigoVenta;
    private javax.swing.JTextField txtFechaVenta;
    // End of variables declaration//GEN-END:variables
}
