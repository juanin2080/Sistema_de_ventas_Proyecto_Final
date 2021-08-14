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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Persona;
import modelo.Proveedor;
import modelo.Rol;

/**
 *
 * @author Usuario
 */
public class ProveedorDAO {

    
    private ProveedorJpaController controladorProveedor = new ProveedorJpaController();
    private PersonaJpaController controladorPersona = new PersonaJpaController();
    private Proveedor proveedor = new Proveedor();
//    private Persona persona = new Persona();
    private String mensaje = "";

    /**
     * Método para insertar un proveedor, el cual primero verifica si ya existe
     * la cedula o no, en caso de no existir lo agrega a la bd.
     * @param nombres
     * @param cedula
     * @param direccion
     * @param telefono
     * @param email
     * @param idRol
     * @param empresa
     * @param ruc
     * @return 
     */
    public String insertarProveedor(String nombres, String cedula, String direccion, String telefono, String email, Rol idRol, String empresa, String ruc) {

        if (validar(cedula) == 1) {
            mensaje = "Ya existe un proveedor con esa cedula";
        } else {
            try {
                proveedor.setNombres(nombres);
                proveedor.setCedula(cedula);
                proveedor.setDireccion(direccion);
                proveedor.setTelefono(telefono);
                proveedor.setEmail(email);
                proveedor.setRol(idRol);
                proveedor.setEmpresa(empresa);
                proveedor.setRuc(ruc);
                controladorPersona.create(proveedor);
                mensaje = "Proveedor registrada con exito";
            } catch (Exception e) {
                mensaje = "No se pudo registrar el proveedor ";
                System.out.println(e.getMessage());
            }
        }

        return mensaje;
    }
    
    /**
     *  Método para actualizar los datos del proveedor, este funciona a traves de
     * su id.
     * @param id
     * @param nombres
     * @param cedula
     * @param direccion
     * @param telefono
     * @param email
     * @param idRol
     * @param empresa
     * @param ruc
     * @return 
     */
    public String actualizarDatos(Long id, String nombres, String cedula, String direccion, String telefono, String email, Rol idRol, String empresa, String ruc) {
        try {
            proveedor.setIdPersona(id);
            proveedor.setRol(idRol);
            proveedor.setNombres(nombres);
            proveedor.setCedula(cedula);
            proveedor.setDireccion(direccion);
            proveedor.setTelefono(telefono);
            proveedor.setEmail(email);
            proveedor.setEmpresa(empresa);
            proveedor.setRuc(ruc);
            controladorProveedor.edit(proveedor);
            mensaje = "Proveedor actualizado con exito";
        } catch (Exception e) {
            mensaje = "No se pudo actualizar el proveedor ";
            System.out.println(e.getMessage());
        }

        return mensaje;
    }

//    public String eliminar(Long id) {
//        try {
//            controladorProveedor.destroy(id);
//            mensaje = "Proveedor eliminado con exito";
//
//        } catch (Exception e) {
//            System.out.println("No se pudo eliminar: " + e.getMessage());
//
//            mensaje = "No se pudo eliminar el proveedor ";
//
//        }
//        return mensaje;
//    }
    /**
     * Método para listar los proveedores, presentamos todos los proveedores en
     * una jtable recorremos dos for el primero es para recorrer los datos de
     * personas que constan en la bdd como proveedores mientras que la otra
     * recorremos los datos de proveedores que constan en la bdd, ambas tablas
     * estan conectadas por un idpersona, por lo cual tambien hago una condición
     * en que si ambos id de las tablas son iguales los presente en el jtable.
     * @param tabla
     * @param cedula 
     */
    public void listarPersonas(JTable tabla, String cedula) {
        String[] datosPersona = new String[9];
        DefaultTableModel modelo;
        String[] titulo = {"Cédula", "Nombres", "Teléfono", "Dirección", "Email", "Ruc", "Empresa", "Id", "Rol"};
        modelo = new DefaultTableModel(null, titulo);

        List<Persona> datos = buscarPersona(cedula);
        List<Proveedor> datosPro = buscarProveedor(cedula);
        String ruc = "";

        for (Persona persona : datos) {
            for (Proveedor proveedor1 : datosPro) {
                if (persona.getIdPersona().equals(proveedor1.getIdPersona())) {
                    datosPersona[0] = persona.getCedula();
                    datosPersona[1] = persona.getNombres();
                    datosPersona[2] = persona.getTelefono();
                    datosPersona[3] = persona.getDireccion();
                    datosPersona[4] = persona.getEmail();
                    datosPersona[5] = proveedor1.getRuc();
                    datosPersona[6] = proveedor1.getEmpresa();
                    datosPersona[7] = persona.getIdPersona() + "";
                    datosPersona[8] = persona.getRol() + "";

                    modelo.addRow(datosPersona);
                }
            }
        }

        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(7).setMaxWidth(0);
        tabla.getColumnModel().getColumn(7).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
        tabla.getColumnModel().getColumn(8).setMaxWidth(0);
        tabla.getColumnModel().getColumn(8).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);
    }
    
    /**
     * Método para buscar los datos de una persona en la bdd.
     * @param cedula
     * @return 
     */
    private List<Persona> buscarPersona(String cedula) {
        EntityManager em = controladorProveedor.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Persona p WHERE p.cedula LIKE :cedula");
        query.setParameter("cedula", cedula + "%");
        List<Persona> lista = query.getResultList();
        return lista;
    }

    /**
     *  Metodo para buscar los datos del proveedor de la tabla proveedor en la bdd.
     * @param id
     * @return 
     */
    public List<Proveedor> buscarProveedor(String id) {
        EntityManager em = controladorProveedor.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Proveedor p WHERE p.idPersona LIKE :id");
        query.setParameter("id", id + "%");
        List<Proveedor> lista = query.getResultList();
        return lista;
    }

    /**
     *  Metodo para validar si la cedula es verdadera o falsa.
     * @param cedula
     * @return 
     */
    public int validar(String cedula) {
        boolean estado = true;
        List<Persona> datos = listarProveedores("%");

        System.out.println(datos.size());
        for (Persona dato : datos) {
            System.out.println(dato.getCedula());
            if (dato.getCedula().equals(cedula)) {
                estado = true;
                break;
            } else {
                estado = false;
            }
        }
        if (estado == true) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Metodo para buscar todos los proveedores en la bdd
     * a traves de su cedula y luego comprobar si si la cedula ya existe o no 
     * @param cedula
     * @return 
     */
    public List<Persona> listarProveedores(String cedula) {
        EntityManager em = controladorPersona.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Persona p WHERE p.cedula like :cedula");
        query.setParameter("cedula", cedula + "%");

        List<Persona> lista = query.getResultList();
        return lista;
    }

}
