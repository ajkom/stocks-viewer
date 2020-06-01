package com.task.stocksviewer.service;

import com.task.stocksviewer.bean.StocksInfo;
import com.task.stocksviewer.repository.StockInfoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StocksInfoServiceTest {
	@Mock
	StockInfoRepository repository;
	@InjectMocks
	StocksInfoService service;

	@Test
	public void testReadCsvFile() throws Exception {
		List<StocksInfo> infoList = service.getDataFromCsvFile();
		assertNotNull(infoList);
		assertEquals(365, infoList.size());
	}

	@Test
	public void testGetStockInfo() {
		given(repository.findAll()).willReturn(new ArrayList<>());

		service.getStocksInfo();
		verify(repository).findAll();
	}
}
