package ru.spbstu_software_design_project.rickandmorty.domain.usecase

import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.repository.CharactersRepository

class GetFavouriteCharactersUseCase(
    private val charactersRepository: CharactersRepository
) {
    operator fun invoke(): List<Character> {
        return charactersRepository.getFavouriteCharacters()
    }
}