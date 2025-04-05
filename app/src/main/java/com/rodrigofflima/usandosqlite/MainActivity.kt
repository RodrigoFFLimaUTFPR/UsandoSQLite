package com.rodrigofflima.usandosqlite

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rodrigofflima.usandosqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.main)

        setButtonsListeners()
    }

    private fun setButtonsListeners() {
        binding.btIncluir.setOnClickListener {
            btIncluirOnClick()
        }

        binding.btAlterar.setOnClickListener {
            btAlterarOnClick()
        }

        binding.btExcluir.setOnClickListener {
            btExcluirOnClick()
        }

        binding.btPesquisar.setOnClickListener {
            btPesquisarOnClick()
        }

        binding.btListar.setOnClickListener {
            btListarOnClick()
        }
    }

    private fun btIncluirOnClick() {
        TODO("Not yet implemented")
    }

    private fun btAlterarOnClick() {
        TODO("Not yet implemented")
    }

    private fun btExcluirOnClick() {
        TODO("Not yet implemented")
    }

    private fun btPesquisarOnClick() {
        TODO("Not yet implemented")
    }

    private fun btListarOnClick() {
        TODO("Not yet implemented")
    }
}