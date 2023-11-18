package com.fahad.auth_fierbase_bottomnavigation.ui.screen.bottomScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.fahad.auth_fierbase_bottomnavigation.ui.screen.navigation.bottom.SearchNavGraph

@Composable
fun Home(navController: NavController) {
  Box(
    contentAlignment = Alignment.Center,

    modifier = Modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.primary)
  ) {
    Column(
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)

    ) {
      Text(
        text = "Search", modifier = Modifier.clickable(onClick = {
          navController.navigate(SearchNavGraph.Search.route)

        })

      )
      Text(
        text = "SearchDetailsSearchDetails",

        modifier = Modifier
          .clickable(onClick = {
            navController.navigate(SearchNavGraph.SearchDetails.route)

          })
          .padding(10.dp)
      )

    }

  }
}