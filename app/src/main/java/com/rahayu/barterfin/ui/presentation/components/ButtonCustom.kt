package com.rahayu.barterfin.ui.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonCustom(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
    border: BorderStroke? = null,
    color: Color = MaterialTheme.colorScheme.primary,
    content: @Composable () -> Unit = { },
) {
    Button(
        border = border,
        onClick = { onClick() },
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 16.dp),
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = color
        )
    ) {
        content()
    }
}