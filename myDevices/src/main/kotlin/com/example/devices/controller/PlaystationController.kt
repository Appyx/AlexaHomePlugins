package com.example.devices.controller

import at.rgstoettner.alexahome.plugin.v2.V2Device
import at.rgstoettner.alexahome.plugin.v2.V2DeviceProvider
import com.example.devices.BasicCLIDevice
import com.example.devices.CLIDevice

/**
 * Created by Gstöttner Robert on 29.08.18.
 */
class PlaystationController : V2DeviceProvider {

    override fun getDevices(): MutableList<V2Device> {
        return mutableListOf(BasicCLIDevice("Plex", "/opt/nodejs/bin/ps4-waker start CUSA01703"),
                             BasicCLIDevice("Netflix", "/opt/nodejs/bin/ps4-waker start CUSA00127"),
                             CLIDevice("PS4", "/opt/nodejs/bin/ps4-waker", "/opt/nodejs/bin/ps4-waker standby"))
    }
}