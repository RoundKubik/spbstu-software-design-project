package ru.spbstu_software_design_project.rickandmorty.data.local.db

import androidx.room.*
import ru.spbstu_software_design_project.rickandmorty.data.local.model.CharacterDetailAndCharacterDbEntity
import ru.spbstu_software_design_project.rickandmorty.data.local.model.DetailCharacterDbEntity


@Dao
interface DetailCharactersDao {

    @Query("SELECT * FROM detail_characters WHERE id = :id")
    suspend fun getCharacter(id: Int): DetailCharacterDbEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: DetailCharacterDbEntity): Long

    @Delete
    suspend fun delete(character: DetailCharacterDbEntity)


    @Transaction
    @Query("SELECT * FROM detail_characters WHERE id = :id")
    suspend fun getCharacterWithDetail(id: Int): CharacterDetailAndCharacterDbEntity
}
