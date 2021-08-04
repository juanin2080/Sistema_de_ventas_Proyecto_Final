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
import modelo.Persona;

/**
 *
 * @author María Castillo
 */
public class facturaTest {
        public static void main(String[] args) {
//        
        FacturaDAO fac1 = new FacturaDAO();
        Date fecha= new Date();
        Persona persona= new Persona();
        System.out.println(fac1.insertarFactura(fecha, "efectivo", true , "2", 10.00, 20.00, persona)); 
       
        //System.out.println(fac1.insertarFactura(fecha,"efectivo", true, "2", Double.valueOf(10.00), Double.valueOf(21.00)));

      //  System.out.println(fac1.darDeBajaPersona(Long.MIN_VALUE));


//s        DetalleFacturaDAO detalleF = new DetalleFacturaDAO();
//        System.out.println(detalleF.insertarDetalleFactura(10 , Double.valueOf(10.5), Double.valueOf(21.05)));
    }
}
