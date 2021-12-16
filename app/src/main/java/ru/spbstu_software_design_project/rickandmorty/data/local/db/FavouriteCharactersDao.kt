package ru.spbstu_software_design_project.rickandmorty.data.local.db

import androidx.room.*
import ru.spbstu_software_design_project.rickandmorty.data.local.model.CharacterDbEntity

@Dao
interface FavouriteCharactersDao {

    @Query("SELECT * FROM favourite_characters")
    suspend fun getAllCharacters(): List<CharacterDbEntity>

    @Query("SELECT * FROM favourite_characters WHERE idCharacter = :id")
    suspend fun getCharacter(id: Int): CharacterDbEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: CharacterDbEntity): Long

    @Delete
    suspend fun delete(character: CharacterDbEntity)

    @Query("SELECT COUNT(*) FROM favourite_characters WHERE idCharacter= :id")
    suspend fun getCountOfCharactersWithId(id: Int): Long
}
