package com.example.geektrust.rate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WaterRatesTest {

    @Test
    void ShouldReturnAmountBySlabsProvided() {


        List<Slabs> slabs = new ArrayList<Slabs>(){{ add(new Slabs(0, 500, 2.0));
            add(new Slabs(501, 1500, 3.0));
            add(new Slabs(1501, Integer.MAX_VALUE, 8.0));}};

        WaterRates waterRates = new WaterRates(slabs);

        int amount = (int) waterRates.calculateCost(3000.0);

        assertEquals(13500, amount);

        int newAmount = (int) waterRates.calculateCost(600.0);

        assertEquals(1300, newAmount);

    }
}