package com.revshop.SellerService;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revshop.model.Seller;
import com.revshop.repo.SellerRepo;
@Service
public class SellerServiceImpl implements SellerService {
	@Autowired
	private SellerRepo repo1;

	@Override
	public Seller register(Seller seller) {
		seller.setCreated_date(LocalDate.now());
		Seller registerData = repo1.save(seller);
		return registerData;
		
	}

	@Override
	public Seller login(int seller_id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
