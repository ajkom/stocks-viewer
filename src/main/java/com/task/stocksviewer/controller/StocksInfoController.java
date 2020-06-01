package com.task.stocksviewer.controller;

import com.task.stocksviewer.bean.StocksInfo;
import com.task.stocksviewer.service.StocksInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/stocks", produces = "application/json")
public class StocksInfoController {
	@Autowired
	StocksInfoService service;

	@GetMapping
	public List<StocksInfo> getStockInfo() {
		return service.getStocksInfo();
	}
}
