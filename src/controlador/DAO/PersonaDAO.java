/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.PersonaJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author Juan Armijos, Cristian Capa, Maria Castillo, Kelly Preciado
 */
public class PersonaDAO {

    private PersonaJpaController controladorPersona = new PersonaJpaController();
    private Persona persona = new Persona();
    
    /**
     * Insertamos los datos de las personas en la bdd
     * @param nombres
     * @param cedula
     * @param direccion
     * @param telefono
     * @param email
     * @param rol
     */

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
            JOptionPane.showMessageDialog(null, "Persona registrada con exito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudo registrar a esa persona ");
        }

    }

    /**
     * Actualizamos los datos de la persona en la bdd
     * @param cedula
     * @param nombres
     * @param direccion
     * @param telefono
     * @param email
     * @param id
     * @param rol 
     */
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

    /**
     * Damos de baja a una persona, es decir que lo eliminamos de la bd
     * @param id 
     */
    public void darDeBajaPersona(Long id) {
        try {
            controladorPersona.destroy(id);
            System.out.println("Persona dado de baja.");
        } catch (Exception e) {
            System.out.println("Hubo un problema al dar de baja a la persona.");
        }

    }

    
    /**
     * Listamos los datos de las personas que estan en la bd en el jtable
     * @param tabla
     * @param cedula 
     */
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

    
    /**
     * Buscamos una persona por medio de su cédula
     * @param cedula
     * @return  retorna una lista de tipo persona
     */
    private List<Persona> buscarPersona(String cedula) {
        EntityManager em = controladorPersona.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Persona p WHERE p.cedula LIKE :cedula");
        query.setParameter("cedula", cedula + "%");
        List<Persona> lista = query.getResultList();
        return lista;
    }

    /**
     * Buscamos los roles de las personas por medio de su id
     * @param id
     * @return un dato de tipo persona
     */
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
    
    /**
     * Buscamos la cuenta de una persona
     * @param cedula
     * @return un dato de tipo persona
     */

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
