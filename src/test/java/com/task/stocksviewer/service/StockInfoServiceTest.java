package com.task.stocksviewer.service;

import com.task.stocksviewer.bean.StockInfo;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StockInfoServiceTest {

	StockInfoService service = new StockInfoService();

	@Test
	public void testReadCsvFile() throws IOException, URISyntaxException {
		List<StockInfo> infoList = service.readCsvFile();
		assertNotNull(infoList);
		assertEquals(365, infoList.size());
	}
}
