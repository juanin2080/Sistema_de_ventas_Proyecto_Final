/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.IllegalOrphanException;
import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Producto;
import modelo.Factura;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.DetalleFactura;

/**
 *
 * @author juana
 */
public class DetalleFacturaJpaController implements Serializable {

    public DetalleFacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sistema_de_Ventas_Proyecto_FinalPU");

    public DetalleFacturaJpaController() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    /**
     * Método create Crea un detalle de Factura de los productos en la base de datos.
     * @param detalleFactura
     * @throws IllegalOrphanException El Flujo de ejecución se detiene inmediatamente despues de la sentencia throw, lo cual nunca se llega a la siguiente sentencia.
     */
    public void create(DetalleFactura detalleFactura) throws IllegalOrphanException {
        List<String> illegalOrphanMessages = null;
        Factura facturaOrphanCheck = detalleFactura.getFactura();
        if (facturaOrphanCheck != null) {
            DetalleFactura oldDetalleFOfFactura = facturaOrphanCheck.getDetalleF();
            if (oldDetalleFOfFactura != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Factura " + facturaOrphanCheck + " already has an item of type DetalleFactura whose factura column cannot be null. Please make another selection for the factura field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto = detalleFactura.getProducto();
            if (producto != null) {
                producto = em.getReference(producto.getClass(), producto.getIdProducto());
                detalleFactura.setProducto(producto);
            }
            Factura factura = detalleFactura.getFactura();
            if (factura != null) {
                factura = em.getReference(factura.getClass(), factura.getIdFactura());
                detalleFactura.setFactura(factura);
            }
            em.persist(detalleFactura);
            if (producto != null) {
                producto.getListaDetalleFactura().add(detalleFactura);
                producto = em.merge(producto);
            }
            if (factura != null) {
                factura.setDetalleF(detalleFactura);
                factura = em.merge(factura);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    /**
     * Método edit edita una cláusula catch (reemplazable), el método no verifica si la entidad ya existe, sino que agrega una nueva entidad.
     * @param detalleFactura
     * @throws IllegalOrphanException encargados de controlar los posibles errores nacientes al conectar a la base de datos.
     * @throws NonexistentEntityException
     * @throws Exception Representa errores que no son críticos y por lo tanto pueden ser tratados y continuar la ejecución de la aplicación.
     */
    public void edit(DetalleFactura detalleFactura) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleFactura persistentDetalleFactura = em.find(DetalleFactura.class, detalleFactura.getIdDetalleFactura());
            Producto productoOld = persistentDetalleFactura.getProducto();
            Producto productoNew = detalleFactura.getProducto();
            Factura facturaOld = persistentDetalleFactura.getFactura();
            Factura facturaNew = detalleFactura.getFactura();
            List<String> illegalOrphanMessages = null;
            if (facturaNew != null && !facturaNew.equals(facturaOld)) {
                DetalleFactura oldDetalleFOfFactura = facturaNew.getDetalleF();
                if (oldDetalleFOfFactura != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Factura " + facturaNew + " already has an item of type DetalleFactura whose factura column cannot be null. Please make another selection for the factura field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (productoNew != null) {
                productoNew = em.getReference(productoNew.getClass(), productoNew.getIdProducto());
                detalleFactura.setProducto(productoNew);
            }
            if (facturaNew != null) {
                facturaNew = em.getReference(facturaNew.getClass(), facturaNew.getIdFactura());
                detalleFactura.setFactura(facturaNew);
            }
            detalleFactura = em.merge(detalleFactura);
            if (productoOld != null && !productoOld.equals(productoNew)) {
                productoOld.getListaDetalleFactura().remove(detalleFactura);
                productoOld = em.merge(productoOld);
            }
            if (productoNew != null && !productoNew.equals(productoOld)) {
                productoNew.getListaDetalleFactura().add(detalleFactura);
                productoNew = em.merge(productoNew);
            }
            if (facturaOld != null && !facturaOld.equals(facturaNew)) {
                facturaOld.setDetalleF(null);
                facturaOld = em.merge(facturaOld);
            }
            if (facturaNew != null && !facturaNew.equals(facturaOld)) {
                facturaNew.setDetalleF(detalleFactura);
                facturaNew = em.merge(facturaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = detalleFactura.getIdDetalleFactura();
                if (findDetalleFactura(id) == null) {
                    throw new NonexistentEntityException("The detalleFactura with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    /**
     * Método para destruir un grupo de subprocesos, indica que todos los subprocesos se han detenido desde entonces.
     * @param id
     * @throws NonexistentEntityException encargado de controlar los posibles errores nacientes al conectar a la base de datos.
     */
    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleFactura detalleFactura;
            try {
                detalleFactura = em.getReference(DetalleFactura.class, id);
                detalleFactura.getIdDetalleFactura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleFactura with id " + id + " no longer exists.", enfe);
            }
            Producto producto = detalleFactura.getProducto();
            if (producto != null) {
                producto.getListaDetalleFactura().remove(detalleFactura);
                producto = em.merge(producto);
            }
            Factura factura = detalleFactura.getFactura();
            if (factura != null) {
                factura.setDetalleF(null);
                factura = em.merge(factura);
            }
            em.remove(detalleFactura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleFactura> findDetalleFacturaEntities() {
        return findDetalleFacturaEntities(true, -1, -1);
    }

    public List<DetalleFactura> findDetalleFacturaEntities(int maxResults, int firstResult) {
        return findDetalleFacturaEntities(false, maxResults, firstResult);
    }

    private List<DetalleFactura> findDetalleFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleFactura.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    /**
     * Método findDetalleFactura busca el patrón especificado o la expresión en la subsecuencia daba por caracteres.
     * @param id
     * @return Retorna el valor de retorno de la operación es el recuento de elementos en la secuencia.
     */
    public DetalleFactura findDetalleFactura(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleFactura.class, id);
        } finally {
            em.close();
        }
    }
    /**
     * Metodo CuentaCount devuelve el recuento de elementos en la secuencia.
     * @return Retorna el valor de retorno de la operación es el recuento de elementos en la secuencia.

     */
    public int getDetalleFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleFactura> rt = cq.from(DetalleFactura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
