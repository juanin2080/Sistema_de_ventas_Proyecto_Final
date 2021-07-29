/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class controladorRegistroProveedor {

    private final String SQL_INSERT = "INSERT INTO proveedor(EMPRESA, RUC) values (?, ?)";
    private PreparedStatement PS;

    private final Conexion CN;

    public controladorRegistroProveedor() {
        PS = null;
        CN = new Conexion();
    }

    public int insertDatos(String empresa, int ruc) {
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setString(1, empresa);
            PS.setInt(2, ruc);
            int res=PS.executeUpdate();
            
            if(res >0){
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + e.getMessage());
        }finally{
            PS= null;
            CN.close();
        }
        return 0;
    }
}
