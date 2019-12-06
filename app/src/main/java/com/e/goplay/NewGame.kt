package com.e.goplay

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.e.goplay.model.Game
import com.e.goplay.retrofit.GameWebClient
import kotlinx.android.synthetic.main.activity_new_game.*



class NewGame : AppCompatActivity()  {


    var valida = false
    val game = Game()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)


        val gameadapter = ArrayAdapter.createFromResource(
            this, R.array.lista_tipoJogo, R.layout.spinner_layout)
        gameadapter.setDropDownViewResource(R.layout.spinner_layout)
        spinnerTipoJogo.setAdapter(gameadapter)


        buttonCriar.setOnClickListener{

            add { game }
            }
        }
    fun add(created: (createdGame: Game) -> Unit) {
        game.tipoJogo = spinnerTipoJogo.selectedItem as String
        game.local = editTextLocal.text.toString()
        game.qntdJogadores =( editTextQtJog.text.toString().toInt())
        game.horario = editTextHorario.text.toString()
        game.description = editTextDesc.text.toString()
        Toast.makeText(application, "Criando Partida", Toast.LENGTH_LONG).show()
                GameWebClient().insert(game, {
                    created(it)
                    finish()
                }, {
                    Toast.makeText(application, "Falha ao Criar Jogo", Toast.LENGTH_LONG).show()
                })
            }

    }



