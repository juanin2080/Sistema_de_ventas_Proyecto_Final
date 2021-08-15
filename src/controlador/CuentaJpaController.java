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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Cuenta;

/**
 *
 * @author Juan Armijos, Cristian Capa, Maria Castillo, Kelly Preciado
 */
public class CuentaJpaController implements Serializable {

    public CuentaJpaController() {
    }

    public CuentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sistema_de_Ventas_Proyecto_FinalPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    /**
     * Método create Crea una compra en la base de datos
     * @param cuenta
     * @throws IllegalOrphanException encargados de controlar los posibles errores nacientes al conectar a la base de datos.
     */
    public void create(Cuenta cuenta) throws IllegalOrphanException {
        List<String> illegalOrphanMessages = null;
        Persona personaOrphanCheck = cuenta.getPersona();
        if (personaOrphanCheck != null) {
            Cuenta oldCuentaOfPersona = personaOrphanCheck.getCuenta();
            if (oldCuentaOfPersona != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Persona " + personaOrphanCheck + " already has an item of type Cuenta whose persona column cannot be null. Please make another selection for the persona field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Persona persona = cuenta.getPersona();
            if (persona != null) {
                persona = em.getReference(persona.getClass(), persona.getIdPersona());
                cuenta.setPersona(persona);
            }
            em.persist(cuenta);
            if (persona != null) {
                persona.setCuenta(cuenta);
                persona = em.merge(persona);
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
     * @param cuenta
     * @throws IllegalOrphanException encargados de controlar los posibles errores nacientes al conectar a la base de datos.
     * @throws NonexistentEntityException
     * @throws Exception Representa errores que no son críticos y por lo tanto pueden ser tratados y continuar la ejecución de la aplicación.
     */
    public void edit(Cuenta cuenta) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cuenta persistentCuenta = em.find(Cuenta.class, cuenta.getIdCuenta());
            Persona personaOld = persistentCuenta.getPersona();
            Persona personaNew = cuenta.getPersona();
            List<String> illegalOrphanMessages = null;
            if (personaNew != null && !personaNew.equals(personaOld)) {
                Cuenta oldCuentaOfPersona = personaNew.getCuenta();
                if (oldCuentaOfPersona != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Persona " + personaNew + " already has an item of type Cuenta whose persona column cannot be null. Please make another selection for the persona field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (personaNew != null) {
                personaNew = em.getReference(personaNew.getClass(), personaNew.getIdPersona());
                cuenta.setPersona(personaNew);
            }
            cuenta = em.merge(cuenta);
            if (personaOld != null && !personaOld.equals(personaNew)) {
                personaOld.setCuenta(null);
                personaOld = em.merge(personaOld);
            }
            if (personaNew != null && !personaNew.equals(personaOld)) {
                personaNew.setCuenta(cuenta);
                personaNew = em.merge(personaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = cuenta.getIdCuenta();
                if (findCuenta(id) == null) {
                    throw new NonexistentEntityException("The cuenta with id " + id + " no longer exists.");
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
            Cuenta cuenta;
            try {
                cuenta = em.getReference(Cuenta.class, id);
                cuenta.getIdCuenta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cuenta with id " + id + " no longer exists.", enfe);
            }
            Persona persona = cuenta.getPersona();
            if (persona != null) {
                persona.setCuenta(null);
                persona = em.merge(persona);
            }
            em.remove(cuenta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cuenta> findCuentaEntities() {
        return findCuentaEntities(true, -1, -1);
    }

    public List<Cuenta> findCuentaEntities(int maxResults, int firstResult) {
        return findCuentaEntities(false, maxResults, firstResult);
    }

    private List<Cuenta> findCuentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cuenta.class));
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
     * Método findCuenta busca el patrón especificado o la expresión en la subsecuencia daba por caracteres.
     * @param id
     * @return Retorna el valor de retorno de la operación es el recuento de elementos en la secuencia.
     */
    public Cuenta findCuenta(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cuenta.class, id);
        } finally {
            em.close();
        }
    }
  /**
     * Metodo CuentaCount devuelve el recuento de elementos en la secuencia. 
     * @return  el valor de retorno de la operación es el recuento de elementos en la secuencia.
     */
    public int getCuentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cuenta> rt = cq.from(Cuenta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
