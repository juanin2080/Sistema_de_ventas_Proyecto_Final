/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JOptionPane;

/**
 *
 * @author juana
 */
public class MenuPrincipalAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarPersonal
     */
    public MenuPrincipalAdministrador() {
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
        btnRegistrar = new newscomponents.RSButtonBigIcon_new();
        btnProveedor = new newscomponents.RSButtonBigIcon_new();
        btnProducto = new newscomponents.RSButtonBigIcon_new();
        btnCompraProveedor = new newscomponents.RSButtonBigIcon_new();
        btnRegistrarCuentas = new newscomponents.RSButtonBigIcon_new();
        btnInventario = new newscomponents.RSButtonBigIcon_new();
        btnMinimizar = new RSMaterialComponent.RSButtonIconDos();
        btnSalir = new RSMaterialComponent.RSButtonIconDos();
        rSLabelImage2 = new necesario.RSLabelImage();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        rSLabelFecha1 = new rojeru_san.rsdate.RSLabelFecha();
        jLabel23 = new javax.swing.JLabel();
        btnRegresar = new newscomponents.RSButtonIcon_new();
        rSLabelImage3 = new necesario.RSLabelImage();
        txtBienvenida = new javax.swing.JLabel();

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
        jPanel2.setLayout(null);

        rSLabelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoSistemaFinal.jpg"))); // NOI18N
        jPanel2.add(rSLabelImage4);
        rSLabelImage4.setBounds(910, 10, 230, 140);

        btnRegistrar.setBackground(new java.awt.Color(0, 153, 102));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBgHover(new java.awt.Color(102, 102, 102));
        btnRegistrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERSON_ADD);
        btnRegistrar.setSizeIcon(50.0F);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrar);
        btnRegistrar.setBounds(20, 20, 120, 110);

        btnProveedor.setBackground(new java.awt.Color(0, 153, 102));
        btnProveedor.setText("Proveedor");
        btnProveedor.setBgHover(new java.awt.Color(102, 102, 102));
        btnProveedor.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERSON);
        btnProveedor.setSizeIcon(50.0F);
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });
        jPanel2.add(btnProveedor);
        btnProveedor.setBounds(150, 20, 120, 110);

        btnProducto.setBackground(new java.awt.Color(0, 153, 102));
        btnProducto.setText("Producto");
        btnProducto.setBgHover(new java.awt.Color(102, 102, 102));
        btnProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SHOPPING_BASKET);
        btnProducto.setSizeIcon(50.0F);
        btnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoActionPerformed(evt);
            }
        });
        jPanel2.add(btnProducto);
        btnProducto.setBounds(410, 20, 130, 110);

        btnCompraProveedor.setBackground(new java.awt.Color(0, 153, 102));
        btnCompraProveedor.setText("Compra ");
        btnCompraProveedor.setBgHover(new java.awt.Color(102, 102, 102));
        btnCompraProveedor.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SHOPPING_CART);
        btnCompraProveedor.setSizeIcon(50.0F);
        btnCompraProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraProveedorActionPerformed(evt);
            }
        });
        jPanel2.add(btnCompraProveedor);
        btnCompraProveedor.setBounds(280, 20, 120, 110);

        btnRegistrarCuentas.setBackground(new java.awt.Color(0, 153, 102));
        btnRegistrarCuentas.setText("Cuenta");
        btnRegistrarCuentas.setBgHover(new java.awt.Color(102, 102, 102));
        btnRegistrarCuentas.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PEOPLE);
        btnRegistrarCuentas.setSizeIcon(50.0F);
        btnRegistrarCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCuentasActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrarCuentas);
        btnRegistrarCuentas.setBounds(550, 20, 130, 110);

        btnInventario.setBackground(new java.awt.Color(0, 153, 102));
        btnInventario.setText("Inventario");
        btnInventario.setBgHover(new java.awt.Color(102, 102, 102));
        btnInventario.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CONTENT_PASTE);
        btnInventario.setSizeIcon(50.0F);
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        jPanel2.add(btnInventario);
        btnInventario.setBounds(690, 20, 130, 110);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 50, 1160, 160);

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

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoSistemaFinal.jpg"))); // NOI18N
        jPanel1.add(rSLabelImage2);
        rSLabelImage2.setBounds(140, 300, 790, 340);

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

        rSLabelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoSistemaFinal.jpg"))); // NOI18N
        jPanel1.add(rSLabelImage3);
        rSLabelImage3.setBounds(10, 10, 50, 40);

        txtBienvenida.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        txtBienvenida.setForeground(new java.awt.Color(51, 51, 51));
        txtBienvenida.setText("Hola, NombreAdmin escoge una opción de nuestro menú");
        jPanel1.add(txtBienvenida);
        txtBienvenida.setBounds(10, 220, 500, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1159, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FiveCodMover.FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FiveCodMover.FiveCodMoverJFrame.MouseDraggedFrame(evt, this);
    }//GEN-LAST:event_formMouseDragged

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed
    
    private void txtRucMouseClicked(java.awt.event.MouseEvent evt) {
        
    }
    
    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        InicioSesion inicioSesion = new InicioSesion();
        this.dispose();
        inicioSesion.setVisible(true);
        inicioSesion.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegresarActionPerformed
    

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        AdministrarPersonas adminPersonas = new AdministrarPersonas();
        this.dispose();
        adminPersonas.setVisible(true);
        adminPersonas.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        AdministrarProducto adminProducto = new AdministrarProducto();
        this.dispose();
        adminProducto.setVisible(true);
        adminProducto.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnProductoActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        AdministrarProveedor adminProveedor = new AdministrarProveedor();
        this.dispose();
        adminProveedor.setVisible(true);
        adminProveedor.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnCompraProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraProveedorActionPerformed
        CompraProveedor cp = new CompraProveedor();
        this.dispose();
        cp.setVisible(true);
        cp.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCompraProveedorActionPerformed

    private void btnRegistrarCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCuentasActionPerformed
        AdministrarCuentas ac = new AdministrarCuentas();
        this.dispose();
        ac.setVisible(true);
        ac.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegistrarCuentasActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        Inventario inv = new Inventario();
        this.dispose();
        inv.setVisible(true);
        inv.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnInventarioActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new MenuPrincipalAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonBigIcon_new btnCompraProveedor;
    private newscomponents.RSButtonBigIcon_new btnInventario;
    private RSMaterialComponent.RSButtonIconDos btnMinimizar;
    private newscomponents.RSButtonBigIcon_new btnProducto;
    private newscomponents.RSButtonBigIcon_new btnProveedor;
    private newscomponents.RSButtonBigIcon_new btnRegistrar;
    private newscomponents.RSButtonBigIcon_new btnRegistrarCuentas;
    private newscomponents.RSButtonIcon_new btnRegresar;
    private RSMaterialComponent.RSButtonIconDos btnSalir;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojeru_san.rsdate.RSLabelFecha rSLabelFecha1;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private necesario.RSLabelImage rSLabelImage2;
    private necesario.RSLabelImage rSLabelImage3;
    private necesario.RSLabelImage rSLabelImage4;
    private javax.swing.JLabel txtBienvenida;
    // End of variables declaration//GEN-END:variables
}
