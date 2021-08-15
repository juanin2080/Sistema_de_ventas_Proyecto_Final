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
import modelo.DetalleFactura;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.DetalleCompra;
import modelo.Producto;

/**
 *
 * @author Juan Armijos, Cristian Capa, Maria Castillo, Kelly Preciado
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
    /**
     * Método create Crea un producto en la base de datos
     * @param producto 
     */
    public void create(Producto producto) {
        if (producto.getListaDetalleFactura() == null) {
            producto.setListaDetalleFactura(new ArrayList<DetalleFactura>());
        }
        if (producto.getListaDetalleCompra() == null) {
            producto.setListaDetalleCompra(new ArrayList<DetalleCompra>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<DetalleFactura> attachedListaDetalleFactura = new ArrayList<DetalleFactura>();
            for (DetalleFactura listaDetalleFacturaDetalleFacturaToAttach : producto.getListaDetalleFactura()) {
                listaDetalleFacturaDetalleFacturaToAttach = em.getReference(listaDetalleFacturaDetalleFacturaToAttach.getClass(), listaDetalleFacturaDetalleFacturaToAttach.getIdDetalleFactura());
                attachedListaDetalleFactura.add(listaDetalleFacturaDetalleFacturaToAttach);
            }
            producto.setListaDetalleFactura(attachedListaDetalleFactura);
            ArrayList<DetalleCompra> attachedListaDetalleCompra = new ArrayList<DetalleCompra>();
            for (DetalleCompra listaDetalleCompraDetalleCompraToAttach : producto.getListaDetalleCompra()) {
                listaDetalleCompraDetalleCompraToAttach = em.getReference(listaDetalleCompraDetalleCompraToAttach.getClass(), listaDetalleCompraDetalleCompraToAttach.getIdDCompra());
                attachedListaDetalleCompra.add(listaDetalleCompraDetalleCompraToAttach);
            }
            producto.setListaDetalleCompra(attachedListaDetalleCompra);
            em.persist(producto);
            for (DetalleFactura listaDetalleFacturaDetalleFactura : producto.getListaDetalleFactura()) {
                Producto oldProductoOfListaDetalleFacturaDetalleFactura = listaDetalleFacturaDetalleFactura.getProducto();
                listaDetalleFacturaDetalleFactura.setProducto(producto);
                listaDetalleFacturaDetalleFactura = em.merge(listaDetalleFacturaDetalleFactura);
                if (oldProductoOfListaDetalleFacturaDetalleFactura != null) {
                    oldProductoOfListaDetalleFacturaDetalleFactura.getListaDetalleFactura().remove(listaDetalleFacturaDetalleFactura);
                    oldProductoOfListaDetalleFacturaDetalleFactura = em.merge(oldProductoOfListaDetalleFacturaDetalleFactura);
                }
            }
            for (DetalleCompra listaDetalleCompraDetalleCompra : producto.getListaDetalleCompra()) {
                Producto oldProductoOfListaDetalleCompraDetalleCompra = listaDetalleCompraDetalleCompra.getProducto();
                listaDetalleCompraDetalleCompra.setProducto(producto);
                listaDetalleCompraDetalleCompra = em.merge(listaDetalleCompraDetalleCompra);
                if (oldProductoOfListaDetalleCompraDetalleCompra != null) {
                    oldProductoOfListaDetalleCompraDetalleCompra.getListaDetalleCompra().remove(listaDetalleCompraDetalleCompra);
                    oldProductoOfListaDetalleCompraDetalleCompra = em.merge(oldProductoOfListaDetalleCompraDetalleCompra);
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
     * @param producto
     * @throws IllegalOrphanException encargados de controlar los posibles errores nacientes al conectar a la base de datos.
     * @throws NonexistentEntityException
     * @throws Exception Representa errores que no son críticos y por lo tanto pueden ser tratados y continuar la ejecución de la aplicación.
     */
    public void edit(Producto producto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getIdProducto());
            ArrayList<DetalleFactura> listaDetalleFacturaOld = persistentProducto.getListaDetalleFactura();
            ArrayList<DetalleFactura> listaDetalleFacturaNew = producto.getListaDetalleFactura();
            ArrayList<DetalleCompra> listaDetalleCompraOld = persistentProducto.getListaDetalleCompra();
            ArrayList<DetalleCompra> listaDetalleCompraNew = producto.getListaDetalleCompra();
            List<String> illegalOrphanMessages = null;
            for (DetalleFactura listaDetalleFacturaOldDetalleFactura : listaDetalleFacturaOld) {
                if (!listaDetalleFacturaNew.contains(listaDetalleFacturaOldDetalleFactura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleFactura " + listaDetalleFacturaOldDetalleFactura + " since its producto field is not nullable.");
                }
            }
            for (DetalleCompra listaDetalleCompraOldDetalleCompra : listaDetalleCompraOld) {
                if (!listaDetalleCompraNew.contains(listaDetalleCompraOldDetalleCompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleCompra " + listaDetalleCompraOldDetalleCompra + " since its producto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            ArrayList<DetalleFactura> attachedListaDetalleFacturaNew = new ArrayList<DetalleFactura>();
            for (DetalleFactura listaDetalleFacturaNewDetalleFacturaToAttach : listaDetalleFacturaNew) {
                listaDetalleFacturaNewDetalleFacturaToAttach = em.getReference(listaDetalleFacturaNewDetalleFacturaToAttach.getClass(), listaDetalleFacturaNewDetalleFacturaToAttach.getIdDetalleFactura());
                attachedListaDetalleFacturaNew.add(listaDetalleFacturaNewDetalleFacturaToAttach);
            }
            listaDetalleFacturaNew = attachedListaDetalleFacturaNew;
            producto.setListaDetalleFactura(listaDetalleFacturaNew);
            ArrayList<DetalleCompra> attachedListaDetalleCompraNew = new ArrayList<DetalleCompra>();
            for (DetalleCompra listaDetalleCompraNewDetalleCompraToAttach : listaDetalleCompraNew) {
                listaDetalleCompraNewDetalleCompraToAttach = em.getReference(listaDetalleCompraNewDetalleCompraToAttach.getClass(), listaDetalleCompraNewDetalleCompraToAttach.getIdDCompra());
                attachedListaDetalleCompraNew.add(listaDetalleCompraNewDetalleCompraToAttach);
            }
            listaDetalleCompraNew = attachedListaDetalleCompraNew;
            producto.setListaDetalleCompra(listaDetalleCompraNew);
            producto = em.merge(producto);
            for (DetalleFactura listaDetalleFacturaNewDetalleFactura : listaDetalleFacturaNew) {
                if (!listaDetalleFacturaOld.contains(listaDetalleFacturaNewDetalleFactura)) {
                    Producto oldProductoOfListaDetalleFacturaNewDetalleFactura = listaDetalleFacturaNewDetalleFactura.getProducto();
                    listaDetalleFacturaNewDetalleFactura.setProducto(producto);
                    listaDetalleFacturaNewDetalleFactura = em.merge(listaDetalleFacturaNewDetalleFactura);
                    if (oldProductoOfListaDetalleFacturaNewDetalleFactura != null && !oldProductoOfListaDetalleFacturaNewDetalleFactura.equals(producto)) {
                        oldProductoOfListaDetalleFacturaNewDetalleFactura.getListaDetalleFactura().remove(listaDetalleFacturaNewDetalleFactura);
                        oldProductoOfListaDetalleFacturaNewDetalleFactura = em.merge(oldProductoOfListaDetalleFacturaNewDetalleFactura);
                    }
                }
            }
            for (DetalleCompra listaDetalleCompraNewDetalleCompra : listaDetalleCompraNew) {
                if (!listaDetalleCompraOld.contains(listaDetalleCompraNewDetalleCompra)) {
                    Producto oldProductoOfListaDetalleCompraNewDetalleCompra = listaDetalleCompraNewDetalleCompra.getProducto();
                    listaDetalleCompraNewDetalleCompra.setProducto(producto);
                    listaDetalleCompraNewDetalleCompra = em.merge(listaDetalleCompraNewDetalleCompra);
                    if (oldProductoOfListaDetalleCompraNewDetalleCompra != null && !oldProductoOfListaDetalleCompraNewDetalleCompra.equals(producto)) {
                        oldProductoOfListaDetalleCompraNewDetalleCompra.getListaDetalleCompra().remove(listaDetalleCompraNewDetalleCompra);
                        oldProductoOfListaDetalleCompraNewDetalleCompra = em.merge(oldProductoOfListaDetalleCompraNewDetalleCompra);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = producto.getIdProducto();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("El producto con el id: " + id + " no existe.");
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
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            ArrayList<DetalleFactura> listaDetalleFacturaOrphanCheck = producto.getListaDetalleFactura();
            for (DetalleFactura listaDetalleFacturaOrphanCheckDetalleFactura : listaDetalleFacturaOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the DetalleFactura " + listaDetalleFacturaOrphanCheckDetalleFactura + " in its listaDetalleFactura field has a non-nullable producto field.");
            }
            ArrayList<DetalleCompra> listaDetalleCompraOrphanCheck = producto.getListaDetalleCompra();
            for (DetalleCompra listaDetalleCompraOrphanCheckDetalleCompra : listaDetalleCompraOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the DetalleCompra " + listaDetalleCompraOrphanCheckDetalleCompra + " in its listaDetalleCompra field has a non-nullable producto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
    /**
     * Método findProducto busca el patrón especificado o la expresión en la subsecuencia daba por caracteres.
     * @param id
     * @return Retorna el valor de retorno de la operación es el recuento de elementos en la secuencia.
     */
    public Producto findProducto(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }
    /**
     * 
     * 
     * @return Retorna el valor de retorno de la operación es el recuento de elementos en la secuencia.
     */
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
