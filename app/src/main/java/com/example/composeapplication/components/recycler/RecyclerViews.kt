package com.example.composeapplication.components.recycler

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapplication.R
import com.example.composeapplication.model.SuperHero
import kotlinx.coroutines.launch

@Preview(showSystemUi = true)
@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Navi", "Aris", "Pepe", "Ivan")
    LazyColumn {
        item { Text(text = "First item") }
        item { Text(text = "Second item") }
        item { Text(text = "Third item") }
        item { Text(text = "Fourth item") }
        items(7) {
            Text(text = "This is the item number ${it + 1}")
        }
        items(myList) {
            Text(text = "Hello my name is $it")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHero()) { superHero ->
            ItemHero(superHero = superHero) {
                Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showSystemUi = true)
@Composable
fun SuperHeroStickyView() {
    val context = LocalContext.current
    val superHero: Map<String, List<SuperHero>> = getSuperHero().groupBy { it.publisher }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        superHero.forEach { (publisher, mySuperHero) ->
            stickyHeader {
                Text(
                    text = publisher,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF394B63))
                        .padding(12.dp),
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
            items(mySuperHero) { superHero ->
                ItemHero(superHero = superHero) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SuperHeroSpecialControlView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxWidth()) {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHero()) { superHero ->
                ItemHero(superHero = superHero) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_SHORT).show()
                }
            }
        }
        val showButton by remember {
            derivedStateOf { rvState.firstVisibleItemIndex > 0 }
        }
        if (showButton) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        rvState.animateScrollToItem(0)
                    }
                }, modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Back to top")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(getSuperHero()) { superHero ->
            ItemHero(superHero = superHero) {
                Toast.makeText(context, superHero.superHeroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}


@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(border = BorderStroke(2.dp, Color.Red), modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemSelected(superHero) }
        .padding(8.dp)) {
        Column() {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "SuperHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.superHeroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName, fontSize = 12.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(6.dp)
            )
        }
    }
}

fun getSuperHero(): List<SuperHero> {
    return listOf(
        SuperHero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        SuperHero("Thor", "Thor Odison", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        SuperHero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman),
        SuperHero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        SuperHero("Thor", "Thor Odison", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        SuperHero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman)
    )
}