package com.erdemyesilcicek.greenflowers.data

import androidx.compose.ui.graphics.vector.ImageVector

data class Currency(
    val name: String,
    val buy: Float,
    val sell: Float,
    val icon: ImageVector
)
