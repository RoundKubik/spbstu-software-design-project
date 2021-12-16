package ru.spbstu_software_design_project.rickandmorty.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.spbstu_software_design_project.rickandmorty.data.local.model.CharacterDbEntity


@Database(
    entities = [CharacterDbEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favouriteCharactersDao(): FavouriteCharactersDao

    companion object {
        const val DATABASE_NAME = "characters.db"
    }
}
