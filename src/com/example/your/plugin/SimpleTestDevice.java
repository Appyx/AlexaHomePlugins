package com.example.your.plugin;


import at.rgstoettner.alexahome.plugin.v2.DeviceV2Adapter;
import at.rgstoettner.alexahome.plugin.v2.OnOff;


/**
 * This is a simple test device for a quick start.<br>
 * It extends from the DeviceV2Adapter because we don't want to implement all methods.<br>
 * So the adapter takes care of the unimportant implementation.<br>
 * <p>
 * The fully qualified name is registered in the file META-INF/services/at.rgstoettner.alexahome.plugin.v2.DeviceV2
 */
public class SimpleTestDevice extends DeviceV2Adapter implements OnOff {


    public static void main(String[] args) {
        SimpleTestDevice test = new SimpleTestDevice();
        test.turnOn();
        test.turnOff();
    }

    @Override
    public String getName() {
        return "Lampe";
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
