/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.FacturaJpaController;
import controlador.PersonaJpaController;
import controlador.ProductoJpaController;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.metamodel.SingularAttribute;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Compra;
import modelo.DetalleFactura;
import modelo.Factura;
import modelo.Persona;
import static modelo.Persona_.cedula;
import modelo.Producto;

/**
 *
 * @author María Castillo
 */
public class FacturaDAO {

    private FacturaJpaController Controladorfactura = new FacturaJpaController();
    private ProductoJpaController controladorProducto = new ProductoJpaController();
    private PersonaJpaController controladorPersona = new PersonaJpaController();
    private Factura factura = new Factura();
    private String mensaje = "";
    private ProductoDAO producto= new ProductoDAO();
    private PersonaDAO pe= new PersonaDAO();
    
    public String insertarFactura(Date fecha, String formaPago, Boolean iva, String nroFactura, Double subtotal, Double total, Persona idPersona) {
        try {
            factura.setIdFactura(Long.MIN_VALUE);
            factura.setFecha(fecha);
            factura.setFormaPago(formaPago);
            factura.setIva(iva);
            factura.setSubtotal(subtotal);
            factura.setNroFactura(nroFactura);
            factura.setTotal(total);
            factura.setPersona(idPersona);
            Controladorfactura.create(factura);
            mensaje = "Factura registrada con exito";
        } catch (Exception e) {
            mensaje = "No se pudo registrar la factura ";
            System.out.println(e.getMessage());
        }
        return mensaje;
    }

    public String actualizarFactura(Long idFactura, Date fecha, String formaPago, Boolean iva, String nroFactura, Double subtotal, Double total, Persona idPersona) {
        try {

            factura.setIdFactura(idFactura);
            factura.setFecha((Date) fecha);
            factura.setFormaPago(formaPago);
            factura.setIva(iva);
            factura.setSubtotal(subtotal);
            factura.setNroFactura(nroFactura);
            factura.setTotal(total);
            factura.setPersona(idPersona);
            Controladorfactura.edit(factura);
            mensaje = "Actualizado exitamente";
        } catch (Exception e) {
            mensaje = "No se puede actualizar ";
            System.out.println(e.getMessage());
        }
        return mensaje;
    }

    public String darDeBajaPersona(Long idFactura) {
        try {
            Controladorfactura.destroy(idFactura);
            mensaje = "Eliminado correctamente";
        } catch (Exception e) {
            mensaje = "No se puede eliminar la informacion";
            System.out.println("mensaje en eliminar" + e.getMessage());
        }
        return mensaje;
    }

    //////////
    public void listarProducto(JTable tablaFactura, String codigo) {
        DefaultTableModel model;
        String[] titulo = { "CODIGO", "MARCA", "PRECIOUNITARIO"};
        model = new DefaultTableModel(null, titulo);
        List<Producto> datos = buscarProducto(codigo);
        String[] listarProducto = new String[3];
        for (Producto product : datos) {
            listarProducto[0] = product.getCodigo() + "";
            listarProducto[1] = product.getMarca();
            listarProducto[2] = product.getPrecio() + "";
            model.addRow(listarProducto);

        }
        tablaFactura.setModel(model);
        
    }
    private List<Producto> buscarProducto(String codigo) {
        Producto pd;
        EntityManager em = controladorProducto.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Producto p WHERE p.codigo like :codigo");
        query.setParameter("codigo", codigo + "%");
        List<Producto> lista = query.getResultList();
        return lista;
    }
       public String listarPersona(String nombre, String cedula) {
        DefaultTableModel model;
        List<Persona> datos = buscarCliente(cedula);
        for (Persona persona : datos) {
           persona.setNombres(nombre);
        }
        return nombre;
    }
        private List<Persona> buscarCliente(String cedula) {
        Persona persona;
        EntityManager em = controladorPersona.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Persona p WHERE p.cedula like :cedula");
        query.setParameter("cedula", cedula + "%");
        List<Persona> lista = query.getResultList();
        return lista;
    }
}
