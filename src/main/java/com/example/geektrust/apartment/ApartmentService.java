package com.example.geektrust.apartment;

import com.example.geektrust.MetaData.MetaData;
import com.example.geektrust.bill.BillSumm;
import com.example.geektrust.exceptions.ApartmentNotFoundException;
import com.example.geektrust.exceptions.InvalidInputException;

public class ApartmentService {

    public static void determineWaterConsumedInRatio(String[] apartmentInput, BillSumm billSummary) {

        String apartmentType = getApartmentType(apartmentInput);
        String[] waterRatio = getWaterRatioFrom(apartmentInput);
        int corporationWaterRatio = getWaterRatioFrom(waterRatio[0]);
        int borewellWaterRatio = getWaterRatioFrom(waterRatio[1]);
        int totalParts = corporationWaterRatio + borewellWaterRatio;

        Apartment apartment = MetaData.getByApartment(apartmentType);
        if (null == apartment)
            throw new ApartmentNotFoundException("Apartment Not Found of type" + apartmentType + " bhk");

        billSummary.setBorewellWaterConsumed((apartment.getMaxLitresAlloted() * borewellWaterRatio) / totalParts);
        billSummary.setCorportationWaterConsumed((apartment.getMaxLitresAlloted() * corporationWaterRatio) / totalParts);
    }

    private static int getWaterRatioFrom(String waterDistribution) {
        try {
            return Integer.parseInt(waterDistribution);
        } catch (NumberFormatException ex) {
            throw new InvalidInputException("Water distribution ratio cannot be " + waterDistribution + " please specify as " + "ALLOT_WATER <apartment_type> <coportationWater>:<borewellWater>");

        }
    }

    private static String[] getWaterRatioFrom(String[] apartmentInput) {
        if (null == apartmentInput[2] || apartmentInput[2].split(":").length != 2)
            throw new InvalidInputException("Water distribution input format is invalid please define as " +
                    "ALLOT_WATER <apartment_type> <coportationWater>:<borewellWater>");
        return apartmentInput[2].split(":");
    }

    private static String getApartmentType(String[] apartmentInput) {
        if (null == apartmentInput[1])
            throw new InvalidInputException("Apartment cannot be null please define input as " +
                    "ALLOT_WATER <apartment_type> <coportationWater>:<borewellWater>");
        return apartmentInput[1];
    }


}
