package com.example.demo.view

import com.example.demo.Controller.Functions
import javafx.scene.image.Image
import tornadofx.*
import kotlin.math.PI
import kotlin.math.sin

class Integral : View("Integral")
{
    init {
        setStageIcon(Image("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/WPint.svg/1200px-WPint.svg.png"))
    }

    private val integral = "\u222B"
    private var up = vbox()

    val x0TF = textfield { style = "-fx-font-size: 10px ; -fx-background-radius: 50 ; -fx-font-size: 10px " ; setPrefSize(60.0,20.0) }
    private val x0 = hbox {
        spacing = 5.0
        add(x0TF)
        add( label { text = "X^0" })
    }

    val x1TF = textfield { style = "-fx-font-size: 10px ; -fx-background-radius: 50 ; -fx-font-size: 10px " ; setPrefSize(60.0,20.0) }
    private val x1 = hbox {
        spacing = 5.0
        add(x0)
        add( label { text = "+" })
        add(x1TF)
        add( label { text = "X^1" })
    }

    val x2TF = textfield { style = "-fx-font-size: 10px ; -fx-background-radius: 50 ; -fx-font-size: 10px " ; setPrefSize(60.0,20.0) }
    private val x2 = hbox {
        spacing = 5.0
        add(x1)
        add( label { text = "+" })
        add(x2TF)
        add( label { text = "X^2" })
    }

    val x3TF = textfield { style = "-fx-font-size: 10px ; -fx-background-radius: 50 ; -fx-font-size: 10px " ; setPrefSize(60.0,20.0) }
    private val x3 = hbox {
        spacing = 5.0
        add(x3TF)
        add( label { text = "X^3" })
    }
    private val plus3Box = hbox {
        spacing = 5.0
        add(x2)
        add(label { text = "+" })
    }

    val x4TF = textfield { style = "-fx-font-size: 10px ; -fx-background-radius: 50 ; -fx-font-size: 10px " ; setPrefSize(60.0,20.0) }
    private val x4 = hbox {
        spacing = 5.0
        add(x3)
        add( label { text = "+" })
        add(x4TF)
        add( label { text = "X^4" })
    }

    val x5TF = textfield { style = "-fx-font-size: 10px ; -fx-background-radius: 50 ; -fx-font-size: 10px " ; setPrefSize(60.0,20.0) }
    private val x5 = hbox {
        spacing = 5.0
        add(x4)
        add( label { text = "+" })
        add(x5TF)
        add( label { text = "X^5" })
    }

    private val plus6Box = hbox {
        spacing = 5.0
        add(x5)
        add(label { text = "+" })
    }
    val x6TF = textfield { style = "-fx-font-size: 10px ; -fx-background-radius: 50 ; -fx-font-size: 10px " ; setPrefSize(60.0,20.0) }
    private val x6 = hbox {
        spacing = 5.0
        add(x6TF)
        add( label { text = "X^6" })
    }

    val x7TF = textfield { style = "-fx-font-size: 10px ; -fx-background-radius: 50 ; -fx-font-size: 10px " ; setPrefSize(60.0,20.0) }
    private val x7 = hbox {
        spacing = 5.0
        add(x6)
        add( label { text = "+" })
        add(x7TF)
        add( label { text = "X^7" })
    }

    val x8TF = textfield { style = "-fx-font-size: 10px ; -fx-background-radius: 50 ; -fx-font-size: 10px " ; setPrefSize(60.0,20.0) }
    private val x8 = hbox {
        spacing = 5.0
        add(x7)
        add( label { text = "+" })
        add(x8TF)
        add( label { text = "X^8" })
    }

    private val plus9Box = hbox {
        spacing = 5.0
        add(x8)
        add(label { text = "+" })
    }
    val x9TF = textfield { style = "-fx-font-size: 10px ; -fx-background-radius: 50 ; -fx-font-size: 10px " ; setPrefSize(60.0,20.0) }
    private val x9 = hbox {
        spacing = 5.0
        add(x9TF)
        add( label { text = "X^9" })
    }

