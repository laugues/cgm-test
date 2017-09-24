package com.laugues.cgm.dao;


import com.laugues.cgm.business.entities.UserEntity;

import javax.persistence.EntityManager;

public class UserDao extends AbstractDAO<UserEntity> {

    public UserDao() {
        super(UserEntity.class);
    }

    public UserDao(EntityManager aEntityManager) {
        super(UserEntity.class, aEntityManager);
    }
}
