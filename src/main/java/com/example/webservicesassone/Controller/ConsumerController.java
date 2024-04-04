package com.example.webservicesassone.Controller;

import com.example.webservicesassone.Model.Consumer;
import com.example.webservicesassone.Service.ConsumerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("consumer")
@RestController
public class ConsumerController {
    private final ConsumerService consumerService;
    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping("{consumerID}")
    public Consumer getCourseByID(@PathVariable ("consumerID") int consumerID){
        return consumerService.getConsumerByID(consumerID);
    }
    @GetMapping("getconsumers")
    public List<Consumer> getAllConsumers(){
        return consumerService.getAllConsumers();
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
    public Consumer UpdateConsumerByID(@RequestBody Consumer consumer, @PathVariable("consumerID") int consumerID){
        return consumerService.UpdateConsumerByID(consumer,consumerID);
    }
}