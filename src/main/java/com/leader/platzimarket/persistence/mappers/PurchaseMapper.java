package com.leader.platzimarket.persistence.mappers;


import com.leader.platzimarket.domain.DomainPurchase;
import com.leader.platzimarket.domain.DomainPurchaseItem;
import com.leader.platzimarket.persistence.entities.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {DomainPurchaseItem.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "id",target = "purchaseId"),
            @Mapping(source = "clientId",target = "clientId"),
            @Mapping(source = "date",target = "date"),
            @Mapping(source = "status",target = "state"),
            @Mapping(source = "coment",target = "comment"),
            @Mapping(source = "paymentMethod",target = "paymentMethod"),
            @Mapping(source = "products",target = "items"),

    })
    DomainPurchase toDomainPurchase(Purchase purchase);

    List<DomainPurchase> toDomainPurchases(List<Purchase> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    Purchase toPurchase(DomainPurchase domainPurchase);
}
