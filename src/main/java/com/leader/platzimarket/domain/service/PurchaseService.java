package com.leader.platzimarket.domain.service;

import com.leader.platzimarket.domain.DomainPurchase;
import com.leader.platzimarket.domain.repository.PurchasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchasesRepository purchasesRepository;

    public List<DomainPurchase> getAll(){
        return this.purchasesRepository.getAll();
    }

    public Optional<List<DomainPurchase>> getByClient(String clientId){
        return this.purchasesRepository.getByClient(clientId);
    }

    public DomainPurchase save(DomainPurchase domainPurchase){
        return this.purchasesRepository.save(domainPurchase);
    }
}
