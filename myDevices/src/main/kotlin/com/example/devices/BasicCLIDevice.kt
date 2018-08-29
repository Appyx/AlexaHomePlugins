package com.example.devices

import at.rgstoettner.alexahome.plugin.v2.OnOff

/**
 * These signals are recorded with the project rc-switch: https://github.com/sui77/rc-switch
 */
class BasicCLIDevice(private val internalName: String,
                     private val command: String) : DeviceAdapter(), OnOff {

    override fun turnOn() = command.runCommandAsync()
    override fun turnOff() = command.runCommandAsync()

    override fun getName() = internalName
}