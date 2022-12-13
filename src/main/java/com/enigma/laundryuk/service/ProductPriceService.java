package com.enigma.laundryuk.service;

import com.enigma.laundryuk.entity.ProductPrice;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductPriceService {
    ProductPrice saveProductPrice(ProductPrice productPrice);
    ProductPrice updateProductPrice(ProductPrice productPrice);
    Page<ProductPrice> getAllProductPrice(int page, int size);
    ProductPrice getProductPriceById(String productPriceId);
    void deleteProductPrice(String id);
}
