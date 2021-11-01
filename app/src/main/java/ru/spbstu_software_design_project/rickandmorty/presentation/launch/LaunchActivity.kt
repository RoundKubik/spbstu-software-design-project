package ru.spbstu_software_design_project.rickandmorty.presentation.launch

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_launch.*
import ru.spbstu_software_design_project.rickandmorty.R
import ru.spbstu_software_design_project.rickandmorty.presentation.main.MainActivity

@AndroidEntryPoint
class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        launching_animation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {}

            override fun onAnimationEnd(animation: Animator?) {
                startActivity(Intent(this@LaunchActivity, MainActivity::class.java))
                finish()
            }

            override fun onAnimationCancel(animation: Animator?) {}
            override fun onAnimationRepeat(animation: Animator?) {}

        })
    }
}