package com.leader.platzimarket.domain.service;

import com.leader.platzimarket.domain.DomainProduct;
import com.leader.platzimarket.domain.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<DomainProduct> getAll(){
        return this.productoRepository.getAll();
    }

    public Optional<DomainProduct> getProduct( int productId){
        return productoRepository.getProduct(productId);
    }

    public Optional<List<DomainProduct>> getByCategory(int categoryId){
        return this.productoRepository.getByCategory(categoryId);
    }

    public DomainProduct saveProduct(DomainProduct product){
        return this.productoRepository.saveProduct(product);
    }

    public boolean deleteProduct(int productId){
        if (this.getProduct(productId).isPresent()){
            this.productoRepository.deleteProduct(productId);
            return true;
        }
        return false;

    }



}
