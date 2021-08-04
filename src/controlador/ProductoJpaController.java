/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.DetalleCompra;
import modelo.DetalleFactura;
import modelo.Producto;

/**
 *
 * @author juana
 */
public class ProductoJpaController implements Serializable {

    public ProductoJpaController() {
    }
    

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sistema_de_Ventas_Proyecto_FinalPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleCompra detalleCompra = producto.getDetalleCompra();
            if (detalleCompra != null) {
                detalleCompra = em.getReference(detalleCompra.getClass(), detalleCompra.getIdDCompra());
                producto.setDetalleCompra(detalleCompra);
            }
            DetalleFactura detalleFactura = producto.getDetalleFactura();
            if (detalleFactura != null) {
                detalleFactura = em.getReference(detalleFactura.getClass(), detalleFactura.getIdDetalleFactura());
                producto.setDetalleFactura(detalleFactura);
            }
            em.persist(producto);
            if (detalleCompra != null) {
                detalleCompra.getListaProductos().add(producto);
                detalleCompra = em.merge(detalleCompra);
            }
            if (detalleFactura != null) {
                detalleFactura.getListaProductos().add(producto);
                detalleFactura = em.merge(detalleFactura);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getIdProducto());
            DetalleCompra detalleCompraOld = persistentProducto.getDetalleCompra();
            DetalleCompra detalleCompraNew = producto.getDetalleCompra();
            DetalleFactura detalleFacturaOld = persistentProducto.getDetalleFactura();
            DetalleFactura detalleFacturaNew = producto.getDetalleFactura();
            if (detalleCompraNew != null) {
                detalleCompraNew = em.getReference(detalleCompraNew.getClass(), detalleCompraNew.getIdDCompra());
                producto.setDetalleCompra(detalleCompraNew);
            }
            if (detalleFacturaNew != null) {
                detalleFacturaNew = em.getReference(detalleFacturaNew.getClass(), detalleFacturaNew.getIdDetalleFactura());
                producto.setDetalleFactura(detalleFacturaNew);
            }
            producto = em.merge(producto);
            if (detalleCompraOld != null && !detalleCompraOld.equals(detalleCompraNew)) {
                detalleCompraOld.getListaProductos().remove(producto);
                detalleCompraOld = em.merge(detalleCompraOld);
            }
            if (detalleCompraNew != null && !detalleCompraNew.equals(detalleCompraOld)) {
                detalleCompraNew.getListaProductos().add(producto);
                detalleCompraNew = em.merge(detalleCompraNew);
            }
            if (detalleFacturaOld != null && !detalleFacturaOld.equals(detalleFacturaNew)) {
                detalleFacturaOld.getListaProductos().remove(producto);
                detalleFacturaOld = em.merge(detalleFacturaOld);
            }
            if (detalleFacturaNew != null && !detalleFacturaNew.equals(detalleFacturaOld)) {
                detalleFacturaNew.getListaProductos().add(producto);
                detalleFacturaNew = em.merge(detalleFacturaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = producto.getIdProducto();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            DetalleCompra detalleCompra = producto.getDetalleCompra();
            if (detalleCompra != null) {
                detalleCompra.getListaProductos().remove(producto);
                detalleCompra = em.merge(detalleCompra);
            }
            DetalleFactura detalleFactura = producto.getDetalleFactura();
            if (detalleFactura != null) {
                detalleFactura.getListaProductos().remove(producto);
                detalleFactura = em.merge(detalleFactura);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    public Producto findProducto(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
