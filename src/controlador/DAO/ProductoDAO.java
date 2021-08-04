/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ProductoJpaController;
import modelo.Producto;

/**
 *
 * @author juana
 */
public class ProductoDAO {

    ProductoJpaController controladorProducto;

    Producto producto;

    public void insertarProducto(int codigo, String nombre, Double precio, int stock, String marca, String estado, String proveedor) {
        try {
            producto.setCodigo(codigo);
            producto.setPrecio(precio);
            producto.setStock(stock);
            producto.setMarca(marca);
            producto.setEstado(true);
            producto.setProveedor(proveedor);
            controladorProducto.create(producto);
            System.out.println("Producto guardado");
        } catch (Exception e) {
            System.out.println("Producto no guardado");
        }
    }
}
