package com.example.course.common

data class TextFieldState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val passwordError: Boolean = false,
    val isLoading: Boolean = false,
    val isFormValid: Boolean = false,
    val errorMessage: String? = null
)
