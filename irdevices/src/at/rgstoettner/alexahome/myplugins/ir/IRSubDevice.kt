package at.rgstoettner.alexahome.myplugins.ir


import at.rgstoettner.alexahome.plugin.v2.OnOff
import at.rgstoettner.alexahome.plugin.v2.V2DeviceAdapter
import java.io.File


/**
 * These signals are recorded with the kernel module gpio-reflect: https://github.com/Appyx/gpio-reflect
 */
class IRSubDevice(private val internalName: String,
                  private val signal: String) : V2DeviceAdapter(), OnOff {

    override fun turnOn() = action()

    override fun turnOff() = action()

    private fun action() {
        object : Thread() {
            override fun run() {
                File("/dev/gpio-reflect").writeText(signal)
            }
        }.start()
    }

    override fun getName() = internalName
    override fun getDescription() = "gpio-reflect sub-device"
}