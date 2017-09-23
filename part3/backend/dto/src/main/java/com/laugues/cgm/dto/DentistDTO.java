package com.laugues.cgm.dto;

import javax.inject.Named;
import java.io.Serializable;
import java.util.Objects;

@Named
public class DentistDTO implements Serializable{

    private String login;
    private String firstName;
    private String lastName;


    public String getLogin() {
        return login;
    }

    public DentistDTO setLogin(String login) {
        this.login = login;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !Objects.equals(getClass(), o.getClass())) return false;
        DentistDTO dentistDTO = (DentistDTO) o;
        return Objects.equals(login, dentistDTO.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
