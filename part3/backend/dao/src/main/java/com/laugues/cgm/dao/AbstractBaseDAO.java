package com.laugues.cgm.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Abstract class that will provide generic methods (from rsql)for all entityClasses.
 *
 * @param <EntityType> the type of entity
 */
public abstract class AbstractBaseDAO<EntityType>
{
    /**
     * The entity class.
     */
    protected Class<EntityType> entityClass;
    /**
     * The entity class instance.
     */
    protected EntityType entityClassInstance;
    Logger LOGGER = LoggerFactory.getLogger(AbstractBaseDAO.class);

    public AbstractBaseDAO(final Class<EntityType> entityClass) {
        this.entityClass = entityClass;
        try {
            this.entityClassInstance = entityClass.newInstance();
        } catch (final InstantiationException e) {
            LOGGER.error("", e);
            throw new RuntimeException(e);
        } catch (final IllegalAccessException e) {
            LOGGER.error("", e);
            throw new RuntimeException(e);
        }
    }

}
