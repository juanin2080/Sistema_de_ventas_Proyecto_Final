package controlador.DAO;

import controlador.ProductoJpaController;
import modelo.Producto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class ProductoDAO {

    private ProductoJpaController controladorProducto = new ProductoJpaController();
    private Producto producto = new Producto();
    private String mensaje = "";

    public String insertarProducto(int codigo, String nombre, Double precio, int stock, String marca, Boolean estado, String proveedor) {
        try {
            producto.setIdProducto(Long.MIN_VALUE);
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setStock(stock);
            producto.setMarca(marca);
            producto.setEstado(estado);
            producto.setProveedor(proveedor);
            controladorProducto.create(producto);
            mensaje = "Producto registrado con exito";

        } catch (Exception e) {
            System.out.println("mensaje en guardar: " + e.getMessage());
            mensaje = "No se pudo registrar el producto ";
        }
        return mensaje;
    }
}
