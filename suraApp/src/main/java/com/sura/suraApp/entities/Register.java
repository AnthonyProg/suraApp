package com.sura.suraApp.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "registro")
public class Register implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idregistro")
    private Long idRegister;
    @Column(name = "fecharegistro")
    private Date registerDate;
    @Column(name = "valorprima")
    private Double premiumValue;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idpropiedad")
    private Property property;

    public Long getIdRegister() {
        return idRegister;
    }

    public void setIdRegister(Long idRegister) {
        this.idRegister = idRegister;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Double getPremiumValue() {
        return premiumValue;
    }

    public void setPremiumValue(Double premiumValue) {
        this.premiumValue = premiumValue;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
