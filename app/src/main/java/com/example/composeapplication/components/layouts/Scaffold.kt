package com.example.composeapplication.components.layouts

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapplication.components.basics.MyBottomNavigation
import com.example.composeapplication.components.basics.MyTopAppBar
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showSystemUi = true)
@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = {
        MyTopAppBar {
            coroutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar("you pressed the $it")
            }
        }
    }, scaffoldState = scaffoldState, bottomBar = { MyBottomNavigation() }) {}
}