package com.barath.app.dto;

import java.io.Serializable;

public class InventoryDTO implements Serializable {

    private String locationName;

    private String productName;

    private Long quantity;

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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public InventoryDTO() {
    }

    public InventoryDTO(String locationName, String productName, Long quantity) {
        this.locationName = locationName;
        this.productName = productName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "InventoryDTO{" +
                "locationName='" + locationName + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
