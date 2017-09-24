package com.laugues.cgm.rest.facade;


import com.laugues.cgm.business.entities.DentistEntity;
import com.laugues.cgm.business.service.DentistService;
import com.laugues.cgm.dto.DentistDTO;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Singleton
@Named
public class DentistFacade {

    @Inject
    protected DentistService dentistService;

    /**
     * Get a list of dentist
     *
     * @return the list of dentist
     */
    public List<DentistDTO> getAll() {
        return dentistService.findAll().stream()
                .filter(Objects::nonNull)
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Convert an entity to a dto
     *
     * @param entity the entity to process
     * @return the dto built
     */
    private DentistDTO entityToDTO(DentistEntity entity) {
        return new DentistDTO()
                .setId(entity.getId())
                .setFirstName(entity.getFirstName())
                .setLastName(entity.getLastName())
                .setImageId(entity.getImageId());
    }
}
