package com.example.webservicesassone.Controller;

import com.example.webservicesassone.Model.Consumer;
import com.example.webservicesassone.Service.ConsumerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("consumer")
@RestController
public class ConsumerController {
    private final ConsumerService consumerService;
    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping("{consumerID}")
    public ResponseEntity<Consumer> getConsumerByID(@PathVariable("consumerID") int consumerID) {
        Optional<Consumer> consumer = Optional.ofNullable(consumerService.getConsumerByID(consumerID));
        return consumer.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }



    @GetMapping("getconsumers")
    public ResponseEntity<List> getAllConsumers(){
        Optional<List> consumers= Optional.ofNullable(consumerService.getAllConsumers());
        return consumers.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }
    @PostMapping("addConsumer")
    public ResponseEntity<Void> AddNewCourse(@RequestBody Consumer consumer){
        consumerService.AddNewConsumer(consumer);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("deleteConsumer/{consumerID}")
    public ResponseEntity<Void> DeleteCourseByID(@PathVariable("consumerID") int consumerID) {
        consumerService.RemoveConsumerByID(consumerID);
        return ResponseEntity.ok().build();
    }
    @PutMapping("updateConsumer/{consumerID}")
    public ResponseEntity<Consumer> UpdateConsumerByID(@RequestBody Consumer consumer, @PathVariable("consumerID") int consumerID){
        Consumer updatedConsumer=consumerService.UpdateConsumerByID(consumer,consumerID);
        if (updatedConsumer != null) {
            return ResponseEntity.ok(updatedConsumer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}