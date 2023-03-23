package com.example.composeapplication.components.basics

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun MyCard() {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.large,
        backgroundColor = Color.LightGray,
        contentColor = Color.Magenta,
        border = BorderStroke(3.dp, Color.Green)
    ) {
        Column(Modifier.padding(8.dp)) {
            Text(text = "Example")
            Text(text = "Example")
            Text(text = "Example")
        }
    }
}