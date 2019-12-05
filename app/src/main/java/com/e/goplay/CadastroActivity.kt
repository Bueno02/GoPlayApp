package com.e.goplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.e.goplay.model.User
import com.e.goplay.retrofit.UserWebClient
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    var user : User = User()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
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
        user.posicao=editTextPos1.text.toString()
        user.posicao2=editTextPos2.text.toString()
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

