package com.fahad.auth_fierbase_bottomnavigation.ui.screen.register

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.fahad.auth_fierbase_bottomnavigation.domain.model.Response
import com.fahad.auth_fierbase_bottomnavigation.domain.model.User
import com.fahad.auth_fierbase_bottomnavigation.domain.repository.AuthRepository
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.navigation.auth.AuthScreen
import com.fahad.auth_fierbase_bottomnavigation.ui.UserDataViewModel
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.navigation.Graph

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: AuthRepository, private val userDataViewModel: UserDataViewModel
) : ViewModel() {
    private val _registrationState = MutableStateFlow<Response<User>>(Response.Loading)
    val registrationState: StateFlow<Response<User>> = _registrationState

    private val _isLoading = mutableStateOf(false)
    val isLoading: Boolean
        get() = _isLoading.value


    fun registerUser(
        email: String, password: String, displayName: String, photoUri: String, // Make it nullable
        navController: NavController
    ) {
        _isLoading.value = true
        viewModelScope.launch {
            _registrationState.value = Response.Loading
            try {
                val registrationResult = repository.registerUser(
                    email, password, displayName, photoUri
                ).first()
                _isLoading.value = false

                if (registrationResult is Response.Success) {
                    val user = registrationResult.data
                    userDataViewModel.setUser(user)
                  navController.navigate( Graph.HOME)
                } else if (registrationResult is Response.Failure) {
                    _registrationState.value = registrationResult

                }
            } catch (e: Exception) {
                Log.e("ViewModel", "registerUser: ${e.message}")
                _registrationState.value = Response.Failure(Exception("Something went wrong"))


            }
        }

    }
}

