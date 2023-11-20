package org.example.enums;

public enum Metrics {
    MM("mm",1),CM("cm",10),DM("dm",100),M("m",1000),KM("km",1000000);
    private final String name;
    private final int multiplier;
    Metrics(String name,int multiplier){
        this.name = name;
        this.multiplier = multiplier;
    }

    public String getName() {
        return name;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
