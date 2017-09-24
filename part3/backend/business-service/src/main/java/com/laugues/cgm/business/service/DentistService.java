package com.laugues.cgm.business.service;


import com.laugues.cgm.business.entities.DentistEntity;
import com.laugues.cgm.dao.DentistDao;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

/**
 * User Service to manipulate {@link DentistEntity}
 */
@Named
@Transactional(Transactional.TxType.REQUIRED)
public class DentistService extends EntityService<DentistEntity, Integer> {

    protected DentistDao dao;

    public DentistService() {
        super(DentistEntity.class);
    }

    @PostConstruct
    protected void init() {
        this.dao = new DentistDao(this.em);
    }

    @Override
    public DentistEntity find(Integer id) {
        return dao.find(id);
    }

    @Override
    public List<DentistEntity> findAll() {
        return dao.findAll();
    }

    @Override
    public DentistEntity edit(DentistEntity entity) {
        return dao.edit(entity);
    }
}
