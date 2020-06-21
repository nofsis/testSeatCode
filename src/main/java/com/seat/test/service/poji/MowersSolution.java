package com.seat.test.service.poji;

import com.seat.test.entities.Mower;
import javafx.util.Pair;

import java.util.List;

/**
 * Created by abderrahman.boudrai on 21/06/2020
 */
public interface MowersSolution {

    public List<String> getMowersFinalCoordinatesAndHeading(final Pair<Integer, Integer> upperRightCoordinates, final List<Mower> mowers);
}
