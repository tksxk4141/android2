package com.example.hw3_animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.transition.*
import com.example.hw3_animation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var scene1 : Scene
    private lateinit var scene2 : Scene

    override fun onCreate(savedInstanceState : Bundle ?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        scene1 = Scene.getSceneForLayout(binding.sceneRoot , R.layout.scene_1 , this)
        scene2 = Scene.getSceneForLayout( binding.sceneRoot , R.layout.scene_2 , this)

        binding.rg.setOnCheckedChangeListener{_,checkedID->
            when(checkedID){
                R.id.radioButton -> TransitionManager.go(scene1 , ChangeBounds())
                R.id.radioButton2 -> TransitionManager.go(scene2 , ChangeBounds())
            }
        }

    }

}
