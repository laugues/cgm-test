package com.laugues.cgm.rest.api;

import com.laugues.cgm.dto.user.UserDTO;
import com.laugues.cgm.rest.facade.UserFacade;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REst API endpoint for manipulate {@link UserDTO}
 */
@Named
@Path(UserResource.USERS_PATH)
public class UserResource {

    protected static final String USERS_PATH = "/users";

    @Inject
    private UserFacade facade;

    /**
     * Create user
     *
     * @param userDTO
     * @return
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UserDTO create(UserDTO userDTO) {
        return facade.create(userDTO);
    }
}
