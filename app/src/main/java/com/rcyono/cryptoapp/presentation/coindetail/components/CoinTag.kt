package com.rcyono.cryptoapp.presentation.coindetail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rcyono.cryptoapp.presentation.ui.theme.ColorPrimary
import com.rcyono.cryptoapp.presentation.ui.theme.red
import com.rcyono.cryptoapp.presentation.ui.theme.yellow

@Composable
fun CoinTag(
    tag: String
) {
    val value = (1..3).random()
    var color: Color = yellow
    when (value) {
        1 -> {
            color = yellow
        }
        2 -> {
            color = red
        }
        3 -> {
            color = ColorPrimary
        }
    }
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = color,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(10.dp)
    ) {
        Text(
            text = tag,
            color = color,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2

        )
    }
}

@Preview
@Composable
fun CoinTagPreview() {
    CoinTag(tag = "Cryptocurrency")
}