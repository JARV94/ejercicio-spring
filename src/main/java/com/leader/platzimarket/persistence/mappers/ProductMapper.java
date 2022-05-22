package com.leader.platzimarket.persistence.mappers;

import com.leader.platzimarket.domain.DomainProduct;
import com.leader.platzimarket.persistence.entities.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "categoryId",target = "categoryId"),
            @Mapping(source = "status",target = "active"),
            @Mapping(source = "soldPrice",target = "price"),
            @Mapping(source = "stock",target = "stock"),
            @Mapping(source = "category",target = "category"),
    })
    DomainProduct toDomainProduct(Product product);

    List<DomainProduct> toDomainProducts(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "qrCode", ignore = true)
    Product toProduct(DomainProduct product);

}
