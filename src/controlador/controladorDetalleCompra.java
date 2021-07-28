/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mysql.cj.xdevapi.PreparableStatement;

/**
 *
 * @author USUARIO
 */
public class controladorDetalleCompra {
    private final String SQL_INSERT = "INSERT INTO detallecompra (CANTIDAD,CODPRODUCTO,IVA,PRECIO,idPersona) values(?,?,?,?,?)";
    private PreparableStatement PS;
    private Conexion CN;

    public controladorDetalleCompra() {
        PS = null;
        CN = new Conexion();
    }
    
//    public int insertDatos(int cantidad, int codProducto, int iva, double precio){
//        try {
//            
//        } catch (Exception e) {
//            System.err.println("Error al guardar los datos en la bd" + e.getMessage());
//        }
//        return 0;
//        
//    }
    
    
}
