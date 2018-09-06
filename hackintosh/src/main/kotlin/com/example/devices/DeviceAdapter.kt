package com.example.devices

import at.rgstoettner.alexahome.plugin.v2.V2DeviceAdapter

/**
 * Created by Gstöttner Robert on 29.08.18.
 */
abstract class DeviceAdapter : V2DeviceAdapter() {
    override fun getManufacturer() = "Bob's IT Factory"
    override fun getModel() = "Model of the Year"
    override fun getSoftwareVersion() = "2.0"
    override fun getDescription() = "A generic device created by AlexaHome"
}