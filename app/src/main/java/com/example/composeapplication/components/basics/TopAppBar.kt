package com.example.composeapplication.components.basics

import android.app.Activity
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun MyTopAppBar() {
    val activity: Activity = LocalContext.current as Activity
    TopAppBar(
        title = {
            Text(text = "My first toolbar")
        },
        backgroundColor = Color.Blue,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(
                onClick = { activity.finish() }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        }, actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = { activity.finish() }) {
                Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
            }
        })
}