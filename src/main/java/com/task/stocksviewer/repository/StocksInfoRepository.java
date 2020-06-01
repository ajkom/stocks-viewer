package com.task.stocksviewer.repository;

import com.task.stocksviewer.bean.StocksInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StocksInfoRepository extends CrudRepository <StocksInfo, Long> {

	List<StocksInfo> findAll();

}
