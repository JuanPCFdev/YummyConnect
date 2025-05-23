package com.jpdev.yummyconnect.core.utils

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object DateUtils {
    fun Long.toFormattedDate(pattern: String = "yyyy-MM-dd HH:mm"): String {
        val formatter = DateTimeFormatter.ofPattern(pattern)
            .withZone(ZoneId.systemDefault())
        return formatter.format(Instant.ofEpochMilli(this))
    }
}