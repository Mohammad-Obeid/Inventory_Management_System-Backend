package com.example.webservicesassone.Repository;

import com.example.webservicesassone.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    Optional<Inventory> findInvByInventoryName(String inventoryName);
}
