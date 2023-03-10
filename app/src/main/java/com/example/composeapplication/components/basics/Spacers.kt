package com.example.composeapplication

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HeightSpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun WidthSpacer(size: Int) {
    Spacer(modifier = Modifier.width(size.dp))
}