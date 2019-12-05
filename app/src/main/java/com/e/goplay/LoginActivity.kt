package com.e.goplay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.e.goplay.model.User
import com.e.goplay.retrofit.UserWebClient
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    var user = User()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



        btn_cadastro.setOnClickListener{
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener{
            Toast.makeText(application, "Validando", Toast.LENGTH_LONG).show()
            UserWebClient().valida(username.text.toString(),{
                user=it
                if(user.senha==password.text.toString()){
                    val intent = Intent(this, GamesActivity::class.java)
                    intent.putExtra("usuario",user)
                    startActivity(intent)
                }else {
                    Toast.makeText(application, "Usuario ou Senha Incorretos", Toast.LENGTH_LONG).show()
                }
            },{
                Toast.makeText(application, "Usuario ou Senha Incorretos", Toast.LENGTH_LONG).show()
        })
        }
    }
}
