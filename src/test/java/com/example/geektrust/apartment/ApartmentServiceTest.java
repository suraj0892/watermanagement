package com.example.geektrust.apartment;

import com.example.geektrust.MetaData.MetaData;
import com.example.geektrust.bill.BillSumm;
import com.example.geektrust.exceptions.ApartmentNotFoundException;
import com.example.geektrust.exceptions.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentServiceTest {
    ByteArrayOutputStream outputStream;

    @BeforeEach
    public void initializeMetaData() {
        MetaData.loadMetaData();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

    }

    @Test
    void ShouldUpdateCorportationAndBorewellWaterConsumedForValidInput() {
        BillSumm billSumm = new BillSumm();
        ApartmentService.determineWaterConsumedInRatio(new String[]{"ALLOT_WATER", "2", "3:7"}, billSumm);
        billSumm.printBill();
        assertEquals("900 1215", outputStream.toString().trim());
    }

    @Test
    void ShouldThrowApartmentNotFoundException() {
        assertThrows(ApartmentNotFoundException.class, () -> {
            ApartmentService.determineWaterConsumedInRatio(new String[]{"ALLOT_WATER", "5", "3:7"}, new BillSumm());
        });
    }

    @Test
    void shouldThrowInvalidInputExcpetionIfInputFormatisInvalid() {
        assertThrows(InvalidInputException.class, () -> {
            ApartmentService.determineWaterConsumedInRatio(new String[]{"ALLOT_WATER", null, "3:7"}, new BillSumm());
        });
        assertThrows(InvalidInputException.class, () -> {
            ApartmentService.determineWaterConsumedInRatio(new String[]{"ALLOT_WATER", "2", "A:B"}, new BillSumm());
        });
        assertThrows(InvalidInputException.class, () -> {
            ApartmentService.determineWaterConsumedInRatio(new String[]{ "ALLOT_WATER", "5", "3:"}, new BillSumm());
        });
    }
}