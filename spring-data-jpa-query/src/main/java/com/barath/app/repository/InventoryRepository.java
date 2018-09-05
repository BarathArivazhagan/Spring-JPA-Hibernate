package com.barath.app.repository;

import com.barath.app.entity.Inventory;
import com.barath.app.entity.InventoryPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, InventoryPK> {

    Inventory findByInventoryPK_LocationNameAndAndInventoryPK_ProductName(String locationName, String productName);

}
