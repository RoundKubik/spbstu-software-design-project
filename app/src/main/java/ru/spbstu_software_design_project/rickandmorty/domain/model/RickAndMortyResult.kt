package ru.spbstu_software_design_project.rickandmorty.domain.model
sealed class RickAndMortyResult<T> {
    data class Success<T>(val data: T): RickAndMortyResult<T>()
    data class Error<T>(val error: String): RickAndMortyResult<T>()
}