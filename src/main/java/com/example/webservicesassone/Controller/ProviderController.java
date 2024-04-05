package com.example.webservicesassone.Controller;

import com.example.webservicesassone.Model.Inventory;
import com.example.webservicesassone.Model.Provider;
import com.example.webservicesassone.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("provider")
@RestController
public class ProviderController {
    private final ProviderService providerService;
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("getproviders")
    public ResponseEntity<List> getAllProviders(){
        Optional<List> Providers= Optional.ofNullable(providerService.getAllProviders());
        return Providers.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }


    @GetMapping("{providerID}")
    public ResponseEntity<Provider> getProviderbyID(@PathVariable("providerID") int providerID){
        Optional<Provider> provider= Optional.ofNullable(providerService.getProviderbyID(providerID));
        return provider.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
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
