package com.sura.suraApp.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "persona")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idpersona")
    private Long idClient;
    @Column(name="cedula")
    private Long idDocument;
    @Column(name = "nombre")
    private String name;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idpais")
    private Country country;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Long idDocument) {
        this.idDocument = idDocument;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
