package com.rcyono.cryptoapp.data.remote.dto.coin


import com.google.gson.annotations.SerializedName

data class Parent(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String
)