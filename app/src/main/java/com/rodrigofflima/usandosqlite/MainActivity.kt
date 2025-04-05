package com.rodrigofflima.usandosqlite

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rodrigofflima.usandosqlite.database.DatabaseHandler
import com.rodrigofflima.usandosqlite.databinding.ActivityMainBinding
import com.rodrigofflima.usandosqlite.entity.Cadastro

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var banco: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        banco = DatabaseHandler(this)

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
        val cadastro =
            Cadastro(0, binding.etNome.text.toString(), binding.etTelefone.text.toString())

        banco.insert(cadastro)

        Toast.makeText(this, "Registro incluido... ", Toast.LENGTH_LONG).show()
    }

    private fun btAlterarOnClick() {
        val cadastro = Cadastro(
            binding.etCod.text.toString().toInt(),
            binding.etNome.text.toString(),
            binding.etTelefone.text.toString()
        )

        banco.update(cadastro)

        Toast.makeText(this, "Registro alterado... ", Toast.LENGTH_LONG).show()
    }

    private fun btExcluirOnClick() {
        banco.delete(binding.etCod.text.toString().toInt())

        Toast.makeText(this, "Registro excluido... ", Toast.LENGTH_LONG).show()
    }

    private fun btPesquisarOnClick() {
        val cadastro = banco.search(binding.etCod.text.toString().toInt())

        if (cadastro != null) {
            binding.etNome.setText(cadastro.nome)
            binding.etTelefone.setText(cadastro.telefone)
        } else {
            Toast.makeText(this, "Registro não encontrado", Toast.LENGTH_LONG).show()
        }
    }

    private fun btListarOnClick() {
//        val registros = banco.list()
//
//        val saida = StringBuilder()
//
//        while (registros.moveToNext()) {
//            saida.append(registros.getString(NOME))
//            saida.append(" - ")
//            saida.append(registros.getString(TELEFONE))
//            saida.append("\n")
//        }
//
//        Toast.makeText(this, saida.toString(), Toast.LENGTH_LONG).show()

        val intent = Intent(this, ListarActivity::class.java)
        startActivity(intent)
    }

    companion object {
        private const val ID = 0
        private const val NOME = 1
        private const val TELEFONE = 2
    }
}