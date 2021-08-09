/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import controlador.DAO.DetalleFacturaDAO;
import controlador.DAO.FacturaDAO;
import controlador.DAO.PersonaDAO;
import controlador.utilidades.Controladores;
import java.util.Date;
import modelo.Persona;
import modelo.Producto;
import vista.Factura;


/**
 *
 * @author María Castillo
 */
public class facturaTest {
    
        public static void main(String[] args) {  
            Controladores controles= new Controladores();
            boolean letras= controles.contieneSoloLetras("aaaa");
            if (letras== true) {
                System.out.println("tiene solo letras");
            }else{
                System.out.println("Tiene numeros");
            }
//            
//            
//       FacturaDAO fac1 = new FacturaDAO();
//       Factura fac = new Factura();
//       fac.setVisible(true);    
//       
//        Date fecha= new Date();  
//        Persona persona = new Persona();
//        persona.setIdPersona(Long.valueOf(1));
//        DetalleFacturaDAO detallefac = new DetalleFacturaDAO();
//        Factura factura= new Factura();
//        factura.setIdFactura(Long.valueOf(1));
//        Producto producto = new Producto();
//        producto.setIdProducto(Long.valueOf(1));
//           System.out.println(detallefac.insertarDetalleFactura(25, Double.valueOf(105.00), Double.valueOf(210.00), factura, producto));
////        //System.out.println(fac1.insertarFactura(fecha,"tarjetaCredito", true, "3", Double.valueOf(205.00), Double.valueOf(21.00), persona));
//       //System.out.println(fac1.actualizarFactura(Long.valueOf(1), fecha, "tarjetaCredito", true, "3", Double.valueOf(11.00), Double.valueOf(45.00), persona));
        }
}
