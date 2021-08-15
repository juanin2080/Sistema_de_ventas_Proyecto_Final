/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.DetalleFacturaJpaController;
import javax.swing.JOptionPane;
//import controlador.FacturaJpaController;
import modelo.DetalleFactura;
import modelo.Factura;
import modelo.Producto;

/**
 *
 * @author María Castillo
 */
public class DetalleFacturaDAO {

    private DetalleFacturaJpaController detallefac = new DetalleFacturaJpaController();
    private DetalleFactura detalle = new DetalleFactura();
//    Producto produc = new Producto();
//    private String mensaje = "";

    public void insertarDetalleFactura(int cantidad, Double precioTotal, Double precioUnitario, Factura factura, Producto producto) {
        try {
            detalle.setIdDetalleFactura(Long.MIN_VALUE);
            detalle.setCantidad(cantidad);
            detalle.setPrecioTotal(precioTotal);
            detalle.setPrecioUnitario(precioUnitario);
            detalle.setProducto(producto);
            detalle.setFactura(factura);
            detallefac.create(detalle);
            JOptionPane.showMessageDialog(null, "Detalle de Factura  registrada con exito");
            System.out.println("Detalle de Factura  registrada con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el Detalle de Factura ");
            System.out.println("No se pudo registrar el Detalle de Factura ");
            System.out.println(e.getMessage());
        }
    }
}
