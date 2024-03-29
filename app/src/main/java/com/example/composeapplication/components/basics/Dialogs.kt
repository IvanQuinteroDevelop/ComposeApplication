package com.example.composeapplication.components.basics

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyAlertDialog(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    if (show) {
        AlertDialog(onDismissRequest = { onDismiss() },
            title = { Text(text = "Dialog title") },
            text = { Text(text = "Hello i am the description of the dialog") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirm button")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Cancel button")
                }
            })
    }
}

@Composable
fun MySimpleCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {

        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "This is an example")
                Button(onClick = { onDismiss() }, modifier = Modifier.align(Alignment.End)) {
                    Text(text = "Ok")
                }
            }
        }
    }
}

@Composable
fun MyCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {

        Dialog(
            onDismissRequest = { onDismiss() }
        ) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog(text = "Set backup account")
                AccountItem(
                    email = "example1@mail.com",
                    drawable = com.example.composeapplication.R.drawable.profile
                )
                AccountItem(
                    email = "example2@mail.com",
                    drawable = com.example.composeapplication.R.drawable.profile
                )
                AccountItem(
                    email = "add account",
                    drawable = com.example.composeapplication.R.drawable.add
                )

            }
        }
    }
}

@Composable
fun MyConfirmationDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                MyTitleDialog(text = "Phone ringtone", Modifier.padding(18.dp))
                Divider(Modifier.fillMaxWidth(), Color.LightGray)
                var status by rememberSaveable {
                    mutableStateOf("")
                }
                MyRadioButtonList(name = status, onSelected = { status = it })
                Divider(Modifier.fillMaxWidth(), Color.LightGray)
                Row(Modifier.align(Alignment.End)) {
                    TextButton(onClick = {}) {
                        Text(text = "Cancel")
                    }
                    TextButton(onClick = {}) {
                        Text(text = "Ok")
                    }
                }
            }
        }
    }
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun MyTitleDialog(text: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}