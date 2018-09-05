package com.barath.app.mapper;

import com.barath.app.dto.InventoryDTO;
import com.barath.app.entity.Inventory;
import com.barath.app.entity.InventoryPK;

public class InventoryMapper {


    public static InventoryDTO mapToInventoryDTO(Inventory inventory){

        InventoryPK inventoryPK = inventory.getInventoryPK();
        return new InventoryDTO(inventoryPK.getLocationName(),inventoryPK.getProductName(),inventory.getQuantity());
    }

    public static Inventory mapToInventory(InventoryDTO inventoryDTO){

       InventoryPK inventoryPK = new InventoryPK(inventoryDTO.getLocationName(),inventoryDTO.getProductName());
       return new Inventory(inventoryPK, inventoryDTO.getQuantity());
    }
}
