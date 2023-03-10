package com.example.composeapplication.components.basics

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(name = "Rows", showSystemUi = true)
@Composable
fun MyRow() {
    Row(
        Modifier
            .horizontalScroll(rememberScrollState())) {
        Text(text = "Ejemplo1", Modifier.width(80.dp), fontSize = 16.sp)
        Text(text = "Ejemplo2", Modifier.width(80.dp), fontSize = 16.sp)
        Text(text = "Ejemplo3", Modifier.width(80.dp), fontSize = 16.sp)
        Text(text = "Ejemplo4", Modifier.width(80.dp), fontSize = 16.sp)
        Text(text = "Ejemplo1", Modifier.width(80.dp), fontSize = 16.sp)
        Text(text = "Ejemplo2", Modifier.width(80.dp), fontSize = 16.sp)
        Text(text = "Ejemplo3", Modifier.width(80.dp), fontSize = 16.sp)
        Text(text = "Ejemplo4", Modifier.width(80.dp), fontSize = 16.sp)
    }
}