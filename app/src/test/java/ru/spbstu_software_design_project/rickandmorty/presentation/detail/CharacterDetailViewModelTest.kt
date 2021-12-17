package ru.spbstu_software_design_project.rickandmorty.presentation.detail

import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import ru.spbstu_software_design_project.rickandmorty.domain.model.Character
import ru.spbstu_software_design_project.rickandmorty.domain.usecase.*

class CharacterDetailViewModelTest {

    companion object{
        const val CHARACTER_ID =1
    }
    private lateinit var viewModel: CharacterDetailViewModel

    private val getDetailCharacterUseCase: GetDetailCharacterUseCase = mockk()

    @Before
    fun setUp() {
        viewModel = CharacterDetailViewModel(
            getDetailCharacterUseCase
        )
    }

    var character = character()
    fun character() = Character()

    @Test
    fun load() {
        viewModel.load(CHARACTER_ID)
    }
}