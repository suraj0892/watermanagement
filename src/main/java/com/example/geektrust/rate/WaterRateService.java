package com.example.geektrust.rate;

import com.example.geektrust.MetaData.MetaData;
import com.example.geektrust.apartment.ApartmentService;
import com.example.geektrust.apartment.GuestService;
import com.example.geektrust.bill.BillSumm;
import com.example.geektrust.exceptions.InvalidInputException;
import com.example.geektrust.utils.AppConstants;

import java.util.List;

public class WaterRateService {

    public static void getBill(List<String> inputs) {
        boolean isBillGenerated = false;
        MetaData.loadMetaData();
        BillSumm billSumm = new BillSumm();

        for (String input : inputs) {
            if(isBillGenerated)
                break;
            String[] inputStr = input.split(" ");

            switch (inputStr[0]) {
                case AppConstants.ALLOT_WATER:
                    ApartmentService.determineWaterConsumedInRatio(inputStr, billSumm);
                    break;
                case AppConstants.ADD_GUESTS:
                    GuestService.determineWaterConsumedInRatio(inputStr, billSumm);
                    break;
                case AppConstants.BILL:
                    billSumm.printBill();
                    isBillGenerated = true;
                    break;
                default:
                    throw new InvalidInputException("Invalid Input please provide valid input");
            }

        }


    }

}
