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
fun Cart() {
  Box(
    contentAlignment = androidx.compose.ui.Alignment.Center,
    modifier = androidx.compose.ui.Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary)
  ){
    Text(text = "Home",
      style = MaterialTheme.typography.labelLarge,
      color = MaterialTheme.colorScheme.onPrimary
    )
  }

}