package com.fod.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Table(name="staff")
public class Staff {
    
    // Properties
    @Id
    @GeneratedValue()
    private Integer staff_id;

    private Integer store_id;
    private String first_name;
    private String last_name;
    private String email;
    private Integer address_id;
    private Boolean active;
    private Instant last_update;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("store_id: ").append(store_id).append("\n");
        sb.append("first_name: ").append(first_name).append("\n");
        sb.append("last_name: ").append(last_name).append("\n");
        sb.append("email: ").append(email).append("\n");
        sb.append("address_id: ").append(address_id).append("\n");
        sb.append("active: ").append(active).append("\n");
        sb.append("last_update: ").append(last_update).append("\n");
        return sb.toString();
    }

    // Generated getters and setters
    public Integer getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Instant getLast_update() {
        return last_update;
    }

    public void setLast_update(Instant last_update) {
        this.last_update = last_update;
    }
}
