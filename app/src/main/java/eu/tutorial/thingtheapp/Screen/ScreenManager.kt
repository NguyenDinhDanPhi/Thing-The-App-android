package eu.tutorial.thingtheapp.Screen

sealed class ScreenManager(val route: String) {
    object MainView: ScreenManager(route = "main_view")
    object DisplayUserChosen: ScreenManager(route = "display_view")
}
