package com.rahayu.barterfin.ui.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahayu.barterfin.R
import com.rahayu.barterfin.ui.theme.labelTextfield

@Composable
fun CustomTextfield(
    hint: String,
    modifier: Modifier = Modifier,
    label : String? = null,
    text: String,
    onTextChange: (String) -> Unit,
    isPassword: Boolean = false,
    validate: (String) -> String,
    passwordVisible : Boolean = false,
    showPassword : (Boolean) -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    var isError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    Column(modifier = modifier,
        horizontalAlignment = Alignment.Start,
        ) {
        label.let {
            if (it != null) {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = labelTextfield,
                        fontSize = 16.sp,
                        lineHeight = 19.sp,
                    ),
                )
            }
        }
        OutlinedTextField(
            value = text,
            shape = RoundedCornerShape(16.dp),
            label = { Text(
                hint,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight(400),
                    color = Color(0xFFE5E7EB),
                )
            ) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color(0xFFE5E7EB),
                errorBorderColor = MaterialTheme.colorScheme.error
            ),
            singleLine = true,
            onValueChange = { newValue ->
                onTextChange(newValue)
                errorMessage = validate(newValue)
                isError = errorMessage.isNotEmpty()
            },
            isError = isError,
            visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                if (isPassword) {
                    IconButton(onClick = {
                        showPassword(!passwordVisible)
                    }) {
                        Icon(
                            imageVector =  if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = if (passwordVisible) stringResource(R.string.show_password) else stringResource(R.string.hide_password)
                        )

                    }
                }
            },
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
        )
        if (isError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}