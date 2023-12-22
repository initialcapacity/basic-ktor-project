package com.initialcapacity.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource

fun dataSource(url: String): DataSource {
    return HikariDataSource(HikariConfig().apply {
        jdbcUrl = url
        validate()
    })
}
