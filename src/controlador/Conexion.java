/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

//import com.sun.jdi.connect.spi.Connection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author juana
 */
public class Conexion {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "Kelly_25092001";
    private static final String URL = "jdbc:mysql://localhost:3306/proyectods?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private Connection CN;
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    private static void setup() {
        if (em == null) {
            Conexion.emf = Persistence.createEntityManagerFactory("Sistema_de_Ventas_Proyecto_FinalPU");
            Conexion.em = Conexion.emf.createEntityManager();
        }
    }
     public Conexion() {
        this.setup();
        CN = null;
    }
    
    /**
     * Establece la conexion con la bd
     * @return Conexion
     */
    public Connection getConnection(){
        try {
            Class.forName(DRIVER);
            CN = DriverManager.getConnection(URL, USER, PASSWORD);                             
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al conectar con la bd", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return CN;
    }
    
    public void Close(){
        try {
            CN.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al conectar con la bd", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void setEmf(EntityManagerFactory emf) {
        Conexion.emf = emf;
    }

    public static EntityManager getEm() {
        return em;
    }

    public static void setEm(EntityManager em) {
        Conexion.em = em;
    }

   

    public static void main(String[] args) {
        new Conexion();

    }
}
