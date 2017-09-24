package com.laugues.cgm.dao;


import com.laugues.cgm.business.entities.DentistEntity;

import javax.persistence.EntityManager;

public class DentistDao extends AbstractDAO<DentistEntity> {

    public DentistDao() {
        super(DentistEntity.class);
    }

    public DentistDao(EntityManager aEntityManager) {
        super(DentistEntity.class, aEntityManager);
    }
}
