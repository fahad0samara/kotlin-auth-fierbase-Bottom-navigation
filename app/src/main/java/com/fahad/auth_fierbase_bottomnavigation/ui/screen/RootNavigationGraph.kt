package com.fahad.auth_fierbase_bottomnavigation.ui.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fahad.auth_fierbase_bottomnavigation.ui.UserDataViewModel
import com.fahad.auth_fierbase_bottomnavigation.ui.authNavGraph
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.login.LoginViewModel
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.register.RegisterViewModel

@Composable
fun RootNavigationGraph(navController: NavHostController) {
  val loginViewModel: LoginViewModel = hiltViewModel()
  val registerViewModel: RegisterViewModel = hiltViewModel()
  val userDataViewModel: UserDataViewModel = hiltViewModel()
  NavHost(
    navController = navController,
    route = Graph.ROOT,
    startDestination = Graph.AUTHENTICATION
  ) {
    authNavGraph( navController = navController,
      loginViewModel = loginViewModel,
      registerViewModel = registerViewModel,
      userDataViewModel = userDataViewModel)
//    composable(route = Graph.HOME) {
//      HomeScreen()
//    }
  }
}

object Graph {
  const val ROOT = "root_graph"
  const val AUTHENTICATION = "auth_graph"
  const val HOME = "home_graph"
  const val DETAILS = "details_graph"
}