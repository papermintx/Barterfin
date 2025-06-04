package com.rahayu.barterfin.ui.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun IconWithNotificationBadge(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
    notificationCount: Int,
    badgeColor: Color
) {
    Box(modifier = modifier) {
        icon()
        if (notificationCount > 0) {
            NotificationBadge(
                count = notificationCount,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(
                        x = 8.dp,
                        y = (-6).dp
                    ),
                badgeColor = badgeColor
            )
        }
    }
}
