/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import controlador.DAO.ProductoDAO;
import vista.AdministrarProducto;

/**
 *
 * @author Usuario
 */
public class ProductoTest {

    public static void main(String[] args) {
//        AdministrarProducto vs= new AdministrarProducto();
//        vs.setVisible(true);
        ProductoDAO pdao = new ProductoDAO();
        System.out.println(pdao.dardeBaja(Long.valueOf(1),13, "gaseosa", Double.valueOf(5.5), "Pepsi", "Jose"));
    }
}
