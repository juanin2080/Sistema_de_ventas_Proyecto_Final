/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.CompraJpaController;
import controlador.DetalleCompraJpaController;
import controlador.DetalleFacturaJpaController;
//import controlador.FacturaJpaController;
import controlador.ProductoJpaController;
import controlador.ProveedorJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.DetalleCompra;

import modelo.Compra;
import modelo.Producto;
import modelo.Proveedor;

/**
 *
 * @author USUARIO
 */
public class DetalleCompraDAO {

    private ProductoDAO prod = new ProductoDAO();
    private ProductoJpaController ControladorProducto = new ProductoJpaController();
    private DetalleCompraJpaController detalleCom = new DetalleCompraJpaController();
    private CompraJpaController ControladorCompra = new CompraJpaController();
    private ProveedorJpaController controladorProveedor = new ProveedorJpaController();
    private DetalleCompra detalle = new DetalleCompra();
    Producto produc = new Producto();
    private String mensaje = "";
    private ArrayList<Producto> listaProductosCopia = new ArrayList<Producto>();
    private Compra compraCopia = new Compra();

    public String insertarDetalleCompra(int cantidad, Double precioTotal, Double precioUnitario, Compra compra, Producto producto) {
        try {
            detalle.setIdDCompra(Long.MIN_VALUE);
            detalle.setCantidad(cantidad);
            detalle.setPrecioTotal(precioTotal);
            detalle.setPrecioUnitario(precioUnitario);
            detalle.setCompra(compra);
            detalle.setProducto(producto);
            detalleCom.create(detalle);
            mensaje = "Detalle de Compra  registrada con exito";
//            JOptionPane.showMessageDialog(null, "Detalle de Compra    registrada con exito");
            System.out.println("Detalle de Compra  registrada con exito");
        } catch (Exception e) {
            mensaje = "No se pudo registrar el Detalle de Compra  ";
//            JOptionPane.showMessageDialog(null, "No se pudo registrar el Detalle de Compra  ");
            System.out.println("No se pudo registrar el Detalle de Compra  ");
            System.out.println(e.getMessage());
        }
        return mensaje;
    }
//buscar producto que estara en detalle Compra

    public Producto buscarProductoDC(ArrayList<Producto> lisProducto) {
        Producto product = new Producto();
        for (Producto producto : lisProducto) {
            product.setIdProducto(producto.getIdProducto());
            product.setCodigo(producto.getCodigo());
            product.setNombre(producto.getNombre());
            product.setPrecio(producto.getPrecio());
            product.setStock((producto.getStock()));
            product.setMarca(producto.getMarca());
            product.setEstado(producto.getEstado());
            product.setProveedor(producto.getProveedor());

        }
        return product;
    }
//buscar productos de la lista copiada

    public Producto buscarProductoenLista(String codigo) {
        List<Producto> datos = ControladorProducto.findProductoEntities();
        Producto producto = new Producto();
        for (Producto dato : datos) {
            if (String.valueOf(dato.getCodigo()).equals(codigo)) {
                producto.setIdProducto(dato.getIdProducto());
                producto.setCodigo(dato.getCodigo());
                producto.setNombre(dato.getNombre());
                producto.setPrecio(dato.getPrecio());
                producto.setStock((dato.getStock()));
                producto.setMarca(dato.getMarca());
                producto.setEstado(dato.getEstado());
                producto.setProveedor(dato.getProveedor());

            }
        }
        return producto;
    }
//mostrar en detalle COMPRA VISTA

    public void listarDetalleCompra(JTable tblDetalleCompra) {
        DefaultTableModel model;
        String[] titulo = {"Fecha", "Forma de pago", "Precio Total", "Cédula proveedor"};
        model = new DefaultTableModel(null, titulo);
        List<DetalleCompra> datos = detalleCom.findDetalleCompraEntities();
        String[] listardetalle = new String[4];
        for (DetalleCompra dato : datos) {
            listardetalle[0] = dato.getCompra().getFecha() + "";
            listardetalle[1] = dato.getCompra().getfPago() + "";
            listardetalle[2] = dato.getCompra().getTotal() + "";
            Proveedor proveedor = buscarProveedor(dato.getCompra().getExternal_IDProveedor());
            System.out.println("estoy en el listar" + proveedor.getCedula());
            listardetalle[3] = proveedor.getCedula();
            model.addRow(listardetalle);
        }
        tblDetalleCompra.setModel(model);
    }

    public DetalleCompra buscarProductoC(String compra) {
        List<DetalleCompra> datos = detalleCom.findDetalleCompraEntities();
        DetalleCompra detallec = new DetalleCompra();
        //crear lista detallefactura y devolver
        for (DetalleCompra dato : datos) {
            if (String.valueOf(dato.getCompra()).equals(compra)) {
                detallec.setIdDCompra(dato.getIdDCompra());
                detallec.setCantidad(dato.getCantidad());
                detallec.setPrecioUnitario(dato.getPrecioUnitario());
                detallec.setPrecioTotal(dato.getPrecioTotal());
            }
        }
        datos.add(detallec);
        return detallec;

    }

    private List<Compra> buscarCompra(String nroCompra) {
        Compra pd;
        EntityManager em = detalleCom.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Compra p WHERE p.nroCompra like :nroCompra");
        query.setParameter("nroCompra", nroCompra + "%");
        List<Compra> lista = query.getResultList();
        for (Compra compra1 : lista) {
            System.out.println(compra1.getNroCompra());

        }
        return lista;
    }

    public List<Producto> buscarProducto(String codigo) {
        EntityManager em = ControladorProducto.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Producto p WHERE p.codigo LIKE :codigo");
        query.setParameter("codigo", codigo + "%");
        List<Producto> lista = query.getResultList();
        return lista;
    }

    public Producto buscarProductoId(Long idProducto, ArrayList<Producto> listProducto) {
        Producto producto = new Producto();

        for (Producto producto1 : listProducto) {
            if (idProducto == producto1.getIdProducto()) {
                producto.setCodigo(producto1.getCodigo());
                producto.setNombre(producto1.getNombre());
                producto.setMarca(producto1.getMarca());
                producto.setPrecio(producto1.getPrecio());
                producto.setStock(producto1.getStock());
                producto.setProveedor(producto1.getProveedor());
                producto.setEstado(producto1.getEstado());

            }

        }
        return producto;

    }

    public Compra buscarProductoBD(String nroCompra) {
        Compra c = new Compra();
        List<Compra> listaFactura = ControladorCompra.findCompraEntities();
        for (Compra com : listaFactura) {
            if (nroCompra.equals(com.getNroCompra())) {
                c = com;
            }

        }
        return c;
    }

    public Proveedor buscarProveedor(Long idProveedor) {
        Proveedor prov = new Proveedor();
        List<Proveedor> listaProveedor = controladorProveedor.findProveedorEntities();
        for (Proveedor com : listaProveedor) {
            if (idProveedor == com.getIdPersona()) {
                prov = com;
            }

        }
        return prov;
    }

    public ArrayList<Producto> getListaProductosCopia() {
        return listaProductosCopia;
    }

    public void setListaProductosCopia(ArrayList<Producto> listaProductosCopia) {
        this.listaProductosCopia = listaProductosCopia;
    }

    public Compra getCompraCopia() {
        return compraCopia;
    }

    public void setCompraCopia(Compra compraCopia) {
        this.compraCopia = compraCopia;
    }

}
