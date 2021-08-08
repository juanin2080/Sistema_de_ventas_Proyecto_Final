/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import controlador.DAO.CompraDAO;
import java.util.Date;
import vista.CompraProveedor;

/**
 *
 * @author USUARIO
 */
public class CompraTest {
    public static void main (String []args){
         CompraDAO cdao = new CompraDAO();
         Date fecha = new Date();
        // System.out.println( cdao.insertarCompra("5", fecha, true, "Tarjeta de Crédito", 200.00, 400.00));
         //System.out.println( cdao.actualizarCompra(Long.valueOf(5), "5", fecha, true, "efectivo", 200.00, 400.00));
//         System.out.println(cdao.eliminarCompra(Long.valueOf(1)));
//         System.out.println(cdao.eliminarCompra(Long.valueOf(2)));
//         System.out.println(cdao.eliminarCompra(Long.valueOf(3)));
//         System.out.println(cdao.eliminarCompra(Long.valueOf(4)));
    CompraProveedor cp = new CompraProveedor();
    cp.setVisible(true);
//    boolean sd= cdao.contieneSoloNumeros("110001010");
//        if(sd == true){
//            System.out.println("contiene numero");
//        }else{
//            System.out.println("no contiene numero");
//        }
//    
    }
      
}
