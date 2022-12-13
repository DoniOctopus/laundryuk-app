package com.enigma.laundryuk.service.impl;

import com.enigma.laundryuk.entity.ProductPrice;
import com.enigma.laundryuk.repository.ProductPriceRepository;
import com.enigma.laundryuk.service.ProductPriceService;
import com.enigma.laundryuk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {

    ProductPriceRepository productPriceRepository;

    @Autowired
    public ProductPriceServiceImpl(ProductPriceRepository productPriceRepository) {
        this.productPriceRepository = productPriceRepository;
    }

    @Override
    public ProductPrice saveProductPrice(ProductPrice productPrice) {
        productPrice.setCreatedAt(new Date());
        productPrice.setUpdatedAt(new Date());
        productPrice.setIsActive(true);
        return productPriceRepository.save(productPrice);
    }

    @Override
    public ProductPrice updateProductPrice(ProductPrice productPrice) {
        productPrice.setUpdatedAt(new Date());
        return productPriceRepository.save(productPrice);
    }

    @Override
    public Page<ProductPrice> getAllProductPrice(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return productPriceRepository.findAll(pageable);
    }

    @Override
    public ProductPrice getProductPriceById(String productPriceId) {
        if (productPriceRepository.findById(productPriceId).isPresent()){
            return productPriceRepository.findById(productPriceId).get();
        }else {
            throw new Error("Price Not Found");
        }
    }

    @Override
    public void deleteProductPrice(String productPriceId) {
        productPriceRepository.deleteById(productPriceId);
    }
}