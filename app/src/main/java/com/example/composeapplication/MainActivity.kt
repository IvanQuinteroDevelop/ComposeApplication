package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composeapplication.model.Routes
import com.example.composeapplication.navigation.*
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.FirstScreen.route
                    ) {
                        composable(Routes.FirstScreen.route) { Screen1(navigationController) }
                        composable(Routes.SecondScreen.route) { Screen2(navigationController) }
                        composable(Routes.ThirdScreen.route) { Screen3(navigationController) }
                        composable("${Routes.FourthScreen.route}/{age}", arguments = listOf(
                            navArgument("age") { type = NavType.IntType }
                        )) { backStackEntry ->
                            Screen4(
                                navigationController,
                                backStackEntry.arguments?.getInt("age") ?: 0
                            )
                        }
                        composable(
                            Routes.FifthScreen.route,
                            arguments = listOf(navArgument("name") { defaultValue = "Pepe" })
                        ) { backStackEntry ->
                            Screen5(
                                navController = navigationController,
                                backStackEntry.arguments?.getString("name")
                            )
                        }
                    }
                    //AddComponents()
                }
            }
        }
    }

}
