package com.laugues.cgm.rest.facade;


import com.laugues.cgm.dto.DentistDTO;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

@Singleton
@Named
public class DentistFacade {

    @Inject
    protected DentistMock dentistMock;

    /**
     * Get a list of dentist
     *
     * @return the list of dentist
     */
    public List<DentistDTO> getAll() {
        return dentistMock.getDentists();
    }
}
