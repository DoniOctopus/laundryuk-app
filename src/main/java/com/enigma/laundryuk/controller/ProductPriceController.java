package com.enigma.laundryuk.controller;

import com.enigma.laundryuk.entity.ProductPrice;
import com.enigma.laundryuk.service.ProductPriceService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productPrices")
public class ProductPriceController {

    ProductPriceService productPriceService;

    public ProductPriceController(ProductPriceService productPriceService) {
        this.productPriceService = productPriceService;
    }

    @PostMapping
    public ProductPrice saveProductPrice(@RequestBody ProductPrice productPrice){
        return productPriceService.saveProductPrice(productPrice);
    }

    @GetMapping("/{id}")
    public ProductPrice getProductPriceById(@PathVariable String id){
        return productPriceService.getProductPriceById(id);
    }

    @GetMapping
    public Page<ProductPrice> getProductPrices(){
        return productPriceService.getAllProductPrice(0,10);
    }

    @PutMapping
    public ProductPrice updateProductPrice(@RequestBody ProductPrice productPrice){
        return productPriceService.updateProductPrice(productPrice);
    }

    @DeleteMapping("/{id}")
    public void deleteProductPrice(@PathVariable String id){
        productPriceService.deleteProductPrice(id);
    }
}