package com.example.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockResult {

	private Long stockId;
	private String stockName;
	private BigDecimal stockPrice;

}
