package com.marketplace.gettako.di

import com.marketplace.gettako.ui.screens.splashscreen.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Mushegh Sahakyan on 2/14/2022.
 */
val viewModelModule = module {
    viewModel<SplashScreenViewModel>()
}