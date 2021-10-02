package ru.spbstu_software_design_project.rickandmorty.domain.usecase

import ru.spbstu_software_design_project.rickandmorty.domain.repository.CharactersRepository
import ru.spbstu_software_design_project.rickandmorty.presentation.model.CharacterCard

class ReplaceFromFavouritesUseCase(
    private val charactersRepository: CharactersRepository
) {
    operator fun invoke(characterCard: CharacterCard) {
        charactersRepository.replaceCharacterFromFavourite()
    }
}