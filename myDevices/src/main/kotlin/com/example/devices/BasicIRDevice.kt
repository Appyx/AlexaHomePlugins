package com.example.devices

import at.rgstoettner.alexahome.plugin.v2.OnOff

/**
 * These signals are recorded with the kernel module gpio-reflect: https://github.com/Appyx/gpio-reflect
 */
open class BasicIRDevice(private val internalName: String,
                         private val signal: String) : DeviceAdapter(), OnOff {

    override fun turnOn() = signal.sendIR()
    override fun turnOff() = signal.sendIR()

    override fun getName() = internalName
}