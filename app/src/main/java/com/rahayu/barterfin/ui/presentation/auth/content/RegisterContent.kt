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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahayu.barterfin.R
import com.rahayu.barterfin.ui.presentation.components.CustomTextfield

@Composable
fun RegisterContent(
    modifier: Modifier = Modifier,
    onclickShowPassword: (Boolean) -> Unit = {},
    showPassword: Boolean,
) {
    Column(
        modifier = modifier.fillMaxSize()
            .background(Color.White)
            .padding(top = 48.dp, start = 28.dp, end = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.welcome),
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        )
        Text(
            text = stringResource(R.string.create_your_account),
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(Modifier.height(47.dp))
        CustomTextfield(
            hint = stringResource(R.string.enter_your_username),
            text = "",
            label = stringResource(R.string.username),
            onTextChange = {},
            validate = { "" },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(Modifier.height(12.dp))
        CustomTextfield(
            hint = stringResource(R.string.enter_email),
            text = "",
            label = stringResource(R.string.email),
            onTextChange = {},
            validate = { "" },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(Modifier.height(12.dp))
        CustomTextfield(
            hint = stringResource(R.string.enter_password),
            text = "",
            isPassword = true,
            passwordVisible = showPassword,
            showPassword = {
                onclickShowPassword(it)
            },
            label = stringResource(R.string.password),
            onTextChange = {},
            validate = { "" },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(Modifier.height(12.dp))
        CustomTextfield(
            hint = stringResource(R.string.confirm_your_password),
            text = "",
            isPassword = true,
            passwordVisible = showPassword,
            showPassword = {
                onclickShowPassword(it)
            },
            label = stringResource(R.string.confirm_password),
            onTextChange = {},
            validate = { "" },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = MaterialTheme.colorScheme.primary,
            )
        ) {
            Text(
                text = stringResource(R.string.register),
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 7.dp),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
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
                fontWeight = FontWeight.Bold,
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

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Color(0xFFE5E7EB)),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Color.White,
            )
        ) {
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
                    text = stringResource(R.string.register_with_google),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
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
                text = stringResource(R.string.already_have_account),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    lineHeight = 19.sp,
                    color = Color(0xFF000000),
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.width(4.dp))
            TextButton(
                onClick = {},
                contentPadding = PaddingValues(0.dp),
            ){
                Text(
                    text = stringResource(R.string.login),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        lineHeight = 19.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                )
            }
        }
    }
}