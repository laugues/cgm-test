package com.laugues.cgm.dto;

import javax.inject.Named;
import java.io.Serializable;
import java.util.Objects;

/**
 * Define a dentist
 */
@Named
public class DentistDTO implements Serializable {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer imageId;

    public DentistDTO() {
    }

    public Integer getId() {
        return id;
    }

    public DentistDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public DentistDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public DentistDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getImageId() {
        return imageId;
    }

    public DentistDTO setImageId(Integer imageId) {
        this.imageId = imageId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !Objects.equals(getClass(), o.getClass())) return false;
        DentistDTO that = (DentistDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
