package com.e.goplay

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.e.goplay.model.Game
import kotlinx.android.synthetic.main.activity_entra_game.*
import kotlinx.android.synthetic.main.activity_new_game.*

class NewGame : AppCompatActivity()  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)


        var game :Game = Game("0","","")


        buttonCriaJogo.setOnClickListener{
            game.tipoJogo = editText1.text.toString()
            game.description = editText5.text.toString()
            Toast.makeText( application,game.tipoJogo, Toast.LENGTH_LONG).show()
        }
    }
}
