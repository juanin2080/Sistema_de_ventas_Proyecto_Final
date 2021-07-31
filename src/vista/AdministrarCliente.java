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
public class AdministrarCliente extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarPersonal
     */
    public AdministrarCliente() {
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
        txtCedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
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
        jLabel22 = new javax.swing.JLabel();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        rSLabelFecha1 = new rojeru_san.rsdate.RSLabelFecha();
        jLabel23 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnRegresar = new newscomponents.RSButtonIcon_new();

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

        lblNombreVendedor.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        lblNombreVendedor.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreVendedor.setText("NombreVendedor.");
        jPanel2.add(lblNombreVendedor);
        lblNombreVendedor.setBounds(120, 70, 320, 40);

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hola,");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 70, 90, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 50, 1160, 160);

        txtCedula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCedula.setForeground(new java.awt.Color(102, 102, 102));
        txtCedula.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCedulaMouseClicked(evt);
            }
        });
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        jPanel1.add(txtCedula);
        txtCedula.setBounds(140, 310, 220, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Cédula:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 310, 80, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Nombres:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 350, 80, 30);

        txtNombres.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombres.setForeground(new java.awt.Color(102, 102, 102));
        txtNombres.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtNombres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombresMouseClicked(evt);
            }
        });
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombres);
        txtNombres.setBounds(140, 350, 220, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Dirección:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 510, 80, 30);

        txtDireccion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(102, 102, 102));
        txtDireccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDireccionMouseClicked(evt);
            }
        });
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDireccion);
        txtDireccion.setBounds(140, 510, 220, 30);

        txtApellidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtApellidos.setForeground(new java.awt.Color(102, 102, 102));
        txtApellidos.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtApellidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtApellidosMouseClicked(evt);
            }
        });
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellidos);
        txtApellidos.setBounds(140, 390, 220, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Apellidos:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 390, 80, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Email:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 430, 80, 30);

        txtEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(102, 102, 102));
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailMouseClicked(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail);
        txtEmail.setBounds(140, 430, 220, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Teléfono:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 470, 80, 30);

        txtTelefono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(102, 102, 102));
        txtTelefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelefonoMouseClicked(evt);
            }
        });
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefono);
        txtTelefono.setBounds(140, 470, 220, 30);

        tbtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombres", "Apellidos", "Email", "Teléfono", "Dirección", "Usuario", "Rol"
            }
        ));
        tbtClientes.setBackgoundHead(new java.awt.Color(102, 0, 102));
        jScrollPane1.setViewportView(tbtClientes);
        if (tbtClientes.getColumnModel().getColumnCount() > 0) {
            tbtClientes.getColumnModel().getColumn(6).setHeaderValue("Usuario");
            tbtClientes.getColumnModel().getColumn(7).setHeaderValue("Rol");
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(402, 240, 750, 310);

        btnGuardar.setBackground(new java.awt.Color(0, 204, 51));
        btnGuardar.setText("Guardar");
        btnGuardar.setColorHover(new java.awt.Color(102, 102, 102));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
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
        btnActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarDatos);
        btnActualizarDatos.setBounds(870, 570, 180, 30);

        labelIcon7.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon7.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        jPanel1.add(labelIcon7);
        labelIcon7.setBounds(560, 620, 30, 30);

        btnDarDeBaja.setBackground(new java.awt.Color(255, 0, 0));
        btnDarDeBaja.setText("Dar de baja");
        btnDarDeBaja.setColorHover(new java.awt.Color(102, 102, 102));
        btnDarDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarDeBajaActionPerformed(evt);
            }
        });
        jPanel1.add(btnDarDeBaja);
        btnDarDeBaja.setBounds(600, 620, 130, 30);

        btnNuevoCliente.setBackground(new java.awt.Color(0, 102, 51));
        btnNuevoCliente.setText("Nuevo cliente");
        btnNuevoCliente.setColorHover(new java.awt.Color(102, 102, 102));
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });
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

        jLabel22.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Electrocasa le da la bienvenida a nuestra familia.");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(50, 80, 570, 70);

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Registre un cliente.");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 220, 370, 50);

        btnRegresar.setBackground(new java.awt.Color(0, 204, 51));
        btnRegresar.setText("Regresar");
        btnRegresar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REPLAY);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar);
        btnRegresar.setBounds(270, 10, 120, 30);

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

    private void txtCedulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCedulaMouseClicked

    }//GEN-LAST:event_txtCedulaMouseClicked

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtNombresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombresMouseClicked

    }//GEN-LAST:event_txtNombresMouseClicked

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMouseClicked

    }//GEN-LAST:event_txtDireccionMouseClicked

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtApellidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidosMouseClicked

    }//GEN-LAST:event_txtApellidosMouseClicked

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseClicked

    }//GEN-LAST:event_txtEmailMouseClicked

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMouseClicked

    }//GEN-LAST:event_txtTelefonoMouseClicked

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarDatosActionPerformed

    private void btnDarDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarDeBajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDarDeBajaActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        AdministrarVentas registroVentas = new AdministrarVentas();
        this.dispose();
        registroVentas.setVisible(true);
        registroVentas.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnVentasActionPerformed

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
            java.util.logging.Logger.getLogger(AdministrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new AdministrarCliente().setVisible(true);
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
    private newscomponents.RSButtonIcon_new btnRegresar;
    private RSMaterialComponent.RSButtonIconDos btnSalir;
    private newscomponents.RSButtonBigIcon_new btnVentas;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
