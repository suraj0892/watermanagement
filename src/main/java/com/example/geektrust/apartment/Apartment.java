package com.example.geektrust.apartment;

public class Apartment {
    private String apartmentType;
    private Integer maxOccupancy;
    private Integer maxLitresPerPerson = Constants.MAX_LITRES;
    private Integer daysAlloted = Constants.MAX_DAYS;
    private Integer maxLitresAlloted;

    public Apartment(String apartmentType, Integer maxOccupancy) {
        this.apartmentType = apartmentType;
        this.maxOccupancy = maxOccupancy;
        this.maxLitresAlloted = this.maxOccupancy * maxLitresPerPerson * daysAlloted;
    }

    public Integer getMaxLitresAlloted() {
        return maxLitresAlloted;
    }

    public String getApartmentType() {
        return apartmentType;
    }

}
