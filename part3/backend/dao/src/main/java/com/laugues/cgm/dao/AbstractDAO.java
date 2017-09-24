package com.laugues.cgm.dao;

import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * Abstract class that will provide generic methods for all entityClasses.
 *
 * @param <EntityType> the type of entity
 */
public abstract class AbstractDAO<EntityType> extends AbstractBaseDAO<EntityType> implements Serializable
{

    /**
     * The Constant ASC.
     */
    public static final String ASC = "ASC";
    /**
     * The Constant DESC.
     */
    public static final String DESC = "DESC";
    /**
     * The Constant LOGGER.
     */
    protected static final transient Logger LOGGER = LoggerFactory
        .getLogger(AbstractDAO.class);
    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    EntityManager entityManager;

    /**
     * Instantiates a new abstract facade.
     *
     * @param entityClass the entity class
     */
    public AbstractDAO(final Class<EntityType> entityClass) {
        super(entityClass);
    }

    /**
     * Instantiates a new abstract facade.
     *
     * @param entityClass    the entity class
     * @param aEntityManager the entityManager
     */
    public AbstractDAO(final Class<EntityType> entityClass, final EntityManager aEntityManager) {
        super(entityClass);
        this.entityManager = aEntityManager;
    }

    /**
     * Initializes the class. If the database is oracle type, the alterSessionForOracle() method is called
     */
    @PostConstruct
    public void init() {
    }


    /**
     * Creates the entity.
     *
     * @param entity the entity to create
     */
    public void create(final EntityType entity) {
        LOGGER.debug(">>>>> com.itesoft.common.freemind.dao.common.AbstractDAO:create");
        getEntityManager().persist(entity);
        LOGGER.debug("<<<<< com.itesoft.common.freemind.dao.common.AbstractDAO:create");
    }

    /**
     * Edits the entity with a new one.
     *
     * @param entity the entity to edit
     * @return the t
     */
    public EntityType edit(final EntityType entity) {
        LOGGER.debug(">>>>> com.itesoft.common.freemind.dao.common.AbstractDAO:edit");
        final EntityType t = getEntityManager().merge(entity);
        LOGGER.debug("<<<<< com.itesoft.common.freemind.dao.common.AbstractDAO:edit");
        return t;
    }

    /**
     * Removes the entity.
     *
     * @param entity the entity to remove
     */
    public void remove(final EntityType entity) {
        LOGGER.debug(">>>>> com.itesoft.common.freemind.dao.common.AbstractDAO:remove");
        getEntityManager().remove(getEntityManager().contains(entity) ? entity : getEntityManager().merge(entity));
        LOGGER.debug("<<<<< com.itesoft.common.freemind.dao.common.AbstractDAO:remove");
    }

    /**
     * Find the entity bound to the id. Initializes the entityManager if null
     *
     * @param id            the id bound to the entity to find
     * @param entityManager : entityManager to use for query
     * @return the entity bound to the id
     */
    public EntityType find(final Object id, @Nullable EntityManager entityManager) {
        LOGGER.debug(">>>>> com.itesoft.common.freemind.dao.common.AbstractDAO:find");
        /**
         * Si l'entityManager est null on récupere l'entity manager de la requete client
         * s'il n'est pas null c'est que l'on est dans un applicationScoped
         */
        if (entityManager == null) {
            entityManager = getEntityManager();
        }
        final EntityType t = entityManager.find(entityClass, id);
        LOGGER.debug("<<<<< com.itesoft.common.freemind.dao.common.AbstractDAO:find");
        return t;
    }

    /**
     * Find the entity bound to the id.
     *
     * @param id the id bound to the entity to find
     * @return the entity bound to the id
     */
    public EntityType find(final Object id) {
        LOGGER.debug(">>>>> com.itesoft.common.freemind.dao.common.AbstractDAO:find");
        final EntityType t = getEntityManager().find(entityClass, id);
        LOGGER.debug("<<<<< com.itesoft.common.freemind.dao.common.AbstractDAO:find");
        return t;
    }

    /**
     * Find all the entityClasses
     *
     * @return a list of entityClasses
     */
    public List<EntityType> findAll() {
        LOGGER.debug(">>>>> com.itesoft.common.freemind.dao.common.AbstractDAO:findAll");
        final List<EntityType> ts = findAll(null);
        LOGGER.debug("<<<<< com.itesoft.common.freemind.dao.common.AbstractDAO:findAll");
        return ts;
    }

    /**
     * Find all the entityClasses.
     *
     * @param entityManager : entityManager to use for query. If null, a new entityManager will be load with getEntityManager() method
     * @return the list
     */
    public List<EntityType> findAll(@Nullable EntityManager entityManager) {
        LOGGER.debug(">>>>> " + this.getClass().getCanonicalName() + ":findAll");
        /**
         * Si l'entityManager est null on récupere l'entity manager de la requete client
         * s'il n'est pas null c'est que l'on est dans un applicationScoped
         */
        if (entityManager == null) {
            entityManager = getEntityManager();
        }
        final javax.persistence.criteria.CriteriaQuery<Object> cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));

        final List<EntityType> ts = (List<EntityType>) entityManager.createQuery(cq).getResultList();
        LOGGER.debug("<<<<< " + this.getClass().getCanonicalName() + ":findAll");
        return ts;
    }

    /**
     * Returns the number .
     *
     * @return the int
     */
    public int count() {
        LOGGER.debug(">>>>> " + this.getClass().getCanonicalName() + ":count");
        //récupétation du criteria builder
        final javax.persistence.criteria.CriteriaQuery<Object> cq = getEntityManager().getCriteriaBuilder()
                                                                                      .createQuery();
        //création du niveau from de la requete en fonction de la entityClass
        final javax.persistence.criteria.Root<EntityType> rt = cq.from(entityClass);
        //creation du niveau select count de la requete en fonction du form
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        //pré initialisation de la requête
        final javax.persistence.Query q = getEntityManager().createQuery(cq);
        //execute la requête
        final int lReturnValue = ((Long) q.getSingleResult()).intValue();
        LOGGER.debug("<<<<< " + this.getClass().getCanonicalName() + ":count");
        return lReturnValue;
    }

    /**
     * Gets the entity manager.
     *
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Sets the entity manager.
     *
     * @param aEntityManager the entityManager
     */
    public void setEntityManager(final EntityManager aEntityManager) {
        entityManager = aEntityManager;
    }
}