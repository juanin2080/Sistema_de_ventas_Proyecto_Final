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
    private String mensaje="";
    
    public String insertarProducto(int codigo, String nombre, Double precio, String Marca, String proveedor){
        try {
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setStock(0);
            producto.setMarca(Marca);
            producto.setEstado(true);
            producto.setProveedor(proveedor);
            controladorProducto.create(producto);
            
           mensaje="Producto registrado con exito";
        } catch (Exception e) {
            System.out.println("mensaje en guardar: " + e.getMessage());
            mensaje = "No se pudo registrar el producto ";
        }
        return mensaje;
    }
    
    public String editar(){
        return null;
    }
    
    public String dardeBaja(){
        return null;
    }
    public void listarProducto(JTable tabla) {
        DefaultTableModel model ;

        String[] titulo = {"CÓDIGO","NOMBRE","PRECIO","STOCK","MARCA","PROVEEDOR"};
        model= new DefaultTableModel(null, titulo);

        List<Producto> datos = controladorProducto.findProductoEntities();

        String[] listarProducto = new String[6];

        for (Producto product : datos) {
            listarProducto[0] = product.getCodigo() + "";
            listarProducto[1] = product.getNombre();
            listarProducto[2] = product.getPrecio() + "";
            listarProducto[3] = product.getStock() + "";
            listarProducto[4] = product.getMarca();
            listarProducto[5] = product.getProveedor();
            model.addRow(listarProducto);
        }
        tabla.setModel(model);
    }
 
}
