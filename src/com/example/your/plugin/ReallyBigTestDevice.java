package com.example.your.plugin;

import at.rgstoettner.alexahome.plugin.v2.Lighting;
import at.rgstoettner.alexahome.plugin.v2.LockState;
import at.rgstoettner.alexahome.plugin.v2.OnOff;
import at.rgstoettner.alexahome.plugin.v2.Percentage;
import at.rgstoettner.alexahome.plugin.v2.Temperature;

public class ReallyBigTestDevice implements Lighting, LockState, OnOff, Percentage, Temperature {


    public static void main(String[] args) {
        ReallyBigTestDevice test = new ReallyBigTestDevice();
        Lighting.Color color = new Lighting.Color();
        color.saturation = 0.5;
        color.brightness = 0.5;
        color.hue = 180;
        test.setColor(color);
    }

    @Override
    public String getAlias() {
        return null;
    }

    @Override
    public String getName() {
        return "Really Big Test Device";
    }

    @Override
    public String getType() {
        return "SWITCH";
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
        return null;
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
    public void decrementPercentage(int delta) {

    }

    @Override
    public void incrementPercentage(int delta) {

    }

    @Override
    public void setPercentage(double value) {

    }

    @Override
    public String getLockState() {
        return null;
    }

    @Override
    public String setLockState(String lockState) {
        return null;
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public Reading getTemperatureReading() {
        return null;
    }

    @Override
    public StateInfo setTargetTemperature(float value) {
        return null;
    }

    @Override
    public StateInfo incrementTargetTemperature() {
        return null;
    }

    @Override
    public StateInfo decrementTargetTemperature() {
        return null;
    }
}
