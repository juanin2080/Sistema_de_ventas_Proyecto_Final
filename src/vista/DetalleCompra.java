/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.DAO.DetalleCompraDAO;
import controlador.utilidades.Controladores;
import java.util.ArrayList;
import java.util.Date;
import modelo.Compra;

/**
 *
 * @author USUARIO
 */
public class DetalleCompra extends javax.swing.JFrame {

    /**
     * Creates new form DetalleCompra
     */
    private DetalleCompraDAO cDAO = new DetalleCompraDAO();
    ArrayList<Compra> listadetalle = new ArrayList<Compra>();
    Date fecha = new Date();
    Compra compra = new Compra();
    Controladores controles = new Controladores();

    public DetalleCompra() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void mostrarTabla() {
        cDAO.listarDetalleCompra(tblDetalleCompra);

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
        btnConfiguración = new newscomponents.RSButtonBigIcon_new();
        btnMinimizar = new RSMaterialComponent.RSButtonIconDos();
        btnSalir = new RSMaterialComponent.RSButtonIconDos();
        rSLabelImage2 = new necesario.RSLabelImage();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        jLabel23 = new javax.swing.JLabel();
        btnRegresar = new RSMaterialComponent.RSButtonCustomIcon();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        rSLabelImage1 = new rojeru_san.rslabel.RSLabelImage();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleCompra = new RSMaterialComponent.RSTableMetro();
        btnMostrar = new rojerusan.RSButtonHover();
        rSLabelFecha2 = new rojeru_san.rsdate.RSLabelFecha();

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
        rSLabelImage4.setBounds(870, 10, 160, 90);

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
        btnRegistrar.setBounds(140, 10, 140, 90);

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
        btnProveedor.setBounds(310, 10, 140, 90);

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
        btnProducto.setBounds(490, 10, 150, 90);

        btnConfiguración.setBackground(new java.awt.Color(0, 153, 102));
        btnConfiguración.setText("Configuración");
        btnConfiguración.setBgHover(new java.awt.Color(102, 102, 102));
        btnConfiguración.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SETTINGS);
        btnConfiguración.setSizeIcon(50.0F);
        btnConfiguración.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguraciónActionPerformed(evt);
            }
        });
        jPanel2.add(btnConfiguración);
        btnConfiguración.setBounds(690, 10, 140, 90);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 50, 1040, 110);

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
        btnMinimizar.setBounds(960, 10, 40, 40);

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
        btnSalir.setBounds(1000, 10, 40, 40);

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoSistemaFinal.jpg"))); // NOI18N
        jPanel1.add(rSLabelImage2);
        rSLabelImage2.setBounds(10, 10, 50, 40);

        rSLabelHora1.setForeground(new java.awt.Color(102, 102, 102));
        rSLabelHora1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(rSLabelHora1);
        rSLabelHora1.setBounds(720, 10, 200, 40);

        jLabel23.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("ELECTROCASA");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(70, 10, 190, 30);

        btnRegresar.setBackground(new java.awt.Color(0, 204, 51));
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setColorIcon(new java.awt.Color(255, 255, 255));
        btnRegresar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REPLAY);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar);
        btnRegresar.setBounds(260, 10, 140, 30);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoSistemaFinal.jpg"))); // NOI18N

        jLabel3.setText("Telf: 0939258198");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("ELECTROCASA");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("RUC:1198367544001");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Direccion: Loja, Ecuador");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(335, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(234, 234, 234))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201, 201, 201)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addContainerGap())
        );

        tblDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDetalleCompra.setBackgoundHead(new java.awt.Color(102, 0, 102));
        jScrollPane1.setViewportView(tblDetalleCompra);

        btnMostrar.setBackground(new java.awt.Color(204, 0, 255));
        btnMostrar.setText("Mostrar");
        btnMostrar.setColorHover(new java.awt.Color(102, 102, 102));
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(321, 321, 321))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(110, 170, 850, 460);

        rSLabelFecha2.setForeground(new java.awt.Color(102, 102, 102));
        rSLabelFecha2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(rSLabelFecha2);
        rSLabelFecha2.setBounds(570, 10, 200, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        FiveCodMover.FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        FiveCodMover.FiveCodMoverJFrame.MouseDraggedFrame(evt, this);
    }//GEN-LAST:event_formMouseDragged

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        AdministrarPersonas adminPersonas = new AdministrarPersonas();
        this.dispose();
        adminPersonas.setVisible(true);
        adminPersonas.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        AdministrarProveedor adminProveedor = new AdministrarProveedor();
        this.dispose();
        adminProveedor.setVisible(true);
        adminProveedor.setLocationRelativeTo(null);


    }//GEN-LAST:event_btnProveedorActionPerformed

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        AdministrarProducto adminProducto = new AdministrarProducto();
        this.dispose();
        adminProducto.setVisible(true);
        adminProducto.setLocationRelativeTo(null);


    }//GEN-LAST:event_btnProductoActionPerformed

    private void btnConfiguraciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguraciónActionPerformed
        // TODO add your handling code here:
        Configuracion conf = new Configuracion();
        this.dispose();
        conf.setVisible(true);
        conf.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnConfiguraciónActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        cDAO.listarDetalleCompra(tblDetalleCompra);

    }//GEN-LAST:event_btnMostrarActionPerformed

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
            java.util.logging.Logger.getLogger(DetalleCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonBigIcon_new btnConfiguración;
    private RSMaterialComponent.RSButtonIconDos btnMinimizar;
    private rojerusan.RSButtonHover btnMostrar;
    private newscomponents.RSButtonBigIcon_new btnProducto;
    private newscomponents.RSButtonBigIcon_new btnProveedor;
    private newscomponents.RSButtonBigIcon_new btnRegistrar;
    private RSMaterialComponent.RSButtonCustomIcon btnRegresar;
    private RSMaterialComponent.RSButtonIconDos btnSalir;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.rsdate.RSLabelFecha rSLabelFecha2;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private rojeru_san.rslabel.RSLabelImage rSLabelImage1;
    private necesario.RSLabelImage rSLabelImage2;
    private necesario.RSLabelImage rSLabelImage4;
    private RSMaterialComponent.RSTableMetro tblDetalleCompra;
    // End of variables declaration//GEN-END:variables
}
