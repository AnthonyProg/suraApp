package com.sura.suraApp.entities;

import javax.persistence.*;

@Entity
@Table(name = "paises")
public class Country {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idpais")
    private Long idCountry;
    @Column(name = "nombre")
    private String name;
    @Column(name = "codigopais")
    private String code;

    public Long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
