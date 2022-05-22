package com.leader.platzimarket.persistence.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Client {


    @Id
    private String id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellidos")
    private String lastname;

    @Column(name = "celular")
    private Long  telephone;

    @Column(name = "direccion")
    private String address;

    @Column(name = "correo_electronico")
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Purchase> purchases;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long  getTelephone() {
        return telephone;
    }

    public void setTelephone(Long  telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
