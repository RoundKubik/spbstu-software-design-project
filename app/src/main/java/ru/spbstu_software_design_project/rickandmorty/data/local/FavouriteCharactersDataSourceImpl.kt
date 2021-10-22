package ru.spbstu_software_design_project.rickandmorty.data.local

import ru.spbstu_software_design_project.rickandmorty.data.local.db.FavouriteCharactersDao
import ru.spbstu_software_design_project.rickandmorty.data.local.model.mapCharacterToCharacterDbEntity
import ru.spbstu_software_design_project.rickandmorty.data.local.model.toCharacter
import ru.spbstu_software_design_project.rickandmorty.data.source.FavouriteCharactersDataSource
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import javax.inject.Inject


class FavouriteCharactersDataSourceImpl  constructor(
    private val favouriteCharactersDao: FavouriteCharactersDao
) : FavouriteCharactersDataSource {

    suspend fun getFavouriteCharacters() =
        favouriteCharactersDao.getAllCharacters().map {
            it.toCharacter()
        }

    suspend fun getCharacter(id: Int) = favouriteCharactersDao.getCharacter(id).toCharacter()

    suspend fun insert(character: Character) {
           // favouriteCharactersDao.insert(mapCharacterToCharacterDbEntity(character))
    }

    suspend fun replace(character: Character) {
    //    favouriteCharactersDao.delete(mapCharacterToCharacterDbEntity(character))
    }
}
