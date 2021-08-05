/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;


import controlador.DetalleFacturaJpaController;
import java.util.List;
import modelo.DetalleFactura;
import modelo.Factura;
import modelo.Producto;

/**
 *
 * @author María Castillo
 */
public class DetalleFacturaDAO {

    private DetalleFacturaJpaController detallefac = new  DetalleFacturaJpaController();
    private DetalleFactura detalle = new DetalleFactura();
    private String mensaje = "";
    public String insertarDetalleFactura(int cantidad, Double precioTotal, Double precioUnitario,Factura idFactura, Producto idProducto){
    try {
        detalle.setIdDetalleFactura(Long.MIN_VALUE);
        detalle.setCantidad(cantidad);
        detalle.setPrecioTotal(precioTotal);
        detalle.setPrecioUnitario(precioUnitario);
        detalle.setFactura(idFactura);
        detalle.setProducto(idProducto);
//        detalle.setIdDetalleFactura(idDetalleFactura);
        detallefac.create(detalle);
        mensaje = "Detalle de Factura  registrada con exito";
        } catch (Exception e) {
            mensaje = "No se pudo registrar el Detalle de Factura ";
            System.out.println(e.getMessage());
    }
    return mensaje;
    }
}
