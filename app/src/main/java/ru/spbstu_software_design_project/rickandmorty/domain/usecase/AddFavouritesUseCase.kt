package ru.spbstu_software_design_project.rickandmorty.domain.usecase

import ru.spbstu_software_design_project.rickandmorty.domain.repository.CharactersRepository

class AddFavouritesUseCase(
    private val charactersRepository: CharactersRepository
) {
    operator fun invoke() {
        charactersRepository.insertCharactersToFavourite()
    }
}