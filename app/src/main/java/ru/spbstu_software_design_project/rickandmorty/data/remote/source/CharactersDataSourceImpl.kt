package ru.spbstu_software_design_project.rickandmorty.data.remote.source

import ru.spbstu_software_design_project.rickandmorty.data.remote.api.RickAndMortyApiService
import ru.spbstu_software_design_project.rickandmorty.data.remote.model.toCharacter
import ru.spbstu_software_design_project.rickandmorty.data.source.CharactersDataSource
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.model.RickAndMortyResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersDataSourceImpl @Inject constructor(
    private val apiService: RickAndMortyApiService
) : CharactersDataSource {

    override suspend fun getCharacter(id: Int): RickAndMortyResult<Character> {
        return safeApiCal {
            apiService.getCharacter(id).toCharacter()
        }
    }
}