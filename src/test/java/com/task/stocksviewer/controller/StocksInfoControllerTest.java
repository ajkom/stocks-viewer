package com.task.stocksviewer.controller;

import com.task.stocksviewer.service.StocksInfoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StocksInfoControllerTest {

	@InjectMocks
	private StocksInfoController controller = new StocksInfoController();

	@Mock
	StocksInfoService service;

	@Test
	public void testGetStockInfo() throws Exception {
		given(service.getStocksInfo()).willReturn(new ArrayList<>());

		controller.getStockInfo();
		verify(service).getStocksInfo();
	}

}
