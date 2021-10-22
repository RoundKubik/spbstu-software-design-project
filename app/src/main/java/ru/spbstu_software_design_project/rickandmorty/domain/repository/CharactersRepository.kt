package ru.spbstu_software_design_project.rickandmorty.domain.repository

import androidx.paging.PagingSource
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character

/**
 *  Repository, provides uploading data about characters from RickAndMorty Api - [https://rickandmortyapi.com/api]
 */
interface CharactersRepository {

    // TODO: remove
    fun getCharactersPagingSource() : PagingSource<Int, Character>

    /**
     * Upload characters by paging
     */
    fun getCharactersPagingSource(nextPage: Int)

    /**
     * Upload character by character id
     */
    fun getCharacter(id: Int)

    fun getFavouriteCharacters() : List<Character>

    /**
     * insert Character to list of favourite character.
     */
    fun insertCharactersToFavourite()

    /**
     * Replacing character of RickAndMorty from favourites. Can work with local storage of
     * favourite characters or remote
     */
    fun replaceCharacterFromFavourite()
}