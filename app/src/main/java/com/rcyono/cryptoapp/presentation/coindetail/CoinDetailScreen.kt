package com.rcyono.cryptoapp.presentation.coindetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.rcyono.cryptoapp.presentation.coindetail.components.CoinTag
import com.rcyono.cryptoapp.presentation.coindetail.components.CoinUsd
import com.rcyono.cryptoapp.presentation.coindetail.components.TeamListItem
import com.rcyono.cryptoapp.presentation.ui.theme.*

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.CoinItemBackground)
    ) {
        state.coinDetail?.let { coin ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(LARGEST_PADDING)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(8f),
                            color = MaterialTheme.colors.textTitleColor
                        )
                        Text(
                            text = if (coin.isActive == true) "active" else "inactive",
                            color = if (coin.isActive == true) Solidgreen else Solidred,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(2f)
                        )
                    }
                    Spacer(modifier = Modifier.height(SPACER_LARGE_PADDING))
                    CoinUsd(usd = coin.quotes.uSD)
                    Spacer(modifier = Modifier.height(SPACER_LARGE_PADDING))
                    Text(
                        text = "Description",
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.textTitleColor
                    )
                    Spacer(modifier = Modifier.height(MEDIUM_PADDING))
                    Text(
                        text = coin.description,
                        style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.textTitleColor
                    )
                    Spacer(modifier = Modifier.height(SPACER_LARGE_PADDING))
                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.textTitleColor
                    )
                    Spacer(modifier = Modifier.height(MEDIUM_PADDING))
                    FlowRow(
                        mainAxisSpacing = LARGE_PADDING,
                        crossAxisSpacing = LARGE_PADDING,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coin.tags?.forEach { tag ->
                            CoinTag(tag = tag)
                        }
                    }
                    Spacer(modifier = Modifier.height(SPACER_LARGE_PADDING))
                    Text(
                        text = "Team members",
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.textTitleColor
                    )
                    Spacer(modifier = Modifier.height(MEDIUM_PADDING))
                }
                items(coin.team) { teamMember ->
                    TeamListItem(
                        teamMember = teamMember,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(TEAM_LIST_PADDING)
                    )
                    Divider()
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = LARGEST_PADDING)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}