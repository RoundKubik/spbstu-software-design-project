package ru.spbstu_software_design_project.rickandmorty.data.remote.model

import kotlinx.serialization.SerialName

data class CharacterLocationResponse(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("type") val type: String,
    @SerialName("dimension") val dimension: String,
    @SerialName("residents") val residents: List<String>,
    @SerialName("url") val url: String,
    @SerialName("created") val created: String
)
