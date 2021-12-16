package ru.spbstu_software_design_project.rickandmorty.presentation.navigation

sealed class Screen(val route: String) {
    object CharactersList: Screen("character_list")
    object DetailScreen: Screen("character_detail")

    companion object {
        const val DETAIL_ID_KEY = "id"
    }

    fun withArgs(vararg arg: String) : String {
        return buildString {
            append(route)
            arg.forEach { argum ->
                append("/$argum")
            }
        }
    }
}