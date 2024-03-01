package com.example.randomuser

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.randomuser.ui.navigation.AppNavigation
import com.example.randomuser.ui.theme.RandomUserTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            val isDetailTheme = remember {
                mutableStateOf(false)
            }
            val navController = rememberNavController()
            RandomUserTheme(isThemeDetail = isDetailTheme.value) {
                //ChangeTheme(isThemeDetail = isDetailTheme.value)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    AppNavigation(context = applicationContext,
                        navHostController = navController,
                        callbackIsDetailTheme = {
                            isDetailTheme.value = it
                        }
                    )
                }
            }
        }
    }
}
