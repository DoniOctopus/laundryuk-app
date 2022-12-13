package com.enigma.laundryuk.service;

import com.enigma.laundryuk.dto.ProductDTO;
import com.enigma.laundryuk.dto.ProductResponseDTO;
import com.enigma.laundryuk.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product saveProduct(ProductDTO product);
    Product updateProduct(ProductDTO product);
    Page<Product> getAllProduct(int page, int size);
    ProductResponseDTO getProductById(String productId);
    void deleteProduct(String id);
}
