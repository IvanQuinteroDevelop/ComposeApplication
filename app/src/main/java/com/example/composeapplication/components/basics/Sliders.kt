package com.example.composeapplication.components.basics

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun MySlider() {
    var sliderPosition by rememberSaveable {
        mutableStateOf(0f)
    }
    Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString(), fontSize = 24.sp)
    }
}

@Preview
@Composable
fun MyAdvanceSlider() {
    var sliderPosition by rememberSaveable {
        mutableStateOf(0f)
    }
    var completeValue by rememberSaveable {
        mutableStateOf("0")
    }

    Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f,
            steps = 99,
            onValueChangeFinished = { completeValue = sliderPosition.toInt().toString() })
        Text(text = completeValue, fontSize = 24.sp)
    }
}

@Preview
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {
    Card(Modifier.padding(8.dp), elevation = 12.dp) {

        Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {

            var currentRange by remember {
                mutableStateOf(0f..10f)
            }
            RangeSlider(values = currentRange, onValueChange = { currentRange = it }, steps = 9)
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "Start value ${currentRange.start}", fontSize = 14.sp)
                WidthSpacer(size = 12)
                Text(text = "Finish Value ${currentRange.endInclusive}", fontSize = 14.sp)
            }
        }
    }

}