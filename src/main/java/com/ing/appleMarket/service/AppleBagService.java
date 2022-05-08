package com.ing.appleMarket.service;

import com.ing.appleMarket.entity.AppleBag;
import com.ing.appleMarket.repository.AppleMarketRepository;
import org.springframework.stereotype.Service;

@Service
public class AppleBagService {
    private final AppleMarketRepository appleMarketRepository;

    public AppleBagService(AppleMarketRepository appleMarketRepository){
        this.appleMarketRepository = appleMarketRepository;
    }
    public AppleBag persistData(final AppleBag appleBag){
        return appleMarketRepository.save(appleBag);
    }
}
