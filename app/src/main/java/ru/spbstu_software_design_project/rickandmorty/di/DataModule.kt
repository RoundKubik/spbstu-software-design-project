package ru.spbstu_software_design_project.rickandmorty.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.spbstu_software_design_project.rickandmorty.RickAndMortyApp
import ru.spbstu_software_design_project.rickandmorty.data.local.FavouriteCharactersDataSourceImpl
import ru.spbstu_software_design_project.rickandmorty.data.local.db.FavouriteCharactersDao
import ru.spbstu_software_design_project.rickandmorty.data.remote.api.RickAndMortyApiService
import ru.spbstu_software_design_project.rickandmorty.data.remote.source.CharacterPagingSource
import ru.spbstu_software_design_project.rickandmorty.data.remote.source.CharactersDataSourceImpl
import ru.spbstu_software_design_project.rickandmorty.data.source.CharactersDataSource
import ru.spbstu_software_design_project.rickandmorty.data.source.FavouriteCharactersDataSource

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {


    companion object {
        @Provides
        fun provideFavouriteCharactersDataSource(
            dao: FavouriteCharactersDao,
            app: RickAndMortyApp
        ): FavouriteCharactersDataSource
        = FavouriteCharactersDataSourceImpl(dao, app)

        @Provides
        fun provideCharactersPagingSource(
            rickAndMortyApiService: RickAndMortyApiService,
            favouriteCharactersDataSource: FavouriteCharactersDataSource
        ) =
            CharacterPagingSource(rickAndMortyApiService, favouriteCharactersDataSource)

        @Provides
        fun provideCharactersDataSource(
            rickAndMortyApiService: RickAndMortyApiService
        ): CharactersDataSource =
            CharactersDataSourceImpl(rickAndMortyApiService)

    }
}