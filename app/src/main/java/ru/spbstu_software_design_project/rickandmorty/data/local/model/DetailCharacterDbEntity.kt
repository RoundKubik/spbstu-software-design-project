package ru.spbstu_software_design_project.rickandmorty.data.local.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.Index


@Entity(
    tableName = "detail_characters", foreignKeys = [
        ForeignKey(
            onDelete = CASCADE,
            entity = CharacterDbEntity::class,
            parentColumns = arrayOf("idCharacter"),
            childColumns = arrayOf("id")
        )
    ],
    indices = [
        Index("id"),
    ]
)
data class DetailCharacterDbEntity(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: String,
    val location: String,
    val image: String,
    val characterId: Int
)