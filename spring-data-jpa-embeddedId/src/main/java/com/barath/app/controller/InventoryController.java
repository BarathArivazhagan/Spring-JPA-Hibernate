package com.barath.app.controller;

import com.barath.app.dto.InventoryDTO;
import com.barath.app.entity.Inventory;
import com.barath.app.mapper.InventoryMapper;
import com.barath.app.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

    private final InventoryService inventoryService;


    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public InventoryDTO addInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = InventoryMapper.mapToInventory(inventoryDTO);
        return InventoryMapper.mapToInventoryDTO(this.inventoryService.addInventory(inventory));
    }

    @GetMapping(value = "/{locationName}/{productName}")
    public InventoryDTO findInventoryByLocationAndProduct(@PathVariable String locationName,
                                                                @PathVariable String productName) {
        Inventory inventory = this.inventoryService.getByLocationAndProductName(locationName, productName);
        return InventoryMapper.mapToInventoryDTO(inventory);
    }

    @GetMapping(value = "/all")
    public List<InventoryDTO> findInventories(){
        List<Inventory> inventories = this.inventoryService.getInventories();

        return inventories.stream().map(InventoryMapper::mapToInventoryDTO).collect(Collectors.toList());
    }

}
