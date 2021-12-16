package ru.spbstu_software_design_project.rickandmorty.utill

import ru.spbstu_software_design_project.rickandmorty.domain.model.Character

fun List<Character>.setLikes(from: List<Character>) {
    from.forEach { character ->
        this.find {
            it.id == character.id
        }?.isLiked = character.isLiked
    }
}