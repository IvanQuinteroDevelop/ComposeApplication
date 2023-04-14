package com.example.composeapplication.components.layouts

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.example.composeapplication.AddComponents
import com.example.composeapplication.components.basics.MyBottomNavigation
import com.example.composeapplication.components.basics.MyDrawer
import com.example.composeapplication.components.basics.MyFAB
import com.example.composeapplication.components.basics.MyTopAppBar
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldExample(navigationController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopAppBar(onClickIcon = {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("you pressed the $it")
                }
            }, onClickDrawer = {
                coroutineScope.launch {
                    scaffoldState.drawerState.open()
                }
            })
        },
        scaffoldState = scaffoldState,
        bottomBar = { MyBottomNavigation() },
        floatingActionButton = { MyFAB(navigationController) },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        drawerGesturesEnabled = false,
        drawerContent = { MyDrawer() { coroutineScope.launch { scaffoldState.drawerState.close() }} }
    ) {
        AddComponents()
    }
}