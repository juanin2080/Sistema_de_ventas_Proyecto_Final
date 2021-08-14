/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.CompraJpaController;
import controlador.ProductoJpaController;
import controlador.ProveedorJpaController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Compra;
import modelo.Producto;
import modelo.Proveedor;

/**
 *
 * @author USUARIO
 */
public class CompraDAO {

    private CompraJpaController tjc = new CompraJpaController();
    private ProductoJpaController controladorProducto = new ProductoJpaController();
    private ProveedorJpaController controladorProveedor = new ProveedorJpaController();
    private Compra compra = new Compra();
    private Producto producto = new Producto();
    private Proveedor provedor = new Proveedor();
    private ProductoDAO pdao = new ProductoDAO();
    private DetalleCompraDAO dcdao = new DetalleCompraDAO();
    private ProveedorDAO prdao = new ProveedorDAO();
    private String mensaje = "";
    
    /**
     * Método para insertar la compra
     * @param nroCompra
     * @param fecha
     * @param iva
     * @param fPago
     * @param subtotal
     * @param total
     * @param idProveedor
     * @return 
     */

    public Compra insertarCompra(String nroCompra, Date fecha, boolean iva, String fPago, double subtotal, double total, Long idProveedor) {
        try {
            compra.setIdCompra(Long.MIN_VALUE);
            compra.setNroCompra(nroCompra);
            compra.setFecha(fecha);
            compra.setIva(true);
            compra.setfPago(fPago);
            compra.setSubtotal(subtotal);
            compra.setTotal(total);
            compra.setExternal_IDProveedor(Long.valueOf(idProveedor));
            tjc.create(compra);
            mensaje = "Guardado correctamente";
            JOptionPane.showMessageDialog(null, "Guardado correctamente");
        } catch (Exception e) {
            System.out.println("MENSAJE EN GUARDAR: " + e.getMessage());
            mensaje = "No se pudo guardar la informacion";
            JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion");
        }
        return compra;
    }

    
    /**
     * Método para listar los productos en la tabla de compra de producto
     * @param tablaCompra
     * @param datos 
     */
    public void listarProducto(JTable tablaCompra, ArrayList<Producto> datos) {
        DefaultTableModel model;
        String[] titulo = {"CODIGO", "MARCA", "STOCK", "PRECIOUNITARIO"};
        model = new DefaultTableModel(null, titulo);
        String[] listarProducto = new String[4];
        Producto producto = new Producto();
        for (Producto dato : datos) {
            producto.setIdProducto(dato.getIdProducto());
            producto.setMarca(dato.getMarca());
            producto.setStock(dato.getStock());
            producto.setPrecio(dato.getPrecio());
            listarProducto[0] = dato.getCodigo() + "";
            listarProducto[1] = dato.getMarca();
            listarProducto[2] = dato.getStock() + "";
            listarProducto[3] = dato.getPrecio() + "";
            model.addRow(listarProducto);
        }
        tablaCompra.setModel(model);
    }
    
    /**
     * Metodo para calcular el stock, en este caso se van a agregar productos 
     * al stock
     * @param listaProductos
     * @param tablaCompra
     * @return 
     */
    public int calcularStock(ArrayList<Producto> listaProductos, JTable tablaCompra) {
        int calcularStock = 0;

        for (Producto dato : listaProductos) {
            if (true) {

            }
            calcularStock += dato.getStock() + 1;

        }
        return calcularStock;
    }

    /**
     * Método para buscar un producto en la BD
     * @param codigo
     * @return 
     */
    private List<Producto> buscarProducto(String codigo) {
        Producto pd;
        EntityManager em = controladorProducto.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Producto p WHERE p.codigo like :codigo");
        query.setParameter("codigo", codigo + "%");
        List<Producto> lista = query.getResultList();
        return lista;
    }

