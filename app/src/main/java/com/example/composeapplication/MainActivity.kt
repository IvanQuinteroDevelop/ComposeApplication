package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.composeapplication.components.basics.*
import com.example.composeapplication.components.layouts.ConstraintLayoutExample1
import com.example.composeapplication.components.layouts.MyComplexLayout
import com.example.composeapplication.components.states.MyStateExample
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    /* comment all the ones below except
                    the one you want to see when running the app */
                    var mText by remember {
                        mutableStateOf("Ivancho")
                    }
                        MyBoxes()
                        MyColumn()
                        MyRow()
                        MyComplexLayout()
                        ConstraintLayoutExample1()
                        MyStateExample()
                        Greeting(name = "Ivan")
                        MyTextField()
                        MyAdvancedTextField()
                        MyOutLinedTextField(name = mText) {
                            mText = it
                        }
                }
            }
        }
    }
}
