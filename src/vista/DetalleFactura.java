/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author María Castillo
 */
public class DetalleFactura extends javax.swing.JFrame {

    /**
     * Creates new form DetalleFactura
     */
    public DetalleFactura() {
        initComponents();
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
        btnClientes = new newscomponents.RSButtonBigIcon_new();
        btnVentas = new newscomponents.RSButtonBigIcon_new();
        txtNroFactura = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        txtCodProducto = new javax.swing.JTextField();
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
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        labelIcon8 = new necesario.LabelIcon();
        labelIcon9 = new necesario.LabelIcon();
        btnBuscar1 = new rojerusan.RSButtonHover();
        btnBuscar = new rojerusan.RSButtonHover();
        txtSubtotal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnBuscarProducto = new rojerusan.RSButtonHover();
        labelIcon11 = new necesario.LabelIcon();
        labelIcon12 = new necesario.LabelIcon();
        btnBuscar3 = new rojerusan.RSButtonHover();
        jLabel22 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        rSLabelImage5 = new necesario.RSLabelImage();
        btnDetalleFactura = new newscomponents.RSButtonBigIcon_new();
        btnFactura = new newscomponents.RSButtonBigIcon_new();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbtClientes1 = new RSMaterialComponent.RSTableMetro();
        btnGuardar1 = new rojerusan.RSButtonHover();
        labelIcon13 = new necesario.LabelIcon();
        btnMinimizar1 = new RSMaterialComponent.RSButtonIconDos();
        btnSalir1 = new RSMaterialComponent.RSButtonIconDos();
        rSLabelImage3 = new necesario.RSLabelImage();
        rSLabelHora2 = new rojeru_san.rsdate.RSLabelHora();
        rSLabelFecha2 = new rojeru_san.rsdate.RSLabelFecha();
        jLabel25 = new javax.swing.JLabel();
        btnRegresar = new newscomponents.RSButtonIcon_new();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setAlignmentY(0.0F);
        jPanel2.setLayout(null);

        rSLabelImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoSistemaFinal.jpg"))); // NOI18N
        jPanel2.add(rSLabelImage4);
        rSLabelImage4.setBounds(600, 10, 160, 70);

        btnClientes.setBackground(new java.awt.Color(0, 153, 102));
        btnClientes.setText("Clientes");
        btnClientes.setBgHover(new java.awt.Color(102, 102, 102));
        btnClientes.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CONTACTS);
        btnClientes.setSizeIcon(30.0F);
        jPanel2.add(btnClientes);
        btnClientes.setBounds(140, 10, 100, 70);

