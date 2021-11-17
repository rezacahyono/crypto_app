package com.rcyono.cryptoapp.domain.navigation.destinantion

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rcyono.cryptoapp.common.Constant.LIST_SCREEN
import com.rcyono.cryptoapp.presentation.coinlist.CoinListScreen


@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToDetailCoin: (coinId: String) -> Unit,
) {
    composable(
        route = LIST_SCREEN
    ) {
        CoinListScreen(navigateToCoinDetail = navigateToDetailCoin)
    }
}