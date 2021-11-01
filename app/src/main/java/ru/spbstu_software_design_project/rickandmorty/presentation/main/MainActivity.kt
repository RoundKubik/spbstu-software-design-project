package ru.spbstu_software_design_project.rickandmorty.presentation.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import ru.spbstu_software_design_project.rickandmorty.presentation.detail.CharacterDetailViewModel
import ru.spbstu_software_design_project.rickandmorty.presentation.detail.DetailScreen
import ru.spbstu_software_design_project.rickandmorty.ui.theme.MyApplicationTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
            }
        }
    }
}