        btnVentas.setBackground(new java.awt.Color(0, 153, 102));
        btnVentas.setText("Ventas");
        btnVentas.setBgHover(new java.awt.Color(102, 102, 102));
        btnVentas.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MONETIZATION_ON);
        btnVentas.setSizeIcon(30.0F);
        jPanel2.add(btnVentas);
        btnVentas.setBounds(330, 10, 100, 70);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 50, 1160, 90);

        txtNroFactura.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNroFactura.setForeground(new java.awt.Color(102, 102, 102));
        txtNroFactura.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtNroFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNroFacturaMouseClicked(evt);
            }
        });
        txtNroFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNroFacturaActionPerformed(evt);
            }
        });
        jPanel1.add(txtNroFactura);
        txtNroFactura.setBounds(130, 180, 160, 30);

        txtCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCliente.setForeground(new java.awt.Color(102, 102, 102));
        txtCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtClienteMouseClicked(evt);
            }
        });
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });
        jPanel1.add(txtCliente);
        txtCliente.setBounds(420, 190, 130, 30);

        txtCodProducto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCodProducto.setForeground(new java.awt.Color(102, 102, 102));
        txtCodProducto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtCodProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCodProductoMouseClicked(evt);
            }
        });
        txtCodProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodProductoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodProducto);
        txtCodProducto.setBounds(130, 280, 160, 30);

        tbtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cantidad", "Marca", "Precio Unitario", "Precio Final"
            }
        ));
        tbtClientes.setBackgoundHead(new java.awt.Color(102, 0, 102));
        jScrollPane1.setViewportView(tbtClientes);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(140, 330, 470, 170);

        btnGuardar.setBackground(new java.awt.Color(0, 204, 51));
        btnGuardar.setText("Guardar");
        btnGuardar.setColorHover(new java.awt.Color(102, 102, 102));
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(110, 600, 130, 30);

        labelIcon5.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        jPanel1.add(labelIcon5);
        labelIcon5.setBounds(70, 600, 30, 30);

        labelIcon6.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon6.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);
        jPanel1.add(labelIcon6);
        labelIcon6.setBounds(410, 600, 30, 30);

        btnActualizarDatos.setBackground(new java.awt.Color(0, 102, 204));
        btnActualizarDatos.setText("Actualizar datos");
        btnActualizarDatos.setColorHover(new java.awt.Color(102, 102, 102));
        jPanel1.add(btnActualizarDatos);
        btnActualizarDatos.setBounds(450, 600, 180, 30);

        labelIcon7.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon7.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        jPanel1.add(labelIcon7);
        labelIcon7.setBounds(70, 650, 30, 30);

        btnDarDeBaja.setBackground(new java.awt.Color(255, 0, 0));
        btnDarDeBaja.setText("Dar de baja");
        btnDarDeBaja.setColorHover(new java.awt.Color(102, 102, 102));
        jPanel1.add(btnDarDeBaja);
        btnDarDeBaja.setBounds(110, 650, 130, 30);

        btnNuevoCliente.setBackground(new java.awt.Color(0, 102, 51));
        btnNuevoCliente.setText("Nuevo cliente");
        btnNuevoCliente.setColorHover(new java.awt.Color(102, 102, 102));
        jPanel1.add(btnNuevoCliente);
        btnNuevoCliente.setBounds(450, 650, 180, 30);

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
        btnMinimizar.setBounds(700, 0, 40, 40);

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
        btnSalir.setBounds(740, 0, 40, 40);

        labelIcon10.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon10.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        jPanel1.add(labelIcon10);
        labelIcon10.setBounds(410, 650, 30, 30);

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoSistemaFinal.jpg"))); // NOI18N
        jPanel1.add(rSLabelImage2);
        rSLabelImage2.setBounds(10, 10, 50, 40);

        rSLabelHora1.setForeground(new java.awt.Color(102, 102, 102));
        rSLabelHora1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(rSLabelHora1);
        rSLabelHora1.setBounds(420, 0, 200, 40);

        rSLabelFecha1.setForeground(new java.awt.Color(102, 102, 102));
        rSLabelFecha1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(rSLabelFecha1);
        rSLabelFecha1.setBounds(260, 0, 200, 40);

        jLabel23.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("ELECTROCASA");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(70, 10, 190, 30);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Cedula Cliente:");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(330, 190, 80, 30);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Codigo Producto:");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(20, 290, 100, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Nro Factura:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 180, 80, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Ingresar los datos.");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 130, 240, 50);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Fecha:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 230, 80, 30);

        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(102, 102, 102));
        txtFecha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFechaMouseClicked(evt);
            }
        });
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFecha);
        txtFecha.setBounds(100, 230, 120, 30);

        labelIcon8.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon8.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);

        labelIcon9.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon9.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        labelIcon8.add(labelIcon9);
        labelIcon9.setBounds(590, 180, 30, 30);

        btnBuscar1.setBackground(new java.awt.Color(0, 204, 51));
        btnBuscar1.setText("Buscar");
        btnBuscar1.setColorHover(new java.awt.Color(102, 102, 102));
        labelIcon8.add(btnBuscar1);
        btnBuscar1.setBounds(630, 180, 130, 30);

        jPanel1.add(labelIcon8);
        labelIcon8.setBounds(570, 190, 30, 30);

        btnBuscar.setBackground(new java.awt.Color(204, 0, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setColorHover(new java.awt.Color(102, 102, 102));
        jPanel1.add(btnBuscar);
        btnBuscar.setBounds(610, 190, 130, 30);

        txtSubtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSubtotal.setForeground(new java.awt.Color(102, 102, 102));
        txtSubtotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtSubtotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSubtotalMouseClicked(evt);
            }
        });
        txtSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotalActionPerformed(evt);
            }
        });
        jPanel1.add(txtSubtotal);
        txtSubtotal.setBounds(530, 510, 80, 18);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Subtotal:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(470, 510, 50, 20);

        btnBuscarProducto.setBackground(new java.awt.Color(204, 0, 255));
        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.setColorHover(new java.awt.Color(102, 102, 102));
        jPanel1.add(btnBuscarProducto);
        btnBuscarProducto.setBounds(360, 290, 90, 20);

        labelIcon11.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon11.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);

        labelIcon12.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon12.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        labelIcon11.add(labelIcon12);
        labelIcon12.setBounds(590, 180, 30, 30);

        btnBuscar3.setBackground(new java.awt.Color(0, 204, 51));
        btnBuscar3.setText("Buscar");
        btnBuscar3.setColorHover(new java.awt.Color(102, 102, 102));
        labelIcon11.add(btnBuscar3);
        btnBuscar3.setBounds(630, 180, 130, 30);

        jPanel1.add(labelIcon11);
        labelIcon11.setBounds(320, 290, 30, 20);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("iva:");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(470, 540, 50, 20);

        txtIva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIva.setForeground(new java.awt.Color(102, 102, 102));
        txtIva.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtIva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIvaMouseClicked(evt);
            }
        });
        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });
        jPanel1.add(txtIva);
        txtIva.setBounds(530, 540, 80, 18);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Total:");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(470, 570, 50, 20);

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(102, 102, 102));
        txtTotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(217, 219, 228)));
        txtTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTotalMouseClicked(evt);
            }
        });
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        jPanel1.add(txtTotal);
        txtTotal.setBounds(530, 570, 80, 18);

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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(0, 0, 204));
        jPanel4.setAlignmentX(0.0F);
        jPanel4.setAlignmentY(0.0F);
        jPanel4.setLayout(null);

        rSLabelImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoSistemaFinal.jpg"))); // NOI18N
        jPanel4.add(rSLabelImage5);
        rSLabelImage5.setBounds(600, 10, 160, 70);

        btnDetalleFactura.setBackground(new java.awt.Color(0, 153, 102));
        btnDetalleFactura.setText("Detalle Factura");
        btnDetalleFactura.setBgHover(new java.awt.Color(102, 102, 102));
        btnDetalleFactura.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.NOTE);
        btnDetalleFactura.setSizeIcon(30.0F);
        btnDetalleFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleFacturaActionPerformed(evt);
            }
        });
        jPanel4.add(btnDetalleFactura);
        btnDetalleFactura.setBounds(140, 10, 140, 70);

        btnFactura.setBackground(new java.awt.Color(0, 153, 102));
        btnFactura.setText("Factura");
        btnFactura.setBgHover(new java.awt.Color(102, 102, 102));
        btnFactura.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SHOPPING_CART);
        btnFactura.setSizeIcon(30.0F);
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });
        jPanel4.add(btnFactura);
        btnFactura.setBounds(400, 10, 100, 70);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(0, 50, 1160, 90);

        tbtClientes1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CodigoProducto", "Cantidad", "Precio Unitario", "Precio total", "Stock"
            }
        ));
        tbtClientes1.setBackgoundHead(new java.awt.Color(102, 0, 102));
        jScrollPane2.setViewportView(tbtClientes1);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(30, 220, 700, 330);

        btnGuardar1.setBackground(new java.awt.Color(0, 204, 51));
        btnGuardar1.setText("Guardar");
        btnGuardar1.setColorHover(new java.awt.Color(102, 102, 102));
        jPanel3.add(btnGuardar1);
        btnGuardar1.setBounds(350, 590, 130, 30);

        labelIcon13.setForeground(new java.awt.Color(102, 102, 102));
        labelIcon13.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        jPanel3.add(labelIcon13);
        labelIcon13.setBounds(310, 590, 30, 30);

        btnMinimizar1.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimizar1.setForeground(new java.awt.Color(102, 102, 102));
        btnMinimizar1.setBackgroundHover(new java.awt.Color(0, 102, 204));
        btnMinimizar1.setForegroundHover(new java.awt.Color(102, 102, 102));
        btnMinimizar1.setForegroundText(new java.awt.Color(102, 102, 102));
        btnMinimizar1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REMOVE);
        btnMinimizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizar1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnMinimizar1);
        btnMinimizar1.setBounds(700, 0, 40, 40);

        btnSalir1.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir1.setForeground(new java.awt.Color(102, 102, 102));
        btnSalir1.setBackgroundHover(new java.awt.Color(255, 0, 0));
        btnSalir1.setForegroundHover(new java.awt.Color(102, 102, 102));
        btnSalir1.setForegroundText(new java.awt.Color(102, 102, 102));
        btnSalir1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalir1);
        btnSalir1.setBounds(740, 0, 40, 40);

        rSLabelImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoSistemaFinal.jpg"))); // NOI18N
        jPanel3.add(rSLabelImage3);
        rSLabelImage3.setBounds(10, 10, 50, 40);

        rSLabelHora2.setForeground(new java.awt.Color(102, 102, 102));
        rSLabelHora2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(rSLabelHora2);
        rSLabelHora2.setBounds(540, 0, 140, 40);

        rSLabelFecha2.setForeground(new java.awt.Color(102, 102, 102));
        rSLabelFecha2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(rSLabelFecha2);
        rSLabelFecha2.setBounds(420, 0, 130, 40);

        jLabel25.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("ELECTROCASA");
        jPanel3.add(jLabel25);
        jLabel25.setBounds(70, 10, 190, 30);

        btnRegresar.setBackground(new java.awt.Color(0, 204, 51));
        btnRegresar.setText("Regresar");
        btnRegresar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REPLAY);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegresar);
        btnRegresar.setBounds(270, 10, 120, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.getAccessibleContext().setAccessibleName("");
        jPanel3.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNroFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNroFacturaMouseClicked

    }//GEN-LAST:event_txtNroFacturaMouseClicked

    private void txtNroFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNroFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNroFacturaActionPerformed

    private void txtClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtClienteMouseClicked

    }//GEN-LAST:event_txtClienteMouseClicked

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtCodProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCodProductoMouseClicked

    }//GEN-LAST:event_txtCodProductoMouseClicked

    private void txtCodProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodProductoActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaMouseClicked

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtSubtotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSubtotalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtotalMouseClicked

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtotalActionPerformed

    private void txtIvaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIvaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIvaMouseClicked

    private void txtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIvaActionPerformed

    private void txtTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTotalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalMouseClicked

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnMinimizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizar1ActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizar1ActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFacturaActionPerformed

    private void btnDetalleFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetalleFacturaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

    }//GEN-LAST:event_btnRegresarActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
    FiveCodMover.FiveCodMoverJFrame.MousePressed(evt);

