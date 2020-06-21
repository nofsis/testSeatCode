package com.seat.test.dtos.poji;

import com.seat.test.dtos.pojo.MowerRequestJsonDto;
import com.seat.test.entities.Mower;

import java.util.List;

/**
 * Created by abderrahman.boudrai on 21/06/2020
 */
public interface MowerMapper {

    public List<Mower> mapMowerDtoListToMowerEntityList(final List<MowerRequestJsonDto> mowerRequestJsonDto);

    public Mower mapMowerDtoToMowerEntity(final MowerRequestJsonDto mowerRequestJsonDto);
}
