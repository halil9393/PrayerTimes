package ui

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import data.MDay
import database.MDayDao
import di.appModule
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.core.KoinApplication

@Composable
@Preview
fun App() {
    MaterialTheme {
        //val mDay by mDayDao.getAllMDay().collectAsState(initial = emptyList())
        val scope = rememberCoroutineScope()
        LaunchedEffect(true){
            val mDayList = listOf(
                MDay(Aksam = "123"),
                MDay(Aksam = "345"),
                MDay(Aksam = "678")
            )

            mDayList.forEach {
                //mDayDao.insert(it)
            }
            println("database room")

            scope.launch {
                //mDayDao.getAllMDay().collect{
                //  it.forEach {
                //println(it)
                //}
                //}
            }
        }
        AppNavigation()
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