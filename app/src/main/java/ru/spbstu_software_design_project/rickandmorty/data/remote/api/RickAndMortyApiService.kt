package ru.spbstu_software_design_project.rickandmorty.data.remote.api

import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.spbstu_software_design_project.rickandmorty.data.remote.model.CharacterResponse
import ru.spbstu_software_design_project.rickandmorty.data.remote.model.CharactersResponse

interface RickAndMortyApiService {

    @GET("character")
    suspend fun getCharacters(): CharactersResponse

    @GET("character/?page={page}")
    suspend fun getCharacters(@Path("page") page : Int) : Response<CharactersResponse>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): CharacterResponse
}