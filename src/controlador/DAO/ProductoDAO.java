/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.ProductoJpaController;
import controlador.ProveedorJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import modelo.Proveedor;

/**
 *
 * @author Usuario
 */
public class ProductoDAO {

    private ProductoJpaController controladorProducto = new ProductoJpaController();
    private Producto producto = new Producto();
    private ProveedorJpaController empresaPro = new ProveedorJpaController();

    /**
     * Metodo para insertar un producto en la bdd verificando que el codigo del
     * producto no exista anteriormente.
     *
     * @param codigo
     * @param nombre
     * @param precio
     * @param Marca
     * @param proveedor
     * @param cantidad
     * @return
     */
    public String insertarProducto(String codigo, String nombre, Double precio, String Marca, String proveedor, int cantidad) {
        String mensaje = "";

        if (validar(Integer.parseInt(codigo)) == 1) {
            mensaje = "Ya existe un producto con ese código";
        } else {
            try {
                producto.setCodigo(Integer.parseInt(codigo));
                producto.setNombre(nombre);
                producto.setPrecio(precio);
                producto.setStock(cantidad);
                producto.setMarca(Marca);
                producto.setEstado(true);
                producto.setProveedor(proveedor);
                controladorProducto.create(producto);

                mensaje = "Producto registrado con exito";
            } catch (Exception e) {
                System.out.println("mensaje en guardar: " + e.getMessage());
                mensaje = "No se pudo registrar el producto ";
            }
        }

        return mensaje;
    }

    /**
     * Método para editar los datos de un producto.
     *
     * @param id
     * @param codigo
     * @param nombre
     * @param precio
     * @param Marca
     * @param proveedor
     * @param cantidad
     * @return
     */
    public String editar(Long id, int codigo, String nombre, Double precio, String Marca, String proveedor, int cantidad) {
        String mensaje = "";
        try {
            producto.setIdProducto(id);
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setStock(cantidad);
            producto.setMarca(Marca);
            producto.setEstado(true);
            producto.setProveedor(proveedor);
            controladorProducto.edit(producto);

            mensaje = "Producto actualizado con exito";
        } catch (Exception e) {
            System.out.println("mensaje en guardar: " + e.getMessage());
            mensaje = "No se pudo actualizar el producto ";
        }
        return mensaje;
    }

    /**
     * Metodo para dar de baja un producto, el cual solo cambiara de estado,
     * pasará de activo a inactivo.
     *
     * @param id
     * @param codigo
     * @param nombre
     * @param precio
     * @param Marca
     * @param proveedor
     * @param cantidad
     * @return
     */
    public String dardeBaja(Long id, int codigo, String nombre, Double precio, String Marca, String proveedor, int cantidad) {
        String mensaje = "";

        try {

            producto.setIdProducto(id);
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setStock(cantidad);
            producto.setMarca(Marca);
            producto.setEstado(false);
            producto.setProveedor(proveedor);
            controladorProducto.edit(producto);

            mensaje = "Producto dado de baja con exito";
        } catch (Exception e) {
            System.out.println("mensaje en guardar: " + e.getMessage());
            mensaje = "No se pudo dar de baja el producto ";
        }
        return mensaje;
    }

    /**
     * Metodo para listar o presentar en el jtable los datos de los productos
     * que estan en la bdd, solo presentara, los productos que esten activos.
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

    private List<Producto> buscarProducto(String codigo) {
        Producto pd;
        EntityManager em = controladorProducto.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Producto p WHERE p.codigo like :codigo");
        query.setParameter("codigo", codigo + "%");

        List<Producto> lista = query.getResultList();
        return lista;
    }

    /**
     * Método para buscar todos los productos que existen en la bdd, lo
     * utilzaremos al momento de validar si ya existe algún código de un
     * producto.
     *
     * @param codigo
     * @return
     */
    public List<Producto> listarProductos(String codigo) {
        EntityManager em = controladorProducto.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Producto p WHERE p.codigo like :codigo");
        query.setParameter("codigo", codigo + "%");

        List<Producto> lista = query.getResultList();
        return lista;
    }

    /**
     * Método para validar si el código el producto ya existe o no.
     *
     * @param codigo
     * @return
     */
    public int validar(int codigo) {
        boolean estado = true;
        List<Producto> datos = listarProductos("%");
        String cod = "";
        for (Producto dato : datos) {
            cod = String.valueOf(dato.getCodigo());
            if (cod.equals(String.valueOf(codigo))) {
                estado = true;
                break;
            } else {
                estado = false;
            }
        }
        if (estado == true) {
            return 1;
        } else {
            return 0;
        }
    }

    public void listarComboBox(JComboBox cbxEmpresa) {
        List<Proveedor> datos = empresaPro.findProveedorEntities();
        for (Proveedor dato : datos) {
            cbxEmpresa.addItem(dato.getEmpresa());
        }
    }

    public Proveedor buscarEmpresa(String empresa) {
        Proveedor empresaCbx = new Proveedor();
        List<Proveedor> datos = this.empresaPro.findProveedorEntities();

        for (Proveedor dato : datos) {
            if (dato.getEmpresa().equals(empresa)) {
                empresaCbx.setEmpresa(dato.getEmpresa());
                empresaCbx.setIdPersona(Long.MIN_VALUE);

            }
        }
        return empresaCbx;

    }

}
