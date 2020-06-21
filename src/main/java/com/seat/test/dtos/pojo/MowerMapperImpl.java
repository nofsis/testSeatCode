package com.seat.test.dtos.pojo;


import com.seat.test.dtos.poji.MowerMapper;
import com.seat.test.entities.Mower;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by abderrahman.boudrai on 21/06/2020
 */
@Component("default")
public class MowerMapperImpl implements MowerMapper {

    @Override
    public List<Mower> mapMowerDtoListToMowerEntityList(final List<MowerRequestJsonDto> mowerRequestJsonDto) {
        if(CollectionUtils.isEmpty(mowerRequestJsonDto)){
            return new ArrayList<>();
	}
	return mowerRequestJsonDto.stream()//
			.map(this::mapMowerDtoToMowerEntity)//
			.collect(Collectors.toList());
    }

    public Mower mapMowerDtoToMowerEntity(final MowerRequestJsonDto mowerRequestJsonDto) {
	return Mower.builder()//
			.instructions(mowerRequestJsonDto.getInstructions())//
			.position(mowerRequestJsonDto.getPosition())//
			.build();
    }

}
