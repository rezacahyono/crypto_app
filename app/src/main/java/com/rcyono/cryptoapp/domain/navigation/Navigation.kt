package com.rcyono.cryptoapp.domain.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.rcyono.cryptoapp.common.Constant.LIST_SCREEN
import com.rcyono.cryptoapp.common.Constant.SPLASH_SCREEN
import com.rcyono.cryptoapp.domain.navigation.destinantion.detailComposable
import com.rcyono.cryptoapp.domain.navigation.destinantion.listComposable
import com.rcyono.cryptoapp.domain.navigation.destinantion.splashComposable

@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navController: NavHostController
) {
    val screen = remember(navController) {
        Screen(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN
    ) {
        splashComposable(screen.splash)

        listComposable(screen.list)

        detailComposable()
    }
}