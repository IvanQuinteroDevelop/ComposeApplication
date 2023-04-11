package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapplication.model.Routes
import com.example.composeapplication.navigation.Screen1
import com.example.composeapplication.navigation.Screen2
import com.example.composeapplication.navigation.Screen3
import com.example.composeapplication.navigation.Screen4
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
                    NavHost(navController = navigationController, startDestination = Routes.FirstScreen.route) {
                        composable(Routes.FirstScreen.route) { Screen1(navigationController) }
                        composable(Routes.SecondScreen.route) { Screen2(navigationController) }
                        composable(Routes.ThirdScreen.route) { Screen3(navigationController) }
                        composable("${Routes.FourthScreen.route}/{name}") { backStackEntry ->
                            Screen4(navigationController, backStackEntry.arguments?.getString("name").orEmpty())
                        }
                    }
                    //AddComponents()
                }
            }
        }
    }

}
