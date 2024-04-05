package com.example.webservicesassone.Controller;


import com.example.webservicesassone.Model.Item;
import com.example.webservicesassone.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("item")
@RestController
public class ItemController {

    private final ItemService itemService;
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("getitems")
    public ResponseEntity<List> getAllItems(){
        Optional<List> items= Optional.ofNullable(itemService.getAllItems());
        return items.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }

    @GetMapping("/{itemID}")
    public ResponseEntity<Item> getItembyID(@PathVariable("itemID") int itemID){
        Optional<Item> item= Optional.ofNullable(itemService.getItembyID(itemID));
        return item.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }



    @PostMapping("additem")
    public ResponseEntity<Void> addNewItem(@RequestBody Item item){
        itemService.addNewItem(item);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("deleteitem/{itemID}")
    public ResponseEntity<Void> deleteItemByID(@PathVariable("itemID") int itemID){
        itemService.deleteItemByID(itemID);
        return ResponseEntity.ok().build();
    }
    @PutMapping("updateitem/{itemID}")
    public Item UpdateItemByID(@RequestBody Item item, @PathVariable("itemID") int itemID){
        return itemService.UpdateItemByID(item, itemID);
    }
}
