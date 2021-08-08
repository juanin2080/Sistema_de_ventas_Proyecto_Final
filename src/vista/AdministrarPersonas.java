/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.DAO.PersonaDAO;
import controlador.DAO.RolDAO;
import controlador.utilidades.Controladores;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Persona;
import modelo.Rol;

/**
 *
 * @author juana
 */
public class AdministrarPersonas extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarPersonal
     */
    private Rol rol = new Rol();
    private RolDAO rDAO = new RolDAO();
    private PersonaDAO pDAO = new PersonaDAO();
    Controladores controles = new Controladores();

    public AdministrarPersonas() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarTabla("");
        llenarCbx();
        txtId.setVisible(false);
        txtRol.setVisible(false);

        txtavisoNombre.setVisible(false);
        txtavisoDirec.setVisible(false);
        txtavisoEmail.setVisible(false);
        txtavisoTlf.setVisible(false);
        txtavisoCed.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void limpiarCampos() {
        txtCedula.setText("");
        txtRol.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        txtNombres.setText("");
        txtTelefono.setText("");
        txtCedula.setEditable(true);
        cbxRol.setEnabled(true);
    }

    public boolean camposVacios() {
        if (txtCedula.getText().equals("") || txtDireccion.getText().equals("")
                || txtEmail.getText().equals("") || txtNombres.getText().equals("")
                || txtTelefono.getText().equals("")) {

            txtavisoNombre.setVisible(true);
            txtavisoDirec.setVisible(true);
            txtavisoEmail.setVisible(true);
            txtavisoNombre.setVisible(true);
            txtavisoTlf.setVisible(true);
            txtavisoCed.setVisible(true);
            return true;
        } else {
            return false;
        }
    }

    private void mostrarTabla(String cedula) {
        pDAO.listarPersonas(tbtPersonal, cedula);
    }

    public void llenarCbx() {
        cbxRol.removeAllItems();
        rDAO.listarComboBox(cbxRol);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rSLabelImage4 = new necesario.RSLabelImage();
        txtRol = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtPersonal = new RSMaterialComponent.RSTableMetro();
        btnGuardar = new rojerusan.RSButtonHover();
        labelIcon5 = new necesario.LabelIcon();
        labelIcon6 = new necesario.LabelIcon();
        btnActualizarDatos = new rojerusan.RSButtonHover();
        btnNuevoPersonal = new rojerusan.RSButtonHover();
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
        jLabel20 = new javax.swing.JLabel();
        cbxRol = new RSMaterialComponent.RSComboBoxMaterial<>();
        txtCedula = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtavisoCed = new javax.swing.JLabel();
        txtavisoNombre = new javax.swing.JLabel();
        txtavisoEmail = new javax.swing.JLabel();
        txtavisoTlf = new javax.swing.JLabel();
        txtavisoDirec = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Electrocasa le da la bienvenida a nuestra familia.");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(50, 80, 570, 70);

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bienvenido a electrocasa.");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(50, 10, 810, 70);

        rSLabelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoSistemaFinal.jpg"))); // NOI18N
        jPanel2.add(rSLabelImage4);
        rSLabelImage4.setBounds(910, 10, 230, 140);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 50, 1160, 160);

        txtRol.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtRol.setForeground(new java.awt.Color(102, 102, 102));
        txtRol.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRolMouseClicked(evt);
            }
        });
        txtRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRolActionPerformed(evt);
            }
        });
        jPanel1.add(txtRol);
        txtRol.setBounds(710, 580, 60, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Cédula:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 280, 80, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Nombres:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 320, 80, 30);

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
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombres);
        txtNombres.setBounds(140, 320, 220, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Dirección:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 440, 80, 30);

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
        txtDireccion.setBounds(140, 440, 220, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Email:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 360, 80, 30);

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
        txtEmail.setBounds(140, 360, 220, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Teléfono:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 400, 80, 30);

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
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono);
        txtTelefono.setBounds(140, 400, 220, 30);

        tbtPersonal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbtPersonal.setBackgoundHead(new java.awt.Color(102, 0, 102));
        tbtPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtPersonalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbtPersonal);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(452, 240, 700, 330);

        btnGuardar.setBackground(new java.awt.Color(0, 204, 51));
        btnGuardar.setText("Guardar");
        btnGuardar.setColorHover(new java.awt.Color(102, 102, 102));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(60, 560, 130, 30);

        labelIcon5.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        jPanel1.add(labelIcon5);
        labelIcon5.setBounds(20, 560, 30, 30);

        labelIcon6.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon6.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);
        jPanel1.add(labelIcon6);
        labelIcon6.setBounds(210, 560, 30, 30);

        btnActualizarDatos.setBackground(new java.awt.Color(0, 102, 204));
        btnActualizarDatos.setText("Actualizar datos");
        btnActualizarDatos.setColorHover(new java.awt.Color(102, 102, 102));
        btnActualizarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarDatos);
        btnActualizarDatos.setBounds(250, 560, 180, 30);

        btnNuevoPersonal.setBackground(new java.awt.Color(0, 102, 51));
        btnNuevoPersonal.setText("Limpiar");
        btnNuevoPersonal.setColorHover(new java.awt.Color(102, 102, 102));
        btnNuevoPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPersonalActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevoPersonal);
        btnNuevoPersonal.setBounds(150, 610, 180, 30);

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
        labelIcon10.setBounds(110, 610, 30, 30);

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
        jLabel4.setText("Ingrese los datos");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 220, 330, 50);

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

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Rol:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(20, 490, 100, 30);

        cbxRol.setForeground(new java.awt.Color(102, 102, 102));
        cbxRol.setColorMaterial(new java.awt.Color(102, 102, 102));
        cbxRol.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbxRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRolActionPerformed(evt);
            }
        });
        jPanel1.add(cbxRol);
        cbxRol.setBounds(140, 480, 220, 40);

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
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        jPanel1.add(txtCedula);
        txtCedula.setBounds(140, 280, 220, 30);

        txtId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtId.setForeground(new java.awt.Color(102, 102, 102));
        txtId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdMouseClicked(evt);
            }
        });
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtId);
        txtId.setBounds(620, 580, 60, 30);

        txtavisoCed.setForeground(new java.awt.Color(255, 0, 0));
        txtavisoCed.setText("*");
        jPanel1.add(txtavisoCed);
        txtavisoCed.setBounds(380, 280, 34, 20);

        txtavisoNombre.setForeground(new java.awt.Color(255, 0, 0));
        txtavisoNombre.setText("*");
        jPanel1.add(txtavisoNombre);
        txtavisoNombre.setBounds(380, 320, 34, 14);

        txtavisoEmail.setForeground(new java.awt.Color(255, 0, 0));
        txtavisoEmail.setText("*");
        jPanel1.add(txtavisoEmail);
        txtavisoEmail.setBounds(380, 360, 34, 14);

        txtavisoTlf.setForeground(new java.awt.Color(255, 0, 0));
        txtavisoTlf.setText("*");
        jPanel1.add(txtavisoTlf);
        txtavisoTlf.setBounds(380, 400, 34, 14);

        txtavisoDirec.setForeground(new java.awt.Color(255, 0, 0));
        txtavisoDirec.setText("*");
        jPanel1.add(txtavisoDirec);
        txtavisoDirec.setBounds(380, 450, 34, 14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1159, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
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

    private void btnNuevoPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPersonalActionPerformed
        limpiarCampos();
        txtavisoNombre.setVisible(false);
        txtavisoDirec.setVisible(false);
        txtavisoEmail.setVisible(false);
        txtavisoTlf.setVisible(false);
        txtavisoCed.setVisible(false);
    }//GEN-LAST:event_btnNuevoPersonalActionPerformed

    private void btnActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosActionPerformed
        if (camposVacios()) {
            JOptionPane.showMessageDialog(null, "Todos deben estar llenos");
        } else {
            Persona person = new Persona();
            person = pDAO.buscarRolPersona(Long.valueOf(txtId.getText()));
            pDAO.actualizarPersona(txtCedula.getText(), txtNombres.getText(), txtDireccion.getText(), txtTelefono.getText(), txtEmail.getText(), Long.valueOf(txtId.getText()), person.getRol());
            limpiarCampos();
            mostrarTabla("");
        }


    }//GEN-LAST:event_btnActualizarDatosActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (camposVacios()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos");
        } else {
            if (controles.validadorDeCedula(txtCedula.getText()) && controles.validarEmail(txtEmail.getText())) {
                rol = rDAO.buscarRol(cbxRol.getSelectedItem().toString());
                String mensaje = pDAO.insertarPersona(txtNombres.getText(), txtCedula.getText(), txtDireccion.getText(), txtTelefono.getText(), txtEmail.getText(), rol);
                JOptionPane.showMessageDialog(null, mensaje);
                limpiarCampos();
                mostrarTabla("");
                cbxRol.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(null, "Tiene Errores en algunos campos");
                txtavisoCed.setVisible(true);
                txtavisoEmail.setVisible(true);
            }

        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMouseClicked

    }//GEN-LAST:event_txtTelefonoMouseClicked

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseClicked

    }//GEN-LAST:event_txtEmailMouseClicked

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMouseClicked

    }//GEN-LAST:event_txtDireccionMouseClicked

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtNombresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombresMouseClicked

    }//GEN-LAST:event_txtNombresMouseClicked

    private void txtRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRolActionPerformed

    private void txtRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRolMouseClicked

    }//GEN-LAST:event_txtRolMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        InicioSesion inicioSesion = new InicioSesion();
        this.dispose();
        inicioSesion.setVisible(true);
        inicioSesion.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tbtPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtPersonalMouseClicked
        int seleccion = tbtPersonal.getSelectedRow();
        txtCedula.setText(tbtPersonal.getValueAt(seleccion, 0) + "");
        txtNombres.setText(tbtPersonal.getValueAt(seleccion, 1) + "");
        txtTelefono.setText(tbtPersonal.getValueAt(seleccion, 2) + "");
        txtDireccion.setText(tbtPersonal.getValueAt(seleccion, 3) + "");
        txtEmail.setText(tbtPersonal.getValueAt(seleccion, 4) + "");
        txtId.setText(tbtPersonal.getValueAt(seleccion, 5) + "");
        txtRol.setText(tbtPersonal.getValueAt(seleccion, 6) + "");
        txtCedula.setEditable(false);
        cbxRol.setEnabled(false);
    }//GEN-LAST:event_tbtPersonalMouseClicked

    private void txtCedulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCedulaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaMouseClicked

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdMouseClicked

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void cbxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxRolActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        // TODO add your handling code here:
        char caracteres = evt.getKeyChar();

        if (caracteres < '0' || caracteres > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtCedulaKeyTyped
    public static boolean validarNombre(String nombre) {
        return nombre.matches("^(([A-Za-z]{1})?[a-z]+[ ]?)+$");
    }
    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char caracteres = evt.getKeyChar();

        if (caracteres < '0' || caracteres > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresKeyTyped

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
            java.util.logging.Logger.getLogger(AdministrarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministrarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministrarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministrarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministrarPersonas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover btnActualizarDatos;
    private rojerusan.RSButtonHover btnGuardar;
    private RSMaterialComponent.RSButtonIconDos btnMinimizar;
    private rojerusan.RSButtonHover btnNuevoPersonal;
    private newscomponents.RSButtonIcon_new btnRegresar;
    private RSMaterialComponent.RSButtonIconDos btnSalir;
    private RSMaterialComponent.RSComboBoxMaterial<Rol> cbxRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private necesario.LabelIcon labelIcon10;
    private necesario.LabelIcon labelIcon5;
    private necesario.LabelIcon labelIcon6;
    private rojeru_san.rsdate.RSLabelFecha rSLabelFecha1;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private necesario.RSLabelImage rSLabelImage2;
    private necesario.RSLabelImage rSLabelImage4;
    private RSMaterialComponent.RSTableMetro tbtPersonal;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtRol;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JLabel txtavisoCed;
    private javax.swing.JLabel txtavisoDirec;
    private javax.swing.JLabel txtavisoEmail;
    private javax.swing.JLabel txtavisoNombre;
    private javax.swing.JLabel txtavisoTlf;
    // End of variables declaration//GEN-END:variables
}
