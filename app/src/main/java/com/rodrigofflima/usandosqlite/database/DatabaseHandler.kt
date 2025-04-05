package com.rodrigofflima.usandosqlite.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.CursorAdapter
import android.widget.Toast
import com.rodrigofflima.usandosqlite.entity.Cadastro

class DatabaseHandler(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(banco: SQLiteDatabase?) {
        banco?.execSQL(
            "CREATE TABLE IF NOT EXISTS ${TABLE_NAME}(" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome TEXT, " +
                    "telefone TEXT)"
        )
    }

    override fun onUpgrade(banco: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        banco?.execSQL("DROP TABLE IF EXISTS ${TABLE_NAME}")
        onCreate(banco)
    }

    fun insert(cadastro: Cadastro) {
        val banco = this.writableDatabase

        val registro = ContentValues()
        registro.put("nome", cadastro.nome)
        registro.put("telefone", cadastro.telefone)

        banco.insert("cadastro", null, registro)
    }

    fun update(cadastro: Cadastro) {
        val banco = this.writableDatabase

        val registro = ContentValues()
        registro.put("nome", cadastro.nome)
        registro.put("telefone", cadastro.telefone)

        banco.update(
            "cadastro",
            registro,
            "_id=${cadastro._id}",
            null
        )
    }

    fun delete(id: Int) {
        val banco = this.writableDatabase
        banco.delete("cadastro", "_id=$id", null)
    }

    fun search(id: Int): Cadastro? {
        val banco = this.writableDatabase

        val registro = banco.query(
            "cadastro",
            null,
            "_id=?",
            arrayOf(id.toString()),
            null,
            null,
            null
        )

        return if (registro.moveToNext()) {
            Cadastro(
                id,
                registro.getString(NOME),
                registro.getString(TELEFONE)
            )
        } else {
            null
        }
    }

    fun list() : Cursor {
        val banco = this.writableDatabase
        val registros = banco.query("cadastro", null, null, null, null, null, null)

        return registros
    }

    companion object {
        public const val DATABASE_VERSION = 1
        public const val DATABASE_NAME = "dbfile.sqlite"
        public const val TABLE_NAME = "cadastro"
        public const val ID = 0
        public const val NOME = 1
        public  const val TELEFONE = 2
    }
}