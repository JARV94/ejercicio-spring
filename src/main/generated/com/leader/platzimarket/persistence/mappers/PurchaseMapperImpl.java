package com.leader.platzimarket.persistence.mappers;

import com.leader.platzimarket.domain.DomainPurchase;
import com.leader.platzimarket.domain.DomainPurchaseItem;
import com.leader.platzimarket.persistence.entities.Purchase;
import com.leader.platzimarket.persistence.entities.PurchaseProduct;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-20T22:18:40-0600",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Eclipse Adoptium)"
)
@Component
public class PurchaseMapperImpl implements PurchaseMapper {

    @Override
    public DomainPurchase toDomainPurchase(Purchase purchase) {
        if ( purchase == null ) {
            return null;
        }

        DomainPurchase domainPurchase = new DomainPurchase();

        if ( purchase.getId() != null ) {
            domainPurchase.setPurchaseId( purchase.getId() );
        }
        domainPurchase.setClientId( purchase.getClientId() );
        domainPurchase.setDate( purchase.getDate() );
        domainPurchase.setState( purchase.getStatus() );
        domainPurchase.setComment( purchase.getComent() );
        domainPurchase.setPaymentMethod( purchase.getPaymentMethod() );
        domainPurchase.setItems( purchaseProductListToDomainPurchaseItemList( purchase.getProducts() ) );

        return domainPurchase;
    }

    @Override
    public List<DomainPurchase> toDomainPurchases(List<Purchase> purchases) {
        if ( purchases == null ) {
            return null;
        }

        List<DomainPurchase> list = new ArrayList<DomainPurchase>( purchases.size() );
        for ( Purchase purchase : purchases ) {
            list.add( toDomainPurchase( purchase ) );
        }

        return list;
    }

    @Override
    public Purchase toPurchase(DomainPurchase domainPurchase) {
        if ( domainPurchase == null ) {
            return null;
        }

        Purchase purchase = new Purchase();

        purchase.setId( domainPurchase.getPurchaseId() );
        purchase.setClientId( domainPurchase.getClientId() );
        purchase.setDate( domainPurchase.getDate() );
        purchase.setStatus( domainPurchase.getState() );
        purchase.setComent( domainPurchase.getComment() );
        purchase.setPaymentMethod( domainPurchase.getPaymentMethod() );
        purchase.setProducts( domainPurchaseItemListToPurchaseProductList( domainPurchase.getItems() ) );

        return purchase;
    }

    protected DomainPurchaseItem purchaseProductToDomainPurchaseItem(PurchaseProduct purchaseProduct) {
        if ( purchaseProduct == null ) {
            return null;
        }

        DomainPurchaseItem domainPurchaseItem = new DomainPurchaseItem();

        if ( purchaseProduct.getQuantity() != null ) {
            domainPurchaseItem.setQuantity( purchaseProduct.getQuantity() );
        }
        if ( purchaseProduct.getTotal() != null ) {
            domainPurchaseItem.setTotal( purchaseProduct.getTotal() );
        }

        return domainPurchaseItem;
    }

    protected List<DomainPurchaseItem> purchaseProductListToDomainPurchaseItemList(List<PurchaseProduct> list) {
        if ( list == null ) {
            return null;
        }

        List<DomainPurchaseItem> list1 = new ArrayList<DomainPurchaseItem>( list.size() );
        for ( PurchaseProduct purchaseProduct : list ) {
            list1.add( purchaseProductToDomainPurchaseItem( purchaseProduct ) );
        }

        return list1;
    }

    protected PurchaseProduct domainPurchaseItemToPurchaseProduct(DomainPurchaseItem domainPurchaseItem) {
        if ( domainPurchaseItem == null ) {
            return null;
        }

        PurchaseProduct purchaseProduct = new PurchaseProduct();

        purchaseProduct.setQuantity( domainPurchaseItem.getQuantity() );
        purchaseProduct.setTotal( domainPurchaseItem.getTotal() );

        return purchaseProduct;
    }

    protected List<PurchaseProduct> domainPurchaseItemListToPurchaseProductList(List<DomainPurchaseItem> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseProduct> list1 = new ArrayList<PurchaseProduct>( list.size() );
        for ( DomainPurchaseItem domainPurchaseItem : list ) {
            list1.add( domainPurchaseItemToPurchaseProduct( domainPurchaseItem ) );
        }

        return list1;
    }
}
