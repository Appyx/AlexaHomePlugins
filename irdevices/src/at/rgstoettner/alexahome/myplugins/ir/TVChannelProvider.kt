package at.rgstoettner.alexahome.myplugins.ir

import at.rgstoettner.alexahome.plugin.v2.V2Device
import at.rgstoettner.alexahome.plugin.v2.V2DeviceProvider


/**
 * These signals are recorded with the kernel module gpio-reflect: https://github.com/Appyx/gpio-reflect
 */
class TVChannelProvider : V2DeviceProvider {


    private val channels = mutableListOf<Pair<String, String>>()


    init {
        //channels.add(Pair("ORF Eins", "9.56|4.463|0.583|0.536|0.582|0.538|0.578|1.660|0.579|0.539|0.582|0.538|0.578|0.541|0.584|0.539|0.577|0.537|0.587|1.651|0.583|1.655|0.582|0.538|0.583|1.654|0.590|1.652|0.581|1.653|0.584|1.660|0.580|1.652|0.585|1.653|0.583|0.535|0.585|0.534|0.582|0.537|0.585|1.652|0.579|0.539|0.582|0.537|0.583|0.535|0.585|0.539|0.579|1.654|0.586|1.652|0.580|1.657|0.586|0.533|0.581|1.662|0.577|1.656|0.589|1.649|0.584|40.92|9.35|2.220|0.578|455.112|9.64|4.456|0.579|0.540|0.577|0.542|0.578|1.664|0.578|0.537|0.583|0.536|0.582|0.536|0.581|0.538|0.585|0.534|0.585|1.653|0.585|1.653|0.582|0.538|0.580|1.660|0.583|1.654|0.587|1.652|0.588|1.655|0.581|1.653|0.586|0.532|0.580|0.539|0.588|1.652|0.578|0.540|0.580|0.539|0.591|0.527|0.581|1.656|0.583|0.536|0.580|1.658|0.584|1.654|0.584|0.534|0.582|1.656|0.579|1.658|0.585|1.654|0.585|0.534|0.582|1.656|0.587|40.86|9.30|2.224|0.578|96.38|9.36|2.225|0.582"))
    }

    override fun getDevices(): MutableList<V2Device> {
        return channels.map { (name, signal) ->
            return@map IRSubDevice(name, signal)
        }.toMutableList()
    }
}