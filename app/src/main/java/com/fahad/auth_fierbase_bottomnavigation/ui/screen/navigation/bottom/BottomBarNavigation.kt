package com.fahad.auth_fierbase_bottomnavigation.ui.screen.navigation.bottom

import androidx.compose.runtime.Composable


import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fahad.auth_fierbase_bottomnavigation.ui.UserDataViewModel
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.bottomScreen.Cart
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.bottomScreen.Home
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.bottomScreen.Search

import com.fahad.auth_fierbase_bottomnavigation.ui.screen.bottomScreen.SearchDetails
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.bottomScreen.Settings
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.navigation.Graph
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.bottomScreen.profile.EditProfileScreen
import com.fahad.auth_firebase.ui.screen.profile.ProfileScreen

@Composable
fun BottomBarNavigation(navController: NavHostController) {
  val userDataViewModel: UserDataViewModel = hiltViewModel()

  NavHost(
    navController = navController,
    route = Graph.HOME,
    startDestination = BottomBar.Home.route
  ) {
    composable(route = BottomBar.Home.route) {
   Home(
     navController=navController
   )
    }

    composable(route = BottomBar.Cart.route) {
   Cart()
    }

    composable(route = BottomBar.Settings.route) {
   Settings()
    }


      composable(route =  BottomBar.Profile.route) {
        ProfileScreen(
          navController = navController, userDataViewModel = userDataViewModel
        )
      }
      composable(route =  "edit_profile") {
        EditProfileScreen(
          navController = navController, userDataViewModel = userDataViewModel
        )
      }




    searchNavGraph(navController = navController)
  }
}

fun NavGraphBuilder.searchNavGraph(navController: NavHostController) {
  navigation(
    route = Graph.Search,
    startDestination = SearchNavGraph.Search.route
  ) {
    composable(route = SearchNavGraph.Search.route) {
      Search()

    }
    composable(route = SearchNavGraph.SearchDetails.route) {
      SearchDetails()
      }
    }
  }


sealed class SearchNavGraph(val route: String) {
  data object Search : SearchNavGraph(route = "Search")
  data object SearchDetails : SearchNavGraph(route = "SearchDetails")
}


