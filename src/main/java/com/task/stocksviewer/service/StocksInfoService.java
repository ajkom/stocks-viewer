package com.task.stocksviewer.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.task.stocksviewer.entity.StocksInfo;
import com.task.stocksviewer.repository.StocksInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
public class StocksInfoService {
    @Autowired
	StocksInfoRepository repository;

    public void save(List<StocksInfo> infoList) {
        repository.saveAll(infoList);
    }

    @Cacheable("stocks")
    public List<StocksInfo> getStocksInfo(){
        return repository.findAll();
    }

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
