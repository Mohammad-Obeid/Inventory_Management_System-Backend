package com.example.webservicesassone.Controller;


import com.example.webservicesassone.Model.Consumer;
import com.example.webservicesassone.Model.Inventory;
import com.example.webservicesassone.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("inventory")
@RestController
public class InventoryController {
    private final InventoryService inventoryService;
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("{inventoryID}")
    public ResponseEntity<Inventory> getInventoryByID(@PathVariable("inventoryID") int inventoryID){
        Optional<Inventory> inventory = Optional.ofNullable(inventoryService.getInventoryByID(inventoryID));
        return inventory.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }

    @GetMapping("getinventories")
    public ResponseEntity<List> getAllInventories(){
        Optional<List> inventories = Optional.ofNullable(inventoryService.getAllInventories());
        return inventories.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }

    @PostMapping("addnewinventory")
    public ResponseEntity<Void> addNewInventory(@RequestBody Inventory inventory){
        inventoryService.addNewInventory(inventory);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("deleteInventory/{inventoryID}")
    public ResponseEntity<Void> DeleteInventorybyID(@PathVariable("inventoryID") int inventoryID){
        inventoryService.DeleteInventorybyID(inventoryID);
        return ResponseEntity.ok().build();
    }

    @PutMapping("updateInventory/{inventoryID}")
    public Inventory UpdateInventoryByID(@RequestBody Inventory inventory, @PathVariable("inventoryID") int inventoryID){
        return inventoryService.UpdateInventoryByID(inventory,inventoryID);
    }

}
