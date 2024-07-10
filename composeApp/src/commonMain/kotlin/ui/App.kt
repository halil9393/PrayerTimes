package ui

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import di.appModule
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.core.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(appModule())
    }) {
        MaterialTheme {
            AppNavigation()
        }
    }

}

sealed class DestinationScreen(var route:String){
    object HomeScreen : DestinationScreen("HomeScreen")
    object SettingsScreen : DestinationScreen("SettingsScreen")
}

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = DestinationScreen.HomeScreen.route,
        enterTransition = {
            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left)
        },
        exitTransition = {
            slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Left)
        },
        popEnterTransition = {
            slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right)
        },
        popExitTransition = {
            slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right)
        }
    ){
        composable(DestinationScreen.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(DestinationScreen.SettingsScreen.route){
            SettingsScreen(navController)
        }
    }
}