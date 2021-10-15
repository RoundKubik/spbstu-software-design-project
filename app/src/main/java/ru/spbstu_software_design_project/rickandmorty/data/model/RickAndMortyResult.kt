package ru.spbstu_software_design_project.rickandmorty.data.model

import ru.spbstu_software_design_project.rickandmorty.domain.model.ErrorEntity


/**
 * Class provides wrapping of result of working network requests
 */
sealed class RickAndMortyResult<T> {
    /**
     * Wrap success from network request
     */
    data class Success<T>(val data: T) : RickAndMortyResult<T>()

    /**
     * Wrap error by [ErrorEntity] if got exception from network
     */
    data class Error<T>(val error: ErrorEntity) : RickAndMortyResult<T>()
}