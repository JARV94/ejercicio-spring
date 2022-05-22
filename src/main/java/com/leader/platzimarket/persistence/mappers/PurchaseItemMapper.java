package com.leader.platzimarket.persistence.mappers;

import com.leader.platzimarket.domain.DomainPurchaseItem;
import com.leader.platzimarket.persistence.entities.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.productId",target = "productId"),
            @Mapping(source = "quantity",target = "quantity"),
            @Mapping(source = "total",target = "total"),
            @Mapping(source = "status",target = "active")
    })
    DomainPurchaseItem toDomainPurchaseItem(PurchaseProduct purchaseProduct);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "id.purchaseId", ignore = true)
    })
    PurchaseProduct toPurchaseProduct(DomainPurchaseItem domainPurchaseItem);
}
