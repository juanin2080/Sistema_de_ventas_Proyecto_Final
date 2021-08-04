/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import controlador.DAO.FacturaDAO;
import java.util.Date;

/**
 *
 * @author María Castillo
 */
public class facturaTest {
        public static void main(String[] args) {
        
//     PersonaDAO pDAO = new PersonaDAO();
//     System.out.println(pDAO.insertarPersona("Rosa perez", "1105309448", "Daniel Alvarez", "0988517478", "juanarmijos@gmail.com", true));
//        
        FacturaDAO fac1 = new FacturaDAO();
        Date fecha= new Date();
    //System.out.println(fac1.actualizarFactura(Long.MIN_VALUE, fecha, "efectivo", true, "0005", Double.valueOf(0.5), Double.valueOf(10.5)));

      System.out.println(fac1.insertarFactura(fecha,"efectivo", true, "2", Double.valueOf(10.5), Double.valueOf(21.5)));

      //  System.out.println(fac1.darDeBajaPersona(Long.MIN_VALUE));


//        DetalleFacturaDAO detalleF = new DetalleFacturaDAO();
//        System.out.println(detalleF.insertarDetalleFactura(10 , Double.valueOf(10.5), Double.valueOf(21.05)));
    }
}
