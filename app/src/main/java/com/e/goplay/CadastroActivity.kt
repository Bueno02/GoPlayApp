package com.e.goplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.e.goplay.model.User
import com.e.goplay.retrofit.UserWebClient
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_cadastro.buttonCriar
import kotlinx.android.synthetic.main.activity_new_game.*

class CadastroActivity : AppCompatActivity() {

    var user : User = User()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val gameadapter = ArrayAdapter.createFromResource(
            this, R.array.lista_posicoes, R.layout.spinner_layout)
        gameadapter.setDropDownViewResource(R.layout.spinner_layout)
        spinnerPos1.setAdapter(gameadapter)
        spinnerPos2.setAdapter(gameadapter)

        buttonCriar.setOnClickListener{
            if(editTextConfirmaSenha.text.toString()==editTextSenha.text.toString())
            add {user}
            else{
                Toast.makeText(application, "Senhas não Conferem", Toast.LENGTH_LONG).show()
            }
        }
    }
    fun add(created: (createdUser: User) -> Unit) {
        user.nome=editTextNome.text.toString()
        user.posicao=spinnerPos1.selectedItem as String
        user.posicao2=spinnerPos2.selectedItem as String
        user.idade=editTextIdade.text.toString().toInt()
        user.email=editTextEmail.text.toString()
        user.senha=editTextSenha.text.toString()
        Toast.makeText(application, "Validando", Toast.LENGTH_LONG).show()
        UserWebClient().insert(user, {
            created(it)
            Toast.makeText(application, "Cadastro Efetuado", Toast.LENGTH_LONG).show()
            finish()
        }, {
            Toast.makeText(application, "Falha no Cadastro", Toast.LENGTH_LONG).show()
        })
    }
    }

