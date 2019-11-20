package com.e.goplay

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.e.goplay.model.Game
import com.e.goplay.model.Note
import com.e.goplay.model.Place

import kotlinx.android.synthetic.main.activity_games.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_new_game.*
import kotlinx.android.synthetic.main.content_games.*
import kotlinx.android.synthetic.main.custom_list.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GamesActivity : AppCompatActivity() {
    private val notes: MutableList<Note> = mutableListOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)
        setSupportActionBar(toolbar)



        val language = arrayOf<String>("Amistoso","Jogo Treino","Casual","Jogo Integração","Copa Society","Copa Futsal","Campeonato Suiço","Amistoso","Treino")
        val description = arrayOf<String>(
            "Buscando Time Adversario Para amistoso society",
            "Jogo Treino entre Software x KMM",
            "Procuando jogadores para uma partida",
            "Jogo premissorio atrás de pessoas para compor um time",
            "Copa de Agro:" +
                    "Premiação:......",
            "Copa Castro" +
                    "Inscrições Limitadas: 8 Equipes",
            "Inscrições Ilimitadas:" +
                    "Requisitos:......",
            "Procuando time adversario para amistoso futsal",
            "Treino de Equipe")


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

        val myListAdapter = MyListAdapter(this,language,description)
        lv.adapter = myListAdapter

    //    lv.adapter = prodAdapter
        lv.setOnItemClickListener { parent, view, position, id ->
            val element = myListAdapter.getItemAtPosition(position) // The item that was clicked
            val intent = Intent(this, EntraGameActivity::class.java)
            startActivity(intent)
        }

        fab.setOnClickListener {
            val intent = Intent(this, NewGame::class.java)
            startActivity(intent)
        }
    }

}
