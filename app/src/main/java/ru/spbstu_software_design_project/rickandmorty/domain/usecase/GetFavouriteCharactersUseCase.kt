package ru.spbstu_software_design_project.rickandmorty.domain.usecase

import ru.spbstu_software_design_project.rickandmorty.domain.repository.CharactersRepository
import ru.spbstu_software_design_project.rickandmorty.presentation.model.CharacterCard

class GetFavouriteCharactersUseCase(
    private val charactersRepository: CharactersRepository
) {
    operator fun invoke(): List<CharacterCard> {
        return charactersRepository.getFavouriteCharacters()
    }
}