package com.example.composeapplication.components.basics

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composeapplication.R

@Preview
@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Example 1",
        modifier = Modifier.clip(RoundedCornerShape(12f)),
        alpha = 0.5f
    )
}

@Preview(showSystemUi = true)
@Composable
fun MyImageAdvance() {
    ConstraintLayout(Modifier.padding(8.dp)) {
        val mainImage = createRef()
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Example 2",
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, Color.LightGray, CircleShape)
                .constrainAs(mainImage) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}

@Preview
@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Rounded.Star, contentDescription = "Icon")
}