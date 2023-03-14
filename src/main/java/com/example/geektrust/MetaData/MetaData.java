package com.example.geektrust.MetaData;

import com.example.geektrust.apartment.Apartment;
import com.example.geektrust.rate.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MetaData {

    private static List<Apartment> apartments;
    private static WaterRates borewellWaterRate;
    private static WaterRates corportationWaterRate;
    private static WaterRates tankerWaterRate;


    public static void loadMetaData() {
        setApartments();
        setBorewellWaterRate();
        setTankerWaterRate();
        setCorporationWaterRate();
    }

    private static void setApartments() {
        apartments = new ArrayList<>();
        apartments.add(new Apartment("2", 3));
        apartments.add(new Apartment("3", 5));
    }

    private static void setTankerWaterRate() {
        List<Slabs> slabs = new ArrayList<>();
        slabs.add(new Slabs(0, 500, 2.0));
        slabs.add(new Slabs(501, 1500, 3.0));
        slabs.add(new Slabs(1501, 3000, 5.0));
        slabs.add(new Slabs(3001, Integer.MAX_VALUE, 8.0));
        tankerWaterRate = new WaterRates(slabs);
    }

    private static void setBorewellWaterRate() {
        List<Slabs> slabs = new ArrayList<>();
        slabs.add(new Slabs(0, Integer.MAX_VALUE, 1.5));
        borewellWaterRate = new WaterRates(slabs);
    }

    private static void setCorporationWaterRate() {
        List<Slabs> slabs = new ArrayList<>();
        slabs.add(new Slabs(0, Integer.MAX_VALUE, 1.0));
        corportationWaterRate = new WaterRates(slabs);
    }

    public static WaterRates getBorewellWaterRate() {
        return borewellWaterRate;
    }

    public static WaterRates getCorportationWaterRate() {
        return corportationWaterRate;
    }

    public static WaterRates getTankerWaterRate() {
        return tankerWaterRate;
    }

    public static Apartment getByApartment(String type) {
        Optional<Apartment> apartment = apartments.stream().filter(entry -> entry.getApartmentType().equalsIgnoreCase(type)).findFirst();
        return apartment.orElse(null);
    }
}