// TODO add your handling code here:
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FiveCodMover.FiveCodMoverJFrame.MouseDraggedFrame(evt, this);

        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged

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
            java.util.logging.Logger.getLogger(DetalleFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonHover btnActualizarDatos;
    private rojerusan.RSButtonHover btnBuscar;
    private rojerusan.RSButtonHover btnBuscar1;
    private rojerusan.RSButtonHover btnBuscar3;
    private rojerusan.RSButtonHover btnBuscarProducto;
    private newscomponents.RSButtonBigIcon_new btnClientes;
    private rojerusan.RSButtonHover btnDarDeBaja;
    private newscomponents.RSButtonBigIcon_new btnDetalleFactura;
    private newscomponents.RSButtonBigIcon_new btnFactura;
    private rojerusan.RSButtonHover btnGuardar;
    private rojerusan.RSButtonHover btnGuardar1;
    private RSMaterialComponent.RSButtonIconDos btnMinimizar;
    private RSMaterialComponent.RSButtonIconDos btnMinimizar1;
    private rojerusan.RSButtonHover btnNuevoCliente;
    private newscomponents.RSButtonIcon_new btnRegresar;
    private RSMaterialComponent.RSButtonIconDos btnSalir;
    private RSMaterialComponent.RSButtonIconDos btnSalir1;
    private newscomponents.RSButtonBigIcon_new btnVentas;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private necesario.LabelIcon labelIcon10;
    private necesario.LabelIcon labelIcon11;
    private necesario.LabelIcon labelIcon12;
    private necesario.LabelIcon labelIcon13;
    private necesario.LabelIcon labelIcon5;
    private necesario.LabelIcon labelIcon6;
    private necesario.LabelIcon labelIcon7;
    private necesario.LabelIcon labelIcon8;
    private necesario.LabelIcon labelIcon9;
    private rojeru_san.rsdate.RSLabelFecha rSLabelFecha1;
    private rojeru_san.rsdate.RSLabelFecha rSLabelFecha2;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora2;
    private necesario.RSLabelImage rSLabelImage2;
    private necesario.RSLabelImage rSLabelImage3;
    private necesario.RSLabelImage rSLabelImage4;
    private necesario.RSLabelImage rSLabelImage5;
    private RSMaterialComponent.RSTableMetro tbtClientes;
    private RSMaterialComponent.RSTableMetro tbtClientes1;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodProducto;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNroFactura;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
