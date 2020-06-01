package com.task.stocksviewer;

import com.task.stocksviewer.repository.StockInfoRepository;
import com.task.stocksviewer.service.StocksInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StocksViewerApplication {
	private static final Logger log = LoggerFactory.getLogger(StocksViewerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StocksViewerApplication.class, args);
	}

	@Bean
	public CommandLineRunner stocksDemo(StocksInfoService service, StockInfoRepository repository){
		return (args) -> {
			// save data from the file to in-memory DB
			service.save(service.getDataFromCsvFile());

			log.info("Saved data from the file, amount of entities: " + String.valueOf(repository.findAll().size()));
		};
	}
}
