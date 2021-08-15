/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.DetalleCompraJpaController;
import javax.swing.JOptionPane;
import modelo.DetalleCompra;

import modelo.Compra;
import modelo.Producto;

/**
 *
 * @author juana
 */
public class DetalleCompraDAO {

    private DetalleCompraJpaController detalleCom = new DetalleCompraJpaController();
    private DetalleCompra detalle = new DetalleCompra();

    public void insertarDetalleCompra(int cantidad, Double precioTotal, Double precioUnitario, Compra compra, Producto producto) {
        try {
            detalle.setIdDCompra(Long.MIN_VALUE);
            detalle.setCantidad(cantidad);
            detalle.setPrecioTotal(precioTotal);
            detalle.setPrecioUnitario(precioUnitario);
            detalle.setCompra(compra);
            detalle.setProducto(producto);
            detalleCom.create(detalle);

            JOptionPane.showMessageDialog(null, "Detalle de Compra    registrada con exito");
            System.out.println("Detalle de Compra  registrada con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el Detalle de Compra  ");
            System.out.println("No se pudo registrar el Detalle de Compra  ");
            System.out.println(e.getMessage());
        }
    }

}
