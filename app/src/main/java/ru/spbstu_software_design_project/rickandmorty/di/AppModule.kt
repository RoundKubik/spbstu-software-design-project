package ru.spbstu_software_design_project.rickandmorty.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.descriptors.PrimitiveKind
import ru.spbstu_software_design_project.rickandmorty.RickAndMortyApp
import ru.spbstu_software_design_project.rickandmorty.utill.InternetUtil
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {


    companion object {
        @Singleton
        @Provides
        fun provideApplication(@ApplicationContext app: Context): RickAndMortyApp {
            return app as RickAndMortyApp
        }

        @Singleton
        @Provides
        fun provideInternetUtil(@ApplicationContext app: RickAndMortyApp): InternetUtil =
            InternetUtil(app)
    }


}