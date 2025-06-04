package com.rahayu.barterfin.ui.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotificationBadge(
    count: Int,
    modifier: Modifier = Modifier,
    badgeColor: Color = Color(0xFF66BB6A),
    textColor: Color = Color.White
) {
    if (count <= 0) {
        return
    }

    val badgeText = if (count > 99) "99+" else count.toString()

    Box(
        modifier = modifier
            .size(17.dp)
            .background(badgeColor, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = badgeText,
            color = textColor,
            style = MaterialTheme.typography.labelSmall.copy(
                textAlign = TextAlign.Center,
                fontSize = 8.sp
            ),
        )
    }
}