package com.rcyono.cryptoapp.domain.navigation

import androidx.navigation.NavController
import com.rcyono.cryptoapp.common.Constant.SPLASH_SCREEN

class Screen(
    navController: NavController
){
    val splash: () -> Unit = {
        navController.navigate(route = "list_screen") {
            popUpTo(SPLASH_SCREEN) { inclusive = true }
        }
    }

    val list: (String) -> Unit = { coinId ->
        navController.navigate("detail/$coinId")
    }

}