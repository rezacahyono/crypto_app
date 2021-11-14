package com.rcyono.cryptoapp.data.repository

import com.rcyono.cryptoapp.data.remote.api.CoinPaprikaApi
import com.rcyono.cryptoapp.data.remote.dto.coin.CoinDetailDto
import com.rcyono.cryptoapp.data.remote.dto.coin.CoinDto
import com.rcyono.cryptoapp.data.remote.dto.tickers.CoinTickersDto
import com.rcyono.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoin(): List<CoinDto> {
        return api.getCoin()
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetailDto {
        return api.getCoinDetail(coinId = coinId)
    }

    override suspend fun getCoinTickers(coinId: String): CoinTickersDto {
        return api.getCoinTickers(coinId = coinId)
    }
}