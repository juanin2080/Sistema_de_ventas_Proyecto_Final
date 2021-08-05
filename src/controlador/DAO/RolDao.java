/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.RolJpaController;
import modelo.Rol;

/**
 *
 * @author María Castillo
 */
public class RolDAO {
    private Rol rol = new Rol();
    private RolJpaController controladorRol = new RolJpaController();

    public void insertarRol(String rolPersona) {
        try {
            rol.setIdRol(Long.MIN_VALUE);
            rol.setRol(rolPersona);
            controladorRol.create(rol);
            System.out.println("Rol creado.");
        } catch (Exception e) {
            System.out.println("Hubo un problema al crear el rol.");
            System.out.println(e.getMessage());

        }

    }

    public void actualizarRol(Long id, String rolPersona) {
        try {
            rol.setIdRol(id);
            rol.setRol(rolPersona);
            controladorRol.edit(rol);
            System.out.println("Rol actualizado.");
        } catch (Exception e) {
            System.out.println("Hubo un problema al actualizar el rol.");

        }

    }

    public void darDeBajaRol(Long id) {
        try {
            controladorRol.destroy(id);
            System.out.println("Rol dado de baja.");
        } catch (Exception e) {
            System.out.println("Hubo un problema al dar de baja al rol.");

        }

    }
}