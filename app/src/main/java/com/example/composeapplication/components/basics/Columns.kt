package com.example.composeapplication.components.basics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(name = "Columns", showSystemUi = true)
@Composable
fun MyColumn() {
    Column() {
        Text("user 1",
            Modifier
                .background(Color.Magenta)
                .fillMaxWidth()
                .height(65.dp))
        Text("user 2",
            Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(65.dp))
        Text("user 3",
            Modifier
                .background(Color.Green)
                .fillMaxWidth()
                .height(65.dp))
        Text("user 4",
            Modifier
                .background(Color.Yellow)
                .fillMaxWidth()
                .height(65.dp))
        Text("user 5",
            Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(65.dp))
    }
}