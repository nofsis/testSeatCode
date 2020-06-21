package com.seat.test.service.pojo;


import com.seat.test.entities.Mower;
import com.seat.test.enums.MovementEnum;
import com.seat.test.enums.OrientationEnum;
import com.seat.test.service.poji.MowersSolution;
import javafx.util.Pair;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by abderrahman.boudrai on 19/06/2020
 */
@Component("defaultMowersSolution")
public class MowersSolutionImpl implements MowersSolution {

    public List<String> getMowersFinalCoordinatesAndHeading(final Pair<Integer, Integer> upperRightCoordinates, final List<Mower> mowers) {
	return mowers.stream()//
			.map(mower -> this.getMowerFinalPositionAndHeading(upperRightCoordinates, mower))//
			.collect(Collectors.toList());

    }

    private String getMowerFinalPositionAndHeading(final Pair<Integer, Integer> upperRightCoordinates, final Mower mower) {

	this.validateMowerPosition(upperRightCoordinates, mower);

	final List<MovementEnum> mowerInstructions = this.convertStringToOrientationsList(mower.getInstructions());

	mowerInstructions//
			.forEach(instruction -> applyInstruction(mower, instruction, upperRightCoordinates));

	return mower.getXPosition() + " " + mower.getYPosition() + " " + mower.getOrientation().getKey();

    }

    private void applyInstruction(Mower mower, MovementEnum instruction, final Pair<Integer, Integer> upperRightCoordinates) {
	if (MovementEnum.RIGHT.equals(instruction)) {
	    rotateMowerToTheRight(mower);
	} else if (MovementEnum.LEFT.equals(instruction)) {
	    rotateMowerToTheLeft(mower);
	} else if (MovementEnum.FORWARD.equals(instruction)) {
	    moveForward(mower, upperRightCoordinates);
	}
    }

    private void moveForward(final Mower mower, final Pair<Integer, Integer> upperRightCoordinates) {
	if (OrientationEnum.NORTH.equals(mower.getOrientation())) {
	    mower.setYPosition(mower.getYPosition() + 1);
	    this.validateMowerPosition(upperRightCoordinates, mower);
	} else if (OrientationEnum.SOUTH.equals(mower.getOrientation())) {
	    mower.setYPosition(mower.getYPosition() - 1);
	    this.validateMowerPosition(upperRightCoordinates, mower);
	} else if (OrientationEnum.WEST.equals(mower.getOrientation())) {
	    mower.setXPosition(mower.getXPosition() - 1);
	    this.validateMowerPosition(upperRightCoordinates, mower);
	} else if (OrientationEnum.EAST.equals(mower.getOrientation())) {
	    mower.setXPosition(mower.getXPosition() + 1);
	    this.validateMowerPosition(upperRightCoordinates, mower);
	}
    }

    private void rotateMowerToTheLeft(final Mower mower) {
	if (OrientationEnum.NORTH.equals(mower.getOrientation())) {
	    mower.setOrientation(OrientationEnum.WEST);
	} else if (OrientationEnum.SOUTH.equals(mower.getOrientation())) {
	    mower.setOrientation(OrientationEnum.EAST);
	} else if (OrientationEnum.WEST.equals(mower.getOrientation())) {
	    mower.setOrientation(OrientationEnum.SOUTH);
	} else if (OrientationEnum.EAST.equals(mower.getOrientation())) {
	    mower.setOrientation(OrientationEnum.NORTH);
	}
    }

    private void rotateMowerToTheRight(Mower mower) {
	if (OrientationEnum.NORTH.equals(mower.getOrientation())) {
	    mower.setOrientation(OrientationEnum.EAST);
	} else if (OrientationEnum.SOUTH.equals(mower.getOrientation())) {
	    mower.setOrientation(OrientationEnum.WEST);
	} else if (OrientationEnum.WEST.equals(mower.getOrientation())) {
	    mower.setOrientation(OrientationEnum.NORTH);
	} else if (OrientationEnum.EAST.equals(mower.getOrientation())) {
	    mower.setOrientation(OrientationEnum.SOUTH);
	}
    }

    private void validateMowerPosition(final Pair<Integer, Integer> upperRightCoordinates, final Mower mower) {
	if (mower.getXPosition() > upperRightCoordinates.getKey() || mower.getYPosition() > upperRightCoordinates.getValue()) {
	    throw new IllegalArgumentException("The mower has to be on the plateau");
	}
    }

    private List<MovementEnum> convertStringToOrientationsList(final String str) {
	return str.chars()//
			.mapToObj(e -> (char) e).map(c -> MovementEnum.getOrientationBy(String.valueOf(c)))//
			.collect(Collectors.toList());

    }

}
