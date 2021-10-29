package ru.spbstu_software_design_project.rickandmorty.domain.usecase

import androidx.paging.PagingSource
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.repository.CharactersRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetCharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {
    operator fun invoke(): PagingSource<Int, Character> {
        return charactersRepository.getCharactersPagingSource()
    }
}