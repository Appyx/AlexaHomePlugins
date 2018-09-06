package com.example.devices.controller

import at.rgstoettner.alexahome.plugin.v2.V2Device
import at.rgstoettner.alexahome.plugin.v2.V2DeviceProvider
import com.example.devices.RFDevice

/**
 * These signals are recorded with the project rc-switch: https://github.com/sui77/rc-switch
 */
class OutletController : V2DeviceProvider {

    private val devices = mutableListOf<V2Device>()

    init {
        devices.add(RFDevice("Strom", "1119505", "1119508"))
        devices.add(RFDevice("Stehlampe", "1118545", "1118548"))
        devices.add(RFDevice("LEDs", "1115473", "1115476"))
        devices.add(RFDevice("Tischlampe", "1119313", "1119316"))
    }

    override fun getDevices(): MutableList<V2Device> {
        return devices
    }
}