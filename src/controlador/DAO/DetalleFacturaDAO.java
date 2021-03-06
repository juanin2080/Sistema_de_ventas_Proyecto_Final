/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.DetalleFacturaJpaController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import controlador.FacturaJpaController;
import modelo.DetalleFactura;
import modelo.Factura;
import modelo.Persona;
import modelo.Producto;

/**
 *
 * @author Juan Armijos, Cristian Capa, Maria Castillo, Kelly Preciado
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
            detalle.setNombreProducto(nombre);
            detalle.setPrecioUnitario(precioUnitario);
            detalle.setProducto(producto);
            detalle.setFactura(factura);
            detallefac.create(detalle);
            System.out.println("Detalle de Factura  registrada con exito");
        } catch (Exception e) {
            System.out.println("No se pudo registrar el Detalle de Factura ");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método para listar personas en un JTable
     * @param tabla
     * @param id
     */
    public void listarFactura(JTable tabla, Long id) {
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
