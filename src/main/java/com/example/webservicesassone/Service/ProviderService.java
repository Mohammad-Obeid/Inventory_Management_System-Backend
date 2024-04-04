package com.example.webservicesassone.Service;


import com.example.webservicesassone.Model.Inventory;
import com.example.webservicesassone.Model.Item;
import com.example.webservicesassone.Model.Provider;
import com.example.webservicesassone.Repository.ItemRepository;
import com.example.webservicesassone.Repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProviderService {
    private static ProviderRepository providerRepo;
    private static ItemRepository itemRepository;
    public ProviderService(ProviderRepository providerRepo,ItemRepository itemRepository) {
        this.providerRepo=providerRepo;
        this.itemRepository=itemRepository;
    }

    public Provider getProviderbyID(int providerID) {
        Optional<Provider> provider=providerRepo.findById(providerID);
        if(provider.isPresent()){
            return provider.get();
        }
        else{
            throw new IllegalStateException("Provider with ID "+ providerID+" wasn't Found");
        }
    }

    public void addNewProvider(Provider provider) {
        Optional<Provider> pro=providerRepo.findProviderByProviderEmail(provider.getProviderEmail());
        if(pro.isPresent()){
            throw new IllegalStateException("Email Already Exists");
        }
        providerRepo.save(provider);
    }

    public void deleteProvider(int providerID) {
        Optional<Provider> provider=providerRepo.findById(providerID);
        if(provider.isPresent()){
            providerRepo.delete(provider.get());
        }
        else{
            throw new IllegalStateException("Provider with ID "+ providerID+" wasn't Found");
        }
    }

    public Provider UpdateProviderByID(Provider provider, int providerID) {
        List<Item> items = itemRepository.findAll();
        List<Item> items2 = new ArrayList<>();
        for(int i=0;i<provider.getItems().size();i++){
            int itemId = provider.getItems().get(i).getItemID();
            for(int j=0;j<items.size();j++){
                if(itemId==items.get(j).getItemID()){
                    items2.add(items.get(j));

                }
            }
        }
        provider.setProviderID(providerID);
        provider.setItems(items2);
        return providerRepo.save(provider);
    }

    public List<Provider> getAllProviders() {
        return providerRepo.findAll();
    }
}
