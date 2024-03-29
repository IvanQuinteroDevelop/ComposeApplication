package com.example.composeapplication.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.composeapplication.model.Routes

@Composable
fun Screen2(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(text = "Screen 2", modifier = Modifier
            .align(Alignment.Center)
            .clickable { navController.navigate(Routes.ThirdScreen.route) })
    }
}

@Composable
fun Screen3(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            text = "Screen 3",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Routes.FourthScreen.createRoute(7)) })
    }
}

@Composable
fun Screen4(navController: NavHostController, age: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(text = "i am $age years old", modifier = Modifier
            .align(Alignment.Center)
            .clickable {
                navController.navigate(Routes.FifthScreen.createRoute("Ivancho"))
            })
    }
}

@Composable
fun Screen5(navController: NavHostController, name: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Text(text = "My name is $name", modifier = Modifier.align(Alignment.Center))
    }
}