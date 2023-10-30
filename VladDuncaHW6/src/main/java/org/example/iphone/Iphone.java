package org.example.iphone;

import org.example.Phone;

public abstract class Iphone extends Phone {
    protected Iphone(){
        super();
    }
    protected Iphone(String color, String material, int batteryLife, String imei){
        super(color,material,batteryLife,imei);
    }
}
