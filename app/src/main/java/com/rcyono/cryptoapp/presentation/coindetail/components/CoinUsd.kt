package com.rcyono.cryptoapp.presentation.coindetail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rcyono.cryptoapp.R
import com.rcyono.cryptoapp.data.remote.dto.tickers.USD
import com.rcyono.cryptoapp.presentation.ui.theme.*

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
                    text = stringResource(R.string.one_hour),
                    style = Typography.body1,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = "${usd.percentChange1h} %",
                    style = Typography.subtitle2,
                    fontWeight = FontWeight.Bold,
                    color = if (usd.percentChange1h > 0.0) Solidgreen else Solidred
                )
            }
            Column(
                modifier = Modifier
                    .weight(3f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.one_day),
                    style = Typography.body1,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = "${usd.percentChange24h} %",
                    style = Typography.subtitle2,
                    fontWeight = FontWeight.Bold,
                    color = if (usd.percentChange24h > 0.0) Solidgreen else Solidred
                )
            }
            Column(
                modifier = Modifier
                    .weight(3f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.one_week),
                    style = Typography.body1,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = "${usd.percentChange7d} %",
                    style = Typography.subtitle2,
                    fontWeight = FontWeight.Bold,
                    color = if (usd.percentChange7d > 0.0) Solidgreen else Solidred
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MEDIUM_PADDING),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.price),
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
                .padding(top = MEDIUM_PADDING),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.marcet_cap),
                style = Typography.subtitle2,
                color = MaterialTheme.colors.onSurface
            )
            Text(
                textAlign = TextAlign.End,
                text = "$ ${usd.marketCap}",
                style = Typography.subtitle2,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )
        }

    }
}
