package com.example.composeapplication.components.basics

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyBadgeBox() {
    BadgedBox(badge = {
        Badge { Text(text = "4") }
    },
        Modifier.padding(12.dp),
        content = {
            Icon(imageVector = Icons.Rounded.Email, contentDescription = "badge")
        })
}