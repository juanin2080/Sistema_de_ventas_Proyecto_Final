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
import modelo.Compra;
import modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.DetalleCompra;

/**
 *
 * @author juana
 */
public class DetalleCompraJpaController implements Serializable {

    
    public DetalleCompraJpaController() {
    }
    
    public DetalleCompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;  
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sistema_de_Ventas_Proyecto_FinalPU");


    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    public void create(DetalleCompra detalleCompra) {
        if (detalleCompra.getListaProductos() == null) {
            detalleCompra.setListaProductos(new ArrayList<Producto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra compra = detalleCompra.getCompra();
            if (compra != null) {
                compra = em.getReference(compra.getClass(), compra.getIdCompra());
                detalleCompra.setCompra(compra);
            }
            List<Producto> attachedListaProductos = new ArrayList<Producto>();
            for (Producto listaProductosProductoToAttach : detalleCompra.getListaProductos()) {
                listaProductosProductoToAttach = em.getReference(listaProductosProductoToAttach.getClass(), listaProductosProductoToAttach.getIdProducto());
                attachedListaProductos.add(listaProductosProductoToAttach);
            }
            detalleCompra.setListaProductos(attachedListaProductos);
            em.persist(detalleCompra);
            if (compra != null) {
                compra.getListaDCompra().add(detalleCompra);
                compra = em.merge(compra);
            }
            for (Producto listaProductosProducto : detalleCompra.getListaProductos()) {
                DetalleCompra oldDetalleCompraOfListaProductosProducto = listaProductosProducto.getDetalleCompra();
                listaProductosProducto.setDetalleCompra(detalleCompra);
                listaProductosProducto = em.merge(listaProductosProducto);
                if (oldDetalleCompraOfListaProductosProducto != null) {
                    oldDetalleCompraOfListaProductosProducto.getListaProductos().remove(listaProductosProducto);
                    oldDetalleCompraOfListaProductosProducto = em.merge(oldDetalleCompraOfListaProductosProducto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleCompra detalleCompra) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleCompra persistentDetalleCompra = em.find(DetalleCompra.class, detalleCompra.getIdDCompra());
            Compra compraOld = persistentDetalleCompra.getCompra();
            Compra compraNew = detalleCompra.getCompra();
            List<Producto> listaProductosOld = persistentDetalleCompra.getListaProductos();
            List<Producto> listaProductosNew = detalleCompra.getListaProductos();
            List<String> illegalOrphanMessages = null;
            for (Producto listaProductosOldProducto : listaProductosOld) {
                if (!listaProductosNew.contains(listaProductosOldProducto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Producto " + listaProductosOldProducto + " since its detalleCompra field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (compraNew != null) {
                compraNew = em.getReference(compraNew.getClass(), compraNew.getIdCompra());
                detalleCompra.setCompra(compraNew);
            }
            List<Producto> attachedListaProductosNew = new ArrayList<Producto>();
            for (Producto listaProductosNewProductoToAttach : listaProductosNew) {
                listaProductosNewProductoToAttach = em.getReference(listaProductosNewProductoToAttach.getClass(), listaProductosNewProductoToAttach.getIdProducto());
                attachedListaProductosNew.add(listaProductosNewProductoToAttach);
            }
            listaProductosNew = attachedListaProductosNew;
            detalleCompra.setListaProductos(listaProductosNew);
            detalleCompra = em.merge(detalleCompra);
            if (compraOld != null && !compraOld.equals(compraNew)) {
                compraOld.getListaDCompra().remove(detalleCompra);
                compraOld = em.merge(compraOld);
            }
            if (compraNew != null && !compraNew.equals(compraOld)) {
                compraNew.getListaDCompra().add(detalleCompra);
                compraNew = em.merge(compraNew);
            }
            for (Producto listaProductosNewProducto : listaProductosNew) {
                if (!listaProductosOld.contains(listaProductosNewProducto)) {
                    DetalleCompra oldDetalleCompraOfListaProductosNewProducto = listaProductosNewProducto.getDetalleCompra();
                    listaProductosNewProducto.setDetalleCompra(detalleCompra);
                    listaProductosNewProducto = em.merge(listaProductosNewProducto);
                    if (oldDetalleCompraOfListaProductosNewProducto != null && !oldDetalleCompraOfListaProductosNewProducto.equals(detalleCompra)) {
                        oldDetalleCompraOfListaProductosNewProducto.getListaProductos().remove(listaProductosNewProducto);
                        oldDetalleCompraOfListaProductosNewProducto = em.merge(oldDetalleCompraOfListaProductosNewProducto);
                    }
                }
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

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            List<Producto> listaProductosOrphanCheck = detalleCompra.getListaProductos();
            for (Producto listaProductosOrphanCheckProducto : listaProductosOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DetalleCompra (" + detalleCompra + ") cannot be destroyed since the Producto " + listaProductosOrphanCheckProducto + " in its listaProductos field has a non-nullable detalleCompra field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
