package com.rahayu.barterfin.ui.presentation.auth.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahayu.barterfin.R
import com.rahayu.barterfin.ui.presentation.components.ButtonCustom
import com.rahayu.barterfin.ui.presentation.components.CustomTextfield
import com.rahayu.barterfin.ui.theme.BarterfinTheme


@Composable
fun LoginContent(
    modifier: Modifier = Modifier,
    onclickShowPassword: (Boolean) -> Unit = {},
    showPassword: Boolean,
    onClickLogin: () -> Unit = {},
    textEmail: String = "",
    textPassword: String = "",
    validateEmail: (String) -> String = { "" },
    validatePassword: (String) -> String = { "" },
    onTextChangeEmail: (String) -> Unit = {},
    onTextChangePassword: (String) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 48.dp, start = 28.dp, end = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.welcome_back),
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
        Text(
            text = stringResource(R.string.login_to_continue),
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(Modifier.height(47.dp))

        CustomTextfield(
            hint = stringResource(R.string.enter_email),
            text = textEmail,
            label = stringResource(R.string.email),
            onTextChange = onTextChangeEmail,
            validate = validateEmail,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(Modifier.height(12.dp))

        CustomTextfield(
            hint = stringResource(R.string.enter_password),
            text = textPassword,
            isPassword = true,
            passwordVisible = showPassword,
            showPassword = {
                onclickShowPassword(it)
            },
            label = stringResource(R.string.password),
            onTextChange = onTextChangePassword,
            validate = validatePassword,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(Modifier.height(16.dp))

        Column(
            modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End,
        ) {
            Text(
                text = stringResource(R.string.forgot_password),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF648DDB)
                )
            )
        }
        Spacer(Modifier.height(20.dp))
        ButtonCustom(
            onClick = onClickLogin,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = stringResource(R.string.login),
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 7.dp),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            )
        }
        Spacer(Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            HorizontalDivider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Or", style = MaterialTheme.typography.bodyMedium.copy(
                color = Color(0xFFE5E7EB),
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                lineHeight = 19.sp
            ))
            Spacer(modifier = Modifier.width(8.dp))
            HorizontalDivider(
                color = Color.LightGray,
                thickness = 1.dp,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(Modifier.height(16.dp))

        ButtonCustom(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            border = BorderStroke(1.dp, Color(0xFFE5E7EB)),
            color = Color.White
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.google_icon),
                    contentDescription = stringResource(R.string.google_icon),
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(R.string.login_with_google),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )
            }
        }

        Spacer(Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.dont_have_account),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color(0xFF000000),
                    fontWeight = FontWeight.Medium
                )
            )
            Spacer(modifier = Modifier.width(4.dp))
            TextButton(
                onClick = {},
                contentPadding = PaddingValues(0.dp),
            ){
                Text(
                    text = stringResource(R.string.register),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowLoginContent() {
    BarterfinTheme {
        LoginContent(
            modifier = Modifier.fillMaxSize(),
            onclickShowPassword = {},
            showPassword = false
        )
    }
}