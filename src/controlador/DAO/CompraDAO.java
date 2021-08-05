/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.CompraJpaController;
import controlador.ProductoJpaController;
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

    public String actualizarCompra(Long id, String nroCompra, Date fecha, boolean iva, String fPago, double subtotal, double total) {
        try {
            compra.setIdCompra(id);
            compra.setNroCompra(nroCompra);
            compra.setFecha(fecha);
            compra.setIva(true);
            compra.setfPago(fPago);
            compra.setSubtotal(subtotal);
            compra.setTotal(total);
            compra.setExternal_IDProveedor(Long.MIN_VALUE);
            tjc.edit(compra);
            mensaje = "Actualizado correctamente";
        } catch (Exception e) {
            System.out.println("MENSAJE EN GUARDAR: " + e.getMessage());
            mensaje = "No se pudo actualizar la informacion";
        }

        return mensaje;
    }

    public String eliminarCompra(Long id) {
        try {
            tjc.destroy(id);
            mensaje = "Eliminado correctamente";
        } catch (Exception e) {
            mensaje = "No se pudo eliminar la informacion";
            System.out.println("MENSAJE EN GUARDAR: " + e.getMessage());
        }
        return mensaje;
    }

    public void listarProducto(JTable tablaFactura, String codigo) {
        DefaultTableModel model;
        String[] titulo = {"CODIGO", "STOCK", "MARCA", "PRECIOUNITARIO"};
        model = new DefaultTableModel(null, titulo);
        List<Producto> datos = buscarProducto(codigo);
        String[] listarProducto = new String[4];
        for (Producto product : datos) {
            listarProducto[0] = product.getCodigo() + "";
            listarProducto[1] = product.getStock() + "";
            listarProducto[2] = product.getMarca();
            listarProducto[3] = product.getPrecio() + "";
            model.addRow(listarProducto);

        }
        tablaFactura.setModel(model);

    }

    private List<Producto> buscarProducto(String codigo) {
        Producto pd;
        EntityManager em = controladorProducto.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Producto p WHERE p.codigo like :codigo");
        query.setParameter("codigo", codigo + "%");
        List<Producto> lista = query.getResultList();
        return lista;
    }
    
    public double calcularSubtotal(){
        double subtotal = 0;
        List<Producto> datos = controladorProducto.findProductoEntities();
        for (Producto dato : datos) {
            subtotal += dato.getPrecio();
            
        }
        return subtotal;
    }
}
