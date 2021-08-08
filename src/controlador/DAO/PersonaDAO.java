/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.PersonaJpaController;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author juana
 */
public class PersonaDAO {

    private PersonaJpaController controladorPersona = new PersonaJpaController();
    private Persona persona = new Persona();

    public void insertarPersona(String nombres, String cedula, String direccion, String telefono, String email, Rol rol) {
        try {

            persona.setIdPersona(Long.MIN_VALUE);
            persona.setNombres(nombres);
            persona.setCedula(cedula);
            persona.setDireccion(direccion);
            persona.setTelefono(telefono);
            persona.setEmail(email);
            persona.setRol(rol);
            controladorPersona.create(persona);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void actualizarPersona(String cedula, String nombres, String direccion, String telefono, String email, Long id, Rol rol) {
        try {
            persona.setIdPersona(id);
            persona.setNombres(nombres);
            persona.setCedula(cedula);
            persona.setDireccion(direccion);
            persona.setTelefono(telefono);
            persona.setEmail(email);
            persona.setRol(rol);
            controladorPersona.edit(persona);
            JOptionPane.showMessageDialog(null, "Persona actualizada con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la persona");
            System.out.println(e.getMessage());
        }

    }

    public void darDeBajaPersona(Long id) {
        try {
            controladorPersona.destroy(id);
            System.out.println("Persona dado de baja.");
        } catch (Exception e) {
            System.out.println("Hubo un problema al dar de baja a la persona.");
        }

    }

    public void listarPersonas(JTable tabla, String cedula) {
        DefaultTableModel modelo;
        String[] titulo = {"Cédula", "Nombres", "Teléfono", "Dirección", "Email", "Id", "Rol"};
        modelo = new DefaultTableModel(null, titulo);
        List<Persona> datos = buscarPersona(cedula);
        String[] datosPersona = new String[7];
        for (Persona persona : datos) {
            datosPersona[0] = persona.getCedula();
            datosPersona[1] = persona.getNombres();
            datosPersona[2] = persona.getTelefono();
            datosPersona[3] = persona.getDireccion();
            datosPersona[4] = persona.getEmail();
            datosPersona[5] = persona.getIdPersona() + "";
            datosPersona[6] = persona.getRol() + "";
            modelo.addRow(datosPersona);
        }
        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla.getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getColumnModel().getColumn(6).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
    }

    private List<Persona> buscarPersona(String cedula) {
        EntityManager em = controladorPersona.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Persona p WHERE p.cedula LIKE :cedula");
        query.setParameter("cedula", cedula + "%");
        List<Persona> lista = query.getResultList();
        return lista;
    }

    public Persona buscarRolPersona(Long id) {
        List<Persona> datos = controladorPersona.findPersonaEntities();
        Persona persona = new Persona();
        for (Persona dato : datos) {
            if (id == dato.getIdPersona()) {
                persona.setIdPersona(dato.getIdPersona());
                persona.setNombres(dato.getNombres());
                persona.setCedula(dato.getCedula());
                persona.setDireccion(dato.getDireccion());
                persona.setTelefono(dato.getTelefono());
                persona.setEmail(dato.getEmail());
                persona.setRol(dato.getRol());
            }

        }
        return persona;

    }

    public Persona BuscarCuentaPersona(String cedula) {
        Persona person = new Persona();
        List<Persona> datos = controladorPersona.findPersonaEntities();
        for (Persona dato : datos) {
            if (dato.getCedula().equals(cedula)) {
                person.setIdPersona(dato.getIdPersona());
                person.setNombres(dato.getNombres());
                person.setCedula(dato.getCedula());
                person.setTelefono(dato.getTelefono());
                person.setEmail(dato.getEmail());
                person.setRol(dato.getRol());
            }

        }
        return person;
    }

}
