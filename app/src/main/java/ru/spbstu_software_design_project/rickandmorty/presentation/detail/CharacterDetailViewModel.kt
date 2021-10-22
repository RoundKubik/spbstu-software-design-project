package ru.spbstu_software_design_project.rickandmorty.presentation.detail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.spbstu_software_design_project.rickandmorty.domain.model.CharacterDetails

class CharacterDetailViewModel : ViewModel(){
    private val _character: MutableStateFlow<CharacterDetails> = MutableStateFlow(
        CharacterDetails(
            id = 1,
            imageUrl ="https://picsum.photos/id/237/200/300",
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            origin = "Earth",
            gender = "Male"
        )
    )
    val character : StateFlow<CharacterDetails> get() = _character
}