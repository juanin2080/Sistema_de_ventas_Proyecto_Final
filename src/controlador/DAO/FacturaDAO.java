/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;

import controlador.FacturaJpaController;
import controlador.PersonaJpaController;
import controlador.ProductoJpaController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Factura;
import modelo.Persona;
import modelo.Producto;

/**
 *
 * @author Juan Armijos, Cristian Capa, Maria Castillo, Kelly Preciado
 */
public class FacturaDAO {

    private FacturaJpaController Controladorfactura = new FacturaJpaController();
    private ProductoJpaController controladorProducto = new ProductoJpaController();
    private PersonaJpaController controladorPersona = new PersonaJpaController();
    private Factura factura = new Factura();
    private String mensaje = "";
    private ProductoDAO producto = new ProductoDAO();
    private DetalleFacturaDAO dDAO = new DetalleFacturaDAO();
    private PersonaDAO pe = new PersonaDAO();

    /**
     * Método para insertar datos a la Factura en la BD
     *
     * @param fecha
     * @param formaPago
     * @param iva
     * @param nroFactura
     * @param subtotal
     * @param total
     * @param idPersona
     * @param idAci
     * @param estado
     * @return Retorna una factura con todos los datos ingresados
     */
    public Factura insertarFactura(Date fecha, String formaPago, Boolean iva, String nroFactura, Double subtotal, Double total, Persona idPersona, String idAci, Boolean estado) {
        try {
            factura.setIdFactura(Long.MIN_VALUE);
            factura.setFecha(fecha);
            factura.setFormaPago(formaPago);
            factura.setIva(iva);
            factura.setSubtotal(subtotal);
            factura.setNroFactura(nroFactura);
            factura.setTotal(total);
            factura.setPersona(idPersona);
            factura.setIdACI(idAci);
            factura.setEstado(estado);
            Controladorfactura.create(factura);
            mensaje = "Factura registrada con exito";

        } catch (Exception e) {
            mensaje = "No se pudo registrar la factura ";
            System.out.println(e.getMessage());
        }
        return factura;
    }

    /**
     * Método para dar de baja a una persona mediante el atributo idFactura
     *
     * @param idFactura
     * @return Retorna un mensaje cuando se realice dicho proceso
     */
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

    /**
     * Método para listar productos en un JTable
     *
     * @param tablaCompra
     * @param datos
     */
    public void listarProducto(JTable tablaCompra, ArrayList<Producto> datos) {
        DefaultTableModel model;
        String[] titulo = {"CODIGO", "MARCA", "STOCK", "PRECIOUNITARIO"};
        model = new DefaultTableModel(null, titulo);
        String[] listarProducto = new String[4];
        Producto producto = new Producto();
        for (Producto dato : datos) {

            producto.setIdProducto(dato.getIdProducto());
            producto.setMarca(dato.getMarca());
            producto.setStock(dato.getStock());
            producto.setPrecio(dato.getPrecio());
            listarProducto[0] = dato.getCodigo() + "";
            listarProducto[1] = dato.getMarca();
            listarProducto[2] = dato.getStock() + "";
            listarProducto[3] = dato.getPrecio() + "";
            model.addRow(listarProducto);
        }

        tablaCompra.setModel(model);
    }

    /**
     * Método para buscar un Producto de la factura
     *
     * @param codigo
     * @param cantidad
     * @return Retorna un producto de la lista Productos
     */
    public Producto buscarProductoFactura(String codigo, int cantidad) {
        List<Producto> datos = controladorProducto.findProductoEntities();
        Producto producto = new Producto();
        for (Producto dato : datos) {
            if (String.valueOf(dato.getCodigo()).equals(codigo)) {
                producto.setIdProducto(dato.getIdProducto());
                producto.setCodigo(dato.getCodigo());
                producto.setNombre(dato.getNombre());
                producto.setPrecio(dato.getPrecio());
                producto.setStock((dato.getStock() - cantidad));
                producto.setMarca(dato.getMarca());
                producto.setEstado(dato.getEstado());
                producto.setProveedor(dato.getProveedor());
            }
        }
        return producto;
    }

    /**
     * Método para buscar un producto de factura mediante en código de producto
     *
     * @param codigo
     * @return Retorna un producto de la lista Productos
     */
    public Producto buscarProductoF(String codigo) {
        List<Producto> datos = controladorProducto.findProductoEntities();
        Producto producto = new Producto();
        for (Producto dato : datos) {
            if (String.valueOf(dato.getCodigo()).equals(codigo)) {
                producto.setIdProducto(dato.getIdProducto());
                producto.setCodigo(dato.getCodigo());
                producto.setNombre(dato.getNombre());
                producto.setPrecio(dato.getPrecio());
                producto.setStock(dato.getStock());
                producto.setMarca(dato.getMarca());
                producto.setEstado(dato.getEstado());
                producto.setProveedor(dato.getProveedor());
            }
        }
        datos.add(producto);
        return producto;
    }

