package com.example.your.plugin;

import at.rgstoettner.alexahome.plugin.v2.Lighting;
import at.rgstoettner.alexahome.plugin.v2.LockState;
import at.rgstoettner.alexahome.plugin.v2.OnOff;
import at.rgstoettner.alexahome.plugin.v2.Percentage;
import at.rgstoettner.alexahome.plugin.v2.Temperature;


/**
 * This class implements all interfaces. So it is the most powerful device.<br>
 * The fully qualified name is registered in the file META-INF/services/at.rgstoettner.alexahome.plugin.v2.DeviceV2
 */
public class ReallyBigTestDevice implements Lighting, LockState, OnOff, Percentage, Temperature {

    //You can add as many fields as you want.
    private Lighting.Color mColor = new Color();

    public ReallyBigTestDevice() {
        //The constructor is called when the plugin is loaded.
        //The plugin is also loaded at each discovery process.
        //So the constructor is the right place to initialize the device.
        mColor.saturation = 0.5;
        mColor.brightness = 0.5;
        mColor.hue = 180;
    }

    //You can also add as many methods as you want
    public static void main(String[] args) {
        //You could use this method to test your plugin without compiling a jar.
        //For example:
        //ReallyBigTestDevice test = new ReallyBigTestDevice();
        //test.setColorTemperature(1000)
    }

    @Override
    public String getName() {
        return "Computer";
    }

    @Override
    public boolean isScene() {
        return true;
    }

    @Override
    public boolean isError() {
        return false;
    }

    @Override
    public String getDescription() {
        return "Nice Description";
    }

    @Override
    public String getManufacturer() {
        return "Any Manufacturer";
    }

    @Override
    public String getModel() {
        return "Simulated Model";
    }

    @Override
    public String getSoftwareVersion() {
        return "v1.0";
    }

    @Override
    public Color setColor(Color color) {
        return mColor;
    }

    @Override
    public int setColorTemperature(int value) {
        return 0;
    }

    @Override
    public int decrementColorTemperature() {
        return 0;
    }

    @Override
    public int incrementColorTemperature() {
        return 0;
    }

    @Override
    public void decrementPercentage(double delta) {

    }

    @Override
    public void incrementPercentage(double delta) {

    }

    @Override
    public void setPercentage(double value) {

    }

    @Override
    public LockState.Value getLockState() {
        return LockState.Value.LOCKED;
    }

    @Override
    public LockState.Value setLockState(LockState.Value lockState) {
        return LockState.Value.UNLOCKED;
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public StateInfo setTargetTemperature(float value) {
        //This setup is necessary for Alexa to know what's going on.
        //It is already a simplified version of the AmazonApi
        StateInfo info = new StateInfo();
        info.actual = new StateInfo.State();
        info.previous = new StateInfo.State();
        info.actual.temp = value;
        info.actual.mode = StateInfo.Mode.AUTO;
        info.previous.temp = value - 10;
        info.previous.mode = StateInfo.Mode.AUTO;
        return info;
    }

    @Override
    public StateInfo incrementTargetTemperature(float delta) {
        StateInfo info = new StateInfo();
        info.actual = new StateInfo.State();
        info.previous = new StateInfo.State();
        info.previous.temp = info.actual.temp;
        info.previous.mode = info.actual.mode;
        info.actual.temp = 20.0f;
        info.actual.mode = StateInfo.Mode.AUTO;
        return info;
    }

    @Override
    public StateInfo decrementTargetTemperature(float delta) {
        StateInfo info = new StateInfo();
        info.actual = new StateInfo.State();
        info.previous = new StateInfo.State();
        info.previous.temp = info.actual.temp;
        info.previous.mode = info.actual.mode;
        info.actual.temp = 20.0f;
        info.actual.mode = StateInfo.Mode.AUTO;
        return info;
    }
}
