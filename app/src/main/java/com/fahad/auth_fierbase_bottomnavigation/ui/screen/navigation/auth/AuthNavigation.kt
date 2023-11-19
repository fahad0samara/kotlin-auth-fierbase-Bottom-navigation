package com.fahad.auth_fierbase_bottomnavigation.ui.screen.navigation.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

import com.fahad.auth_fierbase_bottomnavigation.ui.screen.login.LoginScreen
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.login.LoginViewModel
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.navigation.Graph
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.register.RegisterScreen
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.register.RegisterViewModel

fun NavGraphBuilder.AuthNavigation(navController: NavHostController,
                                 loginViewModel: LoginViewModel,
                                 registerViewModel: RegisterViewModel ) {

  navigation(
    route = Graph.AUTHENTICATION,
    startDestination = AuthScreen.LOGIN.route
  )


  {

    composable(route = AuthScreen.LOGIN.route) {
      LoginScreen(
        navController = navController, loginViewModel = loginViewModel
      )
    }
    composable(route = AuthScreen.REGISTER.route) {
      RegisterScreen(
        navController = navController, registerViewModel = registerViewModel
      )
    }

  }
}

sealed class AuthScreen(val route: String) {
  data object LOGIN : AuthScreen(route = "LOGIN")
  data object REGISTER : AuthScreen(route = "REGISTER")

}

