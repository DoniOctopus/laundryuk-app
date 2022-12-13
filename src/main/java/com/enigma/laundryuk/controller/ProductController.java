package com.enigma.laundryuk.controller;

import com.enigma.laundryuk.dto.ProductDTO;
import com.enigma.laundryuk.dto.ProductResponseDTO;
import com.enigma.laundryuk.entity.Product;
import com.enigma.laundryuk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product saveProduct(@RequestBody ProductDTO product){
        return productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable String id){
        return productService.getProductById(id);
    }

    @GetMapping
    public Page<Product> getProducts(){
        return productService.getAllProduct(0,10);
    }

    @PutMapping
    public Product updateProduct(@RequestBody ProductDTO product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
    }

}