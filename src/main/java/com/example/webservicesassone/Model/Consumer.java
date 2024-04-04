package com.example.webservicesassone.Model;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Table(name= "consumer")
@Entity
public class Consumer {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int consumerID;
    private String consumerName, consumerBD, consumerLocation,consumerEmail;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "consumer_item_table",
    joinColumns = {
            @JoinColumn(name = "consumerID",referencedColumnName = "consumerID")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "itemID", referencedColumnName = "itemID")
    }
    )
    private Set<Item> items;

    public Consumer() {
    }

    public Consumer(int consumerID, String consumerName, String consumerBD, String consumerLocation,String consumerEmail, Set<Item> items) {
        this.consumerID = consumerID;
        this.consumerName = consumerName;
        this.consumerBD = consumerBD;
        this.consumerLocation = consumerLocation;
        this.items = items;
        this.consumerEmail=consumerEmail;
    }
    public Consumer(String consumerName, String consumerBD, String consumerLocation,String consumerEmail, Set<Item> items) {
        this.consumerName = consumerName;
        this.consumerBD = consumerBD;
        this.consumerLocation = consumerLocation;
        this.items = items;
        this.consumerEmail=consumerEmail;
    }

    public int getConsumerID() {
        return consumerID;
    }

    public void setConsumerID(int consumerID) {
        this.consumerID = consumerID;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerBD() {
        return consumerBD;
    }

    public void setConsumerBD(String consumerBD) {
        this.consumerBD = consumerBD;
    }

    public String getConsumerLocation() {
        return consumerLocation;
    }

    public void setConsumerLocation(String consumerLocation) {
        this.consumerLocation = consumerLocation;
    }

    public String getConsumerEmail() {
        return consumerEmail;
    }

    public void setConsumerEmail(String consumerEmail) {
        this.consumerEmail = consumerEmail;
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
        return "Consumer{" +
                "consumerID=" + consumerID +
                ", consumerName='" + consumerName + '\'' +
                ", consumerBD='" + consumerBD + '\'' +
                ", consumerLocation='" + consumerLocation + '\'' +
                ", items=" + items +
                '}';
    }
}
