/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.CompraJpaController;
import controlador.DetalleCompraJpaController;
import controlador.ProductoJpaController;
import controlador.ProveedorJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.DetalleCompra;

import modelo.Compra;
import modelo.Producto;
import modelo.Proveedor;

/**
 *
 * @author juana
 */
public class DetalleCompraDAO {

    private DetalleCompraJpaController detalleCom = new DetalleCompraJpaController();
    private CompraJpaController cjpac = new CompraJpaController();
    private DetalleCompra detalle = new DetalleCompra();
    private Compra compra = new Compra();
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
       public void listarCompras(JTable tblListaCompras) {
        DefaultTableModel model;
        String[] titulo = {"FECHA","NROCOMPRA", "FORMA DE PAGO", "IVA", "TOTAL"};
        model = new DefaultTableModel(null, titulo);
        List<Compra> datos = cjpac.findCompraEntities();
        String[] listarCompra = new String[5];
        
        for (Compra dato : datos) {
            listarCompra[0] = dato.getFecha() + "";
            listarCompra[1] = dato.getNroCompra();
            listarCompra[2] = dato.getFormaPago() + "";          
            listarCompra[3] = dato.isIva() + "";
            listarCompra[4] = dato.getTotal() + "";
            model.addRow(listarCompra);
        }
        tblListaCompras.setModel(model);
    }
}
