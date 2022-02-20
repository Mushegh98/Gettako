package com.marketplace.gettako.ui.screens.splashscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.marketplace.gettako.R
import com.marketplace.gettako.ui.navigation.VIEW_PAGER_SPLASH_SCREEN_ROUTER
import kotlinx.coroutines.delay

/**
 * Created by Mushegh Sahakyan on 2/14/2022.
 */
@Composable
fun SplashScreen(
    navController: NavController,
) {
    SplashScreenUI(
        navController = navController
    )
}


@Composable
fun SplashScreenUI(
    navController: NavController
) {
    val constrainSet = ConstraintSet {
        val gettakoIcon = createRefFor("gettakoIcon")
        val gettakoText = createRefFor("gettakoText")
        val spacer = createRefFor("spacer")
        val guidelineTopGettakoIcon = createGuidelineFromTop(0.29f)
        constrain(gettakoIcon) {
            top.linkTo(guidelineTopGettakoIcon)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.percent(0.35f)
            height = Dimension.percent(0.153f)
        }
        constrain(spacer) {
            top.linkTo(gettakoIcon.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            height = Dimension.percent(0.037f)
        }
        constrain(gettakoText) {
            top.linkTo(spacer.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.percent(0.61f)
            height = Dimension.percent(0.08f)
        }
    }
    ConstraintLayout(
        constraintSet = constrainSet,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            modifier = Modifier
                .layoutId("gettakoIcon"),
            painter = painterResource(id = R.drawable.ic_splash_screen_gettako_icon),
            contentDescription = "GettakoIcon"
        )
        Spacer(
            modifier = Modifier
                .layoutId("spacer")
        )
        Image(
            painter = painterResource(id = R.drawable.ic_splash_screen_gettako_text),
            contentDescription = "GettakoText",
            modifier = Modifier
                .layoutId("gettakoText")
        )
    }
    LaunchedEffect(key1 = true) {
        delay(2000)
        navigateToNextSplashScreen(navController = navController)
    }
}


//@Composable
//fun SplashScreenUI(
//    navController: NavController,
//    state: State<Boolean>
//) {
//    if (state.value) {
//        navigateToNextSplashScreen(navController = navController)
//    } else {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Spacer(
//                modifier = Modifier
//                    .fillMaxHeight(0.29f)
//            )
//            Image(
//                modifier = Modifier
//                    .layoutId("gettakoIcon")
//                    .fillMaxWidth(0.35f)
//                    .fillMaxHeight(0.153f),
//                painter = painterResource(id = R.drawable.ic_splash_screen_gettako_icon),
//                contentDescription = "GettakoIcon"
//            )
//            Spacer(
//                modifier = Modifier
//                    .layoutId("spacer")
//                    .fillMaxHeight(0.037f)
//            )
//            Image(
//                painter = painterResource(id = R.drawable.ic_splash_screen_gettako_text),
//                contentDescription = "GettakoText",
//                modifier = Modifier
//                    .layoutId("gettakoText")
//                    .fillMaxWidth(0.61f)
//                    .fillMaxHeight(0.08f)
//            )
//        }
//
//    }
//}

//@Composable
//fun SplashScreenUI(
//    navController: NavController,
//    state: State<Boolean>
//) {
//    if (state.value) {
//        navigateToNextSplashScreen(navController = navController)
//    } else {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White)
//        ) {
//            Spacer(
//                modifier = Modifier
//                    .fillMaxHeight(0.288f),
//            )
//            Image(
//                modifier = Modifier
//                    .fillMaxWidth(0.35f)
//                    .fillMaxHeight(0.153f),
//                painter = painterResource(id = R.drawable.ic_splash_screen_gettako_icon),
//                contentDescription = "GettakoIcon",
//                alignment = Alignment.Center
//            )
//            Image(
//                painter = painterResource(id = R.drawable.ic_splash_screen_gettako_text),
//                contentDescription = "GettakoText",
//                modifier = Modifier
//                    .padding(top = 29.dp)
//                    .fillMaxWidth(0.61f)
//                    .fillMaxHeight(0.08f)
//            )
//        }
//    }
//}

fun navigateToNextSplashScreen(navController: NavController) {
    navController.navigate(VIEW_PAGER_SPLASH_SCREEN_ROUTER)
}

@Composable
@Preview
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())
}