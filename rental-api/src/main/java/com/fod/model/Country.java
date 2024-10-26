package com.fod.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Table(name="country")
public class Country {
    
    // Properties
    @Id
    @GeneratedValue()
    private Integer country_id;

    private String country;
    private Instant last_update;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("country_id: ").append(country_id).append("\n");
        sb.append("country: ").append(country).append("\n");
        sb.append("last_update: ").append(last_update).append("\n");
        return sb.toString();
    }

    // Generated getters and setters
    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Instant getLast_update() {
        return last_update;
    }

    public void setLast_update(Instant last_update) {
        this.last_update = last_update;
    }
}
