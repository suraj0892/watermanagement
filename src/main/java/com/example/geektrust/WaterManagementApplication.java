package com.example.geektrust;

import com.example.geektrust.rate.WaterRateService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WaterManagementApplication {
    public static void main(String[] args) {

        List<String> inputs = new ArrayList<>();
        try {
            // the file to be opened for reading
//            FileInputStream fis = new FileInputStream(args[0]);
            FileInputStream fis = new FileInputStream("sample_input/input1.txt");

            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
                String inputLine = sc.nextLine();
                if (!inputLine.isEmpty())
                    inputs.add(inputLine);
            }
            sc.close(); // closes the scanner
            WaterRateService.getBill(inputs);
        } catch (IOException e) {
        }

    }
}
