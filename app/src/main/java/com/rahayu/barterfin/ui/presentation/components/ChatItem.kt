package com.rahayu.barterfin.ui.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rahayu.barterfin.ui.theme.BarterfinTheme
import com.rahayu.barterfin.ui.theme.textPrimary

@Composable
fun ChatItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    imageProfileUrl: String,
    name: String,
    lastChat: String? = null,
    newChatCount: Int? = null,
    timeLastChat: String,
) {
    Row(
        modifier = modifier.
            background(MaterialTheme.colorScheme.background)
            .height(60.dp)
            .padding(4.dp)
    ) {
        ProfilePictureWithEdit(
            modifier = Modifier
                .width(52.dp)
                .height(52.dp)
                .align(Alignment.CenterVertically),
            onClick = onClick,
            withEdit = false,
            profileImageUrl = imageProfileUrl,
        )
        Spacer(Modifier.width(12.dp))
        Column(
            modifier = Modifier.weight(1f)
                .fillMaxHeight(),
            verticalArrangement =Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = textPrimary,
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            if (lastChat != null) {
                Text(
                    text = lastChat,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color(0xFF6B7280)
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            } else {
                Text(
                    text = "No messages yet",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color(0xFF6B7280)
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        Spacer(Modifier.width(12.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.CenterVertically),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = timeLastChat,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = textPrimary,
                    fontWeight = FontWeight.Normal
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            if (newChatCount != null && newChatCount > 0) {
                Box(
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFF10B981))
                ){
                    Text(
                        text = newChatCount.toString(),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.align(Alignment.Center),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            } else {
                Box(
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                        .background(Color(0xFF10B981))
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    Text(
                        text = "0",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.align(Alignment.Center),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowChatItem() {
    BarterfinTheme {
        ChatItem(
            onClick = {},
            imageProfileUrl = "https://example.com/profile.jpg",
            name = "John Doe",
            lastChat = "Perfect, Plaza Indonesia works. How about Saturday at 3 PM?",
            newChatCount = 3,
            timeLastChat = "10:30 AM"
        )
    }

}