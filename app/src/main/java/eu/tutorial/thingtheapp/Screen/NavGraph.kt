package eu.tutorial.thingtheapp.Screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import eu.tutorial.thingtheapp.Model.User

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
            route = "${ScreenManager.DisplayUserChosen.route}/{user}", arguments = listOf(
                        navArgument("user") {
                            type = NavType.StringArrayType
                        }
                    )
        ){
                backStackEntry ->
            val userSetNameArray = backStackEntry.arguments?.getStringArray("user")
            val userSet = userSetNameArray?.map { name ->
                User(login = name)
            }?.toSet()

            DisplayUserChosenContent(userSet = userSet)
        }
    }
}