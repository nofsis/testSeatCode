package com.seat.test.controller;


import com.seat.test.dtos.poji.MowerMapper;
import com.seat.test.dtos.pojo.MowersRequestJsonDto;
import com.seat.test.entities.Mower;
import com.seat.test.service.poji.MowersSolution;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by abderrahman.boudrai on 20/06/2020
 */
@RestController
public class MowerRest {

    @Autowired
    MowersSolution mowersSolutionImpl;

    @Autowired
    private MowerMapper mowerMapper;

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getFinalPositionOfMowers(@RequestBody MowersRequestJsonDto mowersRequestJsonDto) {

	     final List<Mower> requestMowers = mowerMapper.mapMowerDtoListToMowerEntityList(mowersRequestJsonDto.getMowers());
	     final List<Integer> upperRightPosition = this.convertStringToOrientationsList(mowersRequestJsonDto.getUpperRightPosition());
	     final Pair<Integer,Integer> upperRightPositionPair = new Pair<>(upperRightPosition.get(0), upperRightPosition.get(1));

	    return this.mowersSolutionImpl.getMowersFinalCoordinatesAndHeading(upperRightPositionPair,requestMowers);

    }

    private List<Integer> convertStringToOrientationsList(final String str) {
	return str.chars()//
			.mapToObj(e -> (char) e)//
			.map(String::valueOf)//
			.map(Integer::parseInt)
			.collect(Collectors.toList());

    }

}
