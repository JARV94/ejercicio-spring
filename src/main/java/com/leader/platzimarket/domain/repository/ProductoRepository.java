package com.leader.platzimarket.domain.repository;

import com.leader.platzimarket.domain.DomainProduct;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository {
    List<DomainProduct> getAll();
    Optional<List<DomainProduct>> getByCategory(int categoryId);
    Optional<List<DomainProduct>> getLowProducts(int stock);
    Optional<DomainProduct> getProduct (int productId);
    DomainProduct saveProduct(DomainProduct product);
    void deleteProduct(int productId);

}
