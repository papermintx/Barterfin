package com.rahayu.barterfin.ui.presentation.auth.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rahayu.barterfin.R
import com.rahayu.barterfin.ui.presentation.components.ButtonCustom
import com.rahayu.barterfin.ui.presentation.components.CustomTextfield
import com.rahayu.barterfin.ui.presentation.components.ProfilePictureWithEdit
import com.rahayu.barterfin.ui.theme.BarterfinTheme

@Composable
fun CreateProfileContent(
    modifier: Modifier = Modifier,
    onClickContinue: () -> Unit,
    textPhoneNumber: String = "",
    textAddress: String = "",
    textDateOfBirth: String = "",
    onClickEditPicture: () -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    onDateOfBirthChange: (String) ->Unit,
    onAddressChange: (String) -> Unit,
    validatePhoneNumber: (String) -> String = { "" },
    validateAddress: (String) -> String = { "" },
    validateDateOfBirth: (String) -> String = { "" },
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 48.dp, start = 28.dp, end = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.complete_your_profile),
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground
            )
        )

        Spacer(Modifier.height(40.dp))

        ProfilePictureWithEdit(
            onClick = onClickEditPicture
        )

        Spacer(Modifier.height(27.dp))

        CustomTextfield(
            hint = stringResource(R.string.enter_your_phone_number),
            text = textPhoneNumber,
            label = stringResource(R.string.phone_number),
            onTextChange = onPhoneNumberChange,
            validate = validatePhoneNumber,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(Modifier.height(12.dp))

        CustomTextfield(
            hint = stringResource(R.string.enter_your_address),
            text = textAddress,
            label = stringResource(R.string.address),
            onTextChange = onAddressChange,
            validate = validateAddress,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(Modifier.height(12.dp))

        CustomTextfield(
            hint = stringResource(R.string.enter_your_date_of_birth),
            text = textDateOfBirth,
            label = stringResource(R.string.date_of_birth),
            onTextChange = onDateOfBirthChange,
            validate = validateDateOfBirth,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(Modifier.height(24.dp))

        ButtonCustom(
            onClick = onClickContinue,
            content = {
                Text(
                    text = stringResource(R.string.continue_button),
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 7.dp),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowProfileContent() {
    BarterfinTheme {
        CreateProfileContent(
            modifier = Modifier.fillMaxSize(),
            onClickContinue = {},
            onClickEditPicture = {},
            onPhoneNumberChange = {},
            onDateOfBirthChange = {},
            onAddressChange = {},
        )
    }

}