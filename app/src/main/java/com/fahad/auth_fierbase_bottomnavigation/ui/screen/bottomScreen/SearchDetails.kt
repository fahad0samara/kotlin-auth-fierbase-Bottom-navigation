package com.fahad.auth_fierbase_bottomnavigation.ui.screen.bottomScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SearchDetails() {
  Box(
    contentAlignment = Alignment.Center,
    modifier = Modifier
      .fillMaxSize().background(MaterialTheme.colorScheme.onSecondaryContainer)
  )
  {

    Text(text = "Search")

  }

}