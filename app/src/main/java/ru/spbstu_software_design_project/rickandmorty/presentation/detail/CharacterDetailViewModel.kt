package ru.spbstu_software_design_project.rickandmorty.presentation.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.spbstu_software_design_project.rickandmorty.domain.model.CharacterDetails
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.GetDetailCharacterUseCase
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getDetailCharacterUseCase: GetDetailCharacterUseCase
) : ViewModel() {
    private val _character: MutableStateFlow<CharacterDetails> = MutableStateFlow(
       getDetailCharacterUseCase.invoke(1)
    )
    val character: StateFlow<CharacterDetails> get() = _character
}