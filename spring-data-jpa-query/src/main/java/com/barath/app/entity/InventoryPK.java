package com.barath.app.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InventoryPK implements Serializable {

    @Column(name="LOCATION_NAME")
    private String locationName;

    @Column(name="PRODUCT_NAME")
    private String productName;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public InventoryPK() {
    }

    public InventoryPK(String locationName, String productName) {
        this.locationName = locationName;
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryPK that = (InventoryPK) o;
        return Objects.equals(locationName, that.locationName) &&
                Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationName, productName);
    }

    @Override
    public String toString() {
        return "InventoryPK{" +
                "locationName='" + locationName + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
