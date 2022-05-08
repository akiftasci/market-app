package com.ing.appleMarket.utils;

import com.ing.appleMarket.dto.AppleBagDto;
import com.ing.appleMarket.entity.AppleBag;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class Util {
    /**
     * Converts LocalDateTime object to String.
     * @param created the date object that wants to be converted.
     * @return LocalDateTime object converted to String.
     **/
    public static String convertLocalDateTimeToString(final LocalDateTime created) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        return formatter.format(created);
    }

    /**
     * Converts String to LocalDateTime object.
     * @param created the String that wants to be converted.
     * @return String converted to LocalDateTime object.
     **/
    public static LocalDateTime convertStringToLocalDateTime(final String created) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        return LocalDateTime.parse(created, formatter);
    }

    /**
     * Converts data transfer object to entity.
     * @param appleBagDto DTO object that wants to be converted to entity.
     * @return appleBag that has been converted from DTO.
     **/
    public static AppleBag convertToEntity(final AppleBagDto appleBagDto) {
        AppleBag appleBag = new AppleBag();

        appleBag.setAmount(appleBagDto.getAmount());
        appleBag.setPrice(appleBagDto.getPrice());
        appleBag.setSupplier(appleBagDto.getSupplier());

        return appleBag;
    }

    public static AppleBagDto convertEntityToDto(final AppleBag entity) {
        AppleBagDto appleBagDto = new AppleBagDto();

        appleBagDto.setId(entity.getId());
        appleBagDto.setDate(convertLocalDateTimeToString(entity.getCreated()));
        appleBagDto.setAmount(entity.getAmount());
        appleBagDto.setPrice(entity.getPrice());
        appleBagDto.setSupplier(entity.getSupplier());

        return appleBagDto;
    }
}
