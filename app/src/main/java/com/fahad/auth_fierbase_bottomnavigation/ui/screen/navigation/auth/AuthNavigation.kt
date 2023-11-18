package com.fahad.auth_fierbase_bottomnavigation.ui.screen.navigation.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fahad.auth_fierbase_bottomnavigation.ui.LoadingScreen
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
    startDestination = AuthScreen.Login.route
  )


  {
    composable("splash") {
      com.fahad.auth_fierbase_bottomnavigation.ui.SplashScreen()
    }
    composable("loading") {
      // Show loading screen while checking authentication state
      LoadingScreen()
    }
    composable(route = AuthScreen.Login.route) {
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
  data object Login : AuthScreen(route = "LOGIN")
  data object REGISTER : AuthScreen(route = "REGISTER")
  data object  Profile : AuthScreen(route = " Profile")

  data object EditProfile : AuthScreen(route = "EditProfile")
}

