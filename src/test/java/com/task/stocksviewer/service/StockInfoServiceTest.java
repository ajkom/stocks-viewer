package com.task.stocksviewer.service;

import com.task.stocksviewer.bean.CompanyInfo;
import com.task.stocksviewer.bean.DateValue;
import com.task.stocksviewer.bean.StockInfo;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

	@Test
	public void testParseDataPerCompany() {
		double nokia1 = 2.00;
		double nokia2 = 3.00;
		double nordea1 = 3.00;
		double nordea2 = 4.00;
		double microsoft1 = 4.00;
		double microsoft2 = 5.00;
		double telia1 = 1.00;
		double telia2 = 2.00;

		LocalDate today = LocalDate.now();

		StockInfo first = new StockInfo(today, nokia1, nordea1, microsoft1, telia1);
		StockInfo second = new StockInfo(today, nokia2, nordea2, microsoft2, telia2);

		List<StockInfo> data = new ArrayList<>(Arrays.asList(first, second));

		List<CompanyInfo> result = service.parseDataPerCompany(data);
		assertNotNull(result);

		assertDataEquals(result.get(0).getDateValueList(), nokia1, nokia2);
		assertDataEquals(result.get(1).getDateValueList(), nordea1, nordea2);
		assertDataEquals(result.get(2).getDateValueList(), microsoft1, microsoft2);
		assertDataEquals(result.get(3).getDateValueList(), telia1, telia2);
	}

	private void assertDataEquals(List<DateValue> list, double first, double second){
		assertEquals(list.get(0).getValue(), first);
		assertEquals(list.get(1).getValue(), second);
	}
}
