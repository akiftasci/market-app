package com.ing.appleMarket.controller;

import com.ing.appleMarket.dto.AppleBagDto;
import com.ing.appleMarket.entity.AppleBag;
import com.ing.appleMarket.service.AppleBagService;
import com.ing.appleMarket.utils.Util;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Validated
public class AppleBagController {
    @Value("${defaults.bag-number}")
    private int defaultBagNumber;

    private final AppleBagService appleBagService;

    public AppleBagController(final AppleBagService appleBagService){
        this.appleBagService = appleBagService;
    }

    @PostMapping(value = "/")
    public AppleBagDto createAccount(@Valid @RequestBody final AppleBagDto requestBody){
        final AppleBag appleBag = Util.convertToEntity(requestBody);

        return appleBagService.persistData(appleBag);
    }
    @GetMapping(value ={ "/" , "/{bagNumber}"})
    public List<AppleBagDto> getAppleBags(@Valid @PathVariable Optional<Integer> bagNumber){
        return appleBagService.getAppleBags(bagNumber.orElse(defaultBagNumber));
    }
}
