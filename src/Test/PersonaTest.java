/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import controlador.utilidades.Controladores;
import controlador.DAO.PersonaDAO;
import controlador.DAO.RolDAO;
import modelo.DetalleCompra;
import modelo.DetalleFactura;
import modelo.Rol;

/**
 *
 * @author juana
 */
public class PersonaTest {
    
    public static void main(String[] args) {
        PersonaDAO pDAO = new PersonaDAO();
        Boolean cedula;
        Controladores controles = new Controladores();
        cedula= controles.validadorDeCedula("1105650376");
        System.out.println(cedula);
//        RolDAO rDAO = new RolDAO();
//        rDAO.insertarRol("Administrador");
//        Rol rol = new Rol();
////        rol.setIdRol(Long.valueOf(1));
////        rol.setRol("Administrador");
////        ProductoDAO proDAO = new ProductoDAO();
////        DetalleCompra dc = new DetalleCompra();
////        DetalleFactura df = new DetalleFactura();
////        System.out.println(pDAO.insertarPersona("Kelly Nicol Preciado", "1109863567", "Sauces", "0998776557", "kellyNco@gmail.com", true));
////        System.out.println(pDAO.insertarPersona("Pedro Marco Rojas", "1178096543", "Argelia", "0954323222", "pedrito98@yahoo.com", true));
////        System.out.println(pDAO.actualizarPersona(Long.valueOf(100), "Juan Carlos Sanchez", "Daniel Alvarez", "0985559155", "juanarmijos@gmail.com", true));
////        pDAO.darDeBajaPersona(Long.valueOf(4));
////        System.out.println(pDAO.insertarPersona("Juan Carlos Armijos", "1150329887", "Daniel Alvarez", "0985559155", "juanarmijos@gmail.com", rol));
//        rDAO.insertarRol("Administrador");
//        rDAO.darDeBajaRol(Long.valueOf(11));
    }
}
