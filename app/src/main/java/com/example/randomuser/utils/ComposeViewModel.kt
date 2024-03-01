package com.example.randomuser.utils

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

@Suppress("MemberVisibilityCanBePrivate", "unused")
abstract class ComposeViewModel<I, S>(initialState: S) : ViewModel() {

    var uiState by mutableStateOf(initialState)
        protected set

    abstract fun sendIntent(intent: I)

}