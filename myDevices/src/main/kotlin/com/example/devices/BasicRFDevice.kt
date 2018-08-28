package com.example.devices

import at.rgstoettner.alexahome.plugin.v2.OnOff
import at.rgstoettner.alexahome.plugin.v2.V2DeviceAdapter
import java.util.concurrent.TimeUnit


/**
 * These signals are recorded with the project rc-switch: https://github.com/sui77/rc-switch
 */
class BasicRFDevice(private val internalName: String,
                    private val on: String,
                    private val off: String) : V2DeviceAdapter(), OnOff {

    override fun turnOn() {
        "./rf/rfsend $on".runCommand(true)
        println("rfsend $on")
    }

    override fun turnOff() {
        "./rf/rfsend $off".runCommand(true)
        println("rfsend $off")
    }

    override fun getName() = internalName
    override fun getDescription() = "rc-switch device"
    override fun getManufacturer(): String ="Bobs"


    private fun String.runCommand(output: Boolean = true) {
        val parts = this.split("//s".toRegex())
        val builder = ProcessBuilder("/bin/bash", "-c", *parts.toTypedArray())
        builder.redirectErrorStream(true)
        val proc = builder.start()
        proc.waitFor(60, TimeUnit.MINUTES)
        if (output) {
            val text = proc.inputStream.bufferedReader().readText()
            println(text)
        }
    }
}