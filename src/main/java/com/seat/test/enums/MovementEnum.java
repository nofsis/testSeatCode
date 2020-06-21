package com.seat.test.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * Created by abderrahman.boudrai on 20/06/2020
 */
@Getter
@AllArgsConstructor
public enum MovementEnum {

    RIGHT("R"),
    LEFT("L"),
    FORWARD("M");

    private String key;

    public static MovementEnum getOrientationBy(String key){
        return Arrays.stream(MovementEnum.values())//
                        .filter(reportType -> reportType.getKey().equals(key))//
                        .findAny()
                        .orElseThrow(()->new IllegalArgumentException("The mower movement should be one on this letters [R,L,M]"));

    }
}
