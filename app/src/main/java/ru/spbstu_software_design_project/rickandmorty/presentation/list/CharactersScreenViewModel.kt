package ru.spbstu_software_design_project.rickandmorty.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.spbstu_software_design_project.rickandmorty.data.remote.source.CharacterPagingSource
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.AddFavouritesUseCase
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.GetCharactersUseCase
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.GetFavouriteCharactersUseCase
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.ReplaceFromFavouritesUseCase
import javax.inject.Inject

@HiltViewModel
class CharactersScreenViewModel @Inject  constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val addToFavouritesUseCase: AddFavouritesUseCase,
    private val replaceFromFavouritesUseCase: ReplaceFromFavouritesUseCase,
    private val getFavouriteCharactersUseCase: GetFavouriteCharactersUseCase
) : ViewModel() {

    companion object {
        private const val DEFAULT_PAGE_SIZE = 20
        private fun defaultPagingConfig() = PagingConfig(pageSize = DEFAULT_PAGE_SIZE)
    }

    val characters: Flow<PagingData<Character>> =
        Pager(defaultPagingConfig()) {
            getCharactersUseCase.invoke()
        }.flow.cachedIn(viewModelScope)

    private val _favouriteCharacters : MutableStateFlow<List<Character>> = MutableStateFlow(listOf())
    val favouriteCharacters: StateFlow<List<Character>> get() = _favouriteCharacters

    private val _state = MutableStateFlow<State>(State.Characters)
    val state: StateFlow<State> get() = _state


    // TODO: add rx or coroutines
    fun addToFavourite(character: Character?) {
        //addToFavouritesUseCase.invoke(characterCard = character)
    }

    // TODO: add rx or coroutines
    fun replaceFromFavourite(character: Character?) {
        // replaceFromFavouritesUseCase.invoke(characterCard = character)
        when (state.value) {
            is State.Favourite -> {
                loadFavouriteCharacters()
            }
        }
    }

    // TODO: add rx or coroutines
    fun loadCharacters() {
        //  _characters.value = getCharactersUseCase.invoke()
        _state.value = State.Characters
    }

    // TODO: add rx or coroutines
    fun loadFavouriteCharacters() {
        _state.value = State.Favourite
        //  _characters.value = getFavouriteCharactersUseCase.invoke()
    }


    sealed class State {
        object Characters : State()
        object Favourite : State()
    }
}
