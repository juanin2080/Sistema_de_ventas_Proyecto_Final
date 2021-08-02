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
import modelo.Factura;
import modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.DetalleFactura;

/**
 *
 * @author juana
 */
public class DetalleFacturaJpaController implements Serializable {

    public DetalleFacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleFactura detalleFactura) throws IllegalOrphanException {
        if (detalleFactura.getListaProducto() == null) {
            detalleFactura.setListaProducto(new ArrayList<Producto>());
        }
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
            Factura factura = detalleFactura.getFactura();
            if (factura != null) {
                factura = em.getReference(factura.getClass(), factura.getIdFactura());
                detalleFactura.setFactura(factura);
            }
            List<Producto> attachedListaProducto = new ArrayList<Producto>();
            for (Producto listaProductoProductoToAttach : detalleFactura.getListaProducto()) {
                listaProductoProductoToAttach = em.getReference(listaProductoProductoToAttach.getClass(), listaProductoProductoToAttach.getId_Producto());
                attachedListaProducto.add(listaProductoProductoToAttach);
            }
            detalleFactura.setListaProducto(attachedListaProducto);
            em.persist(detalleFactura);
            if (factura != null) {
                factura.setDetalleF(detalleFactura);
                factura = em.merge(factura);
            }
            for (Producto listaProductoProducto : detalleFactura.getListaProducto()) {
                DetalleFactura oldDetalleFacturaOfListaProductoProducto = listaProductoProducto.getDetalleFactura();
                listaProductoProducto.setDetalleFactura(detalleFactura);
                listaProductoProducto = em.merge(listaProductoProducto);
                if (oldDetalleFacturaOfListaProductoProducto != null) {
                    oldDetalleFacturaOfListaProductoProducto.getListaProducto().remove(listaProductoProducto);
                    oldDetalleFacturaOfListaProductoProducto = em.merge(oldDetalleFacturaOfListaProductoProducto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleFactura detalleFactura) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleFactura persistentDetalleFactura = em.find(DetalleFactura.class, detalleFactura.getIdDetalleFactura());
            Factura facturaOld = persistentDetalleFactura.getFactura();
            Factura facturaNew = detalleFactura.getFactura();
            List<Producto> listaProductoOld = persistentDetalleFactura.getListaProducto();
            List<Producto> listaProductoNew = detalleFactura.getListaProducto();
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
            for (Producto listaProductoOldProducto : listaProductoOld) {
                if (!listaProductoNew.contains(listaProductoOldProducto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Producto " + listaProductoOldProducto + " since its detalleFactura field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (facturaNew != null) {
                facturaNew = em.getReference(facturaNew.getClass(), facturaNew.getIdFactura());
                detalleFactura.setFactura(facturaNew);
            }
            List<Producto> attachedListaProductoNew = new ArrayList<Producto>();
            for (Producto listaProductoNewProductoToAttach : listaProductoNew) {
                listaProductoNewProductoToAttach = em.getReference(listaProductoNewProductoToAttach.getClass(), listaProductoNewProductoToAttach.getId_Producto());
                attachedListaProductoNew.add(listaProductoNewProductoToAttach);
            }
            listaProductoNew = attachedListaProductoNew;
            detalleFactura.setListaProducto(listaProductoNew);
            detalleFactura = em.merge(detalleFactura);
            if (facturaOld != null && !facturaOld.equals(facturaNew)) {
                facturaOld.setDetalleF(null);
                facturaOld = em.merge(facturaOld);
            }
            if (facturaNew != null && !facturaNew.equals(facturaOld)) {
                facturaNew.setDetalleF(detalleFactura);
                facturaNew = em.merge(facturaNew);
            }
            for (Producto listaProductoNewProducto : listaProductoNew) {
                if (!listaProductoOld.contains(listaProductoNewProducto)) {
                    DetalleFactura oldDetalleFacturaOfListaProductoNewProducto = listaProductoNewProducto.getDetalleFactura();
                    listaProductoNewProducto.setDetalleFactura(detalleFactura);
                    listaProductoNewProducto = em.merge(listaProductoNewProducto);
                    if (oldDetalleFacturaOfListaProductoNewProducto != null && !oldDetalleFacturaOfListaProductoNewProducto.equals(detalleFactura)) {
                        oldDetalleFacturaOfListaProductoNewProducto.getListaProducto().remove(listaProductoNewProducto);
                        oldDetalleFacturaOfListaProductoNewProducto = em.merge(oldDetalleFacturaOfListaProductoNewProducto);
                    }
                }
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

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            List<Producto> listaProductoOrphanCheck = detalleFactura.getListaProducto();
            for (Producto listaProductoOrphanCheckProducto : listaProductoOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DetalleFactura (" + detalleFactura + ") cannot be destroyed since the Producto " + listaProductoOrphanCheckProducto + " in its listaProducto field has a non-nullable detalleFactura field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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

    public DetalleFactura findDetalleFactura(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleFactura.class, id);
        } finally {
            em.close();
        }
    }

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
