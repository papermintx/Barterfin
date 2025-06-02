package com.rahayu.barterfin.ui.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rahayu.barterfin.ui.theme.BarterfinTheme
import com.rahayu.barterfin.R

@Composable
fun ProfilePictureWithEdit(
    profileImageUrl: String? = null,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clickable { onClick() }
    ) {
        if (profileImageUrl.isNullOrEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(Color(0xFFE0E0E0)),
            ) {
                Image(
                    painter = painterResource(R.drawable.profile_default),
                    contentDescription = stringResource(R.string.default_profile_picture),
                    contentScale = ContentScale.Fit
                )
            }
        } else {
            Image(
                painter = rememberAsyncImagePainter(model = profileImageUrl),
                contentDescription = stringResource(R.string.profile_picture),
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .border(2.dp, Color.LightGray, CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        IconButton(
            onClick = onClick,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = 5.dp, y = 5.dp)
                .size(36.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .border(2.dp, Color.White, CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.CameraAlt,
                contentDescription = stringResource(R.string.edit_profile_picture),
                modifier = Modifier.size(20.dp),
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfilePictureWithEdit() {
    BarterfinTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ProfilePictureWithEdit(
                onClick = { println("Edit Profile Picture clicked!") }
            )
            Spacer(modifier = Modifier.height(30.dp))
            ProfilePictureWithEdit(
                profileImageUrl = "https://picsum.photos/id/237/200/300", // Ganti dengan URL gambar Anda
                onClick = { println("Edit Profile Picture with image clicked!") }
            )
        }
    }
}