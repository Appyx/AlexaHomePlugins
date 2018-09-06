package com.example.devices

import at.rgstoettner.alexahome.plugin.v2.OnOff

/**
 * These signals are recorded with the project rc-switch: https://github.com/sui77/rc-switch
 */
class RFDevice(private val internalName: String,
               private val on: String,
               private val off: String) : DeviceAdapter(), OnOff {

    override fun turnOn() = on.sendRF()
    override fun turnOff() = off.sendRF()

    override fun getName() = internalName
}