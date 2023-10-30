package org.example.iphone;

import org.example.others.IMEIGenerator;

public class Iphone15 extends Iphone{
    public Iphone15(){
        super("White","Bioplastics",10, IMEIGenerator.generate());
    }
    public Iphone15(String color,String material){
        super(color,material,10,IMEIGenerator.generate());
    }

    @Override
    public void charge() {
        batteryLife = 10;
    }
}
