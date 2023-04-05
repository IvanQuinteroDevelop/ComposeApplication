package com.example.composeapplication.components.layouts

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapplication.components.basics.MyTopAppBar
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showSystemUi = true)
@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = { MyTopAppBar {
        coroutineScope.launch {
            scaffoldState.snackbarHostState.showSnackbar("you pressed the $it")
        }
    }
    }, scaffoldState = scaffoldState){}
}