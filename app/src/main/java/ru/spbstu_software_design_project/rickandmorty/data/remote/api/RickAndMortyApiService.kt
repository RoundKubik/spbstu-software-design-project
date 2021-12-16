package ru.spbstu_software_design_project.rickandmorty.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.spbstu_software_design_project.rickandmorty.data.remote.model.CharacterResponse
import ru.spbstu_software_design_project.rickandmorty.data.remote.model.CharactersResponse

interface RickAndMortyApiService {

    @GET("character/")
    suspend fun getCharacters(@Query("page") page: Int): CharactersResponse

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): CharacterResponse
}