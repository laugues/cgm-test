package com.laugues.cgm.rest.api;

import com.laugues.cgm.dto.DentistDTO;
import com.laugues.cgm.rest.facade.DentistFacade;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * REst API endpoint for manipulate {@link DentistDTO}
 */
@Named
@Path(DentistResource.DENTIST_PATH)
public class DentistResource {

    protected static final String DENTIST_PATH = "/dentists";

    @Inject
    private DentistFacade facade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DentistDTO> getAll() {
        return facade.getAll();
    }
}
