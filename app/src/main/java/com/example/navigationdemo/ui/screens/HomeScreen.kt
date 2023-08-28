package com.example.navigationdemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationdemo.SharedViewModel
import com.example.navigationdemo.ui.bottomNavigation.BottomNavItem
import com.example.navigationdemo.ui.bottomNavigation.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    viewModel: SharedViewModel,
) {
    val navController = rememberNavController()
    val state by viewModel.sharedState.collectAsStateWithLifecycle()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "Home",
                        route = "home",
                        icon = Icons.Default.Home,
                    ),
                    BottomNavItem(
                        name = "Chat",
                        route = "chat",
                        icon = Icons.Default.Notifications,
                        badgeCount = state,
                    ),
                    BottomNavItem(
                        name = "Settings",
                        route = "settings",
                        icon = Icons.Default.Settings
                    ),
                ),
                navController = navController,
                onItemClick = {
                    viewModel.updateState()
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        HomeNavigation(navController = navController, viewModel)
    }
}

@Composable
fun HomeNavigation(
    navController: NavHostController,
    viewModel: SharedViewModel,
    ) {
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            Home()
        }
        composable(route = "chat") {
            Chat()
        }
        composable(route = "settings") { entry ->
            val state by viewModel.sharedState.collectAsStateWithLifecycle()
            Settings(state)
        }
    }
}

@Composable
fun Home() {
    Text(
        text = "Home",
        modifier = Modifier.fillMaxSize(),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun Chat() {
    Text(
        text = "Chat",
        modifier = Modifier.fillMaxSize(),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun Settings(state: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        Text(
            text = "Settings",
            modifier = Modifier.wrapContentSize(),
            textAlign = TextAlign.Center,
        )
        Text(text = "state $state",
            modifier = Modifier.wrapContentSize(),
            textAlign = TextAlign.Center,)
    }
}