/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.DAO.PersonaDAO;
import controlador.DAO.ProveedorDAO;
import controlador.DAO.RolDAO;
import controladores.utilidades.Controladores;
import javax.swing.JOptionPane;
import modelo.Persona;
import modelo.Proveedor;
import modelo.Rol;

/**
 *
 * @author juana
 */
public class AdministrarProveedor extends javax.swing.JFrame {

    private Rol rol = new Rol();
    private RolDAO rDAO = new RolDAO();
    private PersonaDAO pDAO = new PersonaDAO();
    Controladores controles = new Controladores();
    /**
     * Creates new form RegistrarPersonal
     */
    private ProveedorDAO pdao = new ProveedorDAO();

    public AdministrarProveedor() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarTabla("");
        txtId.setVisible(false);
        txtRol.setVisible(false);
        llenarCbx();

//        cbxRol.setEnabled(false);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rSLabelImage4 = new necesario.RSLabelImage();
        btnRegistrar = new newscomponents.RSButtonBigIcon_new();
        btnProveedor = new newscomponents.RSButtonBigIcon_new();
        btnProducto = new newscomponents.RSButtonBigIcon_new();
        btnConfiguración = new newscomponents.RSButtonBigIcon_new();
        txtCedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtProveedor = new RSMaterialComponent.RSTableMetro();
        btnGuardar = new rojerusan.RSButtonHover();
        labelIcon6 = new necesario.LabelIcon();
        labelIcon8 = new necesario.LabelIcon();
        labelIcon9 = new necesario.LabelIcon();
        labelIcon11 = new necesario.LabelIcon();
        btnNuevoProveedor = new rojerusan.RSButtonHover();
        btnMinimizar = new RSMaterialComponent.RSButtonIconDos();
        btnSalir = new RSMaterialComponent.RSButtonIconDos();
        labelIcon10 = new necesario.LabelIcon();
        labelIcon12 = new necesario.LabelIcon();
        labelIcon13 = new necesario.LabelIcon();
        labelIcon14 = new necesario.LabelIcon();
        rSLabelImage2 = new necesario.RSLabelImage();
        jLabel22 = new javax.swing.JLabel();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        rSLabelFecha1 = new rojeru_san.rsdate.RSLabelFecha();
        jLabel23 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnRegresar = new newscomponents.RSButtonIcon_new();
        btnActualizarDatos1 = new rojerusan.RSButtonHover();
        labelIcon19 = new necesario.LabelIcon();
        labelIcon20 = new necesario.LabelIcon();
        labelIcon21 = new necesario.LabelIcon();
        labelIcon22 = new necesario.LabelIcon();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        cbxRol = new RSMaterialComponent.RSComboBoxMaterial<>();
        jLabel20 = new javax.swing.JLabel();
        txtRol = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();

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

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre Administrador");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 80, 220, 70);

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hola");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(50, 10, 150, 70);

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
        btnRegistrar.setBounds(270, 30, 140, 120);

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
        btnProveedor.setBounds(430, 30, 140, 120);

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
        btnProducto.setBounds(590, 30, 150, 120);

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
        btnConfiguración.setBounds(750, 30, 140, 120);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 50, 1160, 160);

        txtCedula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCedula.setForeground(new java.awt.Color(102, 102, 102));
        txtCedula.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        jPanel1.add(txtCedula);
        txtCedula.setBounds(140, 270, 220, 30);

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
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombres);
        txtNombres.setBounds(140, 310, 220, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Ruc:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 490, 80, 30);

        txtRuc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtRuc.setForeground(new java.awt.Color(102, 102, 102));
        txtRuc.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucActionPerformed(evt);
            }
        });
        jPanel1.add(txtRuc);
        txtRuc.setBounds(140, 490, 220, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Empresa:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 530, 80, 30);

        txtEmpresa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEmpresa.setForeground(new java.awt.Color(102, 102, 102));
        txtEmpresa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmpresa);
        txtEmpresa.setBounds(140, 530, 220, 30);

        tbtProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbtProveedor.setBackgoundHead(new java.awt.Color(102, 0, 102));
        tbtProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbtProveedor);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(492, 240, 660, 340);

        btnGuardar.setBackground(new java.awt.Color(0, 204, 51));
        btnGuardar.setText("Guardar");
        btnGuardar.setColorHover(new java.awt.Color(102, 102, 102));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(760, 590, 130, 30);

        labelIcon6.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon6.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);

        labelIcon8.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon8.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);
        labelIcon6.add(labelIcon8);
        labelIcon8.setBounds(220, 470, 30, 30);

        labelIcon9.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon9.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);

        labelIcon11.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon11.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);
        labelIcon9.add(labelIcon11);
        labelIcon11.setBounds(220, 470, 30, 30);

        labelIcon6.add(labelIcon9);
        labelIcon9.setBounds(220, 470, 30, 30);

        jPanel1.add(labelIcon6);
        labelIcon6.setBounds(920, 590, 30, 30);

        btnNuevoProveedor.setBackground(new java.awt.Color(0, 102, 51));
        btnNuevoProveedor.setText("Nuevo Proveedor");
        btnNuevoProveedor.setColorHover(new java.awt.Color(102, 102, 102));
        btnNuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevoProveedor);
        btnNuevoProveedor.setBounds(960, 640, 180, 30);

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

        labelIcon12.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon12.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        labelIcon10.add(labelIcon12);
        labelIcon12.setBounds(220, 520, 30, 30);

        labelIcon13.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon13.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);

        labelIcon14.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon14.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        labelIcon13.add(labelIcon14);
        labelIcon14.setBounds(220, 520, 30, 30);

        labelIcon10.add(labelIcon13);
        labelIcon13.setBounds(220, 520, 30, 30);

        jPanel1.add(labelIcon10);
        labelIcon10.setBounds(920, 640, 30, 30);

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

        btnActualizarDatos1.setBackground(new java.awt.Color(0, 102, 204));
        btnActualizarDatos1.setText("Actualizar datos");
        btnActualizarDatos1.setColorHover(new java.awt.Color(102, 102, 102));
        btnActualizarDatos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatos1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarDatos1);
        btnActualizarDatos1.setBounds(960, 590, 180, 30);

        labelIcon19.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon19.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);

        labelIcon20.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon20.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        labelIcon19.add(labelIcon20);
        labelIcon20.setBounds(20, 470, 30, 30);

        labelIcon21.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon21.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);

        labelIcon22.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon22.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        labelIcon21.add(labelIcon22);
        labelIcon22.setBounds(20, 470, 30, 30);

        labelIcon19.add(labelIcon21);
        labelIcon21.setBounds(350, 420, 30, 30);

        jPanel1.add(labelIcon19);
        labelIcon19.setBounds(720, 590, 30, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Email:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 360, 80, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Teléfono:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(20, 410, 80, 30);

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
        txtTelefono.setBounds(140, 400, 220, 30);

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
        txtDireccion.setBounds(140, 450, 220, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Dirección:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 450, 80, 30);

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
        txtEmail.setBounds(140, 350, 220, 30);

        cbxRol.setForeground(new java.awt.Color(102, 102, 102));
        cbxRol.setColorMaterial(new java.awt.Color(102, 102, 102));
        cbxRol.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(cbxRol);
        cbxRol.setBounds(140, 570, 220, 40);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Rol:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(20, 580, 100, 30);

        txtRol.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtRol.setForeground(new java.awt.Color(102, 102, 102));
        txtRol.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRolActionPerformed(evt);
            }
        });
        jPanel1.add(txtRol);
        txtRol.setBounds(380, 290, 90, 30);

        txtId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtId.setForeground(new java.awt.Color(102, 102, 102));
        txtId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtId);
        txtId.setBounds(380, 240, 90, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1159, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
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

    private void btnNuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProveedorActionPerformed
        // TODO add your handling code here:
        limpiar();
        txtCedula.setEditable(true);
    }//GEN-LAST:event_btnNuevoProveedorActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
            rol = rDAO.buscarRol(cbxRol.getSelectedItem().toString());
            pdao.insertarProveedor(txtNombres.getText(), txtCedula.getText(), txtDireccion.getText(), txtTelefono.getText(), txtEmail.getText(), rol, txtEmpresa.getText(), txtRuc.getText());

            mostrarTabla("");
            limpiar();
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucActionPerformed

    private void txtRucMouseClicked(java.awt.event.MouseEvent evt) {

    }

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        InicioSesion inicioSesion = new InicioSesion();
        this.dispose();
        inicioSesion.setVisible(true);
        inicioSesion.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnConfiguraciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguraciónActionPerformed
        // TODO add your handling code here:
        Configuracion conf = new Configuracion();
        this.dispose();
        conf.setVisible(true);
        conf.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnConfiguraciónActionPerformed


    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductoActionPerformed

    private void btnActualizarDatos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatos1ActionPerformed
        // TODO add your handling code here:

        if (txtEmpresa.getText().equals("") || txtRuc.getText().equals("") || txtNombres.getText().equals("") || txtCedula.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
        } else {
            String mensaje = "";
            Persona person = new Persona();
            person = pDAO.buscarRolPersona(Long.valueOf(txtId.getText()));
            mensaje = pdao.actualizarDatos(Long.valueOf(txtId.getText()), txtNombres.getText(), txtCedula.getText(), txtDireccion.getText(), txtTelefono.getText(), txtEmail.getText(), person.getRol(), txtEmpresa.getText(), txtRuc.getText());
            JOptionPane.showMessageDialog(null, mensaje);
            mostrarTabla("");
            limpiar();
        }

    }//GEN-LAST:event_btnActualizarDatos1ActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void txtTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMouseClicked

    }//GEN-LAST:event_txtTelefonoMouseClicked

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMouseClicked

    }//GEN-LAST:event_txtDireccionMouseClicked

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseClicked

    }//GEN-LAST:event_txtEmailMouseClicked

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpresaActionPerformed

    private void txtRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRolActionPerformed

    private void tbtProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtProveedorMouseClicked
        // TODO add your handling code here:
        int select = tbtProveedor.getSelectedRow();

        txtCedula.setText(tbtProveedor.getValueAt(select, 0) + "");
        txtNombres.setText(tbtProveedor.getValueAt(select, 1) + "");
        txtTelefono.setText(tbtProveedor.getValueAt(select, 2) + "");
        txtDireccion.setText(tbtProveedor.getValueAt(select, 3) + "");
        txtEmail.setText(tbtProveedor.getValueAt(select, 4) + "");
        txtRuc.setText((String) tbtProveedor.getValueAt(select, 5));
        txtEmpresa.setText(tbtProveedor.getValueAt(select, 6) + "");
        txtId.setText((String) tbtProveedor.getValueAt(select, 7));
        txtRol.setText((String) tbtProveedor.getValueAt(select, 8));
        txtCedula.setEditable(false);

        cbxRol.setEnabled(false);


    }//GEN-LAST:event_tbtProveedorMouseClicked

    public void limpiar() {
        txtCedula.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        txtEmpresa.setText("");
        txtNombres.setText("");
        txtRuc.setText("");
        txtTelefono.setText("");
        txtEmpresa.setText("");
    }

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed
    private void mostrarTabla(String cedula) {
        pdao.listarPersonas(tbtProveedor, cedula);
    }

    public void llenarCbx() {
        cbxRol.removeAllItems();
        rDAO.listarComboBox(cbxRol);
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
            java.util.logging.Logger.getLogger(AdministrarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministrarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministrarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministrarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AdministrarProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover btnActualizarDatos1;
    private newscomponents.RSButtonBigIcon_new btnConfiguración;
    private rojerusan.RSButtonHover btnGuardar;
    private RSMaterialComponent.RSButtonIconDos btnMinimizar;
    private rojerusan.RSButtonHover btnNuevoProveedor;
    private newscomponents.RSButtonBigIcon_new btnProducto;
    private newscomponents.RSButtonBigIcon_new btnProveedor;
    private newscomponents.RSButtonBigIcon_new btnRegistrar;
    private newscomponents.RSButtonIcon_new btnRegresar;
    private RSMaterialComponent.RSButtonIconDos btnSalir;
    private RSMaterialComponent.RSComboBoxMaterial<Rol> cbxRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private necesario.LabelIcon labelIcon11;
    private necesario.LabelIcon labelIcon12;
    private necesario.LabelIcon labelIcon13;
    private necesario.LabelIcon labelIcon14;
    private necesario.LabelIcon labelIcon19;
    private necesario.LabelIcon labelIcon20;
    private necesario.LabelIcon labelIcon21;
    private necesario.LabelIcon labelIcon22;
    private necesario.LabelIcon labelIcon6;
    private necesario.LabelIcon labelIcon8;
    private necesario.LabelIcon labelIcon9;
    private rojeru_san.rsdate.RSLabelFecha rSLabelFecha1;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private necesario.RSLabelImage rSLabelImage2;
    private necesario.RSLabelImage rSLabelImage4;
    private RSMaterialComponent.RSTableMetro tbtProveedor;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtRol;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
