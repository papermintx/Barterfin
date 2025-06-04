package com.rahayu.barterfin.ui.presentation.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rahayu.barterfin.R
import com.rahayu.barterfin.ui.presentation.components.ButtonCustom
import com.rahayu.barterfin.ui.presentation.components.CustomTextfield
import com.rahayu.barterfin.ui.theme.BarterfinTheme

@Composable
fun ForgotScreen(modifier: Modifier = Modifier) {


    Scaffold { innerPadding->
        Box(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
        ){
            Column(
                modifier = Modifier
                    .padding(28.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(40.dp))
                Icon(
                    painter = painterResource(R.drawable.padlock_icon),
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = stringResource(R.string.lock_icon)
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = stringResource(R.string.forgot_password),
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Medium
                    )
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = stringResource(R.string.forgot_text),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Normal

                    )
                )
                Spacer(Modifier.height(22.dp))
                CustomTextfield(
                    hint = stringResource(R.string.enter_email),
                    text = "",
                    leadingIcon = {
                        Icon(
                            painter = painterResource(R.drawable.icon_email),
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = stringResource(R.string.email)
                        )
                    },
                    onTextChange = {},
                    validate = { "" },
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(Modifier.height(16.dp))
                ButtonCustom(
                    onClick = { },
                ) {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = stringResource(R.string.send_reset_link),
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = Color.White,
                                fontWeight = FontWeight.Medium
                            )
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            painter = painterResource(R.drawable.icon_arrow),
                            contentDescription = stringResource(R.string.icon_arrow)
                        )
                    }
                }

                Spacer(Modifier.height(32.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.back_to_login),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }



            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowForgotScreen() {
    BarterfinTheme {
        ForgotScreen()
    }
}