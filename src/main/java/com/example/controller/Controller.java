package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.CompanyStock;
import com.example.service.SearchService;

@RestController
@RequestMapping("/api/stock-service")
public class Controller {

	@Autowired
	private SearchService searchService;

	@GetMapping("search-stocks/{searchString}")
	public List<CompanyStock> searchStocks(@PathVariable String searchString) {
		return searchService.searchStocks(searchString);
	}

	@GetMapping("list-stocks")
	public List<CompanyStock> listStocks() {
		return searchService.listStocks();
	}

}
