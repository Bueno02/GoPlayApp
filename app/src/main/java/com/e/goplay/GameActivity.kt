package com.e.goplay

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.e.goplay.model.Game
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_game_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GameActivity : AppCompatActivity() {

  /*  val Array = { games:List<Game>? ->
        val lvteste = findViewById(R.id.list_view_teste) as ListView
        val prodAdapter = ArrayAdapter<Game>(this,
            android.R.layout.simple_list_item_1, games)
        lvteste.adapter = prodAdapter
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

     /*   val call =  RetrofitInitializer().gameService().list()

        call.enqueue(object: Callback<List<Game>?> {
            override fun onResponse(call: Call<List<Game>?>?,
                                    response: Response<List<Game>?>?) {
                response?.body()?.let {
                    val games: List<Game> = it
                    println("Hueeeeeeeeeeeeee")
                    println(games)
                }
            }

            override fun onFailure(call: Call<List<Game>?>?,
                                   t: Throwable?) {
                println("FAlhoj")
            }
        })
*/
    }
}
