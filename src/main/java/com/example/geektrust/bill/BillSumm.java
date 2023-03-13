package com.example.geektrust.bill;

import com.example.geektrust.MetaData.MetaData;

public class BillSumm {

    private int borewellWaterConsumed;
    private int corportationWaterConsumed;
    private int tankerWaterConsumed;

    public BillSumm() {
        this.tankerWaterConsumed = 0;
        this.corportationWaterConsumed = 0;
        this.borewellWaterConsumed = 0;
    }

    public void setBorewellWaterConsumed(int borewellWaterConsumed) {
        this.borewellWaterConsumed = borewellWaterConsumed;
    }

    public void setCorportationWaterConsumed(int corportationWaterConsumed) {
        this.corportationWaterConsumed = corportationWaterConsumed;
    }

    private void setTankerWaterConsumed(int tankerWaterConsumed) {
        this.tankerWaterConsumed += tankerWaterConsumed;
    }

    public void addGuestWaterConsumed(int numberOfGuests) {
        int waterConsumed = numberOfGuests * 10 * 30;
        setTankerWaterConsumed(waterConsumed);
    }

    public void printBill() {
        int totalWaterConsumed = borewellWaterConsumed + corportationWaterConsumed + tankerWaterConsumed;
        double corporationWaterRate = MetaData.getCorportationWaterRate().calculateCost((double) corportationWaterConsumed);
        double borewellWaterRate = MetaData.getBorewellWaterRate().calculateCost((double) borewellWaterConsumed);
        double tankerWaterRate = MetaData.getTankerWaterRate().calculateCost((double) tankerWaterConsumed);
        int totalAmount = (int) (corporationWaterRate + borewellWaterRate + tankerWaterRate);
        System.out.println(totalWaterConsumed + " " + totalAmount);
    }
}
