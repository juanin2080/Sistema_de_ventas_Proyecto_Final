/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.DetalleFacturaJpaController;
import controlador.FacturaJpaController;
//import controlador.FacturaJpaController;
import controlador.ProductoJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.DetalleFactura;
import modelo.Factura;
import modelo.Producto;

/**
 *
 * @author María Castillo
 */
public class DetalleFacturaDAO {

    private ProductoDAO prod = new ProductoDAO();
    private ProductoJpaController ControladorProducto = new ProductoJpaController();
    private DetalleFacturaJpaController detallefac = new DetalleFacturaJpaController();
    private FacturaJpaController Controladorfactura = new FacturaJpaController();
    private DetalleFactura detalle = new DetalleFactura();
    Producto produc = new Producto();
    private String mensaje = "";
    private ArrayList<Producto> listaProductosCopia = new ArrayList<Producto>();
    private Factura facturaCopia = new Factura();
    /**
     * Método para insertar datos correspondientes al detalle de Factura
     * @param cantidad
     * @param precioTotal
     * @param precioUnitario
     * @param factura
     * @param producto
     * @return 
     */
    public String insertarDetalleFactura(int cantidad, Double precioTotal, Double precioUnitario, Factura factura, Producto producto) {
        try {
            detalle.setIdDetalleFactura(Long.MIN_VALUE);
            detalle.setCantidad(cantidad);
            detalle.setPrecioTotal(precioTotal);
            detalle.setPrecioUnitario(precioUnitario);
            detalle.setProducto(producto);
            detalle.setFactura(factura);
            detallefac.create(detalle);
            mensaje = "Detalle de Factura  registrada con exito";
//            JOptionPane.showMessageDialog(null, "Detalle de Factura  registrada con exito");
            System.out.println("Detalle de Factura  registrada con exito");
        } catch (Exception e) {
            mensaje = "No se pudo registrar el Detalle de Factura ";
//            JOptionPane.showMessageDialog(null, "No se pudo registrar el Detalle de Factura ");
            System.out.println("No se pudo registrar el Detalle de Factura ");
            System.out.println(e.getMessage());
        }
        return mensaje;
    }

    /**
     * Método para buscar productos que estaran en la lista 
     * @param lisProducto
     * @return 
     */
    public Producto buscarProductoDF(ArrayList<Producto> lisProducto) {
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
    /**
     * Método para buscar productos de la lista copiada
     * @param codigo
     * @return 
     */
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
    /**
     * Método para mostrar el detalle de factura en la Ventana
     * @param tablaDetalle 
     */
    public void listarDetalleFactura(JTable tablaDetalle) {
        DefaultTableModel model;
        String[] titulo = {"Fecha", "Forma de pago", "Precio Total", "Cédula cliente"};
        model = new DefaultTableModel(null, titulo);
        List<DetalleFactura> datos = detallefac.findDetalleFacturaEntities();
        String[] listardetalle = new String[4];
        for (DetalleFactura dato : datos) {
            listardetalle[0] = dato.getFactura().getFecha() + "";
            listardetalle[1] = dato.getFactura().getFormaPago() + "";
            listardetalle[2] = dato.getFactura().getTotal() + "";
            listardetalle[3] = dato.getFactura().getPersona().getCedula() + "";
            model.addRow(listardetalle);
        }
        tablaDetalle.setModel(model);
    }
    /**
     * Método para buscar productos en la factura, permita crear lista detalle factura para devolver
     * @param factura
     * @return 
     */
    public DetalleFactura buscarProductoF(String factura) {
        List<DetalleFactura> datos = detallefac.findDetalleFacturaEntities();
        DetalleFactura detallef = new DetalleFactura();
        for (DetalleFactura dato : datos) {
            if (String.valueOf(dato.getFactura()).equals(factura)) {
                detallef.setIdDetalleFactura(dato.getIdDetalleFactura());
                detallef.setCantidad(dato.getCantidad());
                detallef.setPrecioUnitario(dato.getPrecioUnitario());
                detallef.setPrecioTotal(dato.getPrecioTotal());
            } 
        }
        datos.add(detallef);
        return detallef;

    }
    /**
     * Método para buscar productos mediante el nroFactura de la BD
     * @param nroFactura
     * @return 
     */
    private List<Factura> buscarFactura(String nroFactura) {
        Factura pd;
        EntityManager em = detallefac.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Factura p WHERE p.nroFactura like :nroFactura");
        query.setParameter("nroFactura", nroFactura + "%");
        List<Factura> lista = query.getResultList();
        for (Factura factura1 : lista) {
            System.out.println(factura1.getNroFactura());

        }
        return lista;
    }
    /**
     * Método para buscar productos mediante código en la BD
     * @param codigo
     * @return 
     */
    public List<Producto> buscarProducto(String codigo) {
        EntityManager em = ControladorProducto.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Producto p WHERE p.codigo LIKE :codigo");
        query.setParameter("codigo", codigo + "%");
        List<Producto> lista = query.getResultList();
        return lista;
    }
    /**
     * Método para buscar producto por ID
     * @param idProducto
     * @param listProducto
     * @return 
     */
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
    /**
     * Método para buscar factura en la BD
     * @param nroFactura
     * @return 
     */
    public Factura buscarFacturaBD(String nroFactura) {
        Factura f = new Factura();
        List<Factura> listaFactura = Controladorfactura.findFacturaEntities();
        for (Factura fac : listaFactura) {
            if (nroFactura.equals(fac.getNroFactura())) {
                f = fac;
            }

        }
        return f;
    }

    public ArrayList<Producto> getListaProductosCopia() {
        return listaProductosCopia;
    }

    public void setListaProductosCopia(ArrayList<Producto> listaProductosCopia) {
        this.listaProductosCopia = listaProductosCopia;
    }

    public Factura getFacturaCopia() {
        return facturaCopia;
    }

    public void setFacturaCopia(Factura facturaCopia) {
        this.facturaCopia = facturaCopia;
    }

}
