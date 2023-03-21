package com.example.composeapplication.components.basics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MyRadioButton() {
    var status by rememberSaveable {
        mutableStateOf(false)
    }
    Row(Modifier.fillMaxWidth()) {
        
    RadioButton(selected = status, onClick = {status = !status }, colors = RadioButtonDefaults.colors(
        unselectedColor = Color.Red,
        selectedColor = Color.Green,
        disabledColor = Color.DarkGray
    ))
        Text(text = "Option 1", Modifier.align(Alignment.CenterVertically))
    }
}

@Composable
fun MyRadioButtonList(name: String, onSelected:(String) -> Unit) {

    Column(Modifier.fillMaxSize()) {
        Row {
           RadioButton(selected = name == "Ivan" , onClick = {onSelected("Ivan")})
            Text(text = "Ivan", Modifier.align(Alignment.CenterVertically))
        }
        Row {
           RadioButton(selected = name == "Dario" , onClick = {onSelected("Dario")})
            Text(text = "Dario", Modifier.align(Alignment.CenterVertically))
        }
        Row {
           RadioButton(selected = name == "Quintero" , onClick = {onSelected("Quintero")})
            Text(text = "Quintero", Modifier.align(Alignment.CenterVertically))
        }
        Row {
           RadioButton(selected = name == "Torres" , onClick = {onSelected("Torres")})
            Text(text = "Torres", Modifier.align(Alignment.CenterVertically))
        }
    }
}