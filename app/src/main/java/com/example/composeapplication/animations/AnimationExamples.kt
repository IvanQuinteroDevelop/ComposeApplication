package com.example.composeapplication.animations

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
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
import kotlin.random.Random.Default.nextInt

@Preview(showSystemUi = true)
@Composable
fun ColorAnimationSimple() {
    var firstColor by rememberSaveable {
        mutableStateOf(false)
    }
    var showBox by rememberSaveable {
        mutableStateOf(true)
    }
    val currentColor by animateColorAsState(
        targetValue = if (firstColor) Color.Red else Color.Yellow,
        animationSpec = tween(durationMillis = 2000),
        finishedListener = { showBox = !showBox }
    )
    if (showBox) {
        Box(
            Modifier
                .size(100.dp)
                .background(currentColor)
                .clickable { firstColor = !firstColor })
    }
}

@Preview
@Composable
fun SizeAnimation() {
    var smallSize by rememberSaveable {
        mutableStateOf(true)
    }
    var showText by rememberSaveable {
        mutableStateOf(true)
    }
    val size by animateDpAsState(
        targetValue = if (smallSize) 80.dp else 120.dp,
        animationSpec = tween(durationMillis = 500),
        finishedListener = { showText = false }
    )
    Box(
        Modifier
            .size(size)
            .padding(8.dp)
            .background(Color.Cyan)
            .clickable { smallSize = !smallSize }) {
        if (!showText) {
            Text(text = "Hello world")
        }
    }
}

@Preview
@Composable
fun VisibilityAnimation() {
    var isVisible by rememberSaveable {
        mutableStateOf(true)
    }
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Show/Hide")
        }
        Spacer(modifier = Modifier.size(16.dp))
        AnimatedVisibility(
            isVisible,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally()
        ) {
            Box(
                Modifier
                    .size(150.dp)
                    .background(Color.Red)
            )
        }
    }
}

@Preview
@Composable
fun CrossFadeExampleAnimation() {
    var myComponentType: ComponentType by rememberSaveable {
        mutableStateOf(ComponentType.Text)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Button(onClick = { myComponentType = getComponentTypeRandom() }) {
            Text(text = "Change component")
        }

        Crossfade(targetState = myComponentType) {

            when (it) {
                ComponentType.Text -> Text(text = "I'm a component")
                ComponentType.Image -> Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "image"
                )
                ComponentType.Box -> Box(
                    modifier = Modifier
                        .size(150.dp)
                        .background(Color.Green)
                )
                ComponentType.Error -> Text(text = "Error")
            }
        }
    }
}

fun getComponentTypeRandom(): ComponentType {
    return when (nextInt(from = 0, until = 3)) {
        0 -> ComponentType.Text
        1 -> ComponentType.Image
        2 -> ComponentType.Box
        else -> ComponentType.Error
    }
}

enum class ComponentType {
    Image, Text, Box, Error
}