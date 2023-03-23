package com.example.composeapplication.components.basics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Greeting(name: String) {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Hello $name!", color = Color.Blue, fontSize = 24.sp)
        Text(text = "Hello $name!", fontWeight = FontWeight.ExtraBold)
        Text(text = "Hello $name!", style = TextStyle(fontFamily = FontFamily.Cursive, fontSize = 24.sp))
        Text(text = "Hello $name!", style = TextStyle(textDecoration = TextDecoration.LineThrough, fontSize = 24.sp))
        Text(text = "Hello $name!", style = TextStyle(textDecoration = TextDecoration.Underline, fontSize = 24.sp))
        Text(text = "Hello $name!", style = TextStyle(textDecoration = TextDecoration.combine(
            listOf(TextDecoration.Underline, TextDecoration.LineThrough)
        ), fontSize = 24.sp))
    }
}


@Composable
fun MySuperText(name: String) {
    Text(
        text = "Hola $name <3", modifier = Modifier
            .padding(16.dp), color = Color.Black, fontSize = 24.sp
    )
}
