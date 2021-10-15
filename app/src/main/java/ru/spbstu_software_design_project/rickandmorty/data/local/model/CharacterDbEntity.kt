package ru.spbstu_software_design_project.rickandmorty.data.local.model

import androidx.room.Entity
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.model.CharacterDetails

@Entity(
    tableName = "favourite_characters",
    primaryKeys = ["id"]
)
data class CharacterDbEntity(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: String,
    val location: String,
    val image: String,
)

fun mapCharacterToCharacterDbEntity(character: Character) = CharacterDbEntity(
    character.id,
    character.name,
    character.status,
    character.species,
    character.location,
    character.origin,
    character.gender,
    character.imageUrl
)

fun CharacterDbEntity.toCharacter() = Character(
    id = id,
    imageUrl = image,
    name = name,
    status = status,
    species = species,
    location = location,
    origin = origin,
    gender = gender,
    isLiked = true
)

fun CharacterDbEntity.toCharacterDetails() = CharacterDetails(
    id = id,
    imageUrl = image,
    name = name,
    status = status,
    species = species,
    origin = origin,
    gender = gender
)
