package org.example.iphone;

import org.example.others.IMEIGenerator;

public class Iphone14 extends Iphone{
    public Iphone14(){
        super("White","Composite Materials",9, IMEIGenerator.generate());
    }
    public Iphone14(String color, String material){
        super(color,material,9,IMEIGenerator.generate());
    }

    @Override
    public void charge() {
        batteryLife = 9;
    }
}
