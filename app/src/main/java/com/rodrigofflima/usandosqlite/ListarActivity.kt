package com.rodrigofflima.usandosqlite

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SimpleCursorAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rodrigofflima.usandosqlite.adapter.MeuAdapter
import com.rodrigofflima.usandosqlite.database.DatabaseHandler
import com.rodrigofflima.usandosqlite.databinding.ActivityListarBinding
import com.rodrigofflima.usandosqlite.databinding.ActivityMainBinding

class ListarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListarBinding

    private lateinit var banco: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        banco = DatabaseHandler(this)


        val registros = banco.list()

        val adapter = MeuAdapter(this, registros)

        binding.lvPrincipal.adapter = adapter
    }
}