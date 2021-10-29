package ru.spbstu_software_design_project.rickandmorty.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.spbstu_software_design_project.rickandmorty.data.converters.Converters
import ru.spbstu_software_design_project.rickandmorty.data.local.model.CharacterDbEntity
import ru.spbstu_software_design_project.rickandmorty.data.local.model.DetailCharacterDbEntity


@Database(
    entities = [CharacterDbEntity::class, DetailCharacterDbEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favouriteCharactersDao(): FavouriteCharactersDao
    abstract fun detailCharacterDao(): DetailCharactersDao

    companion object {
        const val DATABASE_NAME = "characters.db"
    }
}
