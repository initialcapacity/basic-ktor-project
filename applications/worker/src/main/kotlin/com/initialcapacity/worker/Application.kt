package com.initialcapacity.worker

import org.slf4j.LoggerFactory

class Application(databaseUrl: String) {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    fun start(): Boolean {
        logger.info("application started.")
        return true
    }
}

fun requiredEnvironmentVariable(value: String): String {
    return System.getenv().get(value) ?: throw RuntimeException("missing configuration: $value")
}

fun main(args: Array<String>) {
    val databaseUrl = requiredEnvironmentVariable("DATABASE_URL")
    Application(databaseUrl).start()
}
