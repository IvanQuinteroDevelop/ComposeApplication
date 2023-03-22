package com.example.composeapplication.components.basics

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

@Composable
fun MyDialog(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {
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