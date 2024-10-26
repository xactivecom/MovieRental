package com.fod.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Table(name="store")
public class Store {
    
    // Properties
    @Id
    @GeneratedValue()
    private Integer store_id;

    private Integer manager_staff_id;
    private Integer address_id;
    private Instant last_update;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("store_id: ").append(store_id).append("\n");
        sb.append("manager_staff_id: ").append(manager_staff_id).append("\n");
        sb.append("address_id: ").append(address_id).append("\n");
        sb.append("last_update: ").append(last_update).append("\n");
        return sb.toString();
    }

    // Generated getters and setters
    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    public Integer getManager_staff_id() {
        return manager_staff_id;
    }

    public void setManager_staff_id(Integer manager_staff_id) {
        this.manager_staff_id = manager_staff_id;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public Instant getLast_update() {
        return last_update;
    }

    public void setLast_update(Instant last_update) {
        this.last_update = last_update;
    }
}
