package com.marketplace.gettako.ui.screens.splashscreen

import androidx.lifecycle.viewModelScope
import com.marketplace.gettako.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

/**
 * Created by Mushegh Sahakyan on 2/14/2022.
 */
class SplashScreenViewModel : BaseViewModel() {

    private val _endDelay by lazy { MutableSharedFlow<Boolean>() }
    val endDelay: SharedFlow<Boolean> get() = _endDelay

    init {
        setDelay()
    }
    private fun setDelay() {
        viewModelScope.launch {
            delay(2000)
            _endDelay.tryEmit(true)
        }
    }
}