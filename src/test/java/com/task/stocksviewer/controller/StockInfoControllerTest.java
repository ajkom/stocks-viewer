package com.task.stocksviewer.controller;

import com.task.stocksviewer.service.StockInfoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StockInfoControllerTest {

	@InjectMocks
	private StockInfoController controller = new StockInfoController();

	@Mock
	StockInfoService service;

	@Test
	public void testGetStockInfo() throws IOException, URISyntaxException {
		given(service.readCsvFile()).willReturn(new ArrayList<>());

		controller.getStockInfo();
		verify(service).readCsvFile();
	}

}
