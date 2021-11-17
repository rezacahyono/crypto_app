package com.rcyono.cryptoapp.presentation.coinlist.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.rcyono.cryptoapp.domain.model.Coin
import com.rcyono.cryptoapp.presentation.ui.theme.*

@ExperimentalMaterialApi
@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (String) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.CoinItemBackground,
        shape = RectangleShape,
        elevation = COIN_ITEM_ELEVATION,
        onClick = { onItemClick(coin.id) }

    ) {
        Column(
            modifier = Modifier
                .padding(
                    vertical = LARGEST_PADDING,
                    horizontal = LARGE_PADDING
                )
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(7f),
                    text = "${coin.rank}. ${coin.name} ${coin.symbol}",
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colors.textTitleColor
                )
                Text(
                    modifier = Modifier.weight(2f),
                    text = if (coin.isActive) "active" else "inactive",
                    color = if (coin.isActive) Solidgreen else Solidred,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.subtitle2,
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun CoinListItemPreview() {
    CoinListItem(
        coin = Coin(
            id = "BTC",
            isActive = true,
            name = "Bitcoin",
            rank = 1,
            symbol = "BTC"
        ),
        onItemClick = {}
    )

}
