package com.example.app13

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.app13.databinding.ActivityMainBinding

// App13: Shared Preferences: os valores ficam salvos mesmo quando fecha o app

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sharedPreference = this.getSharedPreferences("valores", Context.MODE_PRIVATE)
        val valor = sharedPreference.getString("valor", "")
        binding.textResultado.text = valor

        binding.buttonGravar.setOnClickListener {
            val novoValor = binding.editValor.text.toString().trim()
            binding.textResultado.text = novoValor

            val editor = sharedPreference.edit()
            editor.putString("valor", novoValor)
            editor.apply()
        }
    }
}