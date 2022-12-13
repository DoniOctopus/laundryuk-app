package com.enigma.laundryuk.repository;

import com.enigma.laundryuk.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice , String> {
}
