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
import modelo.DetalleCompra;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Compra;

/**
 *
 * @author juana
 */


public class CompraJpaController implements Serializable {

    public CompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sistema_de_Ventas_Proyecto_FinalPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CompraJpaController() {
    }

    /**
     *Método create, crea una compra en la base de datos
     * @param compra
     */

    public void create(Compra compra) {
        if (compra.getListaDCompra() == null) {
            compra.setListaDCompra(new ArrayList<DetalleCompra>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<DetalleCompra> attachedListaDCompra = new ArrayList<DetalleCompra>();
            for (DetalleCompra listaDCompraDetalleCompraToAttach : compra.getListaDCompra()) {
                listaDCompraDetalleCompraToAttach = em.getReference(listaDCompraDetalleCompraToAttach.getClass(), listaDCompraDetalleCompraToAttach.getIdDCompra());
                attachedListaDCompra.add(listaDCompraDetalleCompraToAttach);
            }
            compra.setListaDCompra(attachedListaDCompra);
            em.persist(compra);
            for (DetalleCompra listaDCompraDetalleCompra : compra.getListaDCompra()) {
                Compra oldCompraOfListaDCompraDetalleCompra = listaDCompraDetalleCompra.getCompra();
                listaDCompraDetalleCompra.setCompra(compra);
                listaDCompraDetalleCompra = em.merge(listaDCompraDetalleCompra);
                if (oldCompraOfListaDCompraDetalleCompra != null) {
                    oldCompraOfListaDCompraDetalleCompra.getListaDCompra().remove(listaDCompraDetalleCompra);
                    oldCompraOfListaDCompraDetalleCompra = em.merge(oldCompraOfListaDCompraDetalleCompra);
                }
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
     * @param compra
     * @throws IllegalOrphanException El Flujo de ejecución se detiene
     * inmediatamente despues de la sentencia throw, nunca se llega a la
     * siguiente sentencia
     * @throws NonexistentEntityException encargado de controlar los posibles errores nacientes al conectar a la base de datos.
     * @throws Exception Representa errores que no son críticos y por lo tanto pueden ser tratados y continuar la ejecución de la aplicación.
     */
    public void edit(Compra compra) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra persistentCompra = em.find(Compra.class, compra.getIdCompra());
            List<DetalleCompra> listaDCompraOld = persistentCompra.getListaDCompra();
            List<DetalleCompra> listaDCompraNew = compra.getListaDCompra();
            List<String> illegalOrphanMessages = null;
            for (DetalleCompra listaDCompraOldDetalleCompra : listaDCompraOld) {
                if (!listaDCompraNew.contains(listaDCompraOldDetalleCompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleCompra " + listaDCompraOldDetalleCompra + " since its compra field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<DetalleCompra> attachedListaDCompraNew = new ArrayList<DetalleCompra>();
            for (DetalleCompra listaDCompraNewDetalleCompraToAttach : listaDCompraNew) {
                listaDCompraNewDetalleCompraToAttach = em.getReference(listaDCompraNewDetalleCompraToAttach.getClass(), listaDCompraNewDetalleCompraToAttach.getIdDCompra());
                attachedListaDCompraNew.add(listaDCompraNewDetalleCompraToAttach);
            }
            listaDCompraNew = attachedListaDCompraNew;
            compra.setListaDCompra(listaDCompraNew);
            compra = em.merge(compra);
            for (DetalleCompra listaDCompraNewDetalleCompra : listaDCompraNew) {
                if (!listaDCompraOld.contains(listaDCompraNewDetalleCompra)) {
                    Compra oldCompraOfListaDCompraNewDetalleCompra = listaDCompraNewDetalleCompra.getCompra();
                    listaDCompraNewDetalleCompra.setCompra(compra);
                    listaDCompraNewDetalleCompra = em.merge(listaDCompraNewDetalleCompra);
                    if (oldCompraOfListaDCompraNewDetalleCompra != null && !oldCompraOfListaDCompraNewDetalleCompra.equals(compra)) {
                        oldCompraOfListaDCompraNewDetalleCompra.getListaDCompra().remove(listaDCompraNewDetalleCompra);
                        oldCompraOfListaDCompraNewDetalleCompra = em.merge(oldCompraOfListaDCompraNewDetalleCompra);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = compra.getIdCompra();
                if (findCompra(id) == null) {
                    throw new NonexistentEntityException("The compra with id " + id + " no longer exists.");
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
     * @throws IllegalOrphanException encargados de controlar los posibles errores nacientes al conectar a la base de datos.
     * @throws NonexistentEntityException
     */
    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra compra;
            try {
                compra = em.getReference(Compra.class, id);
                compra.getIdCompra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The compra with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<DetalleCompra> listaDCompraOrphanCheck = compra.getListaDCompra();
            for (DetalleCompra listaDCompraOrphanCheckDetalleCompra : listaDCompraOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Compra (" + compra + ") cannot be destroyed since the DetalleCompra " + listaDCompraOrphanCheckDetalleCompra + " in its listaDCompra field has a non-nullable compra field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(compra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Compra> findCompraEntities() {
        return findCompraEntities(true, -1, -1);
    }

    public List<Compra> findCompraEntities(int maxResults, int firstResult) {
        return findCompraEntities(false, maxResults, firstResult);
    }
    /**
     * Metodo FindCompraEntities se utilizapara recuperarla entidad de la base de datos
     * @param all
     * @param maxResults
     * @param firstResult
     * @return 
     */
    private List<Compra> findCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Compra.class));
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
     * Método findCompra busca el patrón especificado o la expresión en la subsecuencia daba por caracteres
     * @param id
     * @return Retorna el valor de retorno de la operación es el recuento de elementos en la secuencia
     */
    public Compra findCompra(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compra.class, id);
        } finally {
            em.close();
        }
    }
    /**
     * Metodo CompraCount devuelve el recuento de elementos en la secuencia 
     * @return  Retorna el valor de retorno de la operación es el recuento de elementos en la secuencia
     */
    public int getCompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Compra> rt = cq.from(Compra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
