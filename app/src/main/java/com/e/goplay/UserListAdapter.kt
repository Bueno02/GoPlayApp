package com.e.goplay

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.e.goplay.model.User


class UserListAdapter(private val context: Activity, private val user:MutableList<User>)
    : ArrayAdapter<User>(context, R.layout.custom_list_user,user) {


    override fun getView(position: Int, view: View?, parent: ViewGroup): View {


        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list_user, null, true)

        val nomeText = rowView.findViewById(R.id.nome) as TextView
        val pos1Text = rowView.findViewById(R.id.pos1) as TextView
        val pos2Text = rowView.findViewById(R.id.pos2) as TextView
      //  val imageView = rowView.findViewById(R.id.icon) as ImageView


        nomeText.text = user[position].nome
//        imageView.setImageResource(imgid[position])
        pos1Text.text = user[position].posicao+"/"
        pos2Text.text = user[position].posicao2
        return rowView
    }

    fun getItemAtPosition(position: Int) : User{
        return user[position]
    }
}