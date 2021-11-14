package com.rcyono.cryptoapp.presentation.coindetail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rcyono.cryptoapp.data.remote.dto.tickers.USD
import com.rcyono.cryptoapp.presentation.ui.theme.Typography
import com.rcyono.cryptoapp.presentation.ui.theme.ColorPrimary
import com.rcyono.cryptoapp.presentation.ui.theme.red

@Composable
fun CoinUsd(
    usd: USD
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row {
            Column(
                modifier = Modifier
                    .weight(3f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "1H",
                    style = Typography.body2,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = "${usd.percentChange1h} %",
                    style = Typography.body1,
                    fontWeight = FontWeight.Bold,
                    color = if (usd.percentChange1h > 0.0) ColorPrimary else red
                )
            }
            Column(
                modifier = Modifier
                    .weight(3f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "24H",
                    style = Typography.body2,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = "${usd.percentChange24h} %",
                    style = Typography.body1,
                    fontWeight = FontWeight.Bold,
                    color = if (usd.percentChange24h > 0.0) ColorPrimary else red
                )
            }
            Column(
                modifier = Modifier
                    .weight(3f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "7D",
                    style = Typography.body2,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = "${usd.percentChange7d} %",
                    style = Typography.body1,
                    fontWeight = FontWeight.Bold,
                    color = if (usd.percentChange7d > 0.0) ColorPrimary else red
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Price",
                style = Typography.body2,
                color = MaterialTheme.colors.onSurface
            )
            Text(
                textAlign = TextAlign.End,
                text = "$ ${usd.price}",
                style = Typography.body1,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Marcet cap",
                style = Typography.body1,
                color = MaterialTheme.colors.onSurface
            )
            Text(
                textAlign = TextAlign.End,
                text = "$ ${usd.marketCap}",
                style = Typography.body1,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )
        }

    }
}
