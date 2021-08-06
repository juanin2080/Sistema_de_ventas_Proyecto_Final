/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.CompraJpaController;
import controlador.ProductoJpaController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Compra;
import modelo.Producto;

/**
 *
 * @author USUARIO
 */
public class CompraDAO {

    private CompraJpaController tjc = new CompraJpaController();
    private ProductoJpaController controladorProducto = new ProductoJpaController();
    private Compra compra = new Compra();
    private Producto producto = new Producto();
    private String mensaje = "";
    private int respuestaStock;

    public String insertarCompra(String nroCompra, Date fecha, boolean iva, String fPago, double subtotal, double total) {
        try {
            compra.setIdCompra(Long.MIN_VALUE);
            compra.setNroCompra(nroCompra);
            compra.setFecha(fecha);
            compra.setIva(true);
            compra.setfPago(fPago);
            compra.setSubtotal(subtotal);
            compra.setTotal(total);
            compra.setExternal_IDProveedor(Long.MIN_VALUE);
            tjc.create(compra);
            mensaje = "Guardado correctamente";
        } catch (Exception e) {
            System.out.println("MENSAJE EN GUARDAR: " + e.getMessage());
            mensaje = "No se pudo guardar la informacion";
        }

        return mensaje;
    }

//    public String actualizarCompra(Long id, String nroCompra, Date fecha, boolean iva, String fPago, double subtotal, double total) {
//        try {
//            compra.setIdCompra(id);
//            compra.setNroCompra(nroCompra);
//            compra.setFecha(fecha);
//            compra.setIva(true);
//            compra.setfPago(fPago);
//            compra.setSubtotal(subtotal);
//            compra.setTotal(total);
//            compra.setExternal_IDProveedor(Long.MIN_VALUE);
//            tjc.edit(compra);
//            mensaje = "Actualizado correctamente";
//        } catch (Exception e) {
//            System.out.println("MENSAJE EN GUARDAR: " + e.getMessage());
//            mensaje = "No se pudo actualizar la informacion";
//        }
//
//        return mensaje;
//    }
//    public String eliminarCompra(Long id) {
//        try {
//            tjc.destroy(id);
//            mensaje = "Eliminado correctamente";
//        } catch (Exception e) {
//            mensaje = "No se pudo eliminar la informacion";
//            System.out.println("MENSAJE EN GUARDAR: " + e.getMessage());
//        }
//        return mensaje;
//    }
//
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
        int stock = calcularStock(datos, tablaCompra);
        System.out.println("stock" + stock);
        tablaCompra.setModel(model);
    }
    public int calcularStock(ArrayList<Producto> listaProductos, JTable tablaCompra) {
        int calcularStock = 0;
        
        for (Producto dato : listaProductos) {
            if (true) {
                
            }
            calcularStock += dato.getStock()+1;
            
        }
        return calcularStock;
    }

    private List<Producto> buscarProducto(String codigo) {
        Producto pd;
        EntityManager em = controladorProducto.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Producto p WHERE p.codigo like :codigo");
        query.setParameter("codigo", codigo + "%");
        List<Producto> lista = query.getResultList();
        return lista;
    }

    public Producto buscarProductoCompra(String codigo) {
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

    public double calcularSubtotal(ArrayList<Producto> listaProductos) {
        double subtotal = 0;
        for (Producto dato : listaProductos) {
            subtotal += dato.getPrecio();

        }
        return subtotal;
    }
      
}
