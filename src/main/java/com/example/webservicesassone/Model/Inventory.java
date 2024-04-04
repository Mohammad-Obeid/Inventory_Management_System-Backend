package com.example.webservicesassone.Model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Table(name = "inventory")
@Entity
public class Inventory {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
   private int inventoryID;
    private String inventoryName, inventoryLocation, ownerName;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private Set<Item> items;

    public Inventory() {
    }

    public Inventory(int inventoryID, String inventoryName, String inventoryLocation, String ownerName, Set<Item> items) {
        this.inventoryID = inventoryID;
        this.inventoryName = inventoryName;
        this.inventoryLocation = inventoryLocation;
        this.ownerName = ownerName;
        this.items = items;
    }

    public Inventory(String inventoryName, String inventoryLocation, String ownerName, Set<Item> items) {
        this.inventoryName = inventoryName;
        this.inventoryLocation = inventoryLocation;
        this.ownerName = ownerName;
        this.items = items;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getInventoryLocation() {
        return inventoryLocation;
    }

    public void setInventoryLocation(String inventoryLocation) {
        this.inventoryLocation = inventoryLocation;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

//    public Set<Item> getItems() {
//        return items;
//    }
//
//    public void setItems(Set<Item> items) {
//        this.items = items;
//    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryID=" + inventoryID +
                ", inventoryName='" + inventoryName + '\'' +
                ", inventoryLocation='" + inventoryLocation +
                '}';
    }
}
