/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import controlador.DAO.PersonaDAO;
import controlador.DAO.ProveedorDAO;
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

//        ProductoDAO proDAO = new ProductoDAO();
//        DetalleCompra dc = new DetalleCompra();
//        DetalleFactura df = new DetalleFactura();
//        System.out.println(pDAO.insertarPersona("Juan Carlos Armijos", "1150329887", "Daniel Alvarez", "0985559155", "juanarmijos@gmail.com", true));
//        System.out.println(pDAO.insertarPersona("Kelly Nicol Preciado", "1109863567", "Sauces", "0998776557", "kellyNco@gmail.com", true));
//        System.out.println(pDAO.insertarPersona("Pedro Marco Rojas", "1178096543", "Argelia", "0954323222", "pedrito98@yahoo.com", true));
//        System.out.println(pDAO.actualizarPersona(Long.valueOf(24), "Juan Carlos Sanchez", "1150329887", "Daniel Alvarez", "0985559155", "juanarmijos@gmail.com", true));
//        System.out.println(pDAO.darDeBajaPersona(Long.valueOf(9)));
//        proDAO.insertarProducto(1111, "Nevera", 1500.0, 30, "Samsung", "1", "Luis");

        PersonaDAO pDao = new PersonaDAO();
        ProveedorDAO proDAO = new ProveedorDAO();
        
        RolDAO rDAO = new RolDAO();
        Rol rol = new Rol();
        rol.setIdRol(Long.valueOf(1));
        rol.setRol("Administrador");
        
       
        Rol rol1 = new Rol();
        rol1.setIdRol(Long.valueOf(2));
        rol1.setRol("Proveedor");
//        
//        rDAO.insertarRol("Proveedor");
        

//        rDAO.insertarRol("Administrador");

//        System.out.println(pDao.insertarPersona("Juan Carlos Armijos", "1150329887", "Daniel Alvarez", "0985559155", "juanarmijos@gmail.com", rol));
        System.out.println(proDAO.insertarProveedor("Cristian", "1105650376", "Loja", "255415", "cris.com", rol1, "LojaGAS", "1234"));
    }
}
