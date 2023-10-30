package org.example.samsung;
import org.example.Phone;

public abstract class Samsung extends Phone {
    protected Samsung(){
        super();
    }
    protected Samsung(String color, String material, int batteryLife, String imei){
        super(color,material,batteryLife,imei);
    }
}
