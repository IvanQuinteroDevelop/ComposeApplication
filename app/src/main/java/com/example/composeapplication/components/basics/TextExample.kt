package com.example.composeapplication

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@Composable
fun MySuperText(name: String) {
    Text(
        text = "Hola $name <3", modifier = Modifier
            .padding(16.dp), color = Color.Black, fontSize = 24.sp
    )
}
