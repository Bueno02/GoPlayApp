package com.e.goplay

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.EditText
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

        dateWatcher(editTextHorario)
        val gameadapter = ArrayAdapter.createFromResource(
            this, R.array.lista_tipoJogo, R.layout.spinner_layout)
        gameadapter.setDropDownViewResource(R.layout.spinner_layout)
        spinnerTipoJogo.setAdapter(gameadapter)


        buttonCriar.setOnClickListener{
            if(editTextLocal.text.isEmpty()||editTextQtJog.text.isEmpty()
                ||editTextHorario.text.isEmpty()||editTextDesc.text.isEmpty()){
                Toast.makeText(application, "Preencha Todos os Campos", Toast.LENGTH_LONG).show()
            }else{
            add { game }
            }
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
    fun dateWatcher( editText: EditText) {

        var oldString : String = ""

        editText.addTextChangedListener(object : TextWatcher {
            var changed: Boolean = false

            override fun afterTextChanged(p0: Editable?) {

                changed = false



            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int)
            {
                //changed=false
                editText.setSelection(p0.toString().length)
            }

            @SuppressLint("SetTextI18n")
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                var str: String = p0.toString()

                if (str != null) {

                    if (oldString.equals(str)) {
                        //significs que o user esta apagando
                        //do Nothing

                    } else if (str.length == 2) {  //  xx
                        var element0: String = str.elementAt(0).toString()
                        var element1: String = str.elementAt(1).toString()
                        str = element0 + element1 + ":"
                        editText.setText(str)
                        oldString = element0 + element1
                        editText.setSelection(str.length)

                    } else if (str.length > 5) { // este exemplo é para data no formato xx/xx/xx. Se você quer usar xx/xx/xxxx mudar para if (str.length >10). O resto do código permanece o mesmo.

                        str = str.substring(0, str.length - 1)
                        editText.setText(str)
                        editText.setSelection(str.length)

                    }


                }

            }
        })
    }

    }



