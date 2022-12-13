package com.enigma.laundryuk.service.impl;

import com.enigma.laundryuk.dto.PriceDTO;
import com.enigma.laundryuk.dto.ProductDTO;
import com.enigma.laundryuk.dto.ProductResponseDTO;
import com.enigma.laundryuk.entity.Product;
import com.enigma.laundryuk.entity.ProductPrice;
import com.enigma.laundryuk.repository.ProductRepository;
import com.enigma.laundryuk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    @Autowired
    ProductPriceServiceImpl productPriceService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(ProductDTO product) {
        Product newProduct = new Product();
        newProduct.setCreatedAt(new Date());
        newProduct.setUpdatedAt(new Date());
        newProduct.setName(product.getName());
        newProduct.setDuration(product.getDuration());
        newProduct = productRepository.save(newProduct);

        List<ProductPrice> productPrices = new ArrayList<>();
        for (PriceDTO data : product.getPrices()) {
            ProductPrice productPrice = new ProductPrice();
            productPrice.setIsActive(true);
            productPrice.setPrice(data.getPrice());
            productPrice.setProduct(newProduct);
            productPrice = productPriceService.saveProductPrice(productPrice);
            productPrices.add(productPrice);
        }

        newProduct.setProductPrice(productPrices);
        newProduct = productRepository.save(newProduct);
        return newProduct;
    }

    @Override
    public Product updateProduct(ProductDTO product) {
        Product newProduct = productRepository.findById(product.getId()).get();
        newProduct.setUpdatedAt(new Date());
        newProduct.setName(product.getName());
        newProduct.setDuration(product.getDuration());
        newProduct = productRepository.save(newProduct);

        List<ProductPrice> productPrices = new ArrayList<>();
        for (PriceDTO data : product.getPrices()) {
            try {
                //update price
                ProductPrice productPrice = productPriceService.getProductPriceById(data.getId());
                productPrice.setIsActive(data.getIsActive());
                productPrice.setPrice(data.getPrice());
                productPrice.setProduct(newProduct);
                productPrice = productPriceService.updateProductPrice(productPrice);
                productPrices.add(productPrice);
            }catch (Exception e){
                //save new price
                ProductPrice newPrice = new ProductPrice();
                newPrice.setIsActive(true);
                newPrice.setPrice(data.getPrice());
                newPrice.setProduct(newProduct);
                newPrice = productPriceService.saveProductPrice(newPrice);
                productPrices.add(newPrice);
            }
        }

        newProduct.setProductPrice(productPrices);
        newProduct = productRepository.save(newProduct);
        return newProduct;
    }

    @Override
    public Page<Product> getAllProduct(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return productRepository.findAll(pageable);
    }

    @Override
    public ProductResponseDTO getProductById(String productId) {
        Product product = productRepository.findById(productId).get();
        ProductResponseDTO response = new ProductResponseDTO();
        response.setId(product.getId());
        response.setCreatedAt(product.getCreatedAt());
        response.setUpdatedAt(product.getUpdatedAt());
        response.setName(product.getName());
        response.setDuration(product.getDuration());

        for (ProductPrice data : product.getProductPrice()) {
            if (data.getIsActive()){
                response.setProductPrice(data);
            }
        }
        return response;
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}