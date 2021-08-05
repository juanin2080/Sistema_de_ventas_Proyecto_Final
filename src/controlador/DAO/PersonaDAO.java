/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.PersonaJpaController;
import java.util.List;
import javax.persistence.EntityManager;
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
    private String mensaje = "";

    public String insertarPersona(String nombres, String cedula, String direccion, String telefono, String email, Rol idRol) {
        try {
            persona.setIdPersona(Long.MIN_VALUE);
            persona.setNombres(nombres);
            persona.setCedula(cedula);
            persona.setDireccion(direccion);
            persona.setTelefono(telefono);
            persona.setEmail(email);
            persona.setRol(idRol);
            controladorPersona.create(persona);
            mensaje = "Persona registrada con exito";
        } catch (Exception e) {
            mensaje = "No se pudo registrar la persona ";
            System.out.println(e.getMessage());
        }

        return mensaje;
    }

    public String actualizarPersona(Long id, String cedula, String nombres, String direccion, String telefono, String email) {
        try {
            persona.setIdPersona(id);
            persona.setNombres(nombres);
            persona.setCedula(cedula);
            persona.setDireccion(direccion);
            persona.setTelefono(telefono);
            persona.setEmail(email);
            controladorPersona.edit(persona);
            mensaje = "Persona actualizada con exito";
            JOptionPane.showMessageDialog(null, "Persona actualizada con exito");
        } catch (Exception e) {
            mensaje = "No se pudo actualizar la persona";
            JOptionPane.showMessageDialog(null, "No se pudo actualizar la persona");
            System.out.println(e.getMessage());
        }

        return mensaje;

    }

    public String darDeBajaPersona(Long id) {
        try {
            controladorPersona.destroy(id);
            mensaje = "Persona dada de baja con exito";
        } catch (Exception e) {
            mensaje = "Persona no dada de baja con exito";
            System.out.println(e.getMessage());
        }
        return mensaje;
    }

    public void listarPersonas(JTable tabla) {
        DefaultTableModel modelo;
        String[] titulo = {"Cédula", "Nombres", "Teléfono", "Dirección", "Email"};
        modelo = new DefaultTableModel(null, titulo);
        List<Persona> datos = controladorPersona.findPersonaEntities();
        String[] datosPersona = new String[5];
        for (Persona persona : datos) {
            datosPersona[0] = persona.getCedula();
            datosPersona[1] = persona.getNombres();
            datosPersona[2] = persona.getTelefono();
            datosPersona[3] = persona.getDireccion();
            datosPersona[4] = persona.getEmail();
            modelo.addRow(datosPersona);
        }
        tabla.setModel(modelo);
    }
//    public List<Persona> buscarPersona(){
//    
//    SELECT p FROM Persona p WHERE p.cedula LIKE '1%'
//    }
  
}
