package com.example.randomuser.ui.navigation

sealed class AppScreens(val route: String) {
    data object ListUserScreen : AppScreens(route = "listUserScreen")
    data object DetailUserScreen : AppScreens(route = "detailUserScreen")


}