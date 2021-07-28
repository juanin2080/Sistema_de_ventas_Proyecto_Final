/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author María Castillo
 */
public class bd {

    private final String SQL_INSERT = "INSERT INTO factura(CodigoProducto,Cantidad , iva, precio)values(?,?,?,?)";
    private PreparedStatement PS;
    private Conexion Co;

    public bd() {
        PS = null;
        Co = new Conexion();
    }

    public int agregarDatos(int codP, int cant, int iv, int prec){

        try {
            //PS = Co.getConnection().preapareStatement(SQL_INSERT);
            PS.setInt(1, codP);
            PS.setInt(2, cant);
            PS.setInt(3, iv);
            PS.setInt(4, prec);
        } catch (Exception e) {
        }
        return 0;
    }
    
}
