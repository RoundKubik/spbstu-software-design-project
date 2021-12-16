package ru.spbstu_software_design_project.rickandmorty.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.model.RickAndMortyResult
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.GetDetailCharacterUseCase
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getDetailCharacterUseCase: GetDetailCharacterUseCase,
) : ViewModel() {
    private var  _character: MutableStateFlow<Character> = MutableStateFlow(
        Character()
    )
    val character: StateFlow<Character> get() = _character

    fun load(id: Int?) {
        id?.let {
            viewModelScope.launch {
                when (val characterData = getDetailCharacterUseCase.invoke(id)) {
                    is RickAndMortyResult.Success -> _character.value = characterData.data
                }
            }
        }
    }
}