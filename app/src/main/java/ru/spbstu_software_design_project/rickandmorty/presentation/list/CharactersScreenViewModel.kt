package ru.spbstu_software_design_project.rickandmorty.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.AddFavouritesUseCase
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.GetCharactersUseCase
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.GetFavouriteCharactersUseCase
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.ReplaceFromFavouritesUseCase
import javax.inject.Inject

@HiltViewModel
class CharactersScreenViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val addToFavouritesUseCase: AddFavouritesUseCase,
    private val replaceFromFavouritesUseCase: ReplaceFromFavouritesUseCase,
    private val getFavouriteCharactersUseCase: GetFavouriteCharactersUseCase
) : ViewModel() {

    companion object {
        private const val DEFAULT_PAGE_SIZE = 20
        private fun defaultPagingConfig() = PagingConfig(pageSize = DEFAULT_PAGE_SIZE)
    }

    sealed class State {
        object Characters : State()
        object Favourite : State()
    }

    val characters: Flow<PagingData<Character>> =
        Pager(defaultPagingConfig()) {
            getCharactersUseCase.invoke()
        }.flow


    private val _favouriteCharacters: MutableStateFlow<List<Character>> = MutableStateFlow(listOf())
    val favouriteCharacters: StateFlow<List<Character>> get() = _favouriteCharacters

    private val _state = MutableStateFlow<State>(State.Characters)
    val state: StateFlow<State> get() = _state


    fun addToFavourite(character: Character) {
        viewModelScope.launch {
            addToFavouritesUseCase.invoke(character)
        }
    }

    fun replaceFromFavourite(character: Character) {
        viewModelScope.launch {
            replaceFromFavouritesUseCase.invoke(character)
            when (state.value) {
                is State.Favourite -> {
                    loadFavouriteCharacters()
                }
            }
        }
    }

    fun toDisplayCharacters() {
        _state.value = State.Characters
    }

    fun loadFavouriteCharacters() {
        _state.value = State.Favourite
        viewModelScope.launch {
            _favouriteCharacters.value = getFavouriteCharactersUseCase.invoke()
        }
    }
}
