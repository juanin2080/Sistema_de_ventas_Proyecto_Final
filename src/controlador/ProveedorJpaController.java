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
import modelo.Rol;
import modelo.Cuenta;
import modelo.Factura;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Proveedor;

/**
 *
 * @author juana
 */
public class ProveedorJpaController implements Serializable {

    public ProveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proveedor proveedor) {
        if (proveedor.getListaFactura() == null) {
            proveedor.setListaFactura(new ArrayList<Factura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol rol = proveedor.getRol();
            if (rol != null) {
                rol = em.merge(rol);
                proveedor.setRol(rol);
            }
            Cuenta cuenta = proveedor.getCuenta();
            if (cuenta != null) {
                cuenta = em.getReference(cuenta.getClass(), cuenta.getIdCuenta());
                proveedor.setCuenta(cuenta);
            }
            List<Factura> attachedListaFactura = new ArrayList<Factura>();
            for (Factura listaFacturaFacturaToAttach : proveedor.getListaFactura()) {
                listaFacturaFacturaToAttach = em.getReference(listaFacturaFacturaToAttach.getClass(), listaFacturaFacturaToAttach.getIdFactura());
                attachedListaFactura.add(listaFacturaFacturaToAttach);
            }
            proveedor.setListaFactura(attachedListaFactura);
            em.persist(proveedor);
            if (rol != null) {
                modelo.Persona oldPersonaOfRol = rol.getPersona();
                if (oldPersonaOfRol != null) {
                    oldPersonaOfRol.setRol(null);
                    oldPersonaOfRol = em.merge(oldPersonaOfRol);
                }
                rol.setPersona(proveedor);
                rol = em.merge(rol);
            }
            if (cuenta != null) {
                modelo.Persona oldPersonaOfCuenta = cuenta.getPersona();
                if (oldPersonaOfCuenta != null) {
                    oldPersonaOfCuenta.setCuenta(null);
                    oldPersonaOfCuenta = em.merge(oldPersonaOfCuenta);
                }
                cuenta.setPersona(proveedor);
                cuenta = em.merge(cuenta);
            }
            for (Factura listaFacturaFactura : proveedor.getListaFactura()) {
                modelo.Persona oldPersonaOfListaFacturaFactura = listaFacturaFactura.getPersona();
                listaFacturaFactura.setPersona(proveedor);
                listaFacturaFactura = em.merge(listaFacturaFactura);
                if (oldPersonaOfListaFacturaFactura != null) {
                    oldPersonaOfListaFacturaFactura.getListaFactura().remove(listaFacturaFactura);
                    oldPersonaOfListaFacturaFactura = em.merge(oldPersonaOfListaFacturaFactura);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedor proveedor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor persistentProveedor = em.find(Proveedor.class, proveedor.getIdPersona());
            Rol rolOld = persistentProveedor.getRol();
            Rol rolNew = proveedor.getRol();
            Cuenta cuentaOld = persistentProveedor.getCuenta();
            Cuenta cuentaNew = proveedor.getCuenta();
            List<Factura> listaFacturaOld = persistentProveedor.getListaFactura();
            List<Factura> listaFacturaNew = proveedor.getListaFactura();
            List<String> illegalOrphanMessages = null;
            if (rolOld != null && !rolOld.equals(rolNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Rol " + rolOld + " since its persona field is not nullable.");
            }
            if (cuentaOld != null && !cuentaOld.equals(cuentaNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Cuenta " + cuentaOld + " since its persona field is not nullable.");
            }
            for (Factura listaFacturaOldFactura : listaFacturaOld) {
                if (!listaFacturaNew.contains(listaFacturaOldFactura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factura " + listaFacturaOldFactura + " since its persona field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (rolNew != null) {
                rolNew = em.merge(rolNew);
                proveedor.setRol(rolNew);
            }
            if (cuentaNew != null) {
                cuentaNew = em.getReference(cuentaNew.getClass(), cuentaNew.getIdCuenta());
                proveedor.setCuenta(cuentaNew);
            }
            List<Factura> attachedListaFacturaNew = new ArrayList<Factura>();
            for (Factura listaFacturaNewFacturaToAttach : listaFacturaNew) {
                listaFacturaNewFacturaToAttach = em.getReference(listaFacturaNewFacturaToAttach.getClass(), listaFacturaNewFacturaToAttach.getIdFactura());
                attachedListaFacturaNew.add(listaFacturaNewFacturaToAttach);
            }
            listaFacturaNew = attachedListaFacturaNew;
            proveedor.setListaFactura(listaFacturaNew);
            proveedor = em.merge(proveedor);
            if (rolNew != null && !rolNew.equals(rolOld)) {
                modelo.Persona oldPersonaOfRol = rolNew.getPersona();
                if (oldPersonaOfRol != null) {
                    oldPersonaOfRol.setRol(null);
                    oldPersonaOfRol = em.merge(oldPersonaOfRol);
                }
                rolNew.setPersona(proveedor);
                rolNew = em.merge(rolNew);
            }
            if (cuentaNew != null && !cuentaNew.equals(cuentaOld)) {
                modelo.Persona oldPersonaOfCuenta = cuentaNew.getPersona();
                if (oldPersonaOfCuenta != null) {
                    oldPersonaOfCuenta.setCuenta(null);
                    oldPersonaOfCuenta = em.merge(oldPersonaOfCuenta);
                }
                cuentaNew.setPersona(proveedor);
                cuentaNew = em.merge(cuentaNew);
            }
            for (Factura listaFacturaNewFactura : listaFacturaNew) {
                if (!listaFacturaOld.contains(listaFacturaNewFactura)) {
                    Proveedor oldPersonaOfListaFacturaNewFactura = (Proveedor) listaFacturaNewFactura.getPersona();
                    listaFacturaNewFactura.setPersona(proveedor);
                    listaFacturaNewFactura = em.merge(listaFacturaNewFactura);
                    if (oldPersonaOfListaFacturaNewFactura != null && !oldPersonaOfListaFacturaNewFactura.equals(proveedor)) {
                        oldPersonaOfListaFacturaNewFactura.getListaFactura().remove(listaFacturaNewFactura);
                        oldPersonaOfListaFacturaNewFactura = em.merge(oldPersonaOfListaFacturaNewFactura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = proveedor.getIdPersona();
                if (findProveedor(id) == null) {
                    throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.");
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
            Proveedor proveedor;
            try {
                proveedor = em.getReference(Proveedor.class, id);
                proveedor.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Rol rolOrphanCheck = proveedor.getRol();
            if (rolOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Proveedor (" + proveedor + ") cannot be destroyed since the Rol " + rolOrphanCheck + " in its rol field has a non-nullable persona field.");
            }
            Cuenta cuentaOrphanCheck = proveedor.getCuenta();
            if (cuentaOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Proveedor (" + proveedor + ") cannot be destroyed since the Cuenta " + cuentaOrphanCheck + " in its cuenta field has a non-nullable persona field.");
            }
            List<Factura> listaFacturaOrphanCheck = proveedor.getListaFactura();
            for (Factura listaFacturaOrphanCheckFactura : listaFacturaOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Proveedor (" + proveedor + ") cannot be destroyed since the Factura " + listaFacturaOrphanCheckFactura + " in its listaFactura field has a non-nullable persona field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(proveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proveedor> findProveedorEntities() {
        return findProveedorEntities(true, -1, -1);
    }

    public List<Proveedor> findProveedorEntities(int maxResults, int firstResult) {
        return findProveedorEntities(false, maxResults, firstResult);
    }

    private List<Proveedor> findProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedor.class));
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

    public Proveedor findProveedor(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proveedor> rt = cq.from(Proveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
