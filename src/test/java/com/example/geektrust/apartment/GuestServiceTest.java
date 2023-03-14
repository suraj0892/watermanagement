package com.example.geektrust.apartment;

import com.example.geektrust.MetaData.MetaData;
import com.example.geektrust.bill.BillSumm;
import com.example.geektrust.exceptions.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GuestServiceTest {

    ByteArrayOutputStream outputStream;

    @BeforeEach
    public void initializeMetaData() {
        MetaData.loadMetaData();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

    }

    @Test
    void ShouldUpdateTankerWaterConsumedForValidInput() {
        BillSumm billSumm = new BillSumm();
        GuestService.determineWaterConsumedInRatio(new String[]{"ADD_GUESTS", "5"}, billSumm);
        billSumm.printBill();
        assertEquals("1500 4000", outputStream.toString().trim());
    }

    @Test
    void ShouldThrowExceptionForInvalidInput() {
        BillSumm billSumm = new BillSumm();
        assertThrows(InvalidInputException.class, () ->  GuestService.determineWaterConsumedInRatio(new String[]{"ADD_GUESTS", null}, billSumm));
        assertThrows(InvalidInputException.class, () ->  GuestService.determineWaterConsumedInRatio(new String[]{"ADD_GUESTS", "A"}, billSumm));

    }
}