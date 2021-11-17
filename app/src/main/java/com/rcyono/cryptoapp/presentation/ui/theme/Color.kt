package com.rcyono.cryptoapp.presentation.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color



val DarkGray = Color(0xFF1A2126)
val LightGray = Color(0XFFFCFCFC)
val MediumGray = Color(0XFF9C9C9C)

val Solidgreen = Color(0XFF18A558)
val Solidyellow = Color(0XFFFDD819)
val Solidred = Color(0XFFF41F4E)

val Colors.CoinItemBackground: Color
    @Composable
    get() = if (isLight) Color.White else DarkGray

val Colors.textTitleColor: Color
    @Composable
    get() = if (isLight) DarkGray else LightGray
