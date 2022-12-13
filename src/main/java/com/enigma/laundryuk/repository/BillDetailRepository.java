package com.enigma.laundryuk.repository;

import com.enigma.laundryuk.entity.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail,String> {
}
