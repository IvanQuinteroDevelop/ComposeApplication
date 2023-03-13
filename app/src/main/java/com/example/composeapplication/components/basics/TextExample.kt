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
        Text(text = "Hello $name!", color = Color.Blue)
        Text(text = "Hello $name!", fontWeight = FontWeight.ExtraBold)
        Text(text = "Hello $name!", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(text = "Hello $name!", style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text(text = "Hello $name!", style = TextStyle(textDecoration = TextDecoration.Underline))
        Text(text = "Hello $name!", style = TextStyle(textDecoration = TextDecoration.combine(
            listOf(TextDecoration.Underline, TextDecoration.LineThrough)
        )))
    }
}


@Composable
fun MySuperText(name: String) {
    Text(
        text = "Hola $name <3", modifier = Modifier
            .padding(16.dp), color = Color.Black, fontSize = 24.sp
    )
}
