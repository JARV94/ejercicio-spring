package com.leader.platzimarket.persistence.mappers;

import com.leader.platzimarket.domain.DomainPurchaseItem;
import com.leader.platzimarket.persistence.entities.PurchaseProduct;
import com.leader.platzimarket.persistence.entities.PurchaseProductPK;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-20T22:18:40-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Eclipse Adoptium)"
)
@Component
public class PurchaseItemMapperImpl implements PurchaseItemMapper {

    @Override
    public DomainPurchaseItem toDomainPurchaseItem(PurchaseProduct purchaseProduct) {
        if ( purchaseProduct == null ) {
            return null;
        }

        DomainPurchaseItem domainPurchaseItem = new DomainPurchaseItem();

        Integer productId = purchaseProductIdProductId( purchaseProduct );
        if ( productId != null ) {
            domainPurchaseItem.setProductId( productId );
        }
        if ( purchaseProduct.getQuantity() != null ) {
            domainPurchaseItem.setQuantity( purchaseProduct.getQuantity() );
        }
        if ( purchaseProduct.getTotal() != null ) {
            domainPurchaseItem.setTotal( purchaseProduct.getTotal() );
        }
        domainPurchaseItem.setActive( purchaseProduct.isStatus() );

        return domainPurchaseItem;
    }

    @Override
    public PurchaseProduct toPurchaseProduct(DomainPurchaseItem domainPurchaseItem) {
        if ( domainPurchaseItem == null ) {
            return null;
        }

        PurchaseProduct purchaseProduct = new PurchaseProduct();

        purchaseProduct.setId( domainPurchaseItemToPurchaseProductPK( domainPurchaseItem ) );
        purchaseProduct.setQuantity( domainPurchaseItem.getQuantity() );
        purchaseProduct.setTotal( domainPurchaseItem.getTotal() );
        purchaseProduct.setStatus( domainPurchaseItem.isActive() );

        return purchaseProduct;
    }

    private Integer purchaseProductIdProductId(PurchaseProduct purchaseProduct) {
        if ( purchaseProduct == null ) {
            return null;
        }
        PurchaseProductPK id = purchaseProduct.getId();
        if ( id == null ) {
            return null;
        }
        Integer productId = id.getProductId();
        if ( productId == null ) {
            return null;
        }
        return productId;
    }

    protected PurchaseProductPK domainPurchaseItemToPurchaseProductPK(DomainPurchaseItem domainPurchaseItem) {
        if ( domainPurchaseItem == null ) {
            return null;
        }

        PurchaseProductPK purchaseProductPK = new PurchaseProductPK();

        purchaseProductPK.setProductId( domainPurchaseItem.getProductId() );

        return purchaseProductPK;
    }
}
