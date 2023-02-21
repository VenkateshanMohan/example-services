package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.CompanyStock;

public interface CompanyStockRepository extends JpaRepository<CompanyStock, Long> {

}
