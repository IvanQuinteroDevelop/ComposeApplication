package com.example.composeapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    name = "Boxes",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 33,
    device = Devices.NEXUS_6
)
@Composable
fun MyBoxes() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), contentAlignment = Alignment.BottomCenter
    ) {
        Column(Modifier.verticalScroll(rememberScrollState()), verticalArrangement = Arrangement . SpaceBetween) {
            MyColumn()
            Box(
                modifier = Modifier
                    .background(Color.Blue)
                    .width(200.dp)
                    .height(100.dp)
                    .verticalScroll(
                        rememberScrollState()
                    ), Alignment.Center
            ) {
                MySuperText(name = "Ivan")
            }
        }
    }
}