/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.DetalleFacturaJpaController;
import controlador.FacturaJpaController;
import java.util.Date;
import static modelo.Compra_.fecha;
import modelo.DetalleFactura;
import modelo.Factura;
import modelo.Persona;

/**
 *
 * @author María Castillo
 */
public class FacturaDAO {
//       private FacturaJpaController Controladorfactura= new FacturaJpaController();
//
//    private Factura factura= new Factura();
//    private String mensaje = "";
//    public String insertarFactura(Date fecha,String formaPago, Boolean iva,String nroFactura,Double subtotal,  Double total,Persona persona){
//        try{
//            factura.setIdFactura(Long.MIN_VALUE);
//            factura.setFecha( fecha);
//            factura.setFormaPago(formaPago);
//            factura.setIva(iva);
//            factura.setSubtotal(subtotal);
//            factura.setNroFactura(nroFactura);
//            factura.setTotal(total);
//            factura.setPersona(persona);
//            //factura.setIdPersona(Long.MIN_VALUE);
//            Controladorfactura.create(factura);
//            mensaje = "Factura registrada con exito";
//        }catch (Exception e){
//            mensaje = "No se pudo registrar la factura ";
//            System.out.println(e.getMessage());
//        }
//        return mensaje;
//    }
//    public String actualizarFactura(Long idFactura, Date fecha,String formaPago, Boolean iva,String nroFactura,Double subtotal,  Double total) {
//        try{
//            
//            factura.setIdFactura(idFactura);
//            factura.setFecha((Date) fecha);
//            factura.setFormaPago(formaPago);
//            factura.setIva(iva);
//            factura.setSubtotal(subtotal);
//            factura.setNroFactura(nroFactura);
//            factura.setTotal(total);
//           // factura.setIdPersona(Long.MIN_VALUE);
//            Controladorfactura.edit(factura);
//            mensaje = "Actualizado exitamente";
//        }catch (Exception e){
//            mensaje = "No se puede actualizar ";
//            System.out.println(e.getMessage());
//        }
//        return mensaje;
//    }
//
//    public String darDeBajaPersona(Long idFactura) {  
//        try{
//            Controladorfactura.destroy(idFactura);
//            mensaje = "Eliminado correctamente";
//        }catch(Exception e){
//               mensaje = "No se puede eliminar la informacion";
//            System.out.println("mensaje en eliminar"+ e.getMessage());
//        }
//        return mensaje;
//    }
}
