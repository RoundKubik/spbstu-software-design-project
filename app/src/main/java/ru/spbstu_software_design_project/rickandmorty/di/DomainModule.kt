package ru.spbstu_software_design_project.rickandmorty.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.spbstu_software_design_project.rickandmorty.data.repository.CharactersRepositoryImpl
import ru.spbstu_software_design_project.rickandmorty.domain.repository.CharactersRepository
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.AddFavouritesUseCase
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.GetCharactersUseCase
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.GetFavouriteCharactersUseCase
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.ReplaceFromFavouritesUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindCharactersRepository(charactersRepository: CharactersRepositoryImpl): CharactersRepository

    companion object {
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