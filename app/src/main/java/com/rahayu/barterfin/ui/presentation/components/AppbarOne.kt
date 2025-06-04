package com.rahayu.barterfin.ui.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rahayu.barterfin.R
import com.rahayu.barterfin.ui.theme.BarterfinTheme
import com.rahayu.barterfin.ui.theme.textPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppbarOne(
    modifier: Modifier = Modifier,
    onClickNotification: () -> Unit = {},
    onClickChat: () -> Unit = {},
    onClickProfile: () -> Unit = {},
    title: String,
    imageUrl: String? = null,
    notificationCount: Int = 0,
    chatCount: Int = 0
) {

    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    color = textPrimary
                )
            )
        },
        navigationIcon = {
            ProfilePictureWithEdit(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(52.dp),
                profileImageUrl = imageUrl,
                onClick = onClickProfile,
                withEdit = false
            )
        },
        actions = {

            IconWithNotificationBadge(
                icon = {
                    Icon(
                        imageVector = Icons.Default.ChatBubbleOutline,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                },
                modifier = Modifier
                    .clickable(
                        onClick = onClickChat
                    ),
                notificationCount = notificationCount,
                badgeColor = MaterialTheme.colorScheme.primary,
            )


            Spacer(Modifier.width(20.dp))

            IconWithNotificationBadge(
                icon = {
                    Icon(
                        imageVector = Icons.Default.NotificationsNone,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                },
                modifier = Modifier
                    .clickable(
                        onClick = onClickNotification
                    ),
                notificationCount = chatCount,
                badgeColor = MaterialTheme.colorScheme.primary,
            )

            Spacer(Modifier.width(8.dp))
        }
    )
    
}

@Preview
@Composable
private fun ShowAppbarOne() {
    BarterfinTheme {
        AppbarOne(
            title = stringResource(R.string.app_name),
            imageUrl = null,
            onClickNotification = {},
            onClickChat = {},
            onClickProfile = {},
            notificationCount = 5,
            chatCount = 3
        )
    }
    
}