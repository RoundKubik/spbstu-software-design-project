package ru.spbstu_software_design_project.rickandmorty.domain.repository

import androidx.paging.PagingSource
import ru.spbstu_software_design_project.rickandmorty.data.remote.source.CharacterPagingSource
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.model.RickAndMortyResult

/**
 *  Repository, provides uploading data about characters from RickAndMorty Api - [https://rickandmortyapi.com/api]
 */
interface CharactersRepository {

    // TODO: remove
    fun getCharactersPagingSource(): PagingSource<Int, Character>

    /**
     * Upload character by character id
     * [id] - character id
     */
    suspend fun getCharacter(id: Int): RickAndMortyResult<Character>


    /**
     * Load favourite characters
     */
    suspend fun getFavouriteCharacters(): List<Character>

    /**
     * insert Character to list of favourite character.
     */
    suspend fun insertCharactersToFavourite(character: Character)

    /**
     * Replacing character of RickAndMorty from favourites. Can work with local storage of
     * favourite characters or remote
     */
    suspend fun replaceCharacterFromFavourite(character: Character)
}