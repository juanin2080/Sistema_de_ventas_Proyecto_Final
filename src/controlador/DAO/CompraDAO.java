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
import modelo.DetalleCompra;
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
    private ProductoDAO pdao = new ProductoDAO();

    private String mensaje = "";
    
    /**
     * Metodo para insertar la Compra 
     * @param nroCompra
     * @param fecha
     * @param iva
     * @param fPago
     * @param subtotal
     * @param total
     * @param idProveedor
     * @param idAci
     * @param estado
     * @return Este método retorna la compra con todos los parámetros ingresados
     */
    public Compra insertarCompra(String nroCompra, Date fecha, boolean iva, String fPago, double subtotal, double total, Long idProveedor, String idAci, Boolean estado) {
        try {
            compra.setIdCompra(Long.MIN_VALUE);
            compra.setNroCompra(nroCompra);
            compra.setFecha(fecha);
            compra.setIva(true);
            compra.setFormaPago(fPago);
            compra.setSubtotal(subtotal);
            compra.setTotal(total);
            compra.setExternal_IDProveedor(Long.valueOf(idProveedor));
            tjc.create(compra);
            JOptionPane.showMessageDialog(null, "Guardado correctamente");
        } catch (Exception e) {
            System.out.println("MENSAJE EN GUARDAR: " + e.getMessage());
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
     * @return retorna el stock de los productos agregados en la tablaCompra
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
     * @return Este método retorna la lista de productos de la bd 
     * que coincidad con el código escrito
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
     * @return retorna el producto que se desea comprar, teniendo en cuenta
     * su código y cantidad
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
     * @return retorna un producto de la lista productos
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
     * @return Este método retorna el subtotal de la lista de todos los productos ingresados.
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
     * @return retorna el producto
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
     * @return Retorna el nombre del proveedor que coincida con la cédula ingresada. 
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
     * @return retorna el Id de producto para poder guardarlo en la tabla Compra de la bd
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
     * @return retorna la lista de los proveedores de la bd que coincidan con la cédula ingresada 
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

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

}
    

