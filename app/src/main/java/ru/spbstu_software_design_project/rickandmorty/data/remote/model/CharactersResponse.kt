package ru.spbstu_software_design_project.rickandmorty.data.remote.model

import kotlinx.serialization.SerialName
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character

data class CharactersResponse(
    @SerialName("info") val info: InfoResponse,
    @SerialName("results") val results: List<CharacterResponse>
)

fun CharactersResponse.toCharactersList() = results.map {
    Character(
        id = it.id,
        imageUrl = it.url,
        name = it.name,
        status = it.status,
        species = it.species,
        location = it.location.name,
        origin = it.origin.name,
        gender = it.gender,
        isLiked = false
    )
}
