package com.leader.platzimarket.web.controllers;

import com.leader.platzimarket.domain.DomainProduct;
import com.leader.platzimarket.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<DomainProduct>> getAll(){
        return new ResponseEntity<>( this.productService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DomainProduct> getProduct( @PathVariable("id") int productId){
        return this.productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK) )
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<DomainProduct>> getByCategory(@PathVariable("categoryId") int categoryId){
        return this.productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products,HttpStatus.OK) )
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ResponseEntity<DomainProduct> saveProduct( @RequestBody DomainProduct product){
        return new ResponseEntity<>(this.productService.saveProduct(product),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct( @PathVariable("id") int productId){
        if (this.productService.deleteProduct(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    }
