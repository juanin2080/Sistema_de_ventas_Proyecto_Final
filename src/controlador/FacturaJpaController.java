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
import modelo.Persona;
import modelo.DetalleFactura;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Factura;

/**
 *
 * @author juana
 */
public class FacturaJpaController implements Serializable {

    public FacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factura factura) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persona = factura.getPersona();
            if (persona != null) {
                persona = em.getReference(persona.getClass(), persona.getIdPersona());
                factura.setPersona(persona);
            }
            DetalleFactura detalleF = factura.getDetalleF();
            if (detalleF != null) {
                detalleF = em.getReference(detalleF.getClass(), detalleF.getIdDetalleFactura());
                factura.setDetalleF(detalleF);
            }
            em.persist(factura);
            if (persona != null) {
                persona.getListaFactura().add(factura);
                persona = em.merge(persona);
            }
            if (detalleF != null) {
                Factura oldFacturaOfDetalleF = detalleF.getFactura();
                if (oldFacturaOfDetalleF != null) {
                    oldFacturaOfDetalleF.setDetalleF(null);
                    oldFacturaOfDetalleF = em.merge(oldFacturaOfDetalleF);
                }
                detalleF.setFactura(factura);
                detalleF = em.merge(detalleF);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factura factura) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura persistentFactura = em.find(Factura.class, factura.getIdFactura());
            Persona personaOld = persistentFactura.getPersona();
            Persona personaNew = factura.getPersona();
            DetalleFactura detalleFOld = persistentFactura.getDetalleF();
            DetalleFactura detalleFNew = factura.getDetalleF();
            List<String> illegalOrphanMessages = null;
            if (detalleFOld != null && !detalleFOld.equals(detalleFNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain DetalleFactura " + detalleFOld + " since its factura field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (personaNew != null) {
                personaNew = em.getReference(personaNew.getClass(), personaNew.getIdPersona());
                factura.setPersona(personaNew);
            }
            if (detalleFNew != null) {
                detalleFNew = em.getReference(detalleFNew.getClass(), detalleFNew.getIdDetalleFactura());
                factura.setDetalleF(detalleFNew);
            }
            factura = em.merge(factura);
            if (personaOld != null && !personaOld.equals(personaNew)) {
                personaOld.getListaFactura().remove(factura);
                personaOld = em.merge(personaOld);
            }
            if (personaNew != null && !personaNew.equals(personaOld)) {
                personaNew.getListaFactura().add(factura);
                personaNew = em.merge(personaNew);
            }
            if (detalleFNew != null && !detalleFNew.equals(detalleFOld)) {
                Factura oldFacturaOfDetalleF = detalleFNew.getFactura();
                if (oldFacturaOfDetalleF != null) {
                    oldFacturaOfDetalleF.setDetalleF(null);
                    oldFacturaOfDetalleF = em.merge(oldFacturaOfDetalleF);
                }
                detalleFNew.setFactura(factura);
                detalleFNew = em.merge(detalleFNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = factura.getIdFactura();
                if (findFactura(id) == null) {
                    throw new NonexistentEntityException("The factura with id " + id + " no longer exists.");
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
            Factura factura;
            try {
                factura = em.getReference(Factura.class, id);
                factura.getIdFactura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factura with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            DetalleFactura detalleFOrphanCheck = factura.getDetalleF();
            if (detalleFOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Factura (" + factura + ") cannot be destroyed since the DetalleFactura " + detalleFOrphanCheck + " in its detalleF field has a non-nullable factura field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Persona persona = factura.getPersona();
            if (persona != null) {
                persona.getListaFactura().remove(factura);
                persona = em.merge(persona);
            }
            em.remove(factura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factura> findFacturaEntities() {
        return findFacturaEntities(true, -1, -1);
    }

    public List<Factura> findFacturaEntities(int maxResults, int firstResult) {
        return findFacturaEntities(false, maxResults, firstResult);
    }

    private List<Factura> findFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factura.class));
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

    public Factura findFactura(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factura.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factura> rt = cq.from(Factura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
