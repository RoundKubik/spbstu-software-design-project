package ru.spbstu_software_design_project.rickandmorty.data.local

import ru.spbstu_software_design_project.rickandmorty.R
import ru.spbstu_software_design_project.rickandmorty.RickAndMortyApp
import ru.spbstu_software_design_project.rickandmorty.data.local.db.FavouriteCharactersDao
import ru.spbstu_software_design_project.rickandmorty.data.local.model.mapCharacterToCharacterDbEntity
import ru.spbstu_software_design_project.rickandmorty.data.local.model.toCharacter
import ru.spbstu_software_design_project.rickandmorty.data.source.FavouriteCharactersDataSource
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.model.RickAndMortyResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavouriteCharactersDataSourceImpl @Inject constructor(
    private val favouriteCharactersDao: FavouriteCharactersDao,
    private val app: RickAndMortyApp
) : FavouriteCharactersDataSource {

    override suspend fun getFavouriteCharacters() =
        favouriteCharactersDao.getAllCharacters().map {
            it.toCharacter().apply {
                isLiked = true
            }
        }

    override suspend fun getCharacter(id: Int): RickAndMortyResult<Character> {
        val count = favouriteCharactersDao.getCountOfCharactersWithId(id)
        return if (count > 0) {
            RickAndMortyResult.Success(
                favouriteCharactersDao.getCharacter(id).toCharacter()
            )
        } else{
            RickAndMortyResult.Error(app.getString(R.string.error_loading_character_from_data))
        }
    }

    override suspend fun insert(character: Character) {
        favouriteCharactersDao.insert(mapCharacterToCharacterDbEntity(character))
    }

    override suspend fun replace(character: Character) {
        favouriteCharactersDao.delete(mapCharacterToCharacterDbEntity(character))
    }
}
