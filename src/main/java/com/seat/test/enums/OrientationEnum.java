package com.seat.test.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * Created by abderrahman.boudrai on 19/06/2020
 */
@Getter
@AllArgsConstructor
public enum OrientationEnum {

    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");

    private String key;


    public static OrientationEnum getOrientationBy(String key){
            return Arrays.stream(OrientationEnum.values())//
                            .filter(reportType -> reportType.getKey().equals(key))//
                            .findAny()
                            .orElseThrow(()->new IllegalArgumentException("The orientation should be one on this letters [N,E,S,W]"));

    }


}
