package com.example.composeapplication.components.basics

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showSystemUi = true)
@Composable
fun MyTextField() {
    var mText by remember {
        mutableStateOf("Ivancho")
    }
    TextField(value = mText, onValueChange = {
        mText = it
    })
}

@Preview(showSystemUi = true)
@Composable
fun MyAdvancedTextField() {
    var mText by remember {
        mutableStateOf("")
    }
    Box(
        Modifier
            .padding(8.dp).fillMaxWidth(), contentAlignment = Alignment.Center
    ) {
        TextField(value = mText, onValueChange = {
            mText = it
        },label = { Text(text = "Introduce your name") })
    }
}

@Composable
fun MyOutLinedTextField(name:String, onValueChanged: (String) -> Unit) {
    ConstraintLayout(
        Modifier
            .padding(8.dp)
    ) {
        Box(
            Modifier
                .padding(8.dp).fillMaxWidth(), contentAlignment = Alignment.Center
        ) {
            OutlinedTextField(value = name, onValueChange = {
                onValueChanged(it)
            }, label = { Text(text = "Introduce your email") },
                isError = !name.contains("@"),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Cyan,
                    unfocusedBorderColor = Color.Green
                )
            )
        }
    }
}