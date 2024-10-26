package com.fod.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Table(name="city")
public class City {
    
    // Properties
    @Id
    @GeneratedValue()
    private Integer city_id;

    private String city;
    private Integer country_id;
    private Instant last_update;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("city_id: ").append(city_id).append("\n");
        sb.append("city: ").append(city).append("\n");
        sb.append("country_id: ").append(country_id).append("\n");
        sb.append("last_update: ").append(last_update).append("\n");
        return sb.toString();
    }

    // Generated getters and setters
    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public Instant getLast_update() {
        return last_update;
    }

    public void setLast_update(Instant last_update) {
        this.last_update = last_update;
    }
}
