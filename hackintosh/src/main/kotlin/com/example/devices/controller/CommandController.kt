package com.example.devices.controller

import at.rgstoettner.alexahome.plugin.v2.V2Device
import at.rgstoettner.alexahome.plugin.v2.V2DeviceProvider
import com.example.devices.BasicCLIDevice

/**
 * Created by Gstöttner Robert on 29.08.18.
 */
class CommandController : V2DeviceProvider {

    override fun getDevices(): MutableList<V2Device> {
        return mutableListOf(BasicCLIDevice("Finder", "open -a finder"),
                             BasicCLIDevice("PC", "pmset sleepnow"))
    }
}