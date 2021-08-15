/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.DetalleFacturaJpaController;
import controlador.FacturaJpaController;
//import controlador.FacturaJpaController;
import controlador.ProductoJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
    /**
     * Método para insertar datos correspondientes al detalle de factura a la BD
     * @param nombre
     * @param precioUnitario
     * @param factura
     * @param producto 
     */
    public void insertarDetalleFactura(String nombre, Double precioUnitario, Factura factura, Producto producto) {
        try {
            detalle.setIdDetalleFactura(Long.MIN_VALUE);
//            detalle.setCantidad(cantidad);
//            detalle.setPrecioTotal(precioTotal);
            detalle.setNombreProducto(nombre);
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
