package com.seat.test.dtos.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by abderrahman.boudrai on 20/06/2020
 */
@Data
@AllArgsConstructor
public class MowerRequestJsonDto {

    private String position;
    private String instructions;
}
