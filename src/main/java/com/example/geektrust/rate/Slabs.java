package com.example.geektrust.rate;

public class Slabs {
    private Integer min;
    private Integer max;
    private Double rate;

    public Slabs(Integer min, Integer max, Double rate) {
        this.min = min;
        this.max = max;
        this.rate = rate;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }

    public Double getRate() {
        return rate;
    }
}
