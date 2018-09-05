package com.barath.app.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name="INVENTORY")
public class Inventory implements Serializable {

    @EmbeddedId
    private InventoryPK inventoryPK;

    @Column(name="QUANTITY")
    private Long quantity;

    public InventoryPK getInventoryPK() {
        return inventoryPK;
    }

    public void setInventoryPK(InventoryPK inventoryPK) {
        this.inventoryPK = inventoryPK;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Inventory() {
    }

    public Inventory(InventoryPK inventoryPK, Long quantity) {
        this.inventoryPK = inventoryPK;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryPK=" + inventoryPK +
                ", quantity=" + quantity +
                '}';
    }
}
