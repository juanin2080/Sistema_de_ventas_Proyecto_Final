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
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Producto;
import modelo.Compra;
import modelo.DetalleCompra;

/**
 *
 * @author juana
 */
public class DetalleCompraJpaController implements Serializable {

    public DetalleCompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleCompra detalleCompra) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto = detalleCompra.getProducto();
            if (producto != null) {
                producto = em.getReference(producto.getClass(), producto.getIdProducto());
                detalleCompra.setProducto(producto);
            }
            Compra compra = detalleCompra.getCompra();
            if (compra != null) {
                compra = em.getReference(compra.getClass(), compra.getIdCompra());
                detalleCompra.setCompra(compra);
            }
            em.persist(detalleCompra);
            if (producto != null) {
                producto.getListaDetalleCompra().add(detalleCompra);
                producto = em.merge(producto);
            }
            if (compra != null) {
                compra.getListaDCompra().add(detalleCompra);
                compra = em.merge(compra);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleCompra detalleCompra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleCompra persistentDetalleCompra = em.find(DetalleCompra.class, detalleCompra.getIdDCompra());
            Producto productoOld = persistentDetalleCompra.getProducto();
            Producto productoNew = detalleCompra.getProducto();
            Compra compraOld = persistentDetalleCompra.getCompra();
            Compra compraNew = detalleCompra.getCompra();
            if (productoNew != null) {
                productoNew = em.getReference(productoNew.getClass(), productoNew.getIdProducto());
                detalleCompra.setProducto(productoNew);
            }
            if (compraNew != null) {
                compraNew = em.getReference(compraNew.getClass(), compraNew.getIdCompra());
                detalleCompra.setCompra(compraNew);
            }
            detalleCompra = em.merge(detalleCompra);
            if (productoOld != null && !productoOld.equals(productoNew)) {
                productoOld.getListaDetalleCompra().remove(detalleCompra);
                productoOld = em.merge(productoOld);
            }
            if (productoNew != null && !productoNew.equals(productoOld)) {
                productoNew.getListaDetalleCompra().add(detalleCompra);
                productoNew = em.merge(productoNew);
            }
            if (compraOld != null && !compraOld.equals(compraNew)) {
                compraOld.getListaDCompra().remove(detalleCompra);
                compraOld = em.merge(compraOld);
            }
            if (compraNew != null && !compraNew.equals(compraOld)) {
                compraNew.getListaDCompra().add(detalleCompra);
                compraNew = em.merge(compraNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = detalleCompra.getIdDCompra();
                if (findDetalleCompra(id) == null) {
                    throw new NonexistentEntityException("The detalleCompra with id " + id + " no longer exists.");
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
            DetalleCompra detalleCompra;
            try {
                detalleCompra = em.getReference(DetalleCompra.class, id);
                detalleCompra.getIdDCompra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleCompra with id " + id + " no longer exists.", enfe);
            }
            Producto producto = detalleCompra.getProducto();
            if (producto != null) {
                producto.getListaDetalleCompra().remove(detalleCompra);
                producto = em.merge(producto);
            }
            Compra compra = detalleCompra.getCompra();
            if (compra != null) {
                compra.getListaDCompra().remove(detalleCompra);
                compra = em.merge(compra);
            }
            em.remove(detalleCompra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleCompra> findDetalleCompraEntities() {
        return findDetalleCompraEntities(true, -1, -1);
    }

    public List<DetalleCompra> findDetalleCompraEntities(int maxResults, int firstResult) {
        return findDetalleCompraEntities(false, maxResults, firstResult);
    }

    private List<DetalleCompra> findDetalleCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleCompra.class));
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

    public DetalleCompra findDetalleCompra(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleCompra.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleCompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleCompra> rt = cq.from(DetalleCompra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
