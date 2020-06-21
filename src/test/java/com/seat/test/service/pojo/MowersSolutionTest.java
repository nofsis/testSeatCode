package com.seat.test.service.pojo;

import com.seat.test.entities.Mower;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by abderrahman.boudrai on 20/06/2020
 */

@RunWith(value = MockitoJUnitRunner.class)
public class MowersSolutionTest {

    @InjectMocks
    MowersSolutionImpl mowersSolution;

    @Test
    public void should_move_the_mowers_correctly(){
        final Mower firstMower = Mower.builder()//
                        .instructions("LMLMLMLMM")
                        .position("1 2 N")//
                        .build();

        final Mower secondMower = Mower.builder()//
                        .instructions("MMRMMRMRRM")
                        .position("3 3 E")//
                        .build();

        final Pair<Integer,Integer> upperRightPosition = new Pair<>(5,5);

        List<String> result = mowersSolution.getMowersFinalCoordinatesAndHeading(upperRightPosition, Stream.of(firstMower, secondMower)
                        .collect(Collectors.toList()));

        Assert.assertTrue(result.get(0).equals("1 3 N") && result.get(1).equals("5 1 E"));



    }

}
