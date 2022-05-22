package com.leader.platzimarket.domain.repository;

import com.leader.platzimarket.domain.DomainPurchase;

import java.util.List;
import java.util.Optional;

public interface PurchasesRepository {
    List<DomainPurchase> getAll();
    Optional< List<DomainPurchase>> getByClient(String clientId);
    DomainPurchase save(DomainPurchase domainPurchase);

}
