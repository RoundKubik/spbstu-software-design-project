package ru.spbstu_software_design_project.rickandmorty.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.spbstu_software_design_project.rickandmorty.data.local.FavouriteCharactersDataSourceImpl
import ru.spbstu_software_design_project.rickandmorty.data.remote.api.RickAndMortyApiService
import ru.spbstu_software_design_project.rickandmorty.data.remote.source.CharacterPagingSource
import ru.spbstu_software_design_project.rickandmorty.data.source.FavouriteCharactersDataSource

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun buildFavouriteCharactersDataSource(favouriteCharactersDataSource: FavouriteCharactersDataSourceImpl): FavouriteCharactersDataSource

    companion object {
        @Provides
        fun provideCharactersPagingSource(rickAndMortyApiService: RickAndMortyApiService) =
            CharacterPagingSource(rickAndMortyApiService)
    }
}