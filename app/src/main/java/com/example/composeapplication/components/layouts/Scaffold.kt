package com.example.composeapplication.components.layouts

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapplication.components.basics.MyTopAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showSystemUi = true)
@Composable
fun ScaffoldExample() {
    Scaffold(topBar = { MyTopAppBar()}){}
}