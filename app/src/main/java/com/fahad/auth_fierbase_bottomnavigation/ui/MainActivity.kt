package com.fahad.auth_fierbase_bottomnavigation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier

import androidx.navigation.compose.rememberNavController

import com.fahad.auth_fierbase_bottomnavigation.ui.screen.navigation.RootNavigation

import com.fahad.auth_fierbase_bottomnavigation.ui.theme.AuthfierbaseBottomNavigationTheme

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge(
      statusBarStyle = SystemBarStyle.light(
        android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT
      ), navigationBarStyle = SystemBarStyle.light(
        android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT
      )

    )
    setContent {

      AuthfierbaseBottomNavigationTheme {
        // A surface container using the 'background' color from the theme
        Surface(
          modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {

          RootNavigation(navController = rememberNavController())

        }
      }
    }
  }
}
