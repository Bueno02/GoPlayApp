package com.e.goplay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.e.goplay.model.Game
import com.e.goplay.model.User
import com.e.goplay.retrofit.GameWebClient
import kotlinx.android.synthetic.main.activity_entra_game.*
import android.widget.ListView


class EntraGameActivity : AppCompatActivity() {

    var game: Game = Game()
    var user: User = User()
    var list_user : MutableList<User> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entra_game)
        val intent: Intent = getIntent()

        game = intent.getSerializableExtra("game") as Game
        user = intent.getSerializableExtra("user") as User
        textViewQntdJoga.text=("Vagas: "+(game.jogadores.size).toString()+"/"+(game.qntdJogadores).toString())
        textViewHorario.text=game.horario
        textViewTipodeJogo.text=(game.tipoJogo)
        textViewLocal.text="Local:"+game.local
        textViewDescription.text=game.description
//        println(list_user[1].nome)
        val userListAdapter = UserListAdapter(this,game.jogadores)
        val lv = findViewById<ListView>(R.id.list_users_insc)
        lv.adapter = userListAdapter

        buttonpt.setOnClickListener {
            if(game.jogadores.size>=game.qntdJogadores) {
                Toast.makeText(application, "Sem Vagas", Toast.LENGTH_LONG).show()
            }else if(game.jogadores.contains(user)){
                Toast.makeText(application, "Você já está Cadastrado", Toast.LENGTH_LONG).show()
            }
        else{
                Toast.makeText(application, "Validando", Toast.LENGTH_LONG).show()
            game.jogadores.add(user)
            alter(game){}
        }
        }
    }
        fun alter(game: Game, altered: (alteredGame: Game) -> Unit) {
            GameWebClient().alter(game, {
                finish()
            }, {
                Toast.makeText(application, "Falha na Inscrição", Toast.LENGTH_LONG).show()
            })
        }
    }