    /**
     * Métod para buscar el producto que se desea comprar, ingresando su 
     * código y cantidad
     * @param codigo
     * @param cantidad
     * @return 
     */
    public Producto buscarProductoCompra(String codigo, int cantidad) {
        List<Producto> datos = controladorProducto.findProductoEntities();
        Producto producto = new Producto();
        for (Producto dato : datos) {
            if (String.valueOf(dato.getCodigo()).equals(codigo)) {
                producto.setIdProducto(dato.getIdProducto());
                producto.setCodigo(dato.getCodigo());
                producto.setNombre(dato.getNombre());
                producto.setPrecio(dato.getPrecio());
                producto.setStock((dato.getStock() + cantidad));
                producto.setMarca(dato.getMarca());
                producto.setEstado(dato.getEstado());
                producto.setProveedor(dato.getProveedor());

            }
        }
        return producto;
    }

    /**
     * Método para agregar productos a la lista llamada datos que es de tipo Producto
     * @param codigo
     * @return 
     */
    public Producto buscarProductoC(String codigo) {
        List<Producto> datos = controladorProducto.findProductoEntities();
        Producto producto = new Producto();
        for (Producto dato : datos) {
            if (String.valueOf(dato.getCodigo()).equals(codigo)) {
                producto.setIdProducto(dato.getIdProducto());
                producto.setCodigo(dato.getCodigo());
                producto.setNombre(dato.getNombre());
                producto.setPrecio(dato.getPrecio());
                producto.setStock(dato.getStock());
                producto.setMarca(dato.getMarca());
                producto.setEstado(dato.getEstado());
                producto.setProveedor(dato.getProveedor());

            }
        }
        datos.add(producto);
        return producto;
    }

    /**
     * El siguiente método permite calcular el subtotal de todos los productos 
     * de los cuales se vaya a realizar la compra
     * @param listaProductos
     * @param cantidad
     * @return 
     */
    public double calcularSubtotal(ArrayList<Producto> listaProductos, int cantidad) {
        double subtotal = 0;
        for (Producto dato : listaProductos) {
            subtotal = (dato.getPrecio() * cantidad);
        }
        return subtotal;
    }

    /**
     * Método que permite realizar una búsqueda del producto por ID
     * @param idProducto
     * @return 
     */
    public Producto buscarProductoID(String idProducto) {
        List<Producto> datos = controladorProducto.findProductoEntities();
        Producto producto = new Producto();
        for (Producto dato : datos) {
            if (String.valueOf(dato.getCodigo()).equals(idProducto)) {
                producto.setIdProducto(dato.getIdProducto());
                producto.setCodigo(dato.getCodigo());
                producto.setNombre(dato.getNombre());
                producto.setPrecio(dato.getPrecio());
                producto.setStock(dato.getStock());
                producto.setMarca(dato.getMarca());
                producto.setEstado(dato.getEstado());
                producto.setProveedor(dato.getProveedor());

            }
        }
        return producto;
    }

    /**
     * Método para listar el nombre del proveedor, buscándolo por cédula
     * @param cedula
     * @return 
     */
    public String listarProveedor(String cedula) {
        String nombre = "";
        DefaultTableModel model;
        List<Proveedor> datos = buscarProveedor(cedula);
        for (Proveedor proveedor : datos) {
            nombre = proveedor.getNombres();
        }
        return nombre;
    }
    
    /**
     * Método para retornar el Id de la lista de los proveedores
     * @param cedula
     * @return 
     */
    public String retornarId(String cedula) {
        String id = "";

        DefaultTableModel model;
        List<Proveedor> datos = buscarProveedor(cedula);
        for (Proveedor proveedor : datos) {
            id = String.valueOf(proveedor.getIdPersona());
        }
        return id;
    }
    
    
    /**
     * Este método nos permite buscar un Proveedor por su cédula 
     * @param cedula
     * @return 
     */
    private List<Proveedor> buscarProveedor(String cedula) {
        Proveedor proveedor;
        EntityManager em = controladorProveedor.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Proveedor p WHERE p.cedula like :cedula");
        query.setParameter("cedula", cedula + "%");
        List<Proveedor> lista = query.getResultList();
        return lista;
    }

    /**
     * Método que nos va a permitir actualizar el stock en la BD
     * @param codigo
     * @param cantidad 
     */
    public void actualizarStockBD(String codigo, int cantidad) {
        Producto p = new Producto();
        p = buscarProductoCompra(codigo, cantidad);
        pdao.editar(p.getIdProducto(), p.getCodigo(), p.getNombre(), p.getPrecio(), p.getMarca(), p.getProveedor(), p.getStock());

    }
}
