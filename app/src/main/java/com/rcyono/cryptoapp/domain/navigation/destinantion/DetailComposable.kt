package com.rcyono.cryptoapp.domain.navigation.destinantion

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rcyono.cryptoapp.common.Constant.DETAIL_SCREEN
import com.rcyono.cryptoapp.presentation.coindetail.CoinDetailScreen


fun NavGraphBuilder.detailComposable() {
    composable(
        route = DETAIL_SCREEN
    ) {
        CoinDetailScreen()
    }
}