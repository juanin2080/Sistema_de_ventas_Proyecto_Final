/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.DetalleFacturaJpaController;
import controlador.FacturaJpaController;
import controlador.ProductoJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    private FacturaDAO fac = new FacturaDAO();
    private ProductoJpaController ControladorProducto = new ProductoJpaController();
    private FacturaJpaController Controladorfactura = new FacturaJpaController();
    private DetalleFacturaJpaController detallefac = new DetalleFacturaJpaController();
    private DetalleFactura detalle = new DetalleFactura();
    Producto produc = new Producto();
    private String mensaje = "";
    private FacturaDAO factura = new FacturaDAO();

//    public String insertarDetalleFactura(int cantidad, Double precioTotal, Double precioUnitario, Factura idFactura, Producto idProducto) {
//        try {
//            detalle.setIdDetalleFactura(Long.MIN_VALUE);
//            detalle.setCantidad(cantidad);
//            detalle.setPrecioTotal(precioTotal);
//            detalle.setPrecioUnitario(precioUnitario);
//            detalle.setFactura(idFactura);
//            detalle.setProducto(idProducto);
////        detalle.setIdDetalleFactura(idDetalleFactura);
//            detallefac.create(detalle);
//            mensaje = "Detalle de Factura  registrada con exito";
//        } catch (Exception e) {
//            mensaje = "No se pudo registrar el Detalle de Factura ";
//            System.out.println(e.getMessage());
//        }
//        return mensaje;
//    }
//COPIAMOS DE FACTURA VISTA
    public  ArrayList<Producto>  copiarListaProductos(ArrayList<Producto> lista) {
        ArrayList<Producto> productos = lista;
        for (Producto listaProducto : lista) {
            listaProducto.getCodigo();
            listaProducto.getStock();
            System.out.println("idCopiado" + listaProducto.getIdProducto());
            System.out.println("codigoCopiado" + listaProducto.getCodigo());
            System.out.println("cod stockCopiado" + listaProducto.getStock());
        }
        return productos;

    }
//buscar producto que estara en detalle F 

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
//mostrar en detalle factura VISTA

    public void listarDetalleFactura(JTable tablaDetalle, String nroFactura) {
        Factura factura = new Factura();
        Producto producto = new Producto();
        DefaultTableModel model;
        String[] titulo = {"FECHA", "STOCK", "PRECIO UNITARIO", "PRECIO TOTAL"};
        model = new DefaultTableModel(null, titulo);
        List<DetalleFactura> datos =detallefac.findDetalleFacturaEntities();
        String[] listardetalle = new String[4];
        for (DetalleFactura dato : datos) {
            factura= fac.buscarFacturaId(dato.getFactura().getIdFactura());
            listardetalle[0]= factura.getFecha()+"";
//            producto = buscarProductoId(dato.getProducto().getIdProducto(), );
            System.out.println("Stock"+ producto.getStock());
            listardetalle[1]= producto.getStock()+"";
            listardetalle[2]= producto.getPrecio()+"";
            listardetalle[3]= factura.getTotal()+"";
            model.addRow(listardetalle);
            factura=  null;
            producto= null;
            
        }
        tablaDetalle.setModel(model);
    }

    public DetalleFactura buscarProductoF(String factura) {
        List<DetalleFactura> datos = detallefac.findDetalleFacturaEntities();
        DetalleFactura detallef = new DetalleFactura();
        //crear lista detallefactura y devolver
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

}
