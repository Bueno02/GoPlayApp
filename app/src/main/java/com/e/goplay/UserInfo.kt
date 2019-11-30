package com.e.goplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.e.goplay.model.User
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

    var user = User("01","Serginho","42","Volante/Zagueiro","9/10","")

        textView_nome.setText(user.nome)
        textView_idade.setText(user.idade)
        textView_posicao.setText(user.posicao)
        textView_avalicao.setText(user.avalicao)
    }
}
