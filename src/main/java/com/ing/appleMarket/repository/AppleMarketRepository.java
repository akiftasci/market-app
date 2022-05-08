package com.ing.appleMarket.repository;


import com.ing.appleMarket.entity.AppleBag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppleMarketRepository extends JpaRepository<AppleBag, Long> {
}
