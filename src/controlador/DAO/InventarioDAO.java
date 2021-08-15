package controlador.DAO;

import controlador.ProductoJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class InventarioDAO {

    private ProductoJpaController controladorProducto = new ProductoJpaController();

    /**
     * Método para listar los productos en el jtable de la vista Inventario.
     *
     * @param tabla
     * @param codigo
     */
    public void listarProducto(JTable tabla, String codigo) {
        DefaultTableModel model;

        String[] titulo = {"CÓDIGO", "NOMBRE", "PRECIO", "MARCA", "PROVEEDOR", "STOCK", "ID"};
        model = new DefaultTableModel(null, titulo);

        List<Producto> datos = buscarProducto(codigo);

        String[] listarProducto = new String[7];

        for (Producto product : datos) {
            if (product.getEstado() == true) {
                listarProducto[0] = product.getCodigo() + "";
                listarProducto[1] = product.getNombre();
                listarProducto[2] = product.getPrecio() + "";
                listarProducto[3] = product.getMarca();
                listarProducto[4] = product.getProveedor();
                listarProducto[5] = product.getStock() + "";
                listarProducto[6] = product.getIdProducto() + "";

                model.addRow(listarProducto);
            }

        }
        tabla.setModel(model);
        tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getColumnModel().getColumn(6).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
    }

    /**
     * Método para capturar los datos que se encuentran en la bd.
     *
     * @param codigo
     * @return
     */
    private List<Producto> buscarProducto(String codigo) {
        Producto pd;
        EntityManager em = controladorProducto.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Producto p WHERE p.codigo like :codigo");
        query.setParameter("codigo", codigo + "%");

        List<Producto> lista = query.getResultList();
        return lista;
    }

}
