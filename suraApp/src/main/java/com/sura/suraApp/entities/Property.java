package com.sura.suraApp.entities;

import javax.persistence.*;
import java.io.Serializable;

public class Property implements Serializable {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="idpropiedad")
        private Long idProperty;
        @OneToOne
        private PropertyType propertyType;
        @ManyToOne
        private Currency currency;
        @ManyToOne
        private Client client;
        @Column(name = "valor")
        private Double value;
        @Column(name = "metraje")
        private Integer metrics;
        @Column(name = "estrato")
        private Integer stratum;

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
}
