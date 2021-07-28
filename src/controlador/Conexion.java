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

/**
 *
 * @author juana
 */
public class Conexion {

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
