package org.example.samsung;

import org.example.others.IMEIGenerator;

public class SamsungA70 extends Samsung{
    public SamsungA70() {
        super("Black","Plastic",10, IMEIGenerator.generate());
    }

    public SamsungA70(String color, String material) {
        super(color, material, 10, IMEIGenerator.generate());
    }

    @Override
    public void charge() {
        batteryLife = 10;
    }
}
