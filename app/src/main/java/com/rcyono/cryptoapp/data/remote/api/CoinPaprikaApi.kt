package com.rcyono.cryptoapp.data.remote.api

import com.rcyono.cryptoapp.data.remote.dto.coin.CoinDetailDto
import com.rcyono.cryptoapp.data.remote.dto.coin.CoinDto
import com.rcyono.cryptoapp.data.remote.dto.tickers.CoinTickersDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("v1/coins")
    suspend fun getCoin(): List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinDetail(
        @Path("coinId") coinId: String
    ): CoinDetailDto

    @GET("v1/tickers/{coinId}")
    suspend fun getCoinTickers(
        @Path("coinId") coinId: String
    ): CoinTickersDto
}