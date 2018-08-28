package com.example.devices.outlets

import com.example.devices.BasicRFDevice
import at.rgstoettner.alexahome.plugin.v2.V2Device
import at.rgstoettner.alexahome.plugin.v2.V2DeviceProvider


/**
 * These signals are recorded with the project rc-switch: https://github.com/sui77/rc-switch
 */
class PowerOutletProvider : V2DeviceProvider {


    private val definitions = mutableListOf<Triple<String, String, String>>()


    init {
        definitions.add(Triple("Strom", "1119505", "1119508"))
        definitions.add(Triple("Stehlampe", "1118545", "1118548"))
        definitions.add(Triple("LEDs", "1115473", "1115476"))
        definitions.add(Triple("Tischlampe", "1119313", "1119316"))
    }


    override fun getDevices(): MutableList<V2Device> {
        return definitions.map { (name, on, off) ->
            return@map BasicRFDevice(name, on, off)
        }.toMutableList()
    }
}