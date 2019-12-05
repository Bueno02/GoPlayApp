package com.e.goplay.retrofit

import com.e.goplay.model.Game


class GameWebClient {

    fun list(success: (games: List<Game>) -> Unit,
             failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().gameService().list()
        call.enqueue(callback({ response ->
            response?.body()?.let {
                println("fez a call do retrofit sucesso")
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                println("fez a call do retrofit falha")
                failure(it)
            }
        }))
    }

    fun insert(game: Game, success: (game: Game) -> Unit,
               failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().gameService().insert(game)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

    fun alter(game: Game, success: (game: Game) -> Unit,
              failure: (throwable: Throwable) -> Unit) {
        val call = RetrofitInitializer().gameService().alter(game.id,game)
        call.enqueue(callback({ response ->
            response?.body()?.let {
                success(it)
            }
        }, { throwable ->
            throwable?.let {
                failure(it)
            }
        }))
    }

}