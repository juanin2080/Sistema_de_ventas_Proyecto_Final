/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.CompraJpaController;
import java.util.Date;
import modelo.Compra;

/**
 *
 * @author USUARIO
 */
public class CompraDAO {
    private CompraJpaController tjc = new CompraJpaController();
    private Compra compra = new Compra();
    private String mensaje = "";
    public String insertarCompra(String nroCompra, Date fecha, boolean iva, String fPago, double subtotal, double total){
        try {
            compra.setIdCompra(Long.MIN_VALUE);
            compra.setNroCompra(nroCompra);
            compra.setFecha(fecha);
            compra.setIva(true);
            compra.setfPago(fPago);
            compra.setSubtotal(subtotal);
            compra.setTotal(total);
            compra.setExternal_IDProveedor(Long.MIN_VALUE);
            tjc.create(compra); 
            mensaje = "Guardado correctamente";
        } catch (Exception e) {
            System.out.println("MENSAJE EN GUARDAR: " + e.getMessage());
            mensaje = "No se pudo guardar la informacion";
        }
        
        return mensaje;
    }
    public String actualizarCompra(Long id,String nroCompra, Date fecha, boolean iva, String fPago, double subtotal, double total){
         try {
            compra.setIdCompra(id);
            compra.setNroCompra(nroCompra);
            compra.setFecha(fecha);
            compra.setIva(true);
            compra.setfPago(fPago);
            compra.setSubtotal(subtotal);
            compra.setTotal(total);
            compra.setExternal_IDProveedor(Long.MIN_VALUE);
            tjc.edit(compra);
            mensaje = "Actualizado correctamente";
        } catch (Exception e) {
            System.out.println("MENSAJE EN GUARDAR: " + e.getMessage());
            mensaje = "No se pudo actualizar la informacion";
        }
        
        return mensaje;
        
        
    }
    public String eliminarCompra(Long id){
        try {
            tjc.destroy(id);
            mensaje = "Eliminado correctamente";
        } catch (Exception e) {
            mensaje = "No se pudo eliminar la informacion";
            System.out.println("MENSAJE EN GUARDAR: " + e.getMessage());
        }
        return mensaje;
    }
    
}
