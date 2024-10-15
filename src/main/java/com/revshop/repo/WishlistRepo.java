package com.revshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revshop.model.Wishlist;

@Repository
public interface WishlistRepo extends JpaRepository<Wishlist, Integer>{

}
