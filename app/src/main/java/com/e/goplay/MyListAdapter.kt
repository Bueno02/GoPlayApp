package com.e.goplay

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.e.goplay.model.Game


class MyListAdapter(private val context: Activity,private val game:MutableList<Game>)
    : ArrayAdapter<Game>(context, R.layout.custom_list,game) {


    override fun getView(position: Int, view: View?, parent: ViewGroup): View {


        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list, null, true)

        val titleText = rowView.findViewById(R.id.title) as TextView
      //  val imageView = rowView.findViewById(R.id.icon) as ImageView
        val subtitleText = rowView.findViewById(R.id.nome) as TextView

        titleText.text = game[position].tipoJogo
//        imageView.setImageResource(imgid[position])
        subtitleText.text = game[position].horario

        return rowView
    }

    fun getItemAtPosition(position: Int) : Game{
        return game[position]
    }
}