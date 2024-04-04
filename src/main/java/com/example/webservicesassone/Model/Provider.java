package com.example.webservicesassone.Model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Table(name = "provider")
@Entity
public class Provider {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int providerID;
    private String providerName, providerPNum, providerLocation, providerEmail;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "provider_item_table",
            joinColumns = {
                    @JoinColumn(name = "providerID",referencedColumnName = "providerID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "itemID", referencedColumnName = "itemID")
            }
    )
    private List<Item> items;

    public Provider() {
    }

    public Provider(int providerID, String providerName, String providerPNum, String providerLocation,String providerEmail, List<Item> items) {
        this.providerID = providerID;
        this.providerName = providerName;
        this.providerPNum = providerPNum;
        this.providerLocation = providerLocation;
        this.items = items;
        this.providerEmail=providerEmail;
    }
    public Provider(String providerName, String providerPNum, String providerLocation,String providerEmail, List<Item> items) {
        this.providerName = providerName;
        this.providerPNum = providerPNum;
        this.providerLocation = providerLocation;
        this.items = items;
        this.providerEmail=providerEmail;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderPNum() {
        return providerPNum;
    }

    public void setProviderPNum(String providerPNum) {
        this.providerPNum = providerPNum;
    }

    public String getProviderLocation() {
        return providerLocation;
    }

    public void setProviderLocation(String providerLocation) {
        this.providerLocation = providerLocation;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getProviderEmail() {
        return providerEmail;
    }

    public void setProviderEmail(String providerEmail) {
        this.providerEmail = providerEmail;
    }

    @Override
    public String toString() {
        return "ProviderRepository{" +
                "providerID=" + providerID +
                ", providerName='" + providerName + '\'' +
                ", providerPNum='" + providerPNum + '\'' +
                ", providerLocation='" + providerLocation + '\'' +
                ", items=" + items +
                '}';
    }
}
