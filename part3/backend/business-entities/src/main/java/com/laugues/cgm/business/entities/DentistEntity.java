package com.laugues.cgm.business.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "dentist")
@Table(name= "dentist")
public class DentistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "image_id")
    private Integer imageId;

    public Integer getId() {
        return id;
    }

    public DentistEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public DentistEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public DentistEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getImageId() {
        return imageId;
    }

    public DentistEntity setImageId(Integer imageId) {
        this.imageId = imageId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !Objects.equals(getClass(), o.getClass())) return false;
        DentistEntity dentistEntity = (DentistEntity) o;
        return Objects.equals(id, dentistEntity.id) &&
                Objects.equals(firstName, dentistEntity.firstName) &&
                Objects.equals(lastName, dentistEntity.lastName) &&
                Objects.equals(imageId, dentistEntity.imageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, imageId);
    }
}
