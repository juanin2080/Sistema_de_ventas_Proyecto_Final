/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.RolJpaController;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Rol;

/**
 *
 * @author juana
 */
public class RolDAO {

    private Rol rol = new Rol();
    private RolJpaController controladorRol = new RolJpaController();

    
    /**
     * Insertamos un rol, este servira para identificar que rol tiene cada persona.
     * @param rolPersona 
     */
    public void insertarRol(String rolPersona) {
        try {
            rol.setIdRol(Long.MIN_VALUE);
            rol.setRol(rolPersona);
            controladorRol.create(rol);
            JOptionPane.showMessageDialog(null, "Rol creado.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema al crear el rol.");
            System.out.println(e.getMessage());

        }

    }

    /**
     * Modificar el rol
     * @param id
     * @param rolPersona 
     */
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

    /**
     * Dar de baja al rol
     * @param id 
     */
    public void darDeBajaRol(Long id) {
        try {
            controladorRol.destroy(id);
            System.out.println("Rol dado de baja.");
        } catch (Exception e) {
            System.out.println("Hubo un problema al dar de baja al rol.");

        }

    }

    /**
     * Listar los datos en el jtable, para poder visualizar todos los roles que se han agregado
     * @param tabla 
     */
    public void listarRoles(JTable tabla) {
        DefaultTableModel modelo;
        String[] titulo = {"Rol"};
        modelo = new DefaultTableModel(null, titulo);
        List<Rol> datos = controladorRol.findRolEntities();
        String[] datosRol = new String[1];
        for (Rol rol : datos) {
            datosRol[0] = rol.getRol();
            modelo.addRow(datosRol);
        }
        tabla.setModel(modelo);

    }

    /**
     * Agregar los datos datos de Rol a un combo box 
     * @param cbxRol 
     */
    public void listarComboBox(JComboBox cbxRol) {
        List<Rol> datos = controladorRol.findRolEntities();
        for (Rol rol : datos) {
            cbxRol.addItem(rol.getRol());
        }
    }

    
    /**
     * Buscar los roles que existen en la bdd
     * @param rol
     * @return 
     */
    public Rol buscarRol(String rol) {
        Rol rolCbx = new Rol();
        List<Rol> datos = controladorRol.findRolEntities();
        for (Rol dato : datos) {
            if (dato.getRol().equals(rol)) {
                rolCbx.setIdRol(dato.getIdRol());
                rolCbx.setRol(dato.getRol());
            }

        }
        return rolCbx;

    }

}
