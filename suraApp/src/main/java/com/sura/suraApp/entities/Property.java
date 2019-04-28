package com.sura.suraApp.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "propiedad")
public class Property implements Serializable {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="idpropiedad")
        private Long idProperty;
        @OneToOne(fetch=FetchType.EAGER)
        @JoinColumn(name="idtipo")
        private PropertyType propertyType;
        @ManyToOne(fetch=FetchType.EAGER)
        @JoinColumn(name="idmoneda")
        private Currency currency;
        @ManyToOne(fetch=FetchType.EAGER)
        @JoinColumn(name="idpersona")
        private Client client;
        @Column(name = "valor")
        private Double value;
        @Column(name = "metraje")
        private Integer metrics;
        @Column(name = "estrato")
        private Integer stratum;
        @Column(name = "direccion")
        private String address;



    public Long getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(Long idProperty) {
        this.idProperty = idProperty;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getMetrics() {
        return metrics;
    }

    public void setMetrics(Integer metrics) {
        this.metrics = metrics;
    }

    public Integer getStratum() {
        return stratum;
    }

    public void setStratum(Integer stratum) {
        this.stratum = stratum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
