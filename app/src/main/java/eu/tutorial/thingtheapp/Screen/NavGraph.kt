package eu.tutorial.thingtheapp.Screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = ScreenManager.MainView.route) {
        composable(
            route = ScreenManager.MainView.route
        ){
            MainContent(navController = navController)
        }
        composable(
            route = ScreenManager.DisplayUserChosen.route
        ){
            DisplayUserChosenContent()
        }
    }
}