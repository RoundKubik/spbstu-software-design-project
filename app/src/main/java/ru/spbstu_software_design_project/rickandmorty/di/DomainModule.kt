package ru.spbstu_software_design_project.rickandmorty.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.w3c.dom.CharacterData
import ru.spbstu_software_design_project.rickandmorty.data.remote.source.CharacterPagingSource
import ru.spbstu_software_design_project.rickandmorty.data.repository.CharactersRepositoryImpl
import ru.spbstu_software_design_project.rickandmorty.data.source.CharactersDataSource
import ru.spbstu_software_design_project.rickandmorty.data.source.FavouriteCharactersDataSource
import ru.spbstu_software_design_project.rickandmorty.domain.repository.CharactersRepository
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.AddFavouritesUseCase
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.GetCharactersUseCase
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.GetFavouriteCharactersUseCase
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.ReplaceFromFavouritesUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {


    companion object {
        @Provides
        fun providesCharactersRepository(
            favouriteCharactersDataSource: FavouriteCharactersDataSource,
            charactersDataSource: CharacterPagingSource,
            characterData: CharactersDataSource
        ): CharactersRepository =  CharactersRepositoryImpl(
            favouriteCharactersDataSource,
            charactersDataSource,
            characterData
        )

        @Provides
        fun provideAddFavouritesUseCase(charactersRepository: CharactersRepository) =
            AddFavouritesUseCase(charactersRepository)

        @Provides
        fun provideGetCharactersUseCase(charactersRepository: CharactersRepository) =
            GetCharactersUseCase(charactersRepository)

        @Provides
        fun provideGetFavouriteCharactersUseCase(charactersRepository: CharactersRepository) =
            GetFavouriteCharactersUseCase(charactersRepository)

        @Provides
        fun provideReplaceFromFavouritesUseCase(charactersRepository: CharactersRepository) =
            ReplaceFromFavouritesUseCase(charactersRepository)

    }

}