package com.example.course.presentation.register

import androidx.compose.material3.Text
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.course.common.TextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    private val _state = mutableStateOf(TextFieldState())
    val state: State<TextFieldState> = _state

    fun onEmailChange(email: String) {
        _state.value = state.value.copy(
            email = email,
            errorMessage = null
        )
        validateForm()
    }

    fun onPasswordChange(password: String) {
        _state.value = state.value.copy(
            password = password,
            errorMessage = null,
            passwordError = password != state.value.confirmPassword
        )
        validateForm()
    }

    fun onConfirmPasswordChange(confirmPassword: String) {
        _state.value = state.value.copy(
            confirmPassword = confirmPassword,
            passwordError = state.value.password != confirmPassword,
            errorMessage = null
        )
        validateForm()
    }

    private fun validateForm() {
        _state.value = state.value.copy(
            isFormValid = state.value.email.isNotBlank() &&
                    state.value.password.isNotBlank() &&
                    state.value.confirmPassword.isNotBlank() &&
                    !state.value.passwordError
        )
    }

}