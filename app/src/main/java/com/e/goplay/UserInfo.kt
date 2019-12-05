package com.e.goplay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.e.goplay.model.User
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfo : AppCompatActivity() {

    var user : User = User()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        val intent: Intent = getIntent()

        user = intent.getSerializableExtra("user") as User

        textView_nome.setText(user.nome)
        textView_idade.setText(user.idade.toString())
        textView_posicao.setText(user.posicao+"/"+user.posicao2)
        textView_avalicao.setText("Avaliação: "+user.avalicao.toString()+"/10")
    }
}
