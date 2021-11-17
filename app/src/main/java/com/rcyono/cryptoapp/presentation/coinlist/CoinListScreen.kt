package com.rcyono.cryptoapp.presentation.coinlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rcyono.cryptoapp.presentation.coinlist.components.CoinListItem
import com.rcyono.cryptoapp.presentation.ui.theme.CoinItemBackground
import com.rcyono.cryptoapp.presentation.ui.theme.Solidgreen

@ExperimentalMaterialApi
@Composable
fun CoinListScreen(
    navigateToCoinDetail: (coinId: String) -> Unit,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.CoinItemBackground)
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.coin) { coin ->
                CoinListItem(
                    coin = coin,
                    onItemClick = {
                        navigateToCoinDetail(coin.id)
                    })
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}