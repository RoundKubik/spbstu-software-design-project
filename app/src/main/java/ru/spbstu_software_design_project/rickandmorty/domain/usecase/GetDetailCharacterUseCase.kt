package ru.spbstu_software_design_project.rickandmorty.domain.usecase

import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.model.RickAndMortyResult
import ru.spbstu_software_design_project.rickandmorty.domain.repository.CharactersRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetDetailCharacterUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {
    suspend operator fun invoke(id: Int): RickAndMortyResult<Character> {
        return charactersRepository.getCharacter(id)
    }
}