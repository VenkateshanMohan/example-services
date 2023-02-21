package com.example.service;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.CompanyStock;
import com.example.repository.CompanyStockRepository;

import jakarta.annotation.PostConstruct;

@Service
public class SearchService {

	@Autowired
	private CompanyStockRepository companyStockRepository;

	@PostConstruct
	private void loadDataIntoHSQL() {
		Stream.of(
				new CompanyStock(1111, "IBMC", "International Business Machine Corporation",
						new BigDecimal("1432.234")),
				new CompanyStock(2222, "APPL", "Apple Inc.", new BigDecimal("5432.234")),
				new CompanyStock(3333, "GOOG", "Alphabet Corporation", new BigDecimal("5478.255")),
				new CompanyStock(4444, "FACB", "Meta Corporation", new BigDecimal("200.456")),
				new CompanyStock(5555, "MICS", "Microsoft Corporation", new BigDecimal("7432.234"))).forEach(book -> {
					companyStockRepository.save(book);
				});
	}

	@Transactional(readOnly = true)
	public List<CompanyStock> searchStocks(String searchString) {
		List<CompanyStock> stockList = new ArrayList<>();
		List<CompanyStock> tempStockList = new ArrayList<>();
		companyStockRepository.findAll().forEach(tempStockList::add);

		tempStockList.stream().filter(obj -> obj.getStockName().contains(searchString)).forEach(stockList::add);
		tempStockList.stream().filter(obj -> obj.getStockCode().contains(searchString)).forEach(stockList::add);
		tempStockList.stream().filter(obj -> obj.getStockPrice().toString().contains(searchString))
				.forEach(stockList::add);

		return stockList.stream().collect(collectingAndThen(
				toCollection(() -> new TreeSet<>(comparingInt(CompanyStock::getStockId))), ArrayList::new));
	}

	@Transactional(readOnly = true)
	public List<CompanyStock> listStocks() {
		return companyStockRepository.findAll();
	}
}
