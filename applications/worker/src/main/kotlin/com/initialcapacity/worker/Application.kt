package com.initialcapacity.worker

import org.slf4j.LoggerFactory

class Application {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    fun start(): Boolean {
        logger.info("application started.")
        return true
    }
}

fun main() {
    Application().start()
}