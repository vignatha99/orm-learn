package com.handson.ormlearn.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handson.ormlearn.model.Stock;
import com.handson.ormlearn.repository.StockRepository;
import com.handson.ormlearn.service.StockService;

@Service
@Transactional
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepo;
	
	@Override
	public List<Stock> getAllStockDetails() {
		return stockRepo.findAll();
	}

	@Override
	public List<Stock> findStockUsingCode(String code) {

		return stockRepo.findStockByCode(code);
	}

	@Override
	public List<Stock> findFBStockInSep19(String code, Date startDate, Date endDate) {

		return stockRepo.fbStockInSep19(code, startDate, endDate);
	}

	@Override
	public List<Stock> findGoogleStockGreaterThan1250(String code, double price) {

		return stockRepo.googleStocks(code, price);
	}

	@Override
	public List<Stock> findTop3VolumeStock() {

		return stockRepo.topVolume();
	}

	@Override
	public List<Stock> findLowest3NetflixStocks(String code) {
		
		return stockRepo.lowNetflixStocks(code);
	}


}
