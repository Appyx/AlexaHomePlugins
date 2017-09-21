package com.example.your.plugin

import at.rgstoettner.alexahome.plugin.v2.OnOff
import at.rgstoettner.alexahome.plugin.v2.V2DeviceAdapter

class ProvidedDevice(val internalName: String) : V2DeviceAdapter(), OnOff {

    override fun turnOn() {
        println("Turn on! ...from provided device: $internalName")
    }

    override fun turnOff() {
        println("Turn off! ...from provided device: $internalName")
    }


    override fun getName(): String {
        return internalName
    }
}