package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
                            .padding(8.dp)
                            .verticalScroll(rememberScrollState())) {
                        var mText by rememberSaveable {
                            mutableStateOf("Navi")
                        }
                        MyBadgeBox()
                        Card(
                            Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(8.dp), elevation = 8.dp) {
                                MyImageAdvance()
                        }

                        MyOutLinedTextField(name = mText) {
                            mText = it
                        }
                        MyDivider()
                        MyAdvancedTextField()
                        val myOptionsList = getOptions(titles = listOf("option 1", "option 2", "option 3"))
                        MyTriStateCheckBox()
                        var name by rememberSaveable {
                            mutableStateOf("Ivan")
                        }
                        myOptionsList.forEach {
                            MyCheckBoxWithTextCompleted(checkInfo = it)
                        }
                        MyRadioButtonList(name = name, onSelected = {
                            name = it
                        })

                        MyRadioButton()
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
