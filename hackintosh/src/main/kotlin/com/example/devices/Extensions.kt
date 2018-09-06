package com.example.devices

import java.util.concurrent.TimeUnit

/**
 * Created by Gstöttner Robert on 29.08.18.
 */
fun String.runCommand(output: Boolean = true) {
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

fun String.log(title: String): String {
    println(title + ": " + this)
    return this
}

fun String.runCommandAsync(output: Boolean = true) {
    object : Thread() {
        override fun run() {
            this@runCommandAsync.runCommand(output)
        }
    }.start()
}