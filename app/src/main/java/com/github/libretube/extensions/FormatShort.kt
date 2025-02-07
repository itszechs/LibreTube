package com.github.libretube.extensions

import java.math.BigDecimal
import java.math.RoundingMode

@Suppress("KotlinConstantConditions")
fun Long?.formatShort(): String = when {
    this == null -> (0).toString()
    this < 1000 -> {
        this.toString()
    }
    this in (1000..999999) -> {
        val decimal = BigDecimal(this / 1000).setScale(0, RoundingMode.HALF_EVEN)
        decimal.toString() + "K"
    }
    this in (1000000..10000000) -> {
        val decimal = BigDecimal(this / 1000000).setScale(0, RoundingMode.HALF_EVEN)
        decimal.toString() + "M"
    }
    else -> {
        val decimal = BigDecimal(this / 1000000).setScale(0, RoundingMode.HALF_EVEN)
        decimal.toString() + "M"
    }
}
