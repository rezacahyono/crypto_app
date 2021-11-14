package com.rcyono.cryptoapp.domain.repository

import com.rcyono.cryptoapp.data.remote.dto.coin.CoinDetailDto
import com.rcyono.cryptoapp.data.remote.dto.coin.CoinDto
import com.rcyono.cryptoapp.data.remote.dto.tickers.CoinTickersDto

interface CoinRepository {
    suspend fun getCoin(): List<CoinDto>

    suspend fun getCoinDetail(coinId: String): CoinDetailDto

    suspend fun getCoinTickers(coinId: String): CoinTickersDto
}