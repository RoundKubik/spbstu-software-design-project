package ru.spbstu_software_design_project.rickandmorty.data.repository

import androidx.paging.PagingSource
import ru.spbstu_software_design_project.rickandmorty.data.remote.source.CharacterPagingSource
import ru.spbstu_software_design_project.rickandmorty.data.source.FavouriteCharactersDataSource
import ru.spbstu_software_design_project.rickandmorty.domain.repository.CharactersRepository
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character

class CharactersRepositoryImpl(
    private val favouriteCharactersDataSource : FavouriteCharactersDataSource,
    private val charactersDataSource: PagingSource<Int, Character>
) : CharactersRepository {

    override fun getCharactersPagingSource() : PagingSource<Int, Character> = charactersDataSource

    override fun getCharactersPagingSource(nextPage: Int) {
        TODO("Not yet implemented")
    }

    override fun getCharacter(id: Int) {
        TODO("Not yet implemented")
    }

    override fun getFavouriteCharacters() {
        TODO("Not yet implemented")
    }

    override fun insertCharactersToFavourite() {
        TODO("Not yet implemented")
    }

    override fun replaceCharacterFromFavourite() {
        TODO("Not yet implemented")
    }
}