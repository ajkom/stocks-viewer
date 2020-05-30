package com.task.stocksviewer.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.task.stocksviewer.bean.StockInfo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class StockInfoService {

    private ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    private String FILE_NAME = "DATA.csv";

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
}
