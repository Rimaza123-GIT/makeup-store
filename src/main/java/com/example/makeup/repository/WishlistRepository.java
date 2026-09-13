package com.example.makeup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.makeup.model.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

}
