package com.laugues.cgm.rest.facade;


import com.laugues.cgm.business.entities.UserEntity;
import com.laugues.cgm.business.service.UserService;
import com.laugues.cgm.dto.user.UserDTO;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Singleton
@Named
public class UserFacade {

    @Inject
    protected UserService userService;

    /**
     * Get a list of dentist
     *
     * @return the list of dentist
     */
    public List<UserDTO> getAll() {
        return userService.findAll().stream()
                .filter(Objects::nonNull)
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO create(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        if (userDTO.getId() != null) {
            userEntity.setId(userDTO.getId());
        }

        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setUserName(userDTO.getUserName());
        //TODO : password should be hashed
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setBirthday(userDTO.getBirthday());

        return entityToDTO(userService.edit(userEntity));
    }

    /**
     * Convert an entity to a dto
     *
     * @param entity the entity to process
     * @return the dto built
     */
    private UserDTO entityToDTO(UserEntity entity) {
        return new UserDTO()
                .setId(entity.getId())
                .setUserName(entity.getUserName())
                .setFirstName(entity.getFirstName())
                .setLastName(entity.getLastName())
                .setEmail(entity.getEmail())
                .setBirthday(entity.getBirthday());
    }
}
