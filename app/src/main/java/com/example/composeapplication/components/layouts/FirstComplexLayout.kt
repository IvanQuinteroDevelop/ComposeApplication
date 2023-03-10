package com.example.composeapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview("ComplexLayout", showSystemUi = true)
@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center) {
            Text(text = "Hola desde el cuadro Cyan")
        }
        HeightSpacer(size = 30)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Box(modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(Color.Blue), contentAlignment = Alignment.Center) {
                Text(text = "Hola desde el cuadro azul")
            }
            WidthSpacer(size = 30)
            Box(modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(Color.Red), contentAlignment = Alignment.Center) {
                Text(text = "Hola desde el cuadro rojo")
            }
        }
        HeightSpacer(size = 30)
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta), contentAlignment = Alignment.BottomCenter) {
            Text(text = "Hola desde el cuadro magenta")
        }
    }
}