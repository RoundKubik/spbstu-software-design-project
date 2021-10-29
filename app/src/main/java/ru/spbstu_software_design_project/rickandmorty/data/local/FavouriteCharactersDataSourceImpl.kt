package ru.spbstu_software_design_project.rickandmorty.data.local

import ru.spbstu_software_design_project.rickandmorty.data.local.db.DetailCharactersDao
import ru.spbstu_software_design_project.rickandmorty.data.local.db.FavouriteCharactersDao
import ru.spbstu_software_design_project.rickandmorty.data.local.model.mapCharacterToCharacterDbEntity
import ru.spbstu_software_design_project.rickandmorty.data.local.model.toCharacter
import ru.spbstu_software_design_project.rickandmorty.data.source.FavouriteCharactersDataSource
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavouriteCharactersDataSourceImpl @Inject  constructor(
    private val favouriteCharactersDao: FavouriteCharactersDao,
    private val detailCharactersDao: DetailCharactersDao
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
