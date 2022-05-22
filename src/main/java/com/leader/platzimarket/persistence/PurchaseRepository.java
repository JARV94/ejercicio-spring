package com.leader.platzimarket.persistence;

import com.leader.platzimarket.domain.DomainPurchase;
import com.leader.platzimarket.domain.repository.PurchasesRepository;
import com.leader.platzimarket.persistence.cruds.PurchaseCrudRepository;
import com.leader.platzimarket.persistence.entities.Purchase;
import com.leader.platzimarket.persistence.mappers.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements PurchasesRepository {

    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;


    @Override
    public List<DomainPurchase> getAll() {
        return this.purchaseMapper.toDomainPurchases((List<Purchase>) this.purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<DomainPurchase>> getByClient(String clientId) {
        return this.purchaseCrudRepository.findByClientId(clientId)
                .map(purchases -> this.purchaseMapper.toDomainPurchases(purchases) );
    }

    @Override
    public DomainPurchase save(DomainPurchase domainPurchase) {
        Purchase purchase = this.purchaseMapper.toPurchase(domainPurchase);
        purchase.getProducts().forEach(product -> product.setPurchase(purchase) );
        return this.purchaseMapper.toDomainPurchase(purchase);
    }
}
