package ru.spbstu_software_design_project.rickandmorty.presentation.list

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import io.mockk.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verifyNoMoreInteractions
import ru.spbstu_software_design_project.rickandmorty.data.remote.api.RickAndMortyApiService
import ru.spbstu_software_design_project.rickandmorty.data.remote.source.CharacterPagingSource
import ru.spbstu_software_design_project.rickandmorty.data.source.FavouriteCharactersDataSource
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.AddFavouritesUseCase
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.GetCharactersUseCase
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.GetFavouriteCharactersUseCase
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.ReplaceFromFavouritesUseCase

class CharactersScreenViewModelTest {

    private lateinit var viewModel: CharactersScreenViewModel

    private val getCharactersUseCase: GetCharactersUseCase = mockk()
    private val addToFavouritesUseCase: AddFavouritesUseCase = mockk()
    private val replaceFromFavouritesUseCase: ReplaceFromFavouritesUseCase = mockk()
    private val getFavouriteCharactersUseCase: GetFavouriteCharactersUseCase = mockk()
    private val api: RickAndMortyApiService = mockk()
    private val favouriteDataSource: FavouriteCharactersDataSource = mockk()

    @Before
    fun setUp() {
        viewModel = CharactersScreenViewModel(
            getCharactersUseCase,
            addToFavouritesUseCase,
            replaceFromFavouritesUseCase,
            getFavouriteCharactersUseCase
        )
    }

    val characters: Flow<PagingData<Character>> =
        Pager(PagingConfig(20)) {
            getCharactersUseCase.invoke()
        }.flow

    fun characters(): PagingSource<Int, Character> = CharacterPagingSource(
        api,
        favouriteDataSource
    )

    fun favouriteChacreacters() = listOf<Character>(Character())
    val favouriteCharacters = favouriteChacreacters()

    fun character() = Character()

    @Test
    fun getCharacters() {
    }

    @Test
    fun getFavouriteCharacters() {
        every {
            runBlocking {
                getFavouriteCharactersUseCase.invoke()
            }
        } returns favouriteChacreacters()
        viewModel.loadFavouriteCharacters()

        verifySequence {
            characters wasNot Called
        }
    }

    @Test
    fun getState() {
        viewModel.loadFavouriteCharacters()
        assert(viewModel.state.value != CharactersScreenViewModel.State.Favourite)
    }

    @Test
    fun addToFavourite() {
        viewModel.addToFavourite(character())
        verifyNoMoreInteractions(viewModel)

    }

    @Test
    fun replaceFromFavourite() {
        viewModel.addToFavourite(character())
        verifyNoMoreInteractions(viewModel)
    }

    @Test
    fun toDisplayCharacters() {
        every {
            runBlocking {
                getCharactersUseCase.invoke()
            }
        } returns characters()

        verifySequence {
            favouriteCharacters wasNot Called
        }
    }
}