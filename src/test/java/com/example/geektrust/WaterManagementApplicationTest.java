package com.example.geektrust;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class WaterManagementApplicationTest {

    @Test
    void GeneratBillForSampleInputFile() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        WaterManagementApplication.main(new String[]{"sample_input/input1.txt"});
        assertEquals("2400 5215", outputStream.toString().trim());

    }
}