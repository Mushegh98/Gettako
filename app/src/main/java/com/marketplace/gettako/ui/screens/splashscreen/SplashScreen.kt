package com.marketplace.gettako.ui.screens.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.marketplace.gettako.R
import com.marketplace.gettako.ui.navigation.VIEW_PAGER_SPLASH_SCREEN_ROUTER
import org.koin.androidx.compose.getViewModel

/**
 * Created by Mushegh Sahakyan on 2/14/2022.
 */
@Composable
fun SplashScreen(
    navController: NavController,
) {
    val viewModel = getViewModel<SplashScreenViewModel>()
    val state: State<Boolean> = viewModel.endDelay.collectAsState(false)
    SplashScreenUI(
        navController = navController,
        state = state
    )
}

@Composable
fun SplashScreenUI(
    navController: NavController,
    state: State<Boolean>
) {
    if (state.value) {
        navigateToNextSplashScreen(navController = navController)
    } else {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_splash_screen_gettako_icon),
                contentDescription = "GettakoIcon"
            )
            Image(
                painter = painterResource(id = R.drawable.ic_splash_screen_gettako_text),
                contentDescription = "GettakoText",
                Modifier.padding(
                    top = 29.dp
                )
            )
        }
    }
}

fun navigateToNextSplashScreen(navController: NavController) {
    navController.navigate(VIEW_PAGER_SPLASH_SCREEN_ROUTER)
}

@Composable
@Preview
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())
}