package com.revshop.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revshop.model.Buyer;

import com.revshop.repo.BuyerRepo;

@Service
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	private BuyerRepo repo;
	@Override
	public Buyer register(Buyer buyer) {
		buyer.setCreated_date(LocalDate.now());
		Buyer registerData = repo.save(buyer);
		return registerData;
	}

	
}
