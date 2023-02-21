package com.example.entity;

import java.math.BigDecimal;
import java.util.Date;

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
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	private Long userId;
	private String stockId;
	private BigDecimal numberOfUnits;
	private BigDecimal amount;
	private BigDecimal stockPrice;
	private Boolean successful;
	private Date submitTime;

}
