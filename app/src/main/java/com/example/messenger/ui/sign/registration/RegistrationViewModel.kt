package com.example.messenger.ui.sign.registration

import androidx.lifecycle.ViewModel
import com.example.messenger.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

}
