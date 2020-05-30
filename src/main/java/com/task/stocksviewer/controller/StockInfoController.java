package com.task.stocksviewer.controller;

import com.task.stocksviewer.bean.StockInfo;
import com.task.stocksviewer.service.StockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping(path = "/api")
public class StockInfoController {
	@Autowired
	StockInfoService service;

	@RequestMapping(path = "/stockInfo")
	public List<StockInfo> getStockInfo() throws IOException, URISyntaxException {
		return service.readCsvFile();
	}

	@RequestMapping(path = "/hello")
	public String hello() {
		return "hello";
	}
}
