/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.PersonaJpaController;
import modelo.Persona;

/**
 *
 * @author juana
 */
public class PersonaDAO {

    private PersonaJpaController controladorPersona = new PersonaJpaController();
    private Persona persona = new Persona();
    private String mensaje = "";

    public String insertarPersona(String nombres, String cedula, String direccion, String telefono, String email, Boolean estado) {
        try {
            persona.setIdPersona(Long.MIN_VALUE);
            persona.setNombres(nombres);
            persona.setCedula(cedula);
            persona.setDireccion(direccion);
            persona.setTelefono(telefono);
            persona.setEmail(email);
            persona.setEstado(estado);
            controladorPersona.create(persona);
            mensaje = "Persona registrada con exito";
        } catch (Exception e) {
            mensaje = "No se pudo registrar la persona ";
            System.out.println(e.getMessage());
        }

        return mensaje;
    }

    public String actualizarPersona() {

        return null;
    }

    public String darDeBajaPersona() {

        return null;
    }
}
