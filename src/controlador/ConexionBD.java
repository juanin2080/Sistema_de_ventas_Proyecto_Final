/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author juana
 */
public class ConexionBD {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "juan2080";
    private static final String URL = "jdbc:mysql://localhost:3306/sistemaventasJA?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private Connection CN;

    public ConexionBD() {
        CN = null;
    }

    /**
     * Establece la conexion con la bd
     *
     * @return Conexion
     */
    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            CN = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al conectar con la bd", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return CN;
    }

    public void Close() {
        try {
            CN.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al conectar con la bd", JOptionPane.ERROR_MESSAGE);
        }
    }

}
