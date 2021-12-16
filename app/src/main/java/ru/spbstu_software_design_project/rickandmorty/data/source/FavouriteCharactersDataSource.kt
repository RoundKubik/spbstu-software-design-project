package ru.spbstu_software_design_project.rickandmorty.data.source

import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.model.RickAndMortyResult

interface FavouriteCharactersDataSource {
    suspend fun getFavouriteCharacters() : List<Character>

    suspend fun getCharacter(id: Int) : RickAndMortyResult<Character>

    suspend fun insert(character: Character)

    suspend fun replace(character: Character)
}