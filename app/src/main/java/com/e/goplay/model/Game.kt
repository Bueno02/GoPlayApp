package com.e.goplay.model

import java.io.Serializable



data class Game constructor(var id : Int = 0,
      //     val local: Place,
           var tipoJogo: String ="",
           var local : String ="",
           var horario: String="",
           var description: String="",
           var qntdJogadores : Int = 0,
           var jogadores : MutableList<User> = mutableListOf()
        ):Serializable{
    constructor() : this(0,"","","","",0, mutableListOf())
}