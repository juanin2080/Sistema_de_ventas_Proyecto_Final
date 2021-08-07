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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Persona;
import modelo.Producto;
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

    public void insertarProveedor(String nombres, String cedula, String direccion, String telefono, String email, Rol idRol, String empresa, String ruc) {

        List<Persona> datos = buscarPersona(cedula);

        for (Persona dato : datos) {
            if (dato.getCedula().equals(cedula)) {
                JOptionPane.showMessageDialog(null, "La cedula ya existe.\n Intente de nuevo");
            } else {
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
                JOptionPane.showMessageDialog(null, mensaje);

            }
        }

    }

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

    public String eliminar(Long id) {
        try {
            controladorProveedor.destroy(id);
            mensaje = "Proveedor eliminado con exito";

        } catch (Exception e) {
            System.out.println("No se pudo eliminar: " + e.getMessage());

            mensaje = "No se pudo eliminar el proveedor ";

        }
        return mensaje;
    }

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

    private List<Persona> buscarPersona(String cedula) {
        EntityManager em = controladorProveedor.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Persona p WHERE p.cedula LIKE :cedula");
        query.setParameter("cedula", cedula + "%");
        List<Persona> lista = query.getResultList();
        return lista;
    }

    public List<Proveedor> buscarProveedor(String id) {
        EntityManager em = controladorProveedor.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Proveedor p WHERE p.idPersona LIKE :id");
        query.setParameter("id", id + "%");
        List<Proveedor> lista = query.getResultList();
        return lista;
    }

}
