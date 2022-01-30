package com.example.demo.Controller

import tornadofx.*

fun main() {

    val p = Functions()

    var x = "5"
    var z = "1"

    while ( x != "0" )
    {
        z = p.multi( mutableListOf( z , x ) )
        x = p.minus( mutableListOf( x ,"1" ) )
    }

    println(z)

}