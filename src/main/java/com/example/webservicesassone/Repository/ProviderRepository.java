package com.example.webservicesassone.Repository;

import com.example.webservicesassone.Model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProviderRepository extends JpaRepository<Provider,Integer> {
    Optional<Provider> findProviderByProviderEmail(String providerEmail);
}
