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

        System.out.println(fac1.insertarFactura(fecha,"efectivo", true, "2", Double.valueOf(10.00), Double.valueOf(21.00), persona));
        //System.out.println(fac1.actualizarFactura(Long.valueOf(24), fecha, "efectivo", true, "2", Double.valueOf(11.00), Double.valueOf(45.00), persona));
        }
}
