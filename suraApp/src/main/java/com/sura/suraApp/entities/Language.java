package com.sura.suraApp.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "idiomas")
public class Language implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ididioma")
    private Long languageId;
    @Column(name = "nombre")
    private String name;
    @Column(name = "sufijo")
    private String suffix;


    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
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
