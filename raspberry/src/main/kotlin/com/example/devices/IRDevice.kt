package com.example.devices

import at.rgstoettner.alexahome.plugin.v2.OnOff

/**
 * These signals are recorded with the kernel module gpio-reflect: https://github.com/Appyx/gpio-reflect
 */
class IRDevice(private val internalName: String,
               private val on: String,
               private val off: String) : DeviceAdapter(), OnOff {

    override fun turnOn() = on.sendIR()
    override fun turnOff() = off.sendIR()

    override fun getName() = internalName
}