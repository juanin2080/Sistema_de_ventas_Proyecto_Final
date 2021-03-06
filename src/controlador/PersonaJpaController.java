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
import modelo.Cuenta;
import modelo.Factura;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Persona;

/**
 *
 * @author Juan Armijos, Cristian Capa, Maria Castillo, Kelly Preciado
 */
public class PersonaJpaController implements Serializable {
    
    public PersonaJpaController() {
    }

    public PersonaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sistema_de_Ventas_Proyecto_FinalPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    /**
     * Método create Crea una Persona en la base de datos
     * @param persona 
     */
    public void create(Persona persona) {
        if (persona.getListaFactura() == null) {
            persona.setListaFactura(new ArrayList<Factura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cuenta cuenta = persona.getCuenta();
            if (cuenta != null) {
                cuenta = em.getReference(cuenta.getClass(), cuenta.getIdCuenta());
                persona.setCuenta(cuenta);
            }
            List<Factura> attachedListaFactura = new ArrayList<Factura>();
            for (Factura listaFacturaFacturaToAttach : persona.getListaFactura()) {
                listaFacturaFacturaToAttach = em.getReference(listaFacturaFacturaToAttach.getClass(), listaFacturaFacturaToAttach.getIdFactura());
                attachedListaFactura.add(listaFacturaFacturaToAttach);
            }
            persona.setListaFactura(attachedListaFactura);
            em.persist(persona);
            if (cuenta != null) {
                Persona oldPersonaOfCuenta = cuenta.getPersona();
                if (oldPersonaOfCuenta != null) {
                    oldPersonaOfCuenta.setCuenta(null);
                    oldPersonaOfCuenta = em.merge(oldPersonaOfCuenta);
                }
                cuenta.setPersona(persona);
                cuenta = em.merge(cuenta);
            }
            for (Factura listaFacturaFactura : persona.getListaFactura()) {
                Persona oldPersonaOfListaFacturaFactura = listaFacturaFactura.getPersona();
                listaFacturaFactura.setPersona(persona);
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
    /**
     * Método edit edita una cláusula catch (reemplazable), el método no verifica si la entidad ya existe, sino que agrega una nueva entidad.
     * @param persona
     * @throws IllegalOrphanException encargados de controlar los posibles errores nacientes al conectar a la base de datos.
     * @throws NonexistentEntityException
     * @throws Exception Representa errores que no son críticos y por lo tanto pueden ser tratados y continuar la ejecución de la aplicación.
     */
    public void edit(Persona persona) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Long id = persona.getIdPersona();
            if (findPersona(id) == null) {
                throw new NonexistentEntityException("The persona with id " + id + " no longer exists.");
            }
            Persona persistentPersona = em.find(Persona.class, persona.getIdPersona());
            Cuenta cuentaOld = persistentPersona.getCuenta();
            Cuenta cuentaNew = persona.getCuenta();
            List<Factura> listaFacturaOld = persistentPersona.getListaFactura();
            List<Factura> listaFacturaNew = persona.getListaFactura();
            List<String> illegalOrphanMessages = null;
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
            if (cuentaNew != null) {
                cuentaNew = em.getReference(cuentaNew.getClass(), cuentaNew.getIdCuenta());
                persona.setCuenta(cuentaNew);
            }
            List<Factura> attachedListaFacturaNew = new ArrayList<Factura>();
            for (Factura listaFacturaNewFacturaToAttach : listaFacturaNew) {
                listaFacturaNewFacturaToAttach = em.getReference(listaFacturaNewFacturaToAttach.getClass(), listaFacturaNewFacturaToAttach.getIdFactura());
                attachedListaFacturaNew.add(listaFacturaNewFacturaToAttach);
            }
            listaFacturaNew = attachedListaFacturaNew;
            persona.setListaFactura(listaFacturaNew);
            persona = em.merge(persona);
            if (cuentaNew != null && !cuentaNew.equals(cuentaOld)) {
                Persona oldPersonaOfCuenta = cuentaNew.getPersona();
                if (oldPersonaOfCuenta != null) {
                    oldPersonaOfCuenta.setCuenta(null);
                    oldPersonaOfCuenta = em.merge(oldPersonaOfCuenta);
                }
                cuentaNew.setPersona(persona);
                cuentaNew = em.merge(cuentaNew);
            }
            for (Factura listaFacturaNewFactura : listaFacturaNew) {
                if (!listaFacturaOld.contains(listaFacturaNewFactura)) {
                    Persona oldPersonaOfListaFacturaNewFactura = listaFacturaNewFactura.getPersona();
                    listaFacturaNewFactura.setPersona(persona);
                    listaFacturaNewFactura = em.merge(listaFacturaNewFactura);
                    if (oldPersonaOfListaFacturaNewFactura != null && !oldPersonaOfListaFacturaNewFactura.equals(persona)) {
                        oldPersonaOfListaFacturaNewFactura.getListaFactura().remove(listaFacturaNewFactura);
                        oldPersonaOfListaFacturaNewFactura = em.merge(oldPersonaOfListaFacturaNewFactura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
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
            Persona persona;
            try {
                persona = em.getReference(Persona.class, id);
                persona.getIdPersona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The persona with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Cuenta cuentaOrphanCheck = persona.getCuenta();
            if (cuentaOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Cuenta " + cuentaOrphanCheck + " in its cuenta field has a non-nullable persona field.");
            }
            List<Factura> listaFacturaOrphanCheck = persona.getListaFactura();
            for (Factura listaFacturaOrphanCheckFactura : listaFacturaOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Persona (" + persona + ") cannot be destroyed since the Factura " + listaFacturaOrphanCheckFactura + " in its listaFactura field has a non-nullable persona field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(persona);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Persona> findPersonaEntities() {
        return findPersonaEntities(true, -1, -1);
    }

    public List<Persona> findPersonaEntities(int maxResults, int firstResult) {
        return findPersonaEntities(false, maxResults, firstResult);
    }

    private List<Persona> findPersonaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Persona.class));
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
     * Método findPersona busca el patrón especificado o la expresión en la subsecuencia daba por caracteres.
     * @param id
     * @return Retorna el valor de retorno de la operación es el recuento de elementos en la secuencia.
     */
    public Persona findPersona(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Persona.class, id);
        } finally {
            em.close();
        }
    }
    /**
     * Metodo PersonaCount devuelve el recuento de elementos en la secuencia.
     * @return Retorna el valor de retorno de la operación es el recuento de elementos en la secuencia.
     */
    public int getPersonaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Persona> rt = cq.from(Persona.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
