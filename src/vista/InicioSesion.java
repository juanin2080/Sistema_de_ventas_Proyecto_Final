/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.DAO.CuentaDAO;
import controlador.RolJpaController;
import javax.swing.JOptionPane;
import modelo.Cuenta;

/**
 *
 * @author Juan Armijos, Cristian Capa, Maria Castillo, Kelly Preciado
 */
public class InicioSesion extends javax.swing.JFrame {

    /**
     * Creates new form InicioSesion
     */
    CuentaDAO cDAO = new CuentaDAO();

    public InicioSesion() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void LimpiarCampos() {
        txtUsuario.setText("");
        txtClave.setText("");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        labelIcon3 = new necesario.LabelIcon();
        rSLabelImage2 = new necesario.RSLabelImage();
        rSLabelImage1 = new rojeru_san.rslabel.RSLabelImage();
        LblImagenInicio = new javax.swing.JLabel();
        labelIcon4 = new necesario.LabelIcon();
        labelIcon6 = new necesario.LabelIcon();
        labelIcon5 = new necesario.LabelIcon();
        jLabel4 = new javax.swing.JLabel();
        btnIngresar = new rojerusan.RSButtonHover();
        jLabel5 = new javax.swing.JLabel();
        btnRegistrarse = new rojerusan.RSButtonHover();
        btnMinimizar = new RSMaterialComponent.RSButtonIconDos();
        btnVerContrasenia = new RSMaterialComponent.RSButtonIconDos();
        btnSalir = new RSMaterialComponent.RSButtonIconDos();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio Sesi??n");
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

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Iniciar Sesi??n.");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(370, 10, 250, 70);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Electrodom??sticos para tu hogar.");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(420, 440, 300, 30);

        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(102, 102, 102));
        txtUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario);
        txtUsuario.setBounds(450, 170, 240, 30);

        txtClave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtClave.setForeground(new java.awt.Color(102, 102, 102));
        txtClave.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtClave);
        txtClave.setBounds(450, 290, 240, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contacto: 0994962257");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 470, 210, 20);

        labelIcon3.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ENHANCED_ENCRYPTION);
        jPanel1.add(labelIcon3);
        labelIcon3.setBounds(400, 290, 30, 30);

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoSistemaFinal.jpg"))); // NOI18N
        jPanel1.add(rSLabelImage2);
        rSLabelImage2.setBounds(20, 10, 320, 170);

        rSLabelImage1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rSLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/destacado-menu-electro.png"))); // NOI18N
        jPanel1.add(rSLabelImage1);
        rSLabelImage1.setBounds(0, 0, 360, 500);

        LblImagenInicio.setBackground(new java.awt.Color(135, 164, 195));
        LblImagenInicio.setOpaque(true);
        jPanel1.add(LblImagenInicio);
        LblImagenInicio.setBounds(0, 0, 360, 460);

        labelIcon4.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PERSON_ADD);
        jPanel1.add(labelIcon4);
        labelIcon4.setBounds(570, 380, 30, 30);

        labelIcon6.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(labelIcon6);
        labelIcon6.setBounds(400, 170, 30, 30);

        labelIcon5.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PORTRAIT);
        jPanel1.add(labelIcon5);
        labelIcon5.setBounds(370, 380, 30, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Usuario.");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(450, 120, 210, 30);

        btnIngresar.setBackground(new java.awt.Color(0, 204, 51));
        btnIngresar.setText("Ingresar");
        btnIngresar.setColorHover(new java.awt.Color(102, 102, 102));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar);
        btnIngresar.setBounds(410, 380, 130, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Contrase??a.");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(450, 240, 210, 30);

        btnRegistrarse.setBackground(new java.awt.Color(0, 0, 204));
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.setColorHover(new java.awt.Color(102, 102, 102));
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarse);
        btnRegistrarse.setBounds(610, 380, 130, 30);

        btnMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimizar.setBackgroundHover(new java.awt.Color(0, 102, 204));
        btnMinimizar.setForegroundText(new java.awt.Color(102, 102, 102));
        btnMinimizar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REMOVE);
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnMinimizar);
        btnMinimizar.setBounds(670, 10, 40, 40);

        btnVerContrasenia.setBackground(new java.awt.Color(255, 255, 255));
        btnVerContrasenia.setBackgroundHover(new java.awt.Color(0, 0, 204));
        btnVerContrasenia.setForegroundText(new java.awt.Color(102, 102, 102));
        btnVerContrasenia.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.VISIBILITY);
        btnVerContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerContraseniaActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerContrasenia);
        btnVerContrasenia.setBounds(700, 290, 30, 30);

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setBackgroundHover(new java.awt.Color(255, 0, 0));
        btnSalir.setForegroundText(new java.awt.Color(102, 102, 102));
        btnSalir.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir);
        btnSalir.setBounds(710, 10, 40, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        Cuenta cuenta = new Cuenta();
        cuenta = cDAO.autenticacion(txtUsuario.getText(), txtClave.getText());
        if (cuenta.getUsuario() == null && cuenta.getClave() == null) {
            JOptionPane.showMessageDialog(null, "Usuario o clave incorrectos");
        } else {
            if (camposVacios()) {
                JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
            } else {
                if (cuenta.getPersona().getRol().getRol().equals("Administrador")) {

                    MenuPrincipalAdministrador mpa = new MenuPrincipalAdministrador();
                    dispose();
                    mpa.setLocationRelativeTo(null);
                    mpa.setVisible(true);
                    LimpiarCampos();

                } else {

                    if (cuenta.getPersona().getRol().getRol().equals("Vendedor")) {
                        MenuPrincipalVendedor mpv = new MenuPrincipalVendedor();
                        dispose();
                        mpv.setLocationRelativeTo(null);
                        mpv.setVisible(true);
                        LimpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(null, "El usuario no est?? autorizado para ingresar al sistema");
                        LimpiarCampos();
                    }
                }
            }
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        RolJpaController rol = new RolJpaController();
        if (rol.getRolCount() == 0) {
            AdministrarRoles ar = new AdministrarRoles();
            dispose();
            ar.setVisible(true);
            ar.setLocationRelativeTo(null);
        } else {
            AdministrarPersonas ap = new AdministrarPersonas();
            this.dispose();
            ap.setVisible(true);
            ap.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    public boolean camposVacios() {
        if (txtUsuario.getText().equals("") || txtClave.getText().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FiveCodMover.FiveCodMoverJFrame.MousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FiveCodMover.FiveCodMoverJFrame.MouseDraggedFrame(evt, this);
    }//GEN-LAST:event_formMouseDragged

    private void btnVerContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerContraseniaActionPerformed
        txtClave.setEchoChar((char) 0);
    }//GEN-LAST:event_btnVerContraseniaActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new InicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel LblImagenInicio;
    rojerusan.RSButtonHover btnIngresar;
    RSMaterialComponent.RSButtonIconDos btnMinimizar;
    rojerusan.RSButtonHover btnRegistrarse;
    RSMaterialComponent.RSButtonIconDos btnSalir;
    RSMaterialComponent.RSButtonIconDos btnVerContrasenia;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JPanel jPanel1;
    necesario.LabelIcon labelIcon3;
    necesario.LabelIcon labelIcon4;
    necesario.LabelIcon labelIcon5;
    necesario.LabelIcon labelIcon6;
    rojeru_san.rslabel.RSLabelImage rSLabelImage1;
    necesario.RSLabelImage rSLabelImage2;
    javax.swing.JPasswordField txtClave;
    javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
