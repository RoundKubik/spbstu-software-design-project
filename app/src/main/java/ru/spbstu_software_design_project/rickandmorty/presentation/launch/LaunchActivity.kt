package ru.spbstu_software_design_project.rickandmorty.presentation.launch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import ru.spbstu_software_design_project.rickandmorty.R

@AndroidEntryPoint
class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
    }
}