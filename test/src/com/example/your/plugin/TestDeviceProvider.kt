package com.example.your.plugin

import at.rgstoettner.alexahome.plugin.v2.V2Device
import at.rgstoettner.alexahome.plugin.v2.V2DeviceProvider

/**
 * This class is written in Kotlin.
 * So you can write Devices in Java or/and Kotlin.
 *
 * It extends the DeviceProvider class which is very useful.
 * You can load multiple devices at runtime.
 * This is important when the number of devices is depending on something and you don't want to create a class for each device.
 *
 *
 * For example: You want to create a device which configures ir devices depending on a configuration file.
 * You could read a file and create a new device for each line in the file.
 * All these devices could share the same class blueprint.
 *
 */
class TestDeviceProvider : V2DeviceProvider {



    override fun getDevices(): MutableList<V2Device> {
        val device1 = ProvidedDevice("device1")
        val device2 = ProvidedDevice("device2")
        return mutableListOf(device1, device2)
    }


}