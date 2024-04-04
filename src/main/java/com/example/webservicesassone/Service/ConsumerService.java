package com.example.webservicesassone.Service;

import com.example.webservicesassone.Model.Consumer;
import com.example.webservicesassone.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumerService {
    private static ConsumerRepository consumerRepo;

    @Autowired
    public ConsumerService(ConsumerRepository consumerRepo) {
        this.consumerRepo=consumerRepo;
    }




    public Consumer getConsumerByID(int consumerID) {
        Optional<Consumer> consumer = consumerRepo.findById(consumerID);
        return consumer.orElse(null);
    }

    public void AddNewConsumer(Consumer consumer) {
        Optional<Consumer> cons=consumerRepo.findConsumerByConsumerEmail(consumer.getConsumerEmail());
        if(cons.isPresent()){
            throw new IllegalStateException("Email Exists");
        }
        consumerRepo.save(consumer);
    }

    public void RemoveConsumerByID(int consumerID) {
        consumerRepo.deleteById(consumerID);

    }

    public Consumer UpdateConsumerByID(Consumer consumer, int consumerID) {
        consumer.setConsumerID(consumerID);
        return consumerRepo.save(consumer);
    }

    public List<Consumer> getAllConsumers() {
        return consumerRepo.findAll();
    }
}
