package com.e.goplay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_entra_game.*

class EntraGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entra_game)
        val intent : Intent = getIntent()

        textViewDescription.setText(intent.getStringExtra("desc"))

    }

}
