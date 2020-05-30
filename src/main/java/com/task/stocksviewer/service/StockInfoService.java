package com.task.stocksviewer.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.task.stocksviewer.bean.CompanyInfo;
import com.task.stocksviewer.bean.StockInfo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StockInfoService {

    private final ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    private final String FILE_NAME = "DATA.csv";

    public List<CompanyInfo> getStockInfo() throws IOException, URISyntaxException {
        List<StockInfo> infoFromFile = readCsvFile();
        return parseDataPerCompany(infoFromFile);
    }

    public List<StockInfo> readCsvFile() throws URISyntaxException, IOException {

        URL url = classLoader.getResource(FILE_NAME);
        Reader reader = Files.newBufferedReader(Paths.get(url.toURI()));

        CsvToBean<StockInfo> csvToBean = new CsvToBeanBuilder<StockInfo>(reader)
                .withSeparator(',')
                .withType(StockInfo.class)
                .withSkipLines(1)
                .build();

        List<StockInfo> stocksList;

        stocksList = csvToBean.parse();
        return stocksList;

    }

    public List<CompanyInfo> parseDataPerCompany(List<StockInfo> stockInfoList) {
        CompanyInfo nokia = new CompanyInfo("Nokia", new ArrayList<>());
        CompanyInfo nordea = new CompanyInfo("Nordea", new ArrayList<>());
        CompanyInfo microsoft = new CompanyInfo("Microsoft", new ArrayList<>());
        CompanyInfo telia = new CompanyInfo("Telia", new ArrayList<>());

        for (StockInfo info : stockInfoList) {
            LocalDate date = info.getDate();
            nokia.addDateValue(date, info.getValueNokia());
            nordea.addDateValue(date, info.getValueNordea());
            microsoft.addDateValue(date, info.getValueMicrosoft());
            telia.addDateValue(date, info.getValueTelia());
        }

        List<CompanyInfo> result = new ArrayList<>(Arrays.asList(nokia, nordea, microsoft, telia));
        return result;
    }
}
