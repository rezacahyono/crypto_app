package com.rcyono.cryptoapp.presentation.coinlist

import com.rcyono.cryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coin: List<Coin> = emptyList(),
    val error: String = ""
)
