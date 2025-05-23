package com.rodrigofflima.usandosqlite.adapter

import android.content.Context
import android.database.Cursor
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.rodrigofflima.usandosqlite.R
import com.rodrigofflima.usandosqlite.database.DatabaseHandler
import com.rodrigofflima.usandosqlite.entity.Cadastro

class MeuAdapter(var context: Context, var cursor: Cursor) : BaseAdapter() {

    override fun getCount(): Int {
        return cursor.count
    }

    override fun getItem(position: Int): Any {
        cursor.moveToPosition(position)

        val cadastro = Cadastro(
            cursor.getInt(DatabaseHandler.ID),
            cursor.getString(DatabaseHandler.NOME).toString(),
            cursor.getString(DatabaseHandler.TELEFONE).toString(),
        )

        return cadastro
    }

    override fun getItemId(position: Int): Long {
        cursor.moveToPosition(position)
        return cursor.getInt(DatabaseHandler.ID).toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val elementoLista = inflater.inflate(R.layout.elemento_lista, null)

        val tvNomeElementoLista = elementoLista.findViewById<TextView>(R.id.tvNomeElementoLista)
        val tvTelefoneElementoLista = elementoLista.findViewById<TextView>(R.id.tvTelefoneElementoLista)

        cursor.moveToPosition(position)

        tvNomeElementoLista.text = cursor.getString(DatabaseHandler.NOME)
        tvTelefoneElementoLista.text = cursor.getString(DatabaseHandler.TELEFONE)

        return elementoLista
    }
}