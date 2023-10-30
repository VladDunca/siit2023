package org.example.samsung;

import org.example.others.IMEIGenerator;

public class SamsungGalaxy6 extends Samsung{
    public SamsungGalaxy6(){
        super("Black","Metal",12, IMEIGenerator.generate());
    }
    public SamsungGalaxy6(String color, String material){
        super(color,material,12,IMEIGenerator.generate());
    }

    @Override
    public void charge() {
        batteryLife = 12;
    }
}
