package ru.spbstu_software_design_project.rickandmorty.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.spbstu_software_design_project.rickandmorty.data.local.db.AppDatabase
import ru.spbstu_software_design_project.rickandmorty.data.local.db.DetailCharactersDao
import ru.spbstu_software_design_project.rickandmorty.data.local.db.FavouriteCharactersDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideFavouriteCharactersDao(appDatabase: AppDatabase): FavouriteCharactersDao =
        appDatabase.favouriteCharactersDao()


    @Provides
    @Singleton
    fun providesDetailCharactersDao(appDatabase: AppDatabase): DetailCharactersDao =
        appDatabase.detailCharacterDao()

}