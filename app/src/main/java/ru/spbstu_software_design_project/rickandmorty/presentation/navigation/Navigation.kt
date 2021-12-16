package ru.spbstu_software_design_project.rickandmorty.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.spbstu_software_design_project.rickandmorty.presentation.detail.DetailScreen
import ru.spbstu_software_design_project.rickandmorty.presentation.list.ListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController(ComposeNavigator())

    NavHost(navController = navController, startDestination = Screen.CharactersList.route) {
        composable(route = Screen.CharactersList.route) {
            ListScreen(navController = navController)
        }

        composable(
            route = Screen.DetailScreen.route + "/{id}",
            arguments = listOf(navArgument("id") {
                type = NavType.StringType
                defaultValue = "-1"
                nullable = true
            })
        ) { entry ->
            DetailScreen(
                id = entry.arguments?.getString(Screen.DETAIL_ID_KEY).toString().toInt(),
                navController = navController
            )
        }


    }
}