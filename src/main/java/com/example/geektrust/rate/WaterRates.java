package com.example.geektrust.rate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WaterRates {

    private final List<Slabs> slabs;

    public WaterRates(List<Slabs> slabs) {
        this.slabs = slabs.stream().sorted(Comparator.comparingInt(Slabs::getMin)).collect(Collectors.toList());
    }

    public double calculateCost(Double waterConsumedInLitres) {
        double cost = 0.0;

        for(Slabs slab : this.slabs) {
            if(waterConsumedInLitres <=0){
                break;
            }

            double waterConsumedInLitresOnSlab = Math.min(waterConsumedInLitres, slab.getMax());
            cost += waterConsumedInLitresOnSlab * slab.getRate();
            waterConsumedInLitres -= waterConsumedInLitresOnSlab;
        }
        return cost;
    }
}
