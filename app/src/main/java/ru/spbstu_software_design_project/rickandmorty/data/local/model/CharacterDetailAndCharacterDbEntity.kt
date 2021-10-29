package ru.spbstu_software_design_project.rickandmorty.data.local.model

import androidx.room.Embedded
import androidx.room.Relation

data class CharacterDetailAndCharacterDbEntity(
    @Embedded
    val character: CharacterDbEntity,
    @Relation(
        parentColumn = "idCharacter",
        entityColumn = "characterId"
    )
    val detailCharacterDbEntity: DetailCharacterDbEntity
)
