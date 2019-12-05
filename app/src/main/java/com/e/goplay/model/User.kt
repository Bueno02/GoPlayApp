package com.e.goplay.model

import java.io.Serializable

data class User constructor (var id : Int = 0,
            var nome : String ="",
            var email : String="",
            var senha : String="",
            var idade : Int=0,
            var posicao : String="",
            var posicao2 : String="",
            var avalicao : Int=0
            ):Serializable
{constructor() : this (0, "","","",0,"","",0)

}