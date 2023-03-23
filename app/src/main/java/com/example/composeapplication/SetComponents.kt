package com.example.composeapplication

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeapplication.components.basics.*
import com.example.composeapplication.ui.CheckInfo

@Composable
fun AddComponents() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(rememberScrollState())
    ) {
        var mText by rememberSaveable {
            mutableStateOf("Navi")
        }
        MyBadgeBox()
        Card(
            Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp), elevation = 8.dp
        ) {
            MyImageAdvance()
        }

        MyOutLinedTextField(name = mText) {
            mText = it
        }
        MyDropDownMenu()
        MyDivider()
        MyAdvancedTextField()
        MyProgressAdvance()
        MyAdvanceSlider()
        MyRangeSlider()
        val myOptionsList =
            getOptions(titles = listOf("option 1", "option 2", "option 3", "Option 4"))
        MyTriStateCheckBox()
        var name by rememberSaveable {
            mutableStateOf("Ivan")
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Box {
                Column {
                    myOptionsList.forEach {
                        MyCheckBoxWithTextCompleted(checkInfo = it)
                    }
                }
            }
            MyRadioButtonList(name = name, onSelected = {
                name = it
            })
        }

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            MyRadioButton()
            MySwitch()
        }
        Greeting(name = mText)
        MyButtonExample()
        MyProgress()
        var showDialog by rememberSaveable {
            mutableStateOf(false)
        }
        var showSimpleCustomDialog by rememberSaveable {
            mutableStateOf(false)
        }
        var showCustomDialog by rememberSaveable {
            mutableStateOf(false)
        }
        var showConfirmDialog by rememberSaveable {
            mutableStateOf(false)
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = {
                showDialog = true
            }) {
                Text(text = "Dialog")
            }
            Button(onClick = {
                showSimpleCustomDialog = true
            }) {
                Text(text = "SimpleCustomDialog")
            }
            MyAlertDialog(show = showDialog,
                onDismiss = {
                    showDialog = false
                }, onConfirm = {
                    showDialog = false
                    Log.i("Dialog", "Confirm button pressed")
                })
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {

            Button(onClick = {
                showCustomDialog = true
            }) {
                Text(text = "CustomDialog")
            }
            Button(onClick = {
                showConfirmDialog = true
            }) {
                Text(text = "ConfirmDialog")
            }
        }

        MySimpleCustomDialog(show = showSimpleCustomDialog, onDismiss = {
            showSimpleCustomDialog = false
        })
        MyCustomDialog(show = showCustomDialog, onDismiss = {
            showCustomDialog = false
        })
        Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            MyConfirmationDialog(show = showConfirmDialog, onDismiss = {
                showConfirmDialog = false
            })
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