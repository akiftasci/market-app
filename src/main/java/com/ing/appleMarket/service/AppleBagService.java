package com.ing.appleMarket.service;

import com.ing.appleMarket.entity.AppleBag;
import com.ing.appleMarket.repository.AppleMarketRepository;
import java.util.List;
import java.util.stream.Collectors;
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

    public List<AppleBag> getAppleBags(final int no){
        final long count = appleMarketRepository.findAll().size();
        if (count < no ){
            throw new RuntimeException();
        }
       return appleMarketRepository.findAll().stream().limit(no).collect(Collectors.toList());
    }
}
