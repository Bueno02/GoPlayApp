package com.e.goplay

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.e.goplay.model.Game
import com.e.goplay.model.User
import com.e.goplay.retrofit.GameWebClient
import kotlinx.android.synthetic.main.activity_games.*


open class GamesActivity : AppCompatActivity() {

    val listGame :  MutableList<Game> = mutableListOf()
    var user : User = User()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        val intent: Intent = getIntent()

        user = intent.getSerializableExtra("usuario") as User

        userbt.setOnClickListener{
            val intent = Intent(this, UserInfo::class.java)
            intent.putExtra("user",user)
            startActivity(intent)
        }

        Toast.makeText(this, "Buscando Jogos", Toast.LENGTH_LONG).show()
        GameWebClient().list({
            listGame.addAll(it)
            adapter()
        }, {
            Toast.makeText(this, "Falha ao buscar jogos", Toast.LENGTH_LONG).show()
        })

       val myListAdapter = MyListAdapter(this,listGame)
        val lv = findViewById<ListView>(R.id.listView_games)
        lv.adapter = myListAdapter

        lv.setOnItemClickListener { parent, view, position, id ->
            val caradavez = myListAdapter.getItemAtPosition(position)
            val intent = Intent(this, EntraGameActivity::class.java)
            intent.putExtra("user",user)
            intent.putExtra("game",caradavez)
            startActivity(intent)
        }

        fab.setOnClickListener {
            val intent = Intent(this, NewGame::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        GameWebClient().list({
            listGame.clear()
            listGame.addAll(it)
            adapter()
        }, {
            Toast.makeText(this, "Falha ao buscar jogos", Toast.LENGTH_LONG).show()
        })
    }
    fun adapter (){
        val myListAdapter = MyListAdapter(this,listGame)
        val lv = findViewById<ListView>(R.id.listView_games)
        lv.adapter = myListAdapter
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
