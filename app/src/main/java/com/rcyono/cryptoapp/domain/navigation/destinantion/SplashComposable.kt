package com.rcyono.cryptoapp.domain.navigation.destinantion

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rcyono.cryptoapp.common.Constant.SPLASH_SCREEN
import com.rcyono.cryptoapp.presentation.splash.SplashScreen

fun NavGraphBuilder.splashComposable(
    navigateToListCoin: () -> Unit
){
    composable(
        route = SPLASH_SCREEN
    ) {
        SplashScreen(navigateToListCoin = navigateToListCoin)
    }

}