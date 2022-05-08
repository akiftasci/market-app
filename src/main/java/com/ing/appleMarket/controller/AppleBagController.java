package com.ing.appleMarket.controller;

import com.ing.appleMarket.dto.AppleBagDto;
import com.ing.appleMarket.entity.AppleBag;
import com.ing.appleMarket.service.AppleBagService;
import com.ing.appleMarket.utils.Util;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AppleBagController {

    private final AppleBagService appleBagService;

    public AppleBagController(final AppleBagService appleBagService){
        this.appleBagService = appleBagService;
    }

    @PostMapping(value = "/")
    public AppleBagDto createAccount(@RequestBody final AppleBagDto requestBody){

        final AppleBag appleBag = Util.convertToEntity(requestBody);
        final AppleBag persistedEntity = appleBagService.persistData(appleBag);

        return Util.convertEntityToDto(persistedEntity);
    }
}
