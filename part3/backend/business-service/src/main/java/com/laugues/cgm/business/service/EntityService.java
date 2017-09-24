package com.laugues.cgm.business.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class EntityService<Entity, EntityIdType>
{
    private final Class<Entity> entityClass;

    @PersistenceContext
    protected EntityManager em;

    /**
     * The main constructor of the entityService
     *
     * @param entityClass the generic Entity service class
     */
    public EntityService(final Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    public Class<Entity> getEntityClass() {
        return entityClass;
    }

    /**
     * Find an entity by id
     *
     * @param id id of the entity
     * @return the entity found
     */
    public abstract Entity find(final EntityIdType id);

    /**
     * Find all entities
     *
     * @return the entities found
     */
    public abstract List<Entity> findAll();


    /**
     * Edit an entity
     *
     * @param entity the new entity
     * @return the edited entity
     */
    public abstract Entity edit(final Entity entity);


}