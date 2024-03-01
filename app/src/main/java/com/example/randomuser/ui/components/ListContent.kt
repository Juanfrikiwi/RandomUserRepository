package com.example.randomuser.ui.components

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.randomuser.data.models.Results

@Composable
fun ListContent(
    context: Context,
    navHostController: NavHostController,
    listFiltered: List<Results>,
    listComplete: List<Results>,
    showSearchBar: Boolean,
    callbackCloseButtonSearchBar : () -> Unit
) {
    val listUsers = remember {
        mutableStateOf(listFiltered)
    }

    if (showSearchBar) {
        MySearchBar(list = listUsers.value,
            callbackSearchList = {
                listUsers.value = it
            },
            callbackCloseButton = {
                callbackCloseButtonSearchBar()
                if (listComplete != null) {
                    listUsers.value = listComplete
                }
            }
        )
    }

    Row {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp)
        ) {
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp, bottom = 8.dp),
                columns = GridCells.Fixed(1)
            ) {
                items(items = listUsers.value) { user ->
                    UserItemList(context, navController = navHostController, user = user)
                }
            }
        }
    }
}

