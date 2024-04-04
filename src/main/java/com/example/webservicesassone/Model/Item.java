package com.example.webservicesassone.Model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Set;

@Table(name ="item")
@Entity
public class Item {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int itemID;
    private String itemName, itemBarcode;
    private double itemPrice;

    @ManyToMany(mappedBy = "items",cascade = CascadeType.MERGE)

    private Set<Consumer> consumers;

    @ManyToMany(mappedBy = "items",cascade = CascadeType.MERGE)
    private Set<Provider> providers;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Inventory inventory;

//    private int invid=inventory.getInventoryID();


    public Item() {
    }

    public Item(int itemID, String itemName, String itemBarcode, double itemPrice, Inventory inventory) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemBarcode = itemBarcode;
        this.itemPrice = itemPrice;
        this.consumers = consumers;
        this.providers = providers;
        this.inventory = inventory;
    }
    public Item(String itemName, String itemBarcode, double itemPrice, Inventory inventory) {
        this.itemName = itemName;
        this.itemBarcode = itemBarcode;
        this.itemPrice = itemPrice;
        this.consumers = consumers;
        this.providers = providers;
        this.inventory = inventory;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemBarcode() {
        return itemBarcode;
    }

    public void setItemBarcode(String itemBarcode) {
        this.itemBarcode = itemBarcode;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

//    public Set<Consumer> getConsumers() {
//        return consumers;
//    }
//
//    public void setConsumers(Set<Consumer> consumers) {
//        this.consumers = consumers;
//    }
//
//    public Set<Provider> getProviders() {
//        return providers;
//    }
//
//    public void setProviders(Set<Provider> providers) {
//        this.providers = providers;
//    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", itemName='" + itemName + '\'' +
                ", itemBarcode='" + itemBarcode + '\'' +
                ", itemPrice=" + itemPrice +
                ", inventory=" + inventory +
                '}';
    }
}
