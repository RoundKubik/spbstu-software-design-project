package ru.spbstu_software_design_project.rickandmorty.data.remote.model

import kotlinx.serialization.SerialName
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character

data class CharacterResponse(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("status") val status: String,
    @SerialName("species") val species: String,
    @SerialName("type") val type: String,
    @SerialName("gender") val gender: String,
    @SerialName("origin") val origin: CharacterLocationResponse,
    @SerialName("location") val location: CharacterLocationResponse,
    @SerialName("image") val image: String,
    @SerialName("episode") val episode: List<String>,
    @SerialName("url") val url: String,
    @SerialName("created") val created: String
)

fun List<CharacterResponse>.toListCharacters() = map {
    it.toCharacter()
}

fun CharacterResponse.toCharacter() = Character(
    id = id,
    name = name,
    status =  status,
    gender = gender,
    imageUrl = image,
    species = species,
    origin = origin.name,
    location = location.name,
    isLiked = false
)
