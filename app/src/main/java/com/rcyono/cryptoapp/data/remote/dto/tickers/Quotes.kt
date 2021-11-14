package com.rcyono.cryptoapp.data.remote.dto.tickers


import com.google.gson.annotations.SerializedName

data class Quotes(
    @SerializedName("USD")
    val uSD: USD
)