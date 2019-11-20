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

open class GamesActivity : AppCompatActivity() {
    private val notes: MutableList<Note> = mutableListOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        var game :Game
        game = (Game("01","Jogo Treino","partida com intuito de treinar a equipe para o campeonato"))
        val listGame :  MutableList<Game> = mutableListOf()
        listGame.add(game)
        game = (Game("02","Jogo Integração","partida casual, com churrasco pós jogo"))
        listGame.add(game)
        game = (Game("03","Amistoso","procurando time adversario para partida"))
        listGame.add(game)
        var lista : MutableList<String> = mutableListOf()
        var lista2 : MutableList<String> = mutableListOf()
        lista.add(listGame[0].tipoJogo)
        lista2.add(listGame[0].description)
        lista.add(listGame[1].tipoJogo)
        lista2.add(listGame[1].description)


        lista.add(listGame[2].tipoJogo)
        lista2.add(listGame[2].description)
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


        val lv = findViewById<ListView>(R.id.listView_games)

      //  val myListAdapter = MyListAdapter(this,language,description)


        val myListAdapter = MyListAdapter(this,lista,lista2)

        lv.adapter = myListAdapter

    //    lv.adapter = prodAdapter
        lv.setOnItemClickListener { parent, view, position, id ->
            val element = myListAdapter.getItemAtPosition(position) // The item that was clicked
            val intent = Intent(this, EntraGameActivity::class.java)
            startActivity(intent)
        }

        fun addGame(game : Game){
            lista.add(game.tipoJogo)
            lista2.add(game.description)
            val myListAdapter = MyListAdapter(this,lista,lista2)
            lv.adapter = myListAdapter
        }
        fab.setOnClickListener {

            val intent = Intent(this, NewGame::class.java)
            startActivity(intent)
        }
    }

}
