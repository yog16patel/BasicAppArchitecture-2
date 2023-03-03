package com.example.basicapparchitecture.ui.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.basicapparchitecture2.ui.theme.TextMain
import com.example.basicapparchitecture2.ui.theme.TextMuted


@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    title: String,
    textColor: Color = TextMain
) {
    Text(
        text = title,
        color = textColor,
        modifier = modifier,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun GeneralText(
    modifier: Modifier = Modifier,
    title: String,
    textColor: Color = TextMuted
) {
    Text(
        text = title,
        color = textColor,
        modifier = modifier,
        fontSize = 14.sp
    )
}