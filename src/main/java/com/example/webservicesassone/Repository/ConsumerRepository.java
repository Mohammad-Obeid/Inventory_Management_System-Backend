package com.example.webservicesassone.Repository;

import com.example.webservicesassone.Model.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
    Optional<Consumer> findConsumerByConsumerEmail(String consumerEmail);
}
