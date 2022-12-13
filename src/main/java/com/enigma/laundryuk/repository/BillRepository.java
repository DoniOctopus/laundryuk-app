package com.enigma.laundryuk.repository;

import com.enigma.laundryuk.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill,String> {
}
