package com.example.composeapplication.components.basics

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    TextField(value = mText, onValueChange = {
        mText = it
    }, label = {Text(text = "Introduce tu nombre") }, isError = !mText.contains("@"))
}

@Preview(showSystemUi = true)
@Composable
fun MyOutLinedTextField() {
    var mText by rememberSaveable {
        mutableStateOf("")
    }
    ConstraintLayout(
        Modifier
            .fillMaxSize()
            .padding(16.dp)) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            OutlinedTextField(value = mText, onValueChange = {
                mText = it
            })
        }
    }
}