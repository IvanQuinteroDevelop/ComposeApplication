package com.example.composeapplication.components.basics

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MySwitch() {
    var myState by rememberSaveable {
        mutableStateOf(true)
    }
    Row {
        Text(text = "Switch", Modifier.align(Alignment.CenterVertically))
        WidthSpacer(size = 8)
        Switch(
            checked = myState, onCheckedChange = { myState = !myState },
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.Red,
                checkedThumbColor = Color.Green,
                uncheckedTrackColor = Color.Magenta,
                checkedTrackColor = Color.Cyan
            )
        )
    }
}