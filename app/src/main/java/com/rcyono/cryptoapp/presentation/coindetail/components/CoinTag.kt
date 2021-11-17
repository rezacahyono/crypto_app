package com.rcyono.cryptoapp.presentation.coindetail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rcyono.cryptoapp.presentation.ui.theme.Solidgreen
import com.rcyono.cryptoapp.presentation.ui.theme.Solidred
import com.rcyono.cryptoapp.presentation.ui.theme.Solidyellow

@Composable
fun CoinTag(
    tag: String
) {
    val value = (1..3).random()
    var color = Solidyellow
    when (value) {
        1 -> color = Solidred
        2 -> color = Solidgreen
        3 -> color = Solidyellow
    }
    Box(
        modifier = Modifier
            .border(
                width = 1.5.dp,
                color = color,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(10.dp)
    ) {
        Text(
            text = tag,
            color = color,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle2

        )
    }
}

@Preview
@Composable
fun CoinTagPreview() {
    CoinTag(tag = "Cryptocurrency")
}