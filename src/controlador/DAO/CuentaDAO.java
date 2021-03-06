/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.CuentaJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cuenta;
import modelo.Persona;

/**
 *
 * @author Juan Armijos, Cristian Capa, Maria Castillo, Kelly Preciado
 */
public class CuentaDAO {

    private CuentaJpaController controladorCuenta = new CuentaJpaController();
    private Cuenta cuenta = new Cuenta();

    
    /**
     * Método para crear una cuenta.
     * @param usuario
     * @param clave
     * @param estado
     * @param persona 
     */
    public void insertarCuenta(String usuario, String clave, Boolean estado, Persona persona) {
        try {
            cuenta.setIdCuenta(Long.MIN_VALUE);
            cuenta.setUsuario(usuario);
            cuenta.setClave(clave);
            cuenta.setEstado(estado);
            cuenta.setPersona(persona);
            controladorCuenta.create(cuenta);
            JOptionPane.showMessageDialog(null, "Cuenta creada con exito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un error al crear su cuenta");
        }

    }

    /**
     * Método para actualizar los datos de la cuenta
     * @param id
     * @param usuario
     * @param clave
     * @param estado
     * @param persona 
     */
    public void actualizarCuenta(Long id, String usuario, String clave, Boolean estado, Persona persona) {
        try {
            cuenta.setIdCuenta(id);
            cuenta.setUsuario(usuario);
            cuenta.setClave(clave);
            cuenta.setEstado(estado);
            cuenta.setPersona(persona);
            controladorCuenta.edit(cuenta);
            JOptionPane.showMessageDialog(null, "Cuenta actualizada con exito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar su cuenta");
        }

    }

    
    /**
     * Método para eliminar la cuenta de la bd
     * @param id 
     */
    public void eliminarCuenta(Long id) {
        try {
            controladorCuenta.destroy(id);
            System.out.println("Cuenta eliminada de la BD");
        } catch (Exception e) {
            System.out.println("Hubo un error al eliminar la cuenta");
        }
    }

    /**
     * Método para listar los datos de la bd en un jtable 
     * @param tabla
     * @param usuario 
     */
    public void listarCuentas(JTable tabla, String usuario) {
        DefaultTableModel modelo;
        String[] titulo = {"IdCuenta", "Clave", "Usuario", "Estado", "IdPersona", "Cédula", "Nombres"};
        modelo = new DefaultTableModel(null, titulo);
        List<Cuenta> datos = buscarCuentas(usuario);
        String[] datosCuenta = new String[7];
        for (Cuenta cuenta : datos) {
            if (cuenta.getEstado() == true) {
                datosCuenta[0] = cuenta.getIdCuenta() + "";
                datosCuenta[1] = cuenta.getClave();
                datosCuenta[2] = cuenta.getUsuario();
                datosCuenta[3] = cuenta.getEstado() + "";
                datosCuenta[4] = cuenta.getPersona().getIdPersona() + "";
                datosCuenta[5] = cuenta.getPersona().getCedula() + "";
                datosCuenta[6] = cuenta.getPersona().getNombres();
                modelo.addRow(datosCuenta);
            }

        }
        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(1).setMaxWidth(0);
        tabla.getColumnModel().getColumn(1).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        tabla.getColumnModel().getColumn(3).setMaxWidth(0);
        tabla.getColumnModel().getColumn(3).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
        tabla.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla.getColumnModel().getColumn(4).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);

    }

    /**
     * Buscamos las cuentas en la bd
     * @param usuario
     * @return 
     */
    private List<Cuenta> buscarCuentas(String usuario) {
        EntityManager em = controladorCuenta.getEntityManager();
        Query query = em.createQuery("SELECT c FROM Cuenta c WHERE c.usuario LIKE :usuario");
        query.setParameter("usuario", usuario + "%");
        List<Cuenta> lista = query.getResultList();
        return lista;
    }

    
    /**
     * Método para dar de baja una cuenta
     * @param id
     * @param usuario
     * @param clave
     * @param estado
     * @param persona 
     */
    public void darDeBajaCuenta(Long id, String usuario, String clave, Boolean estado, Persona persona) {
        try {
            cuenta.setIdCuenta(id);
            cuenta.setUsuario(usuario);
            cuenta.setClave(clave);
            cuenta.setEstado(estado);
            cuenta.setPersona(persona);
            controladorCuenta.edit(cuenta);
            JOptionPane.showMessageDialog(null, "Cuenta dada de baja con exito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Hubo un error al dar de baja a su cuenta");
        }
    }

    
    /**
     * Método para autenticar una cuenta
     * @param usuario
     * @param clave
     * @return 
     */
    public Cuenta autenticacion(String usuario, String clave) {
        Cuenta cuentaPersona = new Cuenta();
        List<Cuenta> datos = controladorCuenta.findCuentaEntities();
        try {
            for (Cuenta cuenta : datos) {
                if (cuenta.getUsuario().equals(usuario) && cuenta.getClave().equals(clave)) {
                    cuentaPersona.setIdCuenta(cuenta.getIdCuenta());
                    cuentaPersona.setUsuario(cuenta.getUsuario());
                    cuentaPersona.setClave(cuenta.getClave());
                    cuentaPersona.setEstado(cuenta.getEstado());
                    cuentaPersona.setPersona(cuenta.getPersona());
                    System.out.println("Entro a verificar los datos");
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Este usuario no está registrado o su tipo de usuario no es permitido en el sistema");
        }

        return cuentaPersona;
    }
}
