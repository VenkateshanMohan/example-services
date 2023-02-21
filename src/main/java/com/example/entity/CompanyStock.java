package com.example.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity
public class CompanyStock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stockId;
	private String stockCode;
	private String stockName;
	private BigDecimal stockPrice;

}
