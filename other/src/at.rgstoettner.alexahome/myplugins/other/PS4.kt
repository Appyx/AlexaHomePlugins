package at.rgstoettner.alexahome.myplugins.other

import at.rgstoettner.alexahome.plugin.v2.V2Device
import at.rgstoettner.alexahome.plugin.v2.V2DeviceProvider

class PS4 : V2DeviceProvider {

    override fun getDevices(): MutableList<V2Device> {
        val devices = mutableListOf<V2Device>()
        return devices
    }
}