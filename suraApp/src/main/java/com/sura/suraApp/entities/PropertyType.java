package com.sura.suraApp.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tipo")
public class PropertyType implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idtipo")
    private Long idType;
    @Column(name = "nombre")
    private String name;

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
