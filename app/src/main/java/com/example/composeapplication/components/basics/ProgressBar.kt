package com.example.composeapplication.components.basics

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun MyProgress() {
    var showLoading by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        Modifier
            .padding(16.dp)
            .fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Magenta, strokeWidth = 8.dp)
            LinearProgressIndicator(
                Modifier.padding(top = 30.dp),
                color = Color.Cyan,
                backgroundColor = Color.Red
            )
        }

        Button(onClick = { showLoading = !showLoading }) {
            Text(text = if (showLoading) "Stop" else "Load profile")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyProgressAdvance() {
    var progressValue by rememberSaveable {
        mutableStateOf(0f)
    }

    Log.i("valor", "$progressValue")
    Column(
        Modifier
            .padding(16.dp)
            .fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(progressValue)

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {
                if (progressValue >= 0.1f) progressValue -= 0.1f
            }) { Text(text = "Reducir") }
            Button(onClick = {
                if (progressValue <= 1f) progressValue += 0.1f
            }) {
                Text(text = "Incrementar")
            }
        }
    }
}
