package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyBoxes()
                    MyColumn()
                }
            }
        }
    }
}


@Composable
fun MySuperText(name: String) {
    Text(
        text = "Hola $name <3", modifier = Modifier
            .padding(16.dp), color = Color.Black, fontSize = 24.sp
    )
}

@Preview(
    name = "Boxes",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 33,
    device = Devices.NEXUS_6
)
@Composable
fun MyBoxes() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), contentAlignment = Alignment.BottomCenter
    ) {
        Column(Modifier.verticalScroll(rememberScrollState()), verticalArrangement = Arrangement . SpaceBetween) {
            MyColumn()
            Box(
                modifier = Modifier
                    .background(Color.Blue)
                    .width(200.dp)
                    .height(100.dp)
                    .verticalScroll(
                        rememberScrollState()
                    ), Alignment.Center
            ) {
                MySuperText(name = "Ivan")
            }
        }
    }
}

@Preview(name = "Columns", showSystemUi = true)
@Composable
fun MyColumn() {
    Column() {
        Text("user 1", Modifier.background(Color.Magenta).fillMaxWidth().height(65.dp))
        Text("user 2", Modifier.background(Color.Red).fillMaxWidth().height(65.dp))
        Text("user 3", Modifier.background(Color.Green).fillMaxWidth().height(65.dp))
        Text("user 4", Modifier.background(Color.Yellow).fillMaxWidth().height(65.dp))
        Text("user 5", Modifier.background(Color.Cyan).fillMaxWidth().height(65.dp))
    }
}


