package com.example.composeapplication.components.basics

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun MyButtonExample() {
    var enable by rememberSaveable {
        mutableStateOf(true)
    }
    Row(
        Modifier
            .fillMaxSize()
            .padding(8.dp),
        Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { enable = false },
            enabled = enable,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Green
            ),
            border = BorderStroke(2.dp, Color.Cyan)
        ) {
            Text(text = "tap me")
        }

        OutlinedButton(onClick = {}) {
            Text(text = "OutLinedButton")
        }

        TextButton(onClick = { }) {
            Text(text = "TextButton")
        }
    }
}