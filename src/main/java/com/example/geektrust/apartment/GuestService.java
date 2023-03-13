package com.example.geektrust.apartment;

import com.example.geektrust.bill.BillSumm;
import com.example.geektrust.exceptions.InvalidInputException;

public class GuestService {

    public static void determineWaterConsumedInRatio(String[] guestInput, BillSumm billSummary) {
        billSummary.addGuestWaterConsumed(getNumberOfGuests(guestInput));
    }

    private static int getNumberOfGuests(String[] guestInput) {

        if (null == guestInput[1])
            throw new InvalidInputException("Number of Guests cannot be null please specify as " + "GUESTS <number_of_addtional_guests>");

        try {
            return Integer.parseInt(guestInput[1]);
        } catch (NumberFormatException ex) {
            throw new InvalidInputException("Number of Guests cannot be "+ guestInput[1] +" please specify as " + "GUESTS <number_of_addtional_guests>");
        }
    }
}
