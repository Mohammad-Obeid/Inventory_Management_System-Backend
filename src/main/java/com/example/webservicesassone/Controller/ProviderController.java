package com.example.webservicesassone.Controller;

import com.example.webservicesassone.Model.Inventory;
import com.example.webservicesassone.Model.Provider;
import com.example.webservicesassone.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("provider")
@RestController
public class ProviderController {
    private final ProviderService providerService;
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("getproviders")
    public List<Provider> getAllProviders(){
        return providerService.getAllProviders();
    }


    @GetMapping("{providerID}")
    public Provider getProviderbyID(@PathVariable("providerID") int providerID){
        return providerService.getProviderbyID(providerID);
    }

    @PostMapping("addprovider")
    public ResponseEntity<Void> addNewProvider(@RequestBody Provider provider){
        providerService.addNewProvider(provider);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("deleteprovider/{providerID}")
    public ResponseEntity<Void> deleteProvider(@PathVariable("providerID") int providerID){
        providerService.deleteProvider(providerID);
        return ResponseEntity.ok().build();
    }

    @PutMapping("updateprovider/{providerID}")
    public Provider UpdateProviderByID(@RequestBody Provider provider, @PathVariable("providerID") int providerID){

        return providerService.UpdateProviderByID(provider, providerID);
    }
}
