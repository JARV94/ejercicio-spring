package com.leader.platzimarket.persistence.cruds;

import com.leader.platzimarket.persistence.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProudctCrudRepository extends CrudRepository<Product,Integer> {
    List<Product> findByCategoryIdOrderByNameAsc(int cateogyrId);

    Optional<List<Product>> findByStockLessThanAndStatus(int stock,boolean status);
}
