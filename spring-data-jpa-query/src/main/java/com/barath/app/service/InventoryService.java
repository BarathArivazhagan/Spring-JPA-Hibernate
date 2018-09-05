package com.barath.app.service;

import com.barath.app.entity.Inventory;
import com.barath.app.entity.InventoryPK;
import com.barath.app.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class InventoryService {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory getByLocationAndProductName(String locationName, String productName) {

        if(logger.isInfoEnabled()){
            logger.info("get inventory by location={} and product={}",locationName,productName);
        }
        return this.inventoryRepository.findByInventoryPK_LocationNameAndAndInventoryPK_ProductName(locationName,productName);
    }

    public Inventory addInventory(Inventory inventory){

        if(logger.isInfoEnabled()){
            logger.info("add inventory {}", Objects.toString(inventory));
        }
        return this.inventoryRepository.save(inventory);
    }

    public List<Inventory> addInventories(List<Inventory> inventories){

        if(logger.isInfoEnabled()){
            logger.info("add inventories {}", inventories);
        }
        return this.inventoryRepository.saveAll(inventories);
    }

    public List<Inventory> getInventories(){

        return this.inventoryRepository.findAll();
    }

    @PostConstruct
    public void init(){

        Inventory inventory1 = new Inventory(new InventoryPK("CHENNAI","TV"),10L);
        Inventory inventory2 = new Inventory(new InventoryPK("BANGALORE","IPHONE"),100L);
        Inventory inventory3 = new Inventory(new InventoryPK("DELHI","TV"),30L);
        Inventory inventory4 = new Inventory(new InventoryPK("DELHI","LAPTOP"),40L);
        Inventory inventory5 = new Inventory(new InventoryPK("KERALA","TV"),50L);
        List<Inventory> inventories =Stream.of(inventory1,inventory2,inventory3,inventory4,inventory5)
                .collect(Collectors.toList());
        this.addInventories(inventories);


    }
}
