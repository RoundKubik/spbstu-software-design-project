package ru.spbstu_software_design_project.rickandmorty.data.repository

import androidx.paging.PagingSource
import ru.spbstu_software_design_project.rickandmorty.data.remote.source.CharacterPagingSource
import ru.spbstu_software_design_project.rickandmorty.data.source.CharactersDataSource
import ru.spbstu_software_design_project.rickandmorty.data.source.FavouriteCharactersDataSource
import ru.spbstu_software_design_project.rickandmorty.domain.repository.CharactersRepository
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.model.RickAndMortyResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersRepositoryImpl @Inject constructor(
    private val favouriteCharactersDataSource: FavouriteCharactersDataSource,
    private val charactersPagingSource: CharacterPagingSource,
    private val charactersDataSource: CharactersDataSource
) : CharactersRepository {

    override fun getCharactersPagingSource(): PagingSource<Int, Character> =
        charactersPagingSource

    override suspend fun getCharacter(id: Int): RickAndMortyResult<Character> {
        return when (val favouriteCharacter = favouriteCharactersDataSource.getCharacter(id)) {
            is RickAndMortyResult.Success -> {
                RickAndMortyResult.Success(favouriteCharacter.data)
            }
            else -> {
                charactersDataSource.getCharacter(id)
            }
        }
    }

    override suspend fun getFavouriteCharacters(): List<Character> =
        favouriteCharactersDataSource.getFavouriteCharacters()

    override suspend fun insertCharactersToFavourite(character: Character) {
        favouriteCharactersDataSource.insert(character = character)
    }

    override suspend fun replaceCharacterFromFavourite(character: Character) {
        favouriteCharactersDataSource.replace(character = character)
    }
}