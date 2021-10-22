package ru.spbstu_software_design_project.rickandmorty.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.spbstu_software_design_project.rickandmorty.data.converters.Converters
import ru.spbstu_software_design_project.rickandmorty.data.local.model.CharacterDbEntity


@Database(
    entities = [CharacterDbEntity::class], version = 1, exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favouriteCharactersDao(): FavouriteCharactersDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null
        private const val DATABASE_NAME = "characters.db"

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}
