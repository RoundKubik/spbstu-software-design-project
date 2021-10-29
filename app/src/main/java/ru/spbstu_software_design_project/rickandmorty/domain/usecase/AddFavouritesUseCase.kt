package ru.spbstu_software_design_project.rickandmorty.domain.usecase

import ru.spbstu_software_design_project.rickandmorty.domain.repository.CharactersRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddFavouritesUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {
    operator fun invoke() {
        charactersRepository.insertCharactersToFavourite()
    }
}