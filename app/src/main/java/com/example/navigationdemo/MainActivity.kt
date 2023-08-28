package com.example.navigationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.navigationdemo.ui.screens.HomeScreen
import com.example.navigationdemo.ui.screens.LoginScreen
import com.example.navigationdemo.ui.screens.WelcomeScreen
import com.example.navigationdemo.ui.theme.NavigationDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainNavigation()
                }
            }
        }
    }
}

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "auth") {
        navigation(
            startDestination = "login",
            route = "auth"
        ) {
            composable(route = "login") { entry ->
                val name = entry.savedStateHandle.get<String>("name")
                LoginScreen(name) { name ->
                    navController.navigate("welcome/$name")
                }
            }
            composable(
                route = "welcome" + "/{name}",
                arguments = listOf(
                    navArgument("name") {
                        type = NavType.StringType
                        nullable = false
                    }
                )
            ) { entry ->
                val name = entry.arguments?.getString("name")
                WelcomeScreen(
                    name = name,
                    onChangeName = { name
                        navController.previousBackStackEntry
                            ?.savedStateHandle
                            ?.set("name", name)
                        navController.popBackStack()
                    },
                    onEnter = {
                        navController.navigate("main")
                    }
                )
            }
        }

        composable(route = "main") { entry ->
            val viewModel = entry.sharedViewModel<SharedViewModel>(navController = navController)
            HomeScreen(viewModel)
        }
    }
}
