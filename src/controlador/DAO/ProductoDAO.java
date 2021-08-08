/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ProductoJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;

/**
 *
 * @author Usuario
 */
public class ProductoDAO {

    private ProductoJpaController controladorProducto = new ProductoJpaController();
    private Producto producto = new Producto();
    private String mensaje = "";

    public void insertarProducto(int codigo, String nombre, Double precio, String Marca, String proveedor, int cantidad) {

        try {
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setStock(cantidad);
            producto.setMarca(Marca);
            producto.setEstado(true);
            producto.setProveedor(proveedor);
            controladorProducto.create(producto);

            mensaje = "Producto registrado con exito";
        } catch (Exception e) {
            System.out.println("mensaje en guardar: " + e.getMessage());
            mensaje = "No se pudo registrar el producto ";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public String editar(Long id, int codigo, String nombre, Double precio, String Marca, String proveedor, int cantidad) {
        try {
            producto.setIdProducto(id);
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setStock(cantidad);
            producto.setMarca(Marca);
            producto.setEstado(true);
            producto.setProveedor(proveedor);
            controladorProducto.edit(producto);

            mensaje = "Producto actualizado con exito";
        } catch (Exception e) {
            System.out.println("mensaje en guardar: " + e.getMessage());
            mensaje = "No se pudo actualizar el producto ";
        }
        return mensaje;
    }

    public String dardeBaja(Long id, int codigo, String nombre, Double precio, String Marca, String proveedor, int cantidad) {
        try {
            producto.setIdProducto(id);
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setStock(cantidad);
            producto.setMarca(Marca);
            producto.setEstado(false);
            producto.setProveedor(proveedor);
            controladorProducto.edit(producto);

            mensaje = "Producto dado de baja con exito";
        } catch (Exception e) {
            System.out.println("mensaje en guardar: " + e.getMessage());
            mensaje = "No se pudo dar de baja el producto ";
        }
        return mensaje;
    }

    public void listarProducto(JTable tabla, String codigo) {
        DefaultTableModel model;

        String[] titulo = {"CÓDIGO", "NOMBRE", "PRECIO", "MARCA", "PROVEEDOR", "STOCK", "ID"};
        model = new DefaultTableModel(null, titulo);

        List<Producto> datos = buscarProducto(codigo);

        String[] listarProducto = new String[7];

        for (Producto product : datos) {
            if (product.getEstado() == true) {
                listarProducto[0] = product.getCodigo() + "";
                listarProducto[1] = product.getNombre();
                listarProducto[2] = product.getPrecio() + "";
                listarProducto[3] = product.getMarca();
                listarProducto[4] = product.getProveedor();
                listarProducto[5] = product.getStock() + "";
                listarProducto[6] = product.getIdProducto() + "";
                model.addRow(listarProducto);
            }
        }
        tabla.setModel(model);
        tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getColumnModel().getColumn(6).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
    }

    private List<Producto> buscarProducto(String codigo) {
        Producto pd;
        EntityManager em = controladorProducto.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Producto p WHERE p.codigo like :codigo");
        query.setParameter("codigo", codigo + "%");

        List<Producto> lista = query.getResultList();
        return lista;
    }
//    public String actualizarStockBD(Long id, int codigo, String nombre, Double precio, String Marca, String proveedor, int stock, int cantidad) {
//        try {
//            producto.setIdProducto(id);
//            producto.setCodigo(codigo);
//            producto.setNombre(nombre);
//            producto.setPrecio(precio);
//            producto.setStock(stock+cantidad);
//            producto.setMarca(Marca);
//            producto.setEstado(true);
//            producto.setProveedor(proveedor);
//            controladorProducto.edit(producto);
//
//            mensaje = "Producto actualizado con exito";
//        } catch (Exception e) {
//            System.out.println("mensaje en guardar: " + e.getMessage());
//            mensaje = "No se pudo actualizar el producto ";
//        }
//        return mensaje;
//    }
}
