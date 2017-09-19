package com.example.your.plugin;


import at.rgstoettner.alexahome.plugin.v2.DeviceV2Adapter;
import at.rgstoettner.alexahome.plugin.v2.OnOff;

public class SimpleTestDevice extends DeviceV2Adapter implements OnOff {


    public static void main(String[] args) {
        SimpleTestDevice test = new SimpleTestDevice();
        test.turnOn();
        test.turnOff();
    }

    @Override
    public String getName() {
        return "Simple Test Device";
    }

    @Override
    public String getType() {
        return "SWITCH";
    }

    @Override
    public void turnOn() {
        System.out.println(getName() + ": turnOn");
    }

    @Override
    public void turnOff() {
        System.out.println(getName() + ": turnOff");
    }
}
