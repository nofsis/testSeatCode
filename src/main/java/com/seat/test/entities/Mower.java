package com.seat.test.entities;

import com.seat.test.enums.OrientationEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by abderrahman.boudrai on 19/06/2020
 */
@Getter
@Setter
public class Mower {

    private Integer xPosition;
    private Integer yPosition;
    private OrientationEnum orientation;
    private String instructions;

    @Builder
    public Mower(String position,String instructions){
        if(position == null || "".equals(position)){
            throw new IllegalArgumentException("The position of the mower couldn't be null");
        }
        try {
            final String[] positionData = position.split(" ");

            xPosition = Integer.parseInt(positionData[0]);
            yPosition = Integer.parseInt(positionData[1]);
            orientation = OrientationEnum.getOrientationBy(positionData[2]);
            this.instructions = instructions;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("The orientation should be one on this letters [N,E,S,W]");
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("The coordinates of a mower should be numbers");
        }

    }






}
