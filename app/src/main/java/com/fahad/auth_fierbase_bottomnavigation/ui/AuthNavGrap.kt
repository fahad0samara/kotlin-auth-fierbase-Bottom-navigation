package com.fahad.auth_fierbase_bottomnavigation.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.Graph
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.login.LoginScreen
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.login.LoginViewModel
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.profile.EditProfileScreen
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.register.RegisterScreen
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.register.RegisterViewModel
import com.fahad.auth_firebase.ui.screen.profile.ProfileScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController,
                                 loginViewModel: LoginViewModel,
                                 registerViewModel: RegisterViewModel,
                                 userDataViewModel: UserDataViewModel) {

  navigation(
    route = Graph.AUTHENTICATION,
    startDestination = AuthScreen.Login.route
  )


  {
    composable("splash") {
      SplashScreen()
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
    composable(route = AuthScreen.Profile.route) {
      ProfileScreen(
        navController = navController, userDataViewModel = userDataViewModel
      )
    }
    composable(route = AuthScreen.EditProfile.route) {
      EditProfileScreen(
        navController = navController, userDataViewModel = userDataViewModel
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

