package com.example.composeapplication.components.recycler

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true)
@Composable
fun SimpleRecyclerView () {
    val myList = listOf("Navi", "Aris", "Pepe", "Ivan")
    LazyColumn{
        item { Text(text = "First item") }
        item { Text(text = "Second item") }
        item { Text(text = "Third item") }
        item { Text(text = "Fourth item") }
        items(7) {
            Text(text = "This is the item number ${it+1}")
        }
        items(myList) {
            Text(text = "Hola me llamo $it")
        }
    }
}