package ru.spbstu_software_design_project.rickandmorty.data.source

import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.model.RickAndMortyResult

interface CharactersDataSource : SafeCallDataSource {
    suspend fun getCharacter(id: Int) : RickAndMortyResult<Character>
}