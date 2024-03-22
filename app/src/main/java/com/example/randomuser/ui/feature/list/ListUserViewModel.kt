package com.example.randomuser.ui.feature.list

import androidx.lifecycle.viewModelScope
import com.example.randomuser.domain.usecase.GetUsersUseCase
import com.example.randomuser.utils.ComposeViewModel
import com.example.randomuser.utils.receive
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListUserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) :
    ComposeViewModel<UiIntent, UiState>(UiState.StartState) {
    override fun sendIntent(intent: UiIntent) {
        intent.receive<UiIntent, UiIntent.GetUserIntent> {
            uiState = UiState.LoadingState
            viewModelScope.launch {
                getUsersUseCase(numUsers = it.numUsers).collect{
                    uiState = if (it == null) {
                        UiState.GetUserErrorState
                    } else UiState.GetUserSuccessfulState(it.body())
                }

            }
        }
    }

    fun changeToState(state: UiState){
        uiState = state
    }
}