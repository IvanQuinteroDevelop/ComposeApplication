package com.example.composeapplication.components.basics

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    val optionList = listOf("first option", "second option", "third option", "fourth option")
    Column(Modifier.padding(8.dp)) {
        optionList.forEach {
            Text(text = it, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp).clickable { onCloseDrawer() })
        }
    }
}