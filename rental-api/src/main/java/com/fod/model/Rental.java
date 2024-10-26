package com.fod.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Table(name="rental")
public class Rental {
    
    // Properties
    @Id
    @GeneratedValue()
    private Integer rental_id;

    private Instant rental_date;
    private Integer inventory_id;
    private Integer customer_id;
    private Instant return_date;
    private Integer staff_id;
    private Instant last_update;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("rental_id: ").append(rental_id).append("\n");
        sb.append("rental_date: ").append(rental_date).append("\n");
        sb.append("inventory_id: ").append(inventory_id).append("\n");
        sb.append("customer_id: ").append(customer_id).append("\n");
        sb.append("return_date: ").append(return_date).append("\n");
        sb.append("staff_id: ").append(staff_id).append("\n");
        sb.append("last_update: ").append(last_update).append("\n");
        return sb.toString();
    }

    // Generated getters and setters
    public Integer getRental_id() {
        return rental_id;
    }

    public void setRental_id(Integer rental_id) {
        this.rental_id = rental_id;
    }

    public Instant getRental_date() {
        return rental_date;
    }

    public void setRental_date(Instant rental_date) {
        this.rental_date = rental_date;
    }

    public Integer getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Integer inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Instant getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Instant return_date) {
        this.return_date = return_date;
    }

    public Integer getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }

    public Instant getLast_update() {
        return last_update;
    }

    public void setLast_update(Instant last_update) {
        this.last_update = last_update;
    }
}
