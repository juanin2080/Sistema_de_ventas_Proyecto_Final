/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.PersonaJpaController;
import controlador.ProveedorJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Persona;
import modelo.Proveedor;
import modelo.Rol;

/**
 *
 * @author Usuario
 */
public class ProveedorDAO {

    private ProveedorJpaController controladorProveedor = new ProveedorJpaController();
//    private PersonaJpaController controladorPersona = new PersonaJpaController();
    private Proveedor proveedor = new Proveedor();
//    private Persona persona = new Persona();
    private String mensaje = "";

   public String insertarProveedor(String nombres, String cedula, String direccion, String telefono, String email, Rol idRol, String empresa, String ruc) {
        try {
            proveedor.setIdPersona(Long.MIN_VALUE);
            proveedor.setNombres(nombres);
            proveedor.setCedula(cedula);
            proveedor.setDireccion(direccion);
            proveedor.setTelefono(telefono);
            proveedor.setEmail(email);
            proveedor.setRol(idRol);
            proveedor.setEmpresa(empresa);
            proveedor.setRuc(ruc);
            controladorProveedor.create(proveedor);
            mensaje = "Proveedor registrada con exito";
        } catch (Exception e) {
            mensaje = "No se pudo registrar el proveedor ";
            System.out.println(e.getMessage());
        }

        return mensaje;
    }
    
    
    public String actualizarDatos(int id, String Empresa, String Ruc){
        try {
            proveedor.setEmpresa(Empresa);
            proveedor.setRuc(Ruc);
            controladorProveedor.edit(proveedor);
            mensaje="Proveedor actualizado con exito";
        } catch (Exception e) {
            System.out.println("mensaje en guardar: " + e.getMessage());
            mensaje = "No se pudo actualizar el proveedor ";
        }
        return mensaje;
    }
    
    public String eliminar(Long id){
        try {
            controladorProveedor.destroy(id);
                        mensaje="Proveedor eliminado con exito";

        } catch (Exception e) {
                        System.out.println("No se pudo eliminar: " + e.getMessage());

                        mensaje = "No se pudo eliminar el proveedor ";

        }
        return  mensaje;
    }
//    
//    public List<Persona> buscarPersona(int cedula){
//       Persona tbp;
////       EntityManager em = controladorPersona.getEntityManager();
//       Query query= em.createQuery("select p from Persona p where p.cedula like :cedula");
//       query.setParameter("cedula", cedula+"%");
//       List<Persona> lista=query.getResultList();
//        
//        return lista;
//    }
}
