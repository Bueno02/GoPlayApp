package com.e.goplay.model

import java.time.LocalDateTime


class Game(var _id: String,
        //   val local: Place,
           var local : String,
           var tipoJogo: String,
           var description: String,
           var horario : String,
           var qntdJogadores : Int
         //  var jogadores : MutableList<User>
        )