    /**
     * Método para buscar productos en la BD
     *
     * @param codigo
     * @return Retorna una lista de Productos
     */
    private List<Producto> buscarProducto(String codigo) {
        Producto pd;
        EntityManager em = controladorProducto.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Producto p WHERE p.codigo like :codigo");
        query.setParameter("codigo", codigo + "%");
        List<Producto> lista = query.getResultList();
        return lista;
    }

    /**
     * Método para listar persona mediante la cédula
     *
     * @param cedula
     * @return Retorna el nombre perteneciente a dicha cédula
     */
    public String listarPersona(String cedula) {
        String nombre = "";

        DefaultTableModel model;
        List<Persona> datos = buscarCliente(cedula);
        for (Persona persona : datos) {
            nombre = persona.getNombres();
        }
        return nombre;
    }

    /**
     * Método para retornar el Id de la persona
     *
     * @param cedula
     * @return Retorno de id de la lista Persona
     */
    public String retornarId(String cedula) {
        String id = "";

        DefaultTableModel model;
        List<Persona> datos = buscarCliente(cedula);
        for (Persona persona : datos) {
            id = String.valueOf(persona.getIdPersona());
        }
        return id;
    }

    /**
     * Método para buscar cliente mediante Cédula en la BD
     *
     * @param cedula
     * @return Retorna lista
     */
    private List<Persona> buscarCliente(String cedula) {
        Persona persona;
        EntityManager em = controladorPersona.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Persona p WHERE p.cedula like :cedula");
        query.setParameter("cedula", cedula + "%");
        List<Persona> lista = query.getResultList();
        return lista;
    }

    /**
     * Método para calcular el subtotal de los productos seleccionados
     *
     * @param listaProductos
     * @param cantidad
     * @return Retorna el valor del subtotal de los productos agregados
     */
    public double calcularSubtotal(ArrayList<Producto> listaProductos, int cantidad) {
        double subtotal = 0;
        for (Producto dato : listaProductos) {
            subtotal = (dato.getPrecio() * cantidad);
        }
        return subtotal;
    }

    /**
     * Método para buscar una Factura con el atributo idFactura
     *
     * @param idFactura
     * @return Retorna una factura de listaFactura
     */
    public Factura buscarFacturaId(Long idFactura) {
        Factura factura = new Factura();
        List<Factura> listafactura = Controladorfactura.findFacturaEntities();
        for (Factura factura1 : listafactura) {
            if (idFactura == factura1.getIdFactura()) {
                factura.setIdFactura(factura1.getIdFactura());
                factura.setFecha(factura1.getFecha());
                factura.setFormaPago(factura1.getFormaPago());
                factura.setNroFactura(factura1.getNroFactura());
                factura.setTotal(factura1.getTotal());
                factura.setSubtotal(factura1.getSubtotal());
                factura.setIva(factura1.isIva());

            }
        }
        return factura;
    }

    /**
     * Método para actualizar el Stock en la BD
     *
     * @param codigo
     * @param cantidad
     */
    public void actualizarStockBD(String codigo, int cantidad) {
        Producto p = new Producto();
        p = buscarProductoFactura(codigo, cantidad);
        producto.editar(p.getIdProducto(), p.getCodigo(), p.getNombre(), p.getPrecio(), p.getMarca(), p.getProveedor(), p.getStock());

    }

    /**
     * Método para buscar una factura mediante el atributo nroFactura
     *
     * @param nroFactura
     * @return Retorna una Factura
     */
    public Factura buscarFacturaCodigo(String nroFactura) {
        Factura factura = new Factura();
        List<Factura> listafactura = Controladorfactura.findFacturaEntities();
        for (Factura factura1 : listafactura) {
            if (nroFactura == factura1.getNroFactura()) {
                factura.setIdFactura(factura1.getIdFactura());
                factura.setFecha(factura1.getFecha());
                factura.setFormaPago(factura1.getFormaPago());
                factura.setNroFactura(factura1.getNroFactura());
                factura.setTotal(factura1.getTotal());
                factura.setSubtotal(factura1.getSubtotal());
                factura.setIva(factura1.isIva());

            }
        }
        return factura;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

}
