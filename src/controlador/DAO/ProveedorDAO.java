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

/**
 *
 * @author Usuario
 */
public class ProveedorDAO {

    private ProveedorJpaController controladorProveedor = new ProveedorJpaController();
    private PersonaJpaController controladorPersona = new PersonaJpaController();
    private Proveedor proveedor = new Proveedor();
    private Persona persona = new Persona();
    private String mensaje = "";

    public String insertarProveedor(String nombre, String Empresa, String Ruc ){
        try {
            persona.setNombres(nombre);
            proveedor.setEmpresa(Empresa);
            proveedor.setRuc(Ruc);
            controladorPersona.create(persona);
            controladorProveedor.create(proveedor);
            mensaje="Proveedor registrado con exito";
        } catch (Exception e) {
            System.out.println("mensaje en guardar: " + e.getMessage());
            mensaje = "No se pudo registrar el proveedor ";
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
    
    public List<Persona> buscarPersona(int cedula){
       Persona tbp;
       EntityManager em = controladorPersona.getEntityManager();
       Query query= em.createQuery("select p from Persona p where p.cedula like :cedula");
       query.setParameter("cedula", cedula+"%");
       List<Persona> lista=query.getResultList();
        
        return lista;
    }
}
