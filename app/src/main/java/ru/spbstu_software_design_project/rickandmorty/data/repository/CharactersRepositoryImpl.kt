package ru.spbstu_software_design_project.rickandmorty.data.repository

import ru.spbstu_software_design_project.rickandmorty.data.remote.source.CharacterPagingSource
import ru.spbstu_software_design_project.rickandmorty.data.source.FavouriteCharactersDataSource
import ru.spbstu_software_design_project.rickandmorty.domain.repository.CharactersRepository
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.model.CharacterDetails
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersRepositoryImpl @Inject constructor(
    private val favouriteCharactersDataSource: FavouriteCharactersDataSource,
    private val charactersDataSource: CharacterPagingSource
) : CharactersRepository {

    override fun getCharactersPagingSource(): CharacterPagingSource = charactersDataSource

    override fun getCharactersPagingSource(nextPage: Int) {
        TODO("Not yet implemented")
    }

    override fun getCharacter(id: Int): CharacterDetails {
        TODO("Not yet implemented")
    }

    override fun getFavouriteCharacters(): List<Character> {
        TODO("Not yet implemented")
    }

    override fun insertCharactersToFavourite() {
        TODO("Not yet implemented")
    }

    override fun replaceCharacterFromFavourite() {
        TODO("Not yet implemented")
    }
}