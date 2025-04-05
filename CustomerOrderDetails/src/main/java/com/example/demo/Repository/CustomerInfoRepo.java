package com.example.demo.Repository;

import com.example.demo.Model.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInfoRepo extends JpaRepository<CustomerInfo,Integer> {
}
