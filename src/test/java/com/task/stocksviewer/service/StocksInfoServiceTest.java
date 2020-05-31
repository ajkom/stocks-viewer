package com.task.stocksviewer.service;

import com.task.stocksviewer.bean.StocksInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StocksInfoServiceTest {

	StocksInfoService service = new StocksInfoService();

	@Test
	public void testReadCsvFile() throws Exception {
		List<StocksInfo> infoList = service.getDataFromCsvFile();
		assertNotNull(infoList);
		assertEquals(365, infoList.size());
	}
}
