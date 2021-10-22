package ru.spbstu_software_design_project.rickandmorty.domain.usecase

import ru.spbstu_software_design_project.rickandmorty.domain.repository.CharactersRepository

class ReplaceFromFavouritesUseCase(
    private val charactersRepository: CharactersRepository
) {
    operator fun invoke() {
        charactersRepository.replaceCharacterFromFavourite()
    }
}