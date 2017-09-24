package com.laugues.cgm.business.service;

import com.laugues.cgm.business.entities.UserEntity;
import com.laugues.cgm.dao.UserDao;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

/**
 * User Service to manipulate {@link UserEntity}
 */
@Named
@Transactional(Transactional.TxType.REQUIRED)
public class UserService extends EntityService<UserEntity, Integer> {

    protected UserDao dao;

    public UserService() {
        super(UserEntity.class);
    }

    @PostConstruct
    protected void init() {
        this.dao = new UserDao(this.em);
    }


    @Override
    public UserEntity find(Integer id) {
        return dao.find(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return dao.findAll();
    }

    @Override
    public UserEntity edit(UserEntity userEntity) {
        return dao.edit(userEntity);
    }
}
