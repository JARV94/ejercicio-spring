package com.leader.platzimarket.persistence.mappers;

import com.leader.platzimarket.domain.DomainProduct;
import com.leader.platzimarket.persistence.entities.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-20T22:18:40-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public DomainProduct toDomainProduct(Product product) {
        if ( product == null ) {
            return null;
        }

        DomainProduct domainProduct = new DomainProduct();

        if ( product.getId() != null ) {
            domainProduct.setId( product.getId() );
        }
        domainProduct.setName( product.getName() );
        if ( product.getCategoryId() != null ) {
            domainProduct.setCategoryId( product.getCategoryId() );
        }
        if ( product.getStatus() != null ) {
            domainProduct.setActive( product.getStatus() );
        }
        if ( product.getSoldPrice() != null ) {
            domainProduct.setPrice( product.getSoldPrice() );
        }
        if ( product.getStock() != null ) {
            domainProduct.setStock( product.getStock() );
        }
        domainProduct.setCategory( categoryMapper.toDomainCategory( product.getCategory() ) );

        return domainProduct;
    }

    @Override
    public List<DomainProduct> toDomainProducts(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<DomainProduct> list = new ArrayList<DomainProduct>( products.size() );
        for ( Product product : products ) {
            list.add( toDomainProduct( product ) );
        }

        return list;
    }

    @Override
    public Product toProduct(DomainProduct product) {
        if ( product == null ) {
            return null;
        }

        Product product1 = new Product();

        product1.setId( product.getId() );
        product1.setName( product.getName() );
        product1.setCategoryId( product.getCategoryId() );
        product1.setStatus( product.isActive() );
        product1.setSoldPrice( product.getPrice() );
        product1.setStock( product.getStock() );
        product1.setCategory( categoryMapper.toCategory( product.getCategory() ) );

        return product1;
    }
}
