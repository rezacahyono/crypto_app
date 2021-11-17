package com.rcyono.cryptoapp.domain.navigation

import androidx.navigation.NavController

class Screen(
    navController: NavController
){
    val list: (String) -> Unit = { coinId ->
        navController.navigate("detail/$coinId")
    }

//    val detail: () -> Unit = {
//        navController.navigate("detail/$coinId")
//    }
}