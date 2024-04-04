package com.example.webservicesassone.Service;

import com.example.webservicesassone.Model.Inventory;
import com.example.webservicesassone.Model.Item;
import com.example.webservicesassone.Repository.InventoryRepository;
import com.example.webservicesassone.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private static ItemRepository itemRepo;
    private static InventoryRepository invRepo;
    public ItemService(ItemRepository itemRepo,InventoryRepository invRepo) {
        this.itemRepo=itemRepo;
        this.invRepo=invRepo;
    }


    public Item getItembyID(int itemID) {
        Optional<Item> std = itemRepo.findById(itemID);
        if(std.isPresent()){
            return std.get();
        }
        else{
            throw new IllegalStateException("Item with ID "+ itemID + " wasn't Found");
        }
    }




    public void addNewItem(Item item) {
        Optional<Item> itemch=itemRepo.findItemByItemBarcode(item.getItemBarcode());
        if(itemch.isPresent()){
            throw new IllegalStateException("Item is already Added");
        }
        itemRepo.save(item);
    }

    public void deleteItemByID(int itemID) {
        Optional<Item> item = itemRepo.findById(itemID);
        if(item.isPresent()){
            itemRepo.deleteById(itemID);
        }
        else{
            throw new IllegalStateException("Item with ID "+ itemID + " wasn't Found");
        }
    }

    public Item UpdateItemByID(Item item, int itemID) {
        int invID=item.getInventory().getInventoryID();
        Optional<Inventory> inven=invRepo.findById(invID);
        item.setItemID(itemID);
        item.setInventory(inven.get());
        return itemRepo.save(item);
    }


    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }
}
