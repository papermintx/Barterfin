package com.rahayu.barterfin.ui.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.rahayu.barterfin.R

@Composable
fun CoilLoader(
    modifier: Modifier = Modifier,
    imageUrl: String,
    placeholder: Painter = painterResource(R.drawable.placeholder_image),
    sizeIndicator: Int = 40,
    loading: Boolean = false,
    error: Painter = painterResource(R.drawable.error),
    onLoadingImage: () -> Unit = { },
    onSuccessImage: () -> Unit = { },
    onErrorImage: () -> Unit = { },
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .transformations(CircleCropTransformation())
                .build(),
            contentDescription = stringResource(R.string.image_product),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit,
            placeholder = placeholder,
            error = error,
            onLoading = {
                onLoadingImage()
            },
            onSuccess = { success ->
                onSuccessImage()
            },
            onError = { error ->
                onErrorImage()
            }
        )

        if (loading) {
            CircularProgressIndicator(modifier = Modifier.size(sizeIndicator.dp))
        }
    }
}

