package com.leader.platzimarket.web.controllers;

import com.leader.platzimarket.domain.DomainPurchase;
import com.leader.platzimarket.domain.service.PurchaseService;
import com.leader.platzimarket.persistence.entities.Purchase;
import com.leader.platzimarket.persistence.mappers.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;


    @GetMapping("")
    public ResponseEntity<List<DomainPurchase>> getAll(){
        return new ResponseEntity<>(this.purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<DomainPurchase>> getByClient(@PathVariable("clientId") String clientId ){
        return this.purchaseService.getByClient(clientId)
                .map(domainPurchases -> new ResponseEntity<>(domainPurchases,HttpStatus.OK) )
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    @PostMapping("")
//    public ResponseEntity<DomainPurchase> save(DomainPurchase domainPurchase){
//        return new ResponseEntity<>(this.purchaseService.save(domainPurchase),HttpStatus.CREATED);
//    }
}
