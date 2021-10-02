package ru.spbstu_software_design_project.rickandmorty.data.remote.model

import kotlinx.serialization.SerialName

data class InfoResponse(
    @SerialName("count") val count: Int,
    @SerialName("pages") val next: String?,
    @SerialName("next") val pages: Int?,
    @SerialName("prev") val prev: String?
)
