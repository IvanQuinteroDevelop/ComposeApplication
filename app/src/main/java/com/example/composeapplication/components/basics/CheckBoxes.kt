package com.example.composeapplication.components.basics

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapplication.ui.CheckInfo

@Preview
@Composable
fun MyCheckbox() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Cyan,
            checkmarkColor = Color.Green
        )
    )
}

@Preview
@Composable
fun MyCheckBoxWithText() {
    var myState by rememberSaveable { mutableStateOf(false) }

    Row {
        Checkbox(checked = myState, onCheckedChange = {myState = !myState})
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "Example 1", Modifier.align(Alignment.CenterVertically))
    }
}


@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {

    Row {
        Checkbox(checked = checkInfo.selected, onCheckedChange = {checkInfo.onCheckedChange(!checkInfo.selected)})
        WidthSpacer(size = 4)
        Text(text = checkInfo.title, Modifier.align(Alignment.CenterVertically))
    }
}
