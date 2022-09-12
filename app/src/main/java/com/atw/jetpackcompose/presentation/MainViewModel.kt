package com.atw.jetpackcompose.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
     var textFieldState = MutableLiveData("")

    fun textFieldValueUpdated(newValue: String) {
        textFieldState.value = newValue
    }
}