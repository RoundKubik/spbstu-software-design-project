package ru.spbstu_software_design_project.rickandmorty.domain.model

data class Character(
    val id: Int = 0,
    val imageUrl: String = "",
    val name: String = "",
    val status: String = "",
    val species: String = "",
    val location: String = "",
    val origin: String = "",
    val gender: String = "",
    var isLiked: Boolean = false
)