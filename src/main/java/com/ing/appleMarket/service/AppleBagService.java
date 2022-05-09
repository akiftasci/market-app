package com.ing.appleMarket.service;

import com.ing.appleMarket.dto.AppleBagDto;
import com.ing.appleMarket.entity.AppleBag;
import com.ing.appleMarket.repository.AppleMarketRepository;
import com.ing.appleMarket.utils.Util;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AppleBagService {
    private final AppleMarketRepository appleMarketRepository;

    public AppleBagService(AppleMarketRepository appleMarketRepository) {
        this.appleMarketRepository = appleMarketRepository;
    }

    public AppleBagDto persistData(final AppleBag appleBag) {
        return Util.convertEntityToDto(appleMarketRepository.save(appleBag));
    }

    public List<AppleBagDto> getAppleBags(final int no) {
        final List<AppleBag> appleBagList = appleMarketRepository.findAll()
            .stream()
            .limit(no)
            .collect(Collectors.toList());

        return appleBagList.stream().map(n -> {
            final AppleBagDto appleBagDto = new AppleBagDto();
            appleBagDto.setId(n.getId());
            appleBagDto.setDate(Util.convertLocalDateTimeToString(n.getCreated()));
            appleBagDto.setSupplier(n.getSupplier());
            appleBagDto.setAmount(n.getAmount());
            appleBagDto.setPrice(n.getPrice());
            return appleBagDto;
        }).collect(Collectors.toList());
    }
}
