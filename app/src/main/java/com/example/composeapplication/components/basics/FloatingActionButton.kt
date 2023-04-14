package com.example.composeapplication.components.basics

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MyFAB() {
    FloatingActionButton(onClick = {}, backgroundColor = Color.Cyan, contentColor = Color.White) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add button")
    }
}