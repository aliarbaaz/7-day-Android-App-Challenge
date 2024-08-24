package com.android.engineer.mealmate.view.utils.constants.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.android.engineer.mealmate.view.features.auth.LoginScreen
import com.android.engineer.mealmate.view.features.auth.SignupScreen
import com.android.engineer.mealmate.view.features.auth.StartScreen
import com.android.engineer.mealmate.view.utils.constants.AUTHENTICATION
import com.android.engineer.mealmate.view.utils.constants.sealed_constants.AuthScreen

fun NavGraphBuilder.authNavGraph(navHostController: NavHostController) {
    navigation(
        route = AUTHENTICATION,
        startDestination = AuthScreen.Start.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navHostController = navHostController)
        }
        composable(route = AuthScreen.Start.route) {
            StartScreen(navHostController = navHostController)
        }
        composable(route = AuthScreen.Signup.route) {
            SignupScreen(navHostController = navHostController)
        }
    }
}