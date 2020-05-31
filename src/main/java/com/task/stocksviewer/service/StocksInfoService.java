package com.task.stocksviewer.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.task.stocksviewer.bean.StocksInfo;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
public class StocksInfoService {

    public List<StocksInfo> getDataFromCsvFile() throws Exception {
        String fileName = "DATA.csv";

        InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName);
        if (is == null) {
            throw new Exception("Couldn't find the file " + fileName);
        }
        Reader reader = new InputStreamReader(is);

        CsvToBean<StocksInfo> csvToBean = new CsvToBeanBuilder<StocksInfo>(reader)
                .withSeparator(',')
                .withType(StocksInfo.class)
                .withSkipLines(1)
                .build();

        List<StocksInfo> stocksList;

        stocksList = csvToBean.parse();
        return stocksList;
    }
}
