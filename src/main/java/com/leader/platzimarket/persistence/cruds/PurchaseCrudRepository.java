package com.leader.platzimarket.persistence.cruds;

import com.leader.platzimarket.persistence.entities.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<Purchase,Integer> {

    Optional<List<Purchase>> findByClientId(String clientId);
}
