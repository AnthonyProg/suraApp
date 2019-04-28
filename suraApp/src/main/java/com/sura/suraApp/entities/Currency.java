package com.sura.suraApp.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "moneda")
public class Currency implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idmoneda")
    private Long idCurrency;
    @Column(name = "nombre")
    private String name;
    @Column(name = "sufijo")
    private String suffix;

    public Long getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(Long idCurrency) {
        this.idCurrency = idCurrency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
