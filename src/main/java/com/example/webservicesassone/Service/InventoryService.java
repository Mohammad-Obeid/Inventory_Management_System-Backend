package com.example.webservicesassone.Service;


import com.example.webservicesassone.Model.Inventory;
import com.example.webservicesassone.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    private static InventoryRepository inventoryRepo;
    public InventoryService(InventoryRepository inventoryRepo) {
        this.inventoryRepo=inventoryRepo;
    }

    public Inventory getInventoryByID(int inventoryID) {
        Optional<Inventory> inventory=inventoryRepo.findById(inventoryID);
        if(inventory.isPresent()){
            Inventory dto = new Inventory();
            dto.setInventoryID(inventory.get().getInventoryID());
            dto.setInventoryName(inventory.get().getInventoryName());
            dto.setInventoryLocation(inventory.get().getInventoryLocation());
            dto.setOwnerName(inventory.get().getOwnerName());
//            dto.setItems(inventory.get().getItems());
            return dto;
        }
        else{
            return null;
        }
    }

    public void addNewInventory(Inventory inventory) {
        Optional<Inventory> inven=inventoryRepo.findInvByInventoryName(inventory.getInventoryName());
        if(inven.isPresent()){
            throw new IllegalStateException("Inventory Exists!");
        }

        inventoryRepo.save(inventory);
    }

    public void DeleteInventorybyID(int inventoryID) {
        Optional<Inventory> uni = inventoryRepo.findById(inventoryID);
        if(uni.isPresent()){
            inventoryRepo.deleteById(inventoryID);
        }
        else{
            throw new IllegalStateException("Inventory with ID "+ inventoryID+" wasn't Found");
        }
    }

    public Inventory UpdateInventoryByID(Inventory inventory, int inventoryID) {
        inventory.setInventoryID(inventoryID);
        return inventoryRepo.save(inventory);
    }

    public List<Inventory> getAllInventories() {
        List<Inventory> inventories = inventoryRepo.findAll();
        if (inventories.isEmpty()) {
            return null;
        }
        return inventories;
    }
}
