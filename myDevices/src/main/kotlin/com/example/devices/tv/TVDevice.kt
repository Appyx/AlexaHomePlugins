package com.example.devices.tv

import at.rgstoettner.alexahome.plugin.v2.OnOff
import at.rgstoettner.alexahome.plugin.v2.Percentage
import at.rgstoettner.alexahome.plugin.v2.V2DeviceAdapter
import java.io.File


/**
 * These signals are recorded with the kernel module gpio-reflect: https://github.com/Appyx/gpio-reflect
 */
class TVDevice : V2DeviceAdapter(), OnOff, Percentage {

    private val power = "9.60|4.462|0.575|0.539|0.579|0.540|0.584|1.654|0.586|0.534|0.579|0.548|0.573|0.537|0.583|0.540|0.579|0.536|0.586|1.653|0.584|1.654|0.576|0.544|0.583|1.656|0.588|1.654|0.578|1.656|0.584|1.654|0.581|1.658|0.587|0.531|0.581|0.543|0.579|0.536|0.583|1.656|0.584|0.534|0.584|0.535|0.584|0.535|0.578|0.541|0.583|1.660|0.583|1.651|0.585|1.652|0.585|0.535|0.584|1.655|0.584|1.654|0.580|1.658|0.585|1.653|0.586|40.91|9.33|2.225|0.582"
    private val volDown = "9.80|4.467|0.575|0.540|0.583|0.536|0.580|1.659|0.582|0.535|0.583|0.536|0.586|0.533|0.585|0.534|0.581|0.538|0.578|1.661|0.580|1.658|0.590|0.530|0.584|1.655|0.586|1.652|0.586|1.652|0.586|1.652|0.580|1.658|0.589|1.650|0.582|1.656|0.587|0.531|0.580|0.539|0.584|0.535|0.584|0.536|0.586|0.533|0.588|0.531|0.580|0.539|0.586|0.533|0.583|1.656|0.583|1.655|0.587|1.652|0.590|1.649|0.583|1.655|0.584|1.654|0.588|40.87|9.36|2.222|0.581"
    private val volUp = "9.50|4.464|0.580|0.540|0.574|0.545|0.573|1.670|0.569|0.546|0.567|0.551|0.570|0.549|0.571|0.548|0.569|0.550|0.562|1.676|0.575|1.663|0.571|0.548|0.567|1.671|0.573|1.666|0.569|1.669|0.567|1.675|0.560|1.674|0.554|0.566|0.562|1.675|0.565|0.555|0.561|0.558|0.561|0.557|0.561|0.558|0.558|0.561|0.562|0.557|0.558|1.680|0.559|0.561|0.553|1.684|0.557|1.686|0.562|1.671|0.549|1.689|0.555|1.683|0.550|1.688|0.552|40.132|8.974|2.271|0.538"

    private var error = false

    override fun getName() = "Fernseher"
    override fun getDescription() = "gpio-reflect device"

    override fun isError(): Boolean {
        val e = error
        error = false
        return e
    }


    override fun turnOn() {
        File("/dev/gpio-reflect").writeText(power)
    }

    override fun turnOff() {
        File("/dev/gpio-reflect").writeText(power)
    }

    override fun decrementPercentage(delta: Double) {
        object : Thread() {
            override fun run() {
                val range = Math.round(delta)
                for (i in 1..range) {
                    File("/dev/gpio-reflect").writeText(volDown)
                }
            }
        }.start()
    }

    override fun incrementPercentage(delta: Double) {
        object : Thread() {
            override fun run() {
                val range = Math.round(delta)
                for (i in 1..range) {
                    File("/dev/gpio-reflect").writeText(volUp)
                }
            }
        }.start()
    }

    override fun setPercentage(value: Double) {
        error = true
    }
}