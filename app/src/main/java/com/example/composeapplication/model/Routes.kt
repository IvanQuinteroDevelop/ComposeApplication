package com.example.composeapplication.model

sealed class Routes(val route: String) {
    object FirstScreen: Routes("first_screen")
    object SecondScreen: Routes("second_screen")
    object ThirdScreen: Routes("third_screen")
    object FourthScreen: Routes("fourth_screen"){
        fun createRoute(age: Int) = "fourth_screen/$age"
    }
    object FifthScreen: Routes("fifth_screen?name={name}"){
        fun createRoute(name:String) = "fifth_screen?name=$name"
    }
}
