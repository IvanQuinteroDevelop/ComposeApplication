package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.composeapplication.components.basics.*
import com.example.composeapplication.ui.CheckInfo
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
                    Column(
                        Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())) {

                        MyImageAdvance()
                        var mText by rememberSaveable {
                            mutableStateOf("Navi")
                        }
                        MyOutLinedTextField(name = mText) {
                            mText = it
                        }
                        MyAdvancedTextField()
                        val myOptionsList = getOptions(titles = listOf("option 1", "option 2", "option 3"))
                        myOptionsList.forEach {
                            MyCheckBoxWithTextCompleted(checkInfo = it)
                        }
                        MySwitch()
                        Greeting(name = mText)
                        MyButtonExample()
                        MyProgress()
                        MyProgressAdvance()
                    }
                }
            }
        }
    }

    @Composable
    fun getOptions(titles: List<String>): List<CheckInfo> {
        return titles.map {
            var status by rememberSaveable { mutableStateOf(false) }
            CheckInfo(
                title = it,
                selected = status,
                onCheckedChange = { newStatus -> status = newStatus }
            )
        }
    }
}
