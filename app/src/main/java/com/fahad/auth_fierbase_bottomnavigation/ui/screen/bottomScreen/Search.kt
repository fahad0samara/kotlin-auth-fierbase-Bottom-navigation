package com.fahad.auth_fierbase_bottomnavigation.ui.screen.bottomScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier

@Composable
fun Search() {
  Box(
    contentAlignment = Center,
    modifier = Modifier
      .fillMaxSize().background(MaterialTheme.colorScheme.secondary)
    )
    {

    Text(text = "Search")

  }

}