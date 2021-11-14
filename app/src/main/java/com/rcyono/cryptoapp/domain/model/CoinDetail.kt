package com.rcyono.cryptoapp.domain.model

import com.rcyono.cryptoapp.data.remote.dto.coin.TeamMember
import com.rcyono.cryptoapp.data.remote.dto.tickers.Quotes

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>?,
    val team: List<TeamMember>,
    val quotes: Quotes
)
