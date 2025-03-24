package com.example.course.presentation.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.course.R
import com.example.course.common.TextFieldState
import com.example.course.route.ScreenKey

@Composable
fun RegisterScreen(navController: NavHostController, viewModel: RegisterViewModel = hiltViewModel() ) {

    val registerState = viewModel.state.value
    val isFormValidState = viewModel.state.value.isFormValid

    BlockRegistration(
        registerState = registerState,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onConfirmPasswordChange = viewModel::onConfirmPasswordChange,
        onRegisterClick = {
            if (isFormValidState) navController.navigate(ScreenKey.AuthScreen)
        }
    )
}

@Composable
fun BlockRegistration (
    registerState: TextFieldState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onRegisterClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(color = colorResource(R.color.background))
            .fillMaxSize()
            .padding(start = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        RegistrationHeader()
        Spacer(modifier = Modifier.height(32.dp))
        RegistrationFields(
            registerState,
            onEmailChange = onEmailChange,
            onPasswordChange = onPasswordChange,
            onConfirmPasswordChange = onConfirmPasswordChange
        )
    }
}


@Composable
private fun RegistrationHeader() {
    Text(
        text = stringResource(R.string.registration),
        style = MaterialTheme.typography.headlineMedium,
        color = colorResource(R.color.light_gray),
        fontSize = 28.sp
    )
    Spacer(modifier = Modifier.height(32.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RegistrationFields(
    state: TextFieldState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        EmailField(
            value = state.email,
            onValueChange = onEmailChange
        )
        PasswordField(
            value = state.password,
            onValueChange = onPasswordChange,
            label = R.string.password
        )
        ConfirmPasswordField(
            value = state.confirmPassword,
            onValueChange = onConfirmPasswordChange,
            isError = state.passwordError
        )
    }
}


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun EmailField(
        value: String,
        onValueChange: (String) -> Unit
    ) {
        Text(
            text = stringResource(R.string.email),
            style = MaterialTheme.typography.headlineMedium,
            color = colorResource(R.color.light_gray),
            fontSize = 28.sp
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            colors = textFieldColors(colorResource(R.color.text_field_color)),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PasswordField(
        value: String,
        onValueChange: (String) -> Unit,
        label: Int
    ) {
        Text(
            text = stringResource(R.string.password),
            style = MaterialTheme.typography.headlineMedium,
            color = colorResource(R.color.light_gray),
            fontSize = 28.sp
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            colors = textFieldColors(colorResource(R.color.text_field_color)),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ConfirmPasswordField(
        value: String,
        onValueChange: (String) -> Unit,
        isError: Boolean
    ) {
        Text(
            text = stringResource(R.string.confirm_password),
            style = MaterialTheme.typography.headlineMedium,
            color = colorResource(R.color.light_gray),
            fontSize = 28.sp
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            colors = textFieldColors(colorResource(R.color.text_field_color)),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isError = isError
        )
}