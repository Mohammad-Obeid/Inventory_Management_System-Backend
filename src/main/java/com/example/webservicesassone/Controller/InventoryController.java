package com.example.webservicesassone.Controller;


import com.example.webservicesassone.Model.Consumer;
import com.example.webservicesassone.Model.Inventory;
import com.example.webservicesassone.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
        Inventory inv= inventoryService.getInventoryByID(inventoryID);
        return  ResponseEntity.ok().body(inv);
    }

    @GetMapping("getinventories")
    public List<Inventory> getAllInventories(){
        return inventoryService.getAllInventories();
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
