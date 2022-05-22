package com.leader.platzimarket.persistence;

import com.leader.platzimarket.domain.DomainProduct;
import com.leader.platzimarket.domain.repository.ProductoRepository;
import com.leader.platzimarket.persistence.cruds.ProudctCrudRepository;
import com.leader.platzimarket.persistence.entities.Product;
import com.leader.platzimarket.persistence.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Indica a Spring que esta clase interactua con la base de datos
@Repository
public class ProductCrudRepository implements ProductoRepository {

    //cede el control a spring para instanciar estos objetos.
    @Autowired
    private ProudctCrudRepository proudctCrudRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<DomainProduct> getAll(){
        List<Product> products = (List<Product>) this.proudctCrudRepository.findAll();
        return productMapper.toDomainProducts(products);
    }

    @Override
    public Optional<List<DomainProduct>> getByCategory(int category){
        List<Product> products = this.proudctCrudRepository.findByCategoryIdOrderByNameAsc(category);
        return Optional.of(productMapper.toDomainProducts(products));
    }

    @Override
    public Optional<List<DomainProduct>> getLowProducts(int quantity){

        Optional <List<Product>> products = this.proudctCrudRepository.findByStockLessThanAndStatus(quantity,true);
        return products.map( prod -> productMapper.toDomainProducts(prod) );
    }

    @Override
    public Optional<DomainProduct> getProduct (int productId){
        return this.proudctCrudRepository.findById(productId).map(prod -> productMapper.toDomainProduct(prod));
    }

    @Override
    public DomainProduct saveProduct(DomainProduct product){
        Product prod = productMapper.toProduct(product);
        return productMapper.toDomainProduct( this.proudctCrudRepository.save(prod
        ));
    }

    public void deleteProduct(int productId){
        this.proudctCrudRepository.deleteById(productId);
    }
}
