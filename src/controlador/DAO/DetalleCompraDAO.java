/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.CompraJpaController;
import controlador.DetalleCompraJpaController;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.DetalleCompra;
import modelo.Compra;
import modelo.Producto;

/**
 *
 * @author Juan Armijos, Cristian Capa, Maria Castillo, Kelly Preciado
 */
public class DetalleCompraDAO {

    private DetalleCompraJpaController detalleCom = new DetalleCompraJpaController();
    private CompraJpaController cjpac = new CompraJpaController();
    private DetalleCompra detalle = new DetalleCompra();

    /**
     * Método para insertar los datos que pertenecen al detalle de la compra
     * @param nombreProducto
     * @param precioUnitario
     * @param compra
     * @param producto 
     */
    public void insertarDetalleCompra(String nombreProducto, Double precioUnitario, Compra compra, Producto producto) {
        try {
            detalle.setIdDCompra(Long.MIN_VALUE);
            detalle.setNombreProducto(nombreProducto);
            detalle.setPrecioUnitario(precioUnitario);
            detalle.setCompra(compra);
            detalle.setProducto(producto);
            detalleCom.create(detalle);
//            JOptionPane.showMessageDialog(null, "Detalle de Compra    registrada con exito");
            System.out.println("Detalle de Compra  registrada con exito");
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "No se pudo registrar el Detalle de Compra  ");
            System.out.println("No se pudo registrar el Detalle de Compra  ");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método para listar las compras en un JTable
     * @param tabla
     * @param id 
     */
    public void listarCompra(JTable tabla, Long id) {
        DefaultTableModel modelo;
        String[] titulo = {"IdDetalleCompra", "Nombre producto", "Precio Unitario", "Nro Compra", "idProducto", "Compra"};
        modelo = new DefaultTableModel(null, titulo);
        List<DetalleCompra> datos = detalleCom.findDetalleCompraEntities();
        String[] listarDetalle = new String[6];
        for (DetalleCompra detalle : datos) {
            if (detalle.getCompra().getIdCompra() == id) {
                listarDetalle[0] = String.valueOf(detalle.getIdDCompra());
                listarDetalle[1] = detalle.getNombreProducto();
                listarDetalle[2] = String.valueOf(detalle.getPrecioUnitario());
                listarDetalle[3] = String.valueOf(detalle.getCompra().getNroCompra());
                listarDetalle[4] = String.valueOf(detalle.getProducto());
                listarDetalle[5] = String.valueOf(detalle.getCompra());
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
