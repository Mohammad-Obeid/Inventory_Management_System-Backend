package com.example.webservicesassone.Repository;

import com.example.webservicesassone.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
    Optional<Item> findItemByItemBarcode(String itemBarcode);
}
