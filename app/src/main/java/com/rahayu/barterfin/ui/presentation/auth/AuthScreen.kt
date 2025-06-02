package com.rahayu.barterfin.ui.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahayu.barterfin.R
import com.rahayu.barterfin.ui.presentation.auth.content.LoginContent
import com.rahayu.barterfin.ui.presentation.auth.content.RegisterContent
import com.rahayu.barterfin.ui.theme.BarterfinTheme
import com.rahayu.barterfin.ui.theme.gradientColorEnd
import com.rahayu.barterfin.ui.theme.gradientColorStart

@Composable
fun AuthScreen(modifier: Modifier = Modifier) {
    var showPassword by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = modifier.fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(gradientColorStart, gradientColorEnd),
                    start = Offset(0f, 0.5f),
                    end = Offset(Float.POSITIVE_INFINITY, 0.5f)
                )
            ),
        contentAlignment = Alignment.Center
    ){
        Scaffold(
            containerColor = Color.Transparent,
        ) { innerPaddding ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPaddding)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.3f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Barterfin.",
                        style = TextStyle(
                            fontFamily = FontFamily(
                                Font(R.font.pacifico_regular, FontWeight.Normal, FontStyle.Normal),

                                ),
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        color = Color.White
                    )
                }

                // Box login
//                Box(
//                    modifier = Mo difier
//                        .fillMaxWidth()
//                        .weight(0.7f)
//                        .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
//                ) {
//                    LoginContent(
//                        showPassword = showPassword,
//                    )
//                }

                // Box Register
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f)
                        .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                ) {
                    RegisterContent(
                        showPassword = showPassword,
                    )
                }

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    BarterfinTheme {
        AuthScreen()
    }
}