package com.task.stocksviewer.controller;

import com.task.stocksviewer.bean.FullStockInfo;
import com.task.stocksviewer.service.StockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/stocks", produces = "application/json")
public class StockInfoController {
	@Autowired
	StockInfoService service;

	@GetMapping
	public List<FullStockInfo> getStockInfo() throws IOException, URISyntaxException {
		return service.getDataFromCsvFile();
	}
}
