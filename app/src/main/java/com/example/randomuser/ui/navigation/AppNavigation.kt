package com.example.randomuser.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.randomuser.ui.feature.detail.DetailUserScreen
import com.example.randomuser.ui.feature.list.ListUserScreen

@Composable
fun  AppNavigation(
    context:Context,
    navHostController:NavHostController,
    callbackIsDetailTheme: (Boolean) -> Unit,
) {
    NavHost(navController = navHostController, startDestination = AppScreens.ListUserScreen.route ){
       composable(AppScreens.ListUserScreen.route) {
           ListUserScreen(context = context, navHostController = navHostController, callbackIsDetailTheme = callbackIsDetailTheme)
       }
        composable(AppScreens.DetailUserScreen.route) {
            DetailUserScreen(context = context, navHostController = navHostController, callbackIsDetailTheme = callbackIsDetailTheme)
        }

    }

}