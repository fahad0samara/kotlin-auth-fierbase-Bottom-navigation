@file:JvmName("BottomBarKt")

package com.fahad.auth_fierbase_bottomnavigation.ui.screen.navigation.bottom

import android.annotation.SuppressLint
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomBarRoot(navController: NavHostController = rememberNavController()) {

  Scaffold(
    bottomBar = { BottomBarItem(navController = navController) }
  ) {
    BottomBarNavigation(navController = navController)
  }
}

@Composable
fun BottomBarItem(navController: NavHostController) {
  val screens = listOf(
    BottomBar.Home,
    BottomBar.Settings,
    BottomBar.Cart,
    BottomBar.Profile,


  )
  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val currentDestination = navBackStackEntry?.destination

  val bottomBarDestination = screens.any { it.route == currentDestination?.route }

  if (bottomBarDestination) {
    NavigationBar {
      val items = screens.map { screen ->
        NavigationBarItem(
          icon = {
            Icon(
              imageVector = screen.icon,
              contentDescription = "Navigation Icon"
            )
          },
          label = {
            Text(text = screen.title)
          },
          selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
          } == true,
          onClick = {
            navController.navigate(screen.route) {
              popUpTo(navController.graph.findStartDestination().id)
              launchSingleTop = true
            }
          }
        )
      }

      items.forEach { item ->
        item
      }
    }
  }
}











