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
import modelo.Persona;
import modelo.Producto;

/**
 *
 * @author María Castillo
 */
public class DetalleFacturaDAO {

    private DetalleFacturaJpaController detallefac = new DetalleFacturaJpaController();
    private DetalleFactura detalle = new DetalleFactura();

//    public void insertarDetalleFactura(int cantidad, Double precioTotal, Double precioUnitario, Factura factura, Producto producto) {
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
//            JOptionPane.showMessageDialog(null, "Detalle de Factura  registrada con exito");
            System.out.println("Detalle de Factura  registrada con exito");
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "No se pudo registrar el Detalle de Factura ");
            System.out.println("No se pudo registrar el Detalle de Factura ");
            System.out.println(e.getMessage());
        }
    }

    public void listarPersonas(JTable tabla, Long id) {
        DefaultTableModel modelo;
        String[] titulo = {"IdDetalleFactura", "Nombre producto", "Precio Unitario", "Nro Factura", "idProducto", "idFactura"};
        modelo = new DefaultTableModel(null, titulo);
        List<DetalleFactura> datos = detallefac.findDetalleFacturaEntities();
        String[] listarDetalle = new String[6];
        for (DetalleFactura detalle : datos) {
            if (detalle.getFactura().getIdFactura() == id) {
                listarDetalle[0] = String.valueOf(detalle.getIdDetalleFactura());
                listarDetalle[1] = detalle.getNombreProducto();
                listarDetalle[2] = String.valueOf(detalle.getPrecioUnitario());
                listarDetalle[3] = String.valueOf(detalle.getFactura().getNroFactura());
                listarDetalle[4] = String.valueOf(detalle.getProducto());
                listarDetalle[5] = String.valueOf(detalle.getFactura());
                modelo.addRow(listarDetalle);

            }

        }
        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla.getColumnModel().getColumn(4).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
        tabla.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla.getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);

    }
}
