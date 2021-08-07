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
import modelo.Factura_;
import static modelo.Factura_.nroFactura;
import modelo.Producto;

/**
 *
 * @author María Castillo
 */
public class DetalleFacturaDAO {

    private ProductoJpaController ControladorProducto = new ProductoJpaController();
    private FacturaJpaController Controladorfactura = new FacturaJpaController();
    private DetalleFacturaJpaController detallefac = new DetalleFacturaJpaController();
    private DetalleFactura detalle = new DetalleFactura();

    private String mensaje = "";
    private FacturaDAO factura = new FacturaDAO();

    public String insertarDetalleFactura(int cantidad, Double precioTotal, Double precioUnitario, Factura idFactura, Producto idProducto) {
        try {
            detalle.setIdDetalleFactura(Long.MIN_VALUE);
            detalle.setCantidad(cantidad);
            detalle.setPrecioTotal(precioTotal);
            detalle.setPrecioUnitario(precioUnitario);
            detalle.setFactura(idFactura);
            detalle.setProducto(idProducto);
//        detalle.setIdDetalleFactura(idDetalleFactura);
            detallefac.create(detalle);
            mensaje = "Detalle de Factura  registrada con exito";
        } catch (Exception e) {
            mensaje = "No se pudo registrar el Detalle de Factura ";
            System.out.println(e.getMessage());
        }
        return mensaje;
    }

    public void listarDetalleFactura(JTable tablaDetalle, String nroFactura) {
        DefaultTableModel model;
        String[] titulo = {"CODIGO PRODUCTO", "CANTIDAD", "PRECIO UNITARIO", "PRECIO TOTAL"};
        model = new DefaultTableModel(null, titulo);
        //List<Producto> datosProducto = buscarProducto(codigo);
        List<Factura> datos = buscarFactura(nroFactura);
        String[] listardetalle = new String[4];
        for (Factura dato : datos) {
            
            listardetalle[0] = dato.getDetalleF().getProducto().getCodigo() + "";
            listardetalle[1] = dato.getDetalleF().getProducto().getStock() + "";
            listardetalle[2] = dato.getSubtotal() + "";
            listardetalle[3] = dato.getTotal() + "";
            model.addRow(listardetalle);
            System.out.println("datos"+dato.getNroFactura());
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

}
