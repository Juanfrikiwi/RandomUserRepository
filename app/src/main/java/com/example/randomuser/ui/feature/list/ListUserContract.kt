package com.example.randomuser.ui.feature.list

import com.example.randomuser.data.models.UserInfo


sealed interface UiState {
    data object LoadingState : UiState
    data object StartState : UiState

    data object GetUserErrorState : UiState

    class GetUserSuccessfulState(val usersList: UserInfo?) : UiState

    }

    sealed interface UiIntent {
        class GetUserIntent(val numUsers:Int) : UiIntent
    }