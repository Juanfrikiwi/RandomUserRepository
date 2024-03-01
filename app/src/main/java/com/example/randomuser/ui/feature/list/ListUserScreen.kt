package com.example.randomuser.ui.feature.list

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.randomuser.data.models.Results
import com.example.randomuser.data.models.UserInfo
import com.example.randomuser.ui.components.ErrorGetUsersContent
import com.example.randomuser.ui.components.ListContent
import com.example.randomuser.ui.components.StartStateContent
import com.example.randomuser.ui.components.TopBars
import com.example.randomuser.ui.components.LoadingContent
import com.example.randomuser.utils.receive


enum class StateListUserScreen(var value: String) {
    StartState("START_STATE"),
    LoadingState("LOADING_STATE"),
    ListScreenState("LIST_SCREEN_STATE"),
    GetUserErrorState("GET_USER_ERROR_STATE");
}

@Composable
fun ListUserScreen(
    context: Context,
    navHostController: NavHostController,
    callbackIsDetailTheme: (Boolean) -> Unit,
    viewModel: ListUserViewModel = hiltViewModel(),
) {
    callbackIsDetailTheme(false)

    var screenState = remember {
        mutableStateOf(StateListUserScreen.StartState)
    }

    var usersList by remember {
        mutableStateOf(mutableStateOf<UserInfo?>(null))
    }
    var isLoading by remember {
        mutableStateOf(mutableStateOf<Boolean>(false))
    }

    viewModel.uiState.receive<UiState, UiState.StartState> {
        screenState.value = StateListUserScreen.StartState
    }

    viewModel.uiState.receive<UiState, UiState.LoadingState> {
        screenState.value = StateListUserScreen.LoadingState
    }

    viewModel.uiState.receive<UiState, UiState.GetUserSuccessfulState> {
        screenState.value = StateListUserScreen.ListScreenState
        usersList.value = it.usersList
    }

    viewModel.uiState.receive<UiState, UiState.GetUserErrorState> {
        screenState.value = StateListUserScreen.GetUserErrorState

    }

    var isShowSearchBar by remember {
        mutableStateOf(mutableStateOf(false))
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            if (screenState.value != StateListUserScreen.StartState) {
                TopBars().ListUserTopBar(
                    callbackBackButtonClicked = {
                        screenState.value = StateListUserScreen.StartState
                    },
                    callbackSearchUser = {
                        isShowSearchBar.value = true
                    }
                )
            }
        }
    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            ListUserScreenContent(
                context = context,
                navHostController = navHostController,
                viewModel = viewModel,
                usersList = usersList.value?.results,
                isShowSearchBar = isShowSearchBar,
                screenState = screenState.value
            )
        }
    }
}


@Composable
fun ListUserScreenContent(
    context: Context,
    navHostController: NavHostController,
    viewModel: ListUserViewModel,
    usersList: List<Results>?,
    isShowSearchBar: MutableState<Boolean>,
    screenState: StateListUserScreen,
) {
    var list by remember {
        mutableStateOf(mutableStateOf<List<Results>>(arrayListOf()))
    }
    if (usersList != null) {
        list.value = usersList.distinct().sortedBy { it.name.first }
    }
    when (screenState.value) {
        StateListUserScreen.StartState.value -> {
            StartStateContent(viewModel = viewModel)
        }

        StateListUserScreen.LoadingState.value -> {
            LoadingContent()
        }

        StateListUserScreen.ListScreenState.value -> {
            usersList?.let {
                ListContent(
                    context = context,
                    navHostController = navHostController,
                    listFiltered = list.value,
                    listComplete = it,
                    showSearchBar = isShowSearchBar.value,
                    callbackCloseButtonSearchBar = {
                        isShowSearchBar.value = false
                    }
                )
            }
        }
        StateListUserScreen.GetUserErrorState.value -> {
            ErrorGetUsersContent {
                viewModel.changeToState(UiState.StartState)
            }
        }
    }
}

