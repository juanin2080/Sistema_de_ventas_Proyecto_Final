/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import controlador.DAO.DetalleFacturaDAO;
import controlador.DAO.FacturaDAO;
import controlador.DAO.PersonaDAO;
import java.util.Date;  
import modelo.Factura;
import modelo.Persona;
import modelo.Producto;
import modelo.Rol;

/**
 *
 * @author María Castillo
 */
public class FacturaTest {
    
        public static void main(String[] args) {      
        FacturaDAO fac1 = new FacturaDAO();
        Date fecha= new Date();  
        Persona persona = new Persona();
        persona.setIdPersona(Long.valueOf(1));
        DetalleFacturaDAO detallefac = new DetalleFacturaDAO();
        Factura factura= new Factura();
        factura.setIdFactura(Long.valueOf(1));
        Producto producto = new Producto();
        producto.setIdProducto(Long.valueOf(1));
            System.out.println(detallefac.insertarDetalleFactura(25, Double.valueOf(105.00), Double.valueOf(210.00), factura, producto));
        //System.out.println(fac1.insertarFactura(fecha,"tarjetaCredito", true, "3", Double.valueOf(205.00), Double.valueOf(21.00), persona));
       //System.out.println(fac1.actualizarFactura(Long.valueOf(1), fecha, "tarjetaCredito", true, "3", Double.valueOf(11.00), Double.valueOf(45.00), persona));
        }
}
