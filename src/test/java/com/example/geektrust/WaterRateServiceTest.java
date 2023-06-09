package com.example.geektrust;

import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.rate.WaterRateService;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WaterRateServiceTest {

    @Test
    void ShouldReturnAmountAndWaterConsumedWhenInputIsValid() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<String> input = new ArrayList<>();
        input.add("ALLOT_WATER 3 2:1");
        input.add("ADD_GUESTS 4");
        input.add("ADD_GUESTS 1");
        input.add("BILL");
        WaterRateService.getBill(input);
        assertEquals("3000 5750", outputStream.toString().trim());
    }

    @Test
    void ShouldExitAndPrintBillWhenBILLInputIsFound() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<String> input = new ArrayList<>();
        input.add("ALLOT_WATER 3 2:1");
        input.add("ADD_GUESTS 4");
        input.add("ADD_GUESTS 1");
        input.add("BILL");
        input.add("RANDOM STRING");
        WaterRateService.getBill(input);
        assertEquals("3000 5750", outputStream.toString().trim());
    }

    @Test
    void ShouldThrowInvalidInputExceptionWhenINputIsCorrupted() {

        List<String> input = new ArrayList<>();
        input.add("NOBODY 3 2:1");
        input.add("ADD_GUESTS 4");
        input.add("ADD_GUESTS 1");
        input.add("BILL");
        input.add("RANDOM STRING");
        assertThrows(InvalidInputException.class, () -> WaterRateService.getBill(input));
    }
}