    val x10TF = textfield { style = "-fx-font-size: 10px ; -fx-background-radius: 50 ; -fx-font-size: 10px " ; setPrefSize(60.0,20.0) }
    private val x10 = hbox {
        spacing = 5.0
        add(x9)
        add( label { text = "+" })
        add(x10TF)
        add( label { text = "X^10" })
    }


    private val calculateBTN = button {
        text = "Calculate"
        style = "-fx-alignment: center ; -fx-background-radius: 50 ; -fx-font-weight: bold "
        action {
            val function = Functions()
            function.calculate_integral(this@Integral)
        }
    }

     val resultTF = textfield {
        style = "-fx-font-size: 20px ; -fx-background-radius: 50"
    }

    private val resultBox = vbox {
        spacing = 5.0
        add(resultTF)
        add(calculateBTN)
    }

    val upperCase = textfield {
        style = "-fx-font-size: 20px ; -fx-background-radius: 50"
    }
    val lowerCase = textfield {
        style = "-fx-font-size: 20px ; -fx-background-radius: 50"
    }


    private fun showDegree(number : Int)
    {
        when ( number )
        {
            0 -> { up.add(x0) ; up.add(resultBox) }
            1 -> { up.add(x1) ; up.add(resultBox) }
            2 -> { up.add(x2) ; up.add(resultBox) }
            3 -> { up.add(plus3Box) ; up.add(x3) ; up.add(resultBox) }
            4 -> { up.add(plus3Box) ; up.add(x4) ; up.add(resultBox) }
            5 -> { up.add(plus3Box) ; up.add(x5) ; up.add(resultBox) }
            6 -> { up.add(plus3Box) ; up.add(plus6Box) ; up.add(x6) ; up.add(resultBox) }
            7 -> { up.add(plus3Box) ; up.add(plus6Box) ; up.add(x7) ; up.add(resultBox) }
            8 -> { up.add(plus3Box) ; up.add(plus6Box) ; up.add(x8) ; up.add(resultBox) }
            9 -> { up.add(plus3Box) ; up.add(plus6Box) ; up.add(plus9Box) ; up.add(x9) ; up.add(resultBox) }
            10 -> { up.add(plus3Box) ; up.add(plus6Box) ; up.add(plus9Box) ; up.add(x10) ; up.add(resultBox) }
        }
    }

    override val root = anchorpane() {

//          style = "-fx-background-color: #3FEC9F"
        style = "-fx-background-color: #27C9FF"


        setMinSize(500.0 , 600.0)

        val upCase = vbox {
            style = "-fx-alignment: center"
            add( label { text = " Upper Case : " ; style = "-fx-font-weight: bold"} )
            add( upperCase )
        }

        val lowCase = vbox {
            style = "-fx-alignment: center"
            add(label { text = " Lower Case : " ; style = "-fx-font-weight: bold"} )
            add( lowerCase )
        }

        val case = vbox {
            spacing = 20.0
            add( upCase )
            add( lowCase )
        }

        val shape = hbox {

            add( label { text = integral ; style = "-fx-font-size : 110px"} )
            add( case )
        }

        val degreeTF = textfield {
            style = "-fx-font-size: 10px ; -fx-background-radius: 50"
        }

        val submit = button {
            text = "Submit"
            style = "-fx-alignment: center ; -fx-background-radius: 50 ; -fx-font-weight: bold "
            action { showDegree( degreeTF.text.toInt() ) }
        }

        val degree = hbox {
            spacing = 10.0
            add( label { text = " Enter degree :" ; style = "-fx-font-weight: bold" })
            add( degreeTF )
            add(submit)
        }

         up = vbox {
            spacing = 30.0
            paddingLeft = 80
            paddingTop = 30
            add( shape )
            add( degree)
        }





    }


}