package com.fahad.auth_fierbase_bottomnavigation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height

import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.fahad.auth_fierbase_bottomnavigation.ui.screen.login.LoginScreen
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.login.LoginViewModel
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.navigation.RootNavigation

import com.fahad.auth_fierbase_bottomnavigation.ui.screen.bottomScreen.profile.EditProfileScreen
import com.fahad.auth_firebase.ui.screen.profile.ProfileScreen

import com.fahad.auth_fierbase_bottomnavigation.ui.screen.register.RegisterScreen
import com.fahad.auth_fierbase_bottomnavigation.ui.screen.register.RegisterViewModel

import com.fahad.auth_fierbase_bottomnavigation.ui.theme.AuthfierbaseBottomNavigationTheme


import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.light(
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


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val registerViewModel: RegisterViewModel = hiltViewModel()
    val loginViewModel: LoginViewModel = hiltViewModel()
    val userDataViewModel: UserDataViewModel = hiltViewModel()

    // Check authentication state when the MainScreen is recomposed
    LaunchedEffect(Unit) {
        checkAuthenticationState(navController, userDataViewModel)
    }

    NavHost(
        navController = navController,
        startDestination = "splash" // Set the splash screen as the initial destination
    ) {
        composable("splash") {
            SplashScreen()
        }
        composable("loading") {
            // Show loading screen while checking authentication state
            LoadingScreen()
        }
        composable("login") {
            LoginScreen(
                navController = navController, loginViewModel = loginViewModel
            )
        }
        composable("register") {
            RegisterScreen(
                navController = navController, registerViewModel = registerViewModel
            )
        }
        composable("profile") {
            ProfileScreen(
                navController = navController, userDataViewModel = userDataViewModel
            )
        }
        composable("edit_profile") {
            EditProfileScreen(
                navController = navController, userDataViewModel = userDataViewModel
            )
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize().background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()

    }
}

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White), // Set a background color for the splash screen
        contentAlignment = Alignment.Center
    ) {
        // Add your splash screen content
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Auth Firebase",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
    }
}





private fun checkAuthenticationState(navController: NavController, userDataViewModel: UserDataViewModel) {
    val auth = Firebase.auth
    val currentUser = auth.currentUser

    if (currentUser != null) {
        // Get user data from Firebase
        userDataViewModel.getUserData()


        // Navigate to the success screen
        navController.navigate("profile") {
            popUpTo("loading") { inclusive = true }
        }
    } else {
        // Navigate to the login screen
        navController.navigate("login") {
            popUpTo("loading") { inclusive = true }
        }
    }
}
