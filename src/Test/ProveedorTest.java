/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import vista.AdministrarProveedor;
import controlador.DAO.ProveedorDAO;
import controlador.utilidades.Controladores;

/**
 *
 * @author Usuario
 */
public class ProveedorTest {

    public static void main(String[] args) {
        ProveedorDAO pDAO = new ProveedorDAO();
//        System.out.println(pDAO.insertarProveedor("Tía", "2313"));
        //System.out.println(pDAO.eliminar(Long.valueOf(4)));

        AdministrarProveedor pd = new AdministrarProveedor();
        pd.setVisible(true);
//        Controladores controles = new Controladores();
//        Boolean da = controles.contieneSoloLetras("Maria");
//        da=controles.validadorDeCedula("1105309445");
//        
//        da= controles.validarEmail("maria.castillo@gmail.com");
//        if (da== true) {
////            System.out.println("letras");
//            System.out.println("correcta");
//        }else{
////            System.out.println("numeroa");
//            System.out.println("incorrecta");
//        }
    }

}
