/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import controlador.DAO.ProductoDAO;
import controladores.utilidades.Controladores;
import vista.AdministrarProducto;

/**
 *
 * @author Usuario
 */
public class ProductoTest {

    public static void main(String[] args) {
        AdministrarProducto vs = new AdministrarProducto();
        vs.setVisible(true);
//        ProductoDAO pdao = new ProductoDAO();
//        System.out.println(pdao.insertarProducto(13, "gaseosa", Double.valueOf(5.5), "Pepsi", "Jose"));
//        pdao.editar(Long.MIN_VALUE, 0, "asd", Double.valueOf(0.5), "asd", "asd");

//        Controladores con = new Controladores();
//        Boolean letras= con.contieneSoloLetras("2.6");
//        if(letras ==true){
//            System.out.println("letras");
//        }else{
//            System.out.println("numeros");
//        }
        
    }
}
