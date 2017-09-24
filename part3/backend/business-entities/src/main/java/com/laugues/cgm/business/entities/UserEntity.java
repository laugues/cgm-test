package com.laugues.cgm.business.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "user")
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birthday")
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public UserEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserEntity setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public UserEntity setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !Objects.equals(getClass(), o.getClass())) return false;
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(id, userEntity.id) &&
                Objects.equals(userName, userEntity.userName) &&
                Objects.equals(password, userEntity.password) &&
                Objects.equals(email, userEntity.email) &&
                Objects.equals(firstName, userEntity.firstName) &&
                Objects.equals(lastName, userEntity.lastName) &&
                Objects.equals(birthday, userEntity.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, email, firstName, lastName, birthday);
    }
}
