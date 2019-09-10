package com.e.goplay

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.e.goplay.model.Game
import com.e.goplay.model.Place

import kotlinx.android.synthetic.main.activity_games.*
import kotlinx.android.synthetic.main.content_games.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GamesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)
        setSupportActionBar(toolbar)

        val local = Place("Avenida 11 de Outubro")

        val jogo = Game("01", local, "Amistoso")
        val jogo2 = Game("01", local, "Amistoso")
        val jogo3 = Game("01", local, "Amistoso")
        val jogo4 = Game("01", local, "Amistoso")
        val jogo5 = Game("01", local, "Amistoso")
        val jogo6 = Game("01", local, "Amistoso")
        var listaJogo = listOf(jogo,jogo2,jogo3,jogo4,jogo5,jogo6)


        val lv = findViewById<ListView>(R.id.listView_games)
        val prodAdapter = ArrayAdapter<Game>(this,
            android.R.layout.simple_list_item_1, listaJogo)

        lv.adapter = prodAdapter

